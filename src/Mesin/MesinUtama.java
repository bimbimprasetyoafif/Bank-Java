package Mesin;
/**
 *
 * @author Bimo Prasetyo Afif
 */
import Admin.AdminView;
import Admin.ListNasabah;
import Admin.ResetPASS;
import Admin.ResetPIN;
import PesanPopup.PesanPopup;
import Database.*;
import Login.*;
import Pendaftaran.*;
import Media.*;
import Fitur.*;
import Main.*;

public class MesinUtama {
       
    private static MesinUtama mesin; //Untuk singleton nya
    private boolean status;
    private Admin userAdmin;
    private TellerAdmin userTeller;
    private Nasabah userNasabah;
    private Nasabah userNasabah2;
    private String back = "";
    private int mode = 0;
    
    private MainView view;
    private DaftarNasabahBaru daftarnasabahbaru;
    private DaftarAkunBaru daftarakunbaru;  //x
    private DaftarATM daftaratmbaru;
    private LoginKartu loginkartu;
    private LoginAkun loginakun;
    private ATM atm;
    private InternetBanking internetbanking;
    private Teller teller;
    private CekSaldo ceksaldo;
    private TarikUang tarikuang;
    private Transfer transfer;
    private PesanPopup pesanpopup;
    
    private AdminView admin;
    private ListNasabah listnasabah;
    private ResetPIN resetpin;
    private ResetPASS resetpass;
    
    //<editor-fold defaultstate="collapsed" desc="TEMPLATE">
    
