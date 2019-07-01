/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import Database.Nasabah;
import controller.FilterInputControl;
import controller.LogControl;
import controller.MesinUtama;
import model.DatabaseEye;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class DaftarControl {
    private static DaftarControl daftar;
    
    public static DaftarControl getInstance(){
        if(daftar == null){
            daftar = new DaftarControl();
        }
        return daftar;
    }
    
    public void clearAllForm(){
        MesinUtama.getMesin().getDaftarnasabahbaru().getjTextField1().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjTextField2().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjTextField3().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjTextField4().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel8().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel9().setText(null);
        MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel10().setText(null);
        
        MesinUtama.getMesin().getDaftarakunbaru().getjLabel1().setText(null);
        MesinUtama.getMesin().getDaftarakunbaru().getjLabel7().setText(null);
        MesinUtama.getMesin().getDaftarakunbaru().getjLabel8().setText(null);
        MesinUtama.getMesin().getDaftarakunbaru().getjPasswordField1().setText(null);
        MesinUtama.getMesin().getDaftarakunbaru().getjTextField1().setText(null);
        MesinUtama.getMesin().getDaftarakunbaru().getjTextField2().setText(null);
        
        MesinUtama.getMesin().getDaftarAtm().getjLabel6().setText(null);
        MesinUtama.getMesin().getDaftarAtm().getjLabel7().setText(null);
        MesinUtama.getMesin().getDaftarAtm().getjTextField1().setText(null);
        MesinUtama.getMesin().getDaftarAtm().getjTextField2().setText(null);
        MesinUtama.getMesin().getDaftarAtm().getjPasswordField1().setText(null);
    }
    
    //<editor-fold defaultstate="collapsed" desc="BAGIAN PENDAFTARAN NASABAH BARU">
    
    public void daftarNasabah(String nama, String rekening, String saldoAwal, String id, javax.swing.JFrame frame){
        try{
            if(FilterInputControl.getInstance().cekNama(nama,MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel9()) & FilterInputControl.getInstance().cekNominaldanMinimal(saldoAwal,100000L,MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel10()) & DatabaseEye.getInstance().nasabahMencariNoIdentitas(id, MesinUtama.getMesin().getDaftarnasabahbaru().getjLabel8())){
                    Database.getInstance().getNasabah().add(new Nasabah(nama, rekening, Long.parseLong(saldoAwal), id));
                    FiturControl.getInstance().cetakBuktiPendaftaran(nama, rekening);
                    MesinUtama.getMesin().getPesanpopup().show("Pendaftaran Berhasil", MesinUtama.getMesin().getDaftarnasabahbaru());
                    MesinUtama.getMesin().getDaftarnasabahbaru().updateRekening();
                    setUpFormDaftarNasabah();
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Daftar Nasabah",frame);
        }
    }
    
    public void setUpFormDaftarNasabah(){
        clearAllForm();
        MesinUtama.getMesin().getDaftarnasabahbaru().getjTextField1().setText(Long.toString(MesinUtama.getMesin().getDaftarnasabahbaru().getRekening()));       
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BAGIAN PENDAFTARAN AKUN BARU">
    
    public boolean cekAkunPadaNasabah(String rek, javax.swing.JFrame frame){
            
            if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(rek, frame)){
                if(!MesinUtama.getMesin().getUserNasabah().getUsername().isEmpty() & !MesinUtama.getMesin().getUserNasabah().getPassword().isEmpty()){
                    MesinUtama.getMesin().getPesanpopup().show("Akun sudah ada", frame);
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                MesinUtama.getMesin().getPesanpopup().show("Tidak Ditemukan Nasabah", frame);
                return false;
            }            
    }
        
    public void daftarAkun(String rek, String uname, String pass, javax.swing.JFrame frame){
        try{
            if(DatabaseEye.getInstance().nasabahMencariUsername(uname, MesinUtama.getMesin().getDaftarakunbaru().getjLabel7(), MesinUtama.getMesin().getDaftarakunbaru()) & FilterInputControl.getInstance().cekUsernameatauPasswordBaru(uname,MesinUtama.getMesin().getDaftarakunbaru().getjLabel7()) & FilterInputControl.getInstance().cekUsernameatauPasswordBaru(pass,MesinUtama.getMesin().getDaftarakunbaru().getjLabel8()) & FilterInputControl.getInstance().cekRekening(rek, MesinUtama.getMesin().getDaftarakunbaru().getjLabel1())){
                if(!cekAkunPadaNasabah(rek, frame)){
                    MesinUtama.getMesin().getUserNasabah().setUsername(uname);
                    MesinUtama.getMesin().getUserNasabah().setPassword(pass);
                    MesinUtama.getMesin().getPesanpopup().show("Pendaftaran Berhasil", MesinUtama.getMesin().getDaftarakunbaru());
                    clearAllForm();
                }
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Daftar Akun",MesinUtama.getMesin().getDaftarakunbaru());
            System.out.println(e);
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BAGIAN PENDAFTARAN ATM BARU">
    
    public boolean cekATMPadaNasabah(String rek, javax.swing.JFrame frame){
            
            if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(rek, frame)){
                if(!MesinUtama.getMesin().getUserNasabah().getATM().isEmpty()){
                    MesinUtama.getMesin().getPesanpopup().show("ATM sudah ada", frame);
                    return true;
                }
                else{
                    return false;
                }
                
            }
            else{
                MesinUtama.getMesin().getPesanpopup().show("Tidak Ditemukan Nasabah", frame);
                return false;
            }            
    }
        
    public void daftarATM(String rek, String atm, String pin, javax.swing.JFrame frame){
        try{
            if(FilterInputControl.getInstance().cekRekening(rek, MesinUtama.getMesin().getDaftarAtm().getjLabel6()) & FilterInputControl.getInstance().cekPin(pin, MesinUtama.getMesin().getDaftarAtm().getjLabel7()) ){
                if(!cekAkunPadaNasabah(rek, frame)){
                    MesinUtama.getMesin().getUserNasabah().setATM(atm);
                    MesinUtama.getMesin().getUserNasabah().setPin(pin);
                    MesinUtama.getMesin().getPesanpopup().show("Pendaftaran Berhasil", MesinUtama.getMesin().getDaftarAtm());
                    clearAllForm();
                    MesinUtama.getMesin().getDaftarAtm().updateNoATM();
                    MesinUtama.getMesin().getDaftarAtm().getjTextField1().setText(Long.toString(MesinUtama.getMesin().getDaftarAtm().getATM()));
                }
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Tidak DItemukan Nasabah",MesinUtama.getMesin().getDaftarAtm());
            System.out.println(e);
        }
    }
    
    //</editor-fold>
    
}
