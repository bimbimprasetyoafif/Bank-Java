/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fitur;

import Database.Nasabah;
import Database.Transaksi;
import Mesin.DatabaseEye;
import Mesin.FilterInputControl;
import Mesin.LogControl;
import Mesin.MesinUtama;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class FiturControl {
    private static FiturControl fitur;
    
    public static FiturControl getInstance(){
        if(fitur == null){
            fitur = new FiturControl();
        }
        return fitur;
    }
    
    //<editor-fold defaultstate="collapsed" desc="CEK SALDO">
    
    public String tampilkanSaldo(){
        try{
            if(!(MesinUtama.getMesin().getUserNasabah() == null)){
                return Long.toString(MesinUtama.getMesin().getUserNasabah().getSaldo());
            }
            else{
                return "-----";
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Cek Saldo",MesinUtama.getMesin().getCeksaldo());
            return "ERROR";
        }  
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="TARIK UANG">
    
    public void tarikUang(String nominal){
        try{
            if(FilterInputControl.getInstance().cekNominaldanMinimal(nominal,50000L,MesinUtama.getMesin().getTarikuang().getjLabel4())){
                    if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(MesinUtama.getMesin().getUserNasabah().getNo_rekening(), MesinUtama.getMesin().getTarikuang())){
                        if(MesinUtama.getMesin().getUserNasabah().getSaldo()-Long.parseLong(nominal) > 50000){
                            if(Long.parseLong(nominal)%50000 != 0){
                                MesinUtama.getMesin().getPesanpopup().show("Khusus Rp.50.000",MesinUtama.getMesin().getTarikuang());
                            }
                            else{
                                MesinUtama.getMesin().getUserNasabah().kurangiSaldo(Long.parseLong(nominal),(short)15);
                                if(MesinUtama.getMesin().getBack().equals("atm")){
                                    cetakStruk("PENARIKAN", MesinUtama.getMesin().getUserNasabah().getNo_rekening(), "", Long.toString(Long.parseLong(nominal)), Long.toString(MesinUtama.getMesin().getUserNasabah().getSaldo()));
                                    MesinUtama.getMesin().mode(2,MesinUtama.getMesin().getTarikuang());
                                }
                                else{
                                    MesinUtama.getMesin().mode(4,MesinUtama.getMesin().getTarikuang());
                                }
                                MesinUtama.getMesin().getPesanpopup().show("Penarikan Berhasil",MesinUtama.getMesin().getTarikuang());
                            }
                        }
                        else{
                            MesinUtama.getMesin().getPesanpopup().show("-- SALDO TIDAK CUKUP --", MesinUtama.getMesin().getTarikuang());
                            MesinUtama.getMesin().kembali(MesinUtama.getMesin().getTarikuang());
                        }
                }
            }           
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Penarikan",MesinUtama.getMesin().getTarikuang());
            MesinUtama.getMesin().mode(0, MesinUtama.getMesin().getTarikuang());
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="TRANSFER">
    
    public void transfer(String rek_tujuan, String nominal){
        try{
            if(FilterInputControl.getInstance().cekRekTujuanTransfer(rek_tujuan, MesinUtama.getMesin().getTransfer().getjLabel5()) & FilterInputControl.getInstance().cekNominaldanMinimal(nominal,10000L, MesinUtama.getMesin().getTransfer().getjLabel6())){  
                if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(MesinUtama.getMesin().getUserNasabah().getNo_rekening(), MesinUtama.getMesin().getTransfer())){
                    if(MesinUtama.getMesin().getUserNasabah().getSaldo()-Long.parseLong(nominal)>=50000){
                        if(DatabaseEye.getInstance().nasabahBerdasarkanRekening2(rek_tujuan, MesinUtama.getMesin().getTransfer())){
                            MesinUtama.getMesin().getUserNasabah().kurangiSaldo(Long.parseLong(nominal), (short)21);
                            MesinUtama.getMesin().getUserNasabah2().tambahSaldo(Long.parseLong(nominal),(short)20);
                            if(MesinUtama.getMesin().getBack().equals("atm")){
                                cetakStruk("TRANSFER",MesinUtama.getMesin().getUserNasabah().getNo_rekening() ,MesinUtama.getMesin().getUserNasabah2().getNo_rekening() , nominal, Long.toString(MesinUtama.getMesin().getUserNasabah().getSaldo()));
                                MesinUtama.getMesin().mode(2,MesinUtama.getMesin().getTransfer());
                                MesinUtama.getMesin().getPesanpopup().show("Transfer Berhasil",MesinUtama.getMesin().getLoginkartu());
                            }
                            else{
                                MesinUtama.getMesin().mode(4,MesinUtama.getMesin().getTransfer());
                                MesinUtama.getMesin().getPesanpopup().show("Transfer Berhasil",MesinUtama.getMesin().getInternetbanking());
                            }
                            
                            MesinUtama.getMesin().setUserNasabah2Null();
                        }
                    }
                    else{
                        MesinUtama.getMesin().getPesanpopup().show("-- Saldo tidak cukup --", MesinUtama.getMesin().getTransfer());
                    }
                }
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Transfer",MesinUtama.getMesin().getTransfer());
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="STRUK">
    
    private void cetakStruk(String transaksi, String rek_asal, String rek_tujuan, String nominal, String saldo){
        String isi = isiStrukTransaksi(transaksi, rek_asal, rek_tujuan, nominal, saldo, transaksi);
        isi+="====SIMPAN STRUK INI====";
        tampilkanStruk(isi);
    }
    
    public void cetakBuktiPendaftaran(String nama, String rek){
        String isi = isiStrukPendaftaran(nama, rek);
        String enter = "\n";
        isi+="\n====SIMPAN STRUK INI===="+enter;
        isi+="=========PRIVASI========"+enter;
        tampilkanStruk(isi);
    }
    
    private String isiStrukTransaksi(String transaksi, String rek_asal, String rek_tujuan, String nominal, String saldo, String transkasi){
        String header = "======= Struk =======\n\n"+"Transaksi : "+transaksi+"\n"+"Rek : "+rek_asal.substring(0, 3)+"*******"+rek_asal.substring(7)+"\n"+"Nominal : "+nominal+"\n";
        if(transaksi.equalsIgnoreCase("transfer")){
            return header+"Rek. Tujuan : "+rek_tujuan.substring(0, 3)+"*******"+rek_tujuan.substring(7)+"\n"+"Saldo :"+saldo+"\n\n";
        }
        else{
            return header+"Saldo :"+saldo+"\n\n";
        }
    }
    
    private String isiStrukPendaftaran(String nama, String rek){
        return "===== Nasabah Baru =====\n\n"+"Rek : "+rek+"\n"+"Atas Nama : "+nama+"\n";
    }
    
    private void tampilkanStruk(String data){
        Struk struk = new Struk();
        struk.getjTextPane1().setText(data);
        struk.show();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BUKU TABUNGAN">
    
    public void cetakBuku(Nasabah nasabah){
        try{
            BukuTabungan buku = new BukuTabungan();
            buku.getjTextArea1().setText(nasabah.getNama()+"\n"+nasabah.getNo_rekening()+"\n\nKode\tDebit\tKredit\tSaldo\n-----------------------------------------------------------------------------------------------\n");
            for(Transaksi transaksi: nasabah.getTransaksi()){
                buku.getjTextArea1().setText(buku.getjTextArea1().getText()+transaksi.getAll());
            }
            buku.show();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencetak Buku",MesinUtama.getMesin().getTeller());
        }
    }
    
    //</editor-fold>
}