        //koding disini
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    
    public static MesinUtama getMesin(){//hanya design pattern singleton biasa
        if(MesinUtama.mesin == null){
            MesinUtama.mesin = new MesinUtama();
        }
        
        return mesin;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SETTER / GETTER">
    
    public void setBack(String back){
        this.back = back;
    }
    
    public String getBack(){
        return this.back;
    }
    
    public void setMode(int mode){
        this.mode = mode;
    }
    
    public int getMode(){
        return this.mode;
    }
    
    public void setStatus(boolean stat){
        this.status = stat;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public Nasabah getUserNasabah(){
        return this.userNasabah;
    }
    
    public Nasabah getUserNasabah2(){
        return this.userNasabah2;
    }
    
    public Admin getUserAdmin(){
        return this.userAdmin;
    }
    
    public void setUserNasabahNull(){
        this.userNasabah = null;
    }
    
    public void setUserNasabah2Null(){
        this.userNasabah2 = null;
    }
    
    public void setUserAdminNull(){
        this.userAdmin = null;
    }
    
    public void setUserTellerNull(){
        this.userTeller = null;
    }

    public MainView getView() {
        if(view == null){
            view = new MainView();
        }
        return view;
    }

    public DaftarNasabahBaru getDaftarnasabahbaru() {
        if(daftarnasabahbaru == null){
            daftarnasabahbaru = new DaftarNasabahBaru();
        }
        return daftarnasabahbaru;
    }

    public DaftarAkunBaru getDaftarakunbaru() {
        if(daftarakunbaru == null){
            daftarakunbaru = new DaftarAkunBaru();
        }
        return daftarakunbaru;
    }

    public LoginKartu getLoginkartu() {
        if(loginkartu == null){
            loginkartu = new LoginKartu();
        }
        return loginkartu;
    }

    public LoginAkun getLoginakun() {
        if(loginakun == null){
            loginakun = new LoginAkun();
        }
        return loginakun;
    }

    public ATM getAtm() {
        if(atm == null){
            atm = new ATM();
        }
        return atm;
    }
    
    public DaftarATM getDaftarAtm() {
        if(daftaratmbaru == null){
            daftaratmbaru = new DaftarATM();
        }
        return daftaratmbaru;
    }

    public InternetBanking getInternetbanking() {
        if(internetbanking == null){
            internetbanking = new InternetBanking();
        }
        return internetbanking;
    }

    public Teller getTeller() {
        if(teller == null){
            teller = new Teller();
        }
        return teller;
    }

    public CekSaldo getCeksaldo() {
        if(ceksaldo == null){
            ceksaldo = new CekSaldo();
        }
        return ceksaldo;
    }

    public TarikUang getTarikuang() {
        if(tarikuang == null){
            tarikuang = new TarikUang();
        }
        return tarikuang;
    }

    public Transfer getTransfer() {
        if(transfer == null){
            transfer = new Transfer();
        }
        return transfer;
    }

    public PesanPopup getPesanpopup() {
        if(pesanpopup == null){
            pesanpopup = new PesanPopup();
        }
        return pesanpopup;
    }

    public ListNasabah getListnasabah() {
        if(listnasabah == null){
            listnasabah = new ListNasabah();
        }
        return listnasabah;
    }

    public ResetPIN getResetpin() {
        if(resetpin == null){
            resetpin = new ResetPIN();
        }
        return resetpin;
    }

    public ResetPASS getResetpass() {
        if(resetpass == null){
            resetpass = new ResetPASS();
        }
        return resetpass;
    }
    
    
    
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="MODE MENU">  
   
    public void mode(int mode, javax.swing.JFrame dari){ //------------------------------------- Mode Pilihan
        switch (mode) {
            case 0:
                //-----------------------------------------------------------------------------Menu Awal
                this.mode=0;
                this.back = "";     //  SEMUA DATA DI SET 0 atau Kosongan
                userNasabah = null;
                userNasabah2 = null;
                userAdmin = null;
                view = new MainView();
                view.show();
                break;
            case 1:
                //-----------------------------------------------------------------------------Login Akun
                loginakun = new LoginAkun();
                if(this.mode == 1 || this.mode == 5){
                    loginakun.show("Login User Admin");  //pembeda admin dan nasabah
                }
                else if(this.mode == 4){
                    loginakun.show("Login User Teller");  //pembeda admin dan nasabah
                }
                else{
                    loginakun.show("Login User Nasabah");
                }
                break;
            case 2:
                //-----------------------------------------------------------------------------Login kartu
                loginkartu = new LoginKartu();
                loginkartu.show();
                break;
            case 3:
                //-----------------------------------------------------------------------------ATM
                atm = new ATM();
                atm.show();
                break;
            case 4:
                //-----------------------------------------------------------------------------Internet Banking
                internetbanking = new InternetBanking();
                internetbanking.show();
                break;
            case 5:
                //-----------------------------------------------------------------------------Teller / Admin page
                teller = new Teller();
                teller.show();
                break;
            case 6:
                //-----------------------------------------------------------------------------Cek Saldo
                ceksaldo = new CekSaldo();
                ceksaldo.show();
                break;
            case 7:
                //-----------------------------------------------------------------------------MesinTransfer
                transfer = new Transfer();
                transfer.show();
                break;
            case 8:
                //-----------------------------------------------------------------------------Tarik
                tarikuang = new TarikUang();
                tarikuang.show();
                break;
            case 9:
                //-----------------------------------------------------------------------------Admin
                admin = new AdminView();
                admin.show();
                break;
            case 10:
                //-----------------------------------------------------------------------------Pendaftaran nasabah baru
                daftarnasabahbaru = new DaftarNasabahBaru();
                daftarnasabahbaru.show();
                break;
            case 11:
                //-----------------------------------------------------------------------------Pendaftaran akun baru
                daftarakunbaru = new DaftarAkunBaru();
                daftarakunbaru.show();
                break;   
            case 12:
                //-----------------------------------------------------------------------------Pendaftaran atm baru
                daftaratmbaru = new DaftarATM();
                daftaratmbaru.show();
                break;
            case 13:
                //-----------------------------------------------------------------------------Pendaftaran atm baru
                listnasabah = new ListNasabah();
                listnasabah.show();
                break;
            default:
                System.out.println("Tidak menampilkan apa2");
                break;
        }
        dari.dispose();
        //System.gc();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BAGIAN TOMBOL KEMBALI, FUNGSI INIT, DLL">
    
    public void setUserNasabahdanStatus(Nasabah nasabah, boolean stat){
        this.userNasabah = nasabah;
        this.status = stat;
    }
    
    public void setUserNasabah2danStatus(Nasabah nasabah, boolean stat){
        this.userNasabah2 = nasabah;
        this.status = stat;
    }
    
    public void setUserAdmindanStatus(Admin admin, boolean stat){
        this.userAdmin = admin;
        this.status = stat;
    } 
    
    public void setUserTellerdanStatus(TellerAdmin teller, boolean stat){
        this.userTeller = teller;
        this.status = stat;
    } 
    
    public void initStatusdanLabel(boolean stat, javax.swing.JLabel label){
        this.status = stat;
        label.setText(null);
    }
    
    public void initNasabahNullAndStatusFalse(){
        this.status = false;
        this.userNasabah = null;
    }
    
    public void kembali(javax.swing.JFrame frame){
        if(this.back.equalsIgnoreCase("atm")){
            mode(2,frame);
        }
        else{
            mode(4,frame);
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="TELLER">
    
    public void bukuTabungan(String no_rek){
        if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(no_rek, transfer)){
            FiturControl.getInstance().cetakBuku(userNasabah);
        }
        else{
            pesanpopup.show("Gagal Mencetak Tabungan", teller);
        }
        userNasabah = null;
    }
    
    private void transaksiTeller(long nominal, short kode){
        switch(kode){
            case 11:
                userNasabah.tambahSaldo(nominal, kode);
                pesanpopup.show("Setor Berhasil",teller);
                break;
            case 16:
                userNasabah.kurangiSaldo(nominal, kode);
                pesanpopup.show("Tarik Tunai Berhasil",teller);
                break;
            default:
                System.out.println("Tidak Ada Transaksi");
        }
    }
    
    public void tambahSaldo(String no_rek, String nominal){
        try{
            if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(no_rek, teller) & FilterInputControl.getInstance().cekNominaldanMinimal(nominal, 10000L, teller.getjLabel5())){
                transaksiTeller(Long.parseLong(nominal), (short)11);
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Setor",teller);
        }
        userNasabah = null;
    }
    
    public void tarikSaldo(String no_rek, String nominal){
        try{
            if(DatabaseEye.getInstance().nasabahBerdasarkanRekening(no_rek, teller) & FilterInputControl.getInstance().cekNominaldanMinimal(nominal, 100000L, teller.getjLabel5())){
                transaksiTeller(Long.parseLong(nominal), (short)16);                
            }          
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Tarik Tunai",teller);        
        }
        userNasabah = null;
    }
    
    //</editor-fold>
    
}
