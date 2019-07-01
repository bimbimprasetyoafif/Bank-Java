package controller;
/**
 *
 * @author Bimo Prasetyo Afif
 */
import model.FiturControl;
import model.DatabaseEye;
import view.CekSaldo;
import view.Transfer;
import view.TarikUang;
import view.LoginKartu;
import view.LoginAkun;
import view.MainView;
import view.Teller;
import view.InternetBanking;
import view.ATM;
import view.DaftarNasabahBaru;
import view.DaftarATM;
import view.DaftarAkunBaru;
import view.AdminView;
import view.ListNasabah;
import view.ResetPASS;
import view.ResetPIN;
import view.PesanPopup;
import Database.*;

public class MesinUtama {
       
    private static MesinUtama mesin; //Untuk singleton nya
    private boolean status;
    private Admin userAdmin;
    private TellerAdmin userTeller;
    private Nasabah userNasabah;
    private Nasabah userNasabah2;
    private String back = "";
    private int mode = 0;
    
    private MainView view = new MainView();
    private DaftarNasabahBaru daftarnasabahbaru = new DaftarNasabahBaru();
    private DaftarAkunBaru daftarakunbaru = new DaftarAkunBaru();  //x
    private DaftarATM daftaratmbaru = new DaftarATM();
    private LoginKartu loginkartu = new LoginKartu();
    private LoginAkun loginakun = new LoginAkun();
    private ATM atm = new ATM();
    private InternetBanking internetbanking = new InternetBanking();
    private Teller teller = new Teller();
    private CekSaldo ceksaldo = new CekSaldo();
    private TarikUang tarikuang = new TarikUang();
    private Transfer transfer = new Transfer();
    private PesanPopup pesanpopup = new PesanPopup();
    
    private AdminView admin = new AdminView();
    private ListNasabah listnasabah = new ListNasabah();
    private ResetPIN resetpin = new ResetPIN();
    private ResetPASS resetpass = new ResetPASS();
    
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
        return view;
    }

    public DaftarNasabahBaru getDaftarnasabahbaru() {
        return daftarnasabahbaru;
    }

    public DaftarAkunBaru getDaftarakunbaru() {
        return daftarakunbaru;
    }

    public LoginKartu getLoginkartu() {
        return loginkartu;
    }

    public LoginAkun getLoginakun() {
        return loginakun;
    }

    public ATM getAtm() {
        return atm;
    }
    
    public DaftarATM getDaftarAtm() {
        return daftaratmbaru;
    }

    public InternetBanking getInternetbanking() {
        return internetbanking;
    }

    public Teller getTeller() {
        return teller;
    }

    public CekSaldo getCeksaldo() {
        return ceksaldo;
    }

    public TarikUang getTarikuang() {
        return tarikuang;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public PesanPopup getPesanpopup() {
        return pesanpopup;
    }

    public ListNasabah getListnasabah() {
        return listnasabah;
    }

    public ResetPIN getResetpin() {
        return resetpin;
    }

    public ResetPASS getResetpass() {
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
                view.show();
                break;
            case 1:
                //-----------------------------------------------------------------------------Login Akun
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
                loginkartu.show();
                break;
            case 3:
                //-----------------------------------------------------------------------------ATM
                atm.show();
                break;
            case 4:
                //-----------------------------------------------------------------------------Internet Banking
                internetbanking.show();
                break;
            case 5:
                //-----------------------------------------------------------------------------Teller / Admin page
                teller.show();
                break;
            case 6:
                //-----------------------------------------------------------------------------Cek Saldo
                ceksaldo.show();
                break;
            case 7:
                //-----------------------------------------------------------------------------MesinTransfer
                transfer.show();
                break;
            case 8:
                //-----------------------------------------------------------------------------Tarik
                tarikuang.show();
                break;
            case 9:
                //-----------------------------------------------------------------------------Admin
                admin.show();
                break;
            case 10:
                //-----------------------------------------------------------------------------Pendaftaran nasabah baru
                daftarnasabahbaru.show();
                break;
            case 11:
                //-----------------------------------------------------------------------------Pendaftaran akun baru
                daftarakunbaru.show();
                break;   
            case 12:
                //-----------------------------------------------------------------------------Pendaftaran atm baru
                daftaratmbaru.show();
                break;
            case 13:
                //-----------------------------------------------------------------------------Pendaftaran atm baru
                listnasabah.show();
                break;
            default:
                System.out.println("Tidak menampilkan apa2");
                break;
        }
        dari.dispose();
        System.gc();
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
