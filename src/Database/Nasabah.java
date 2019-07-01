package Database;
import Abstracts.Users;
import java.util.ArrayList;
/**
 *
 * @author Bimo Prasetyo Afif
 */
public class Nasabah extends Users {    
    
    private String no_rekening = "";
    private String no_identitas = "";
    private String no_atm = "";
    private String pin;
    private long saldo;

    protected ArrayList<Transaksi> transaksi = new ArrayList<>();
    
    public Nasabah(String name, String no_rekening, long saldo, String id) {
        super(name);
        this.nama = name;
        this.no_rekening = no_rekening;
        
        transaksi.add(new Transaksi((short)10,"",Long.toString(saldo),Long.toString(this.saldo)));
    }
    
    public ArrayList<Transaksi> getTransaksi(){
        return this.transaksi;
    }

    @Override
    public String getUsername() {
        return super.username;
    }

    @Override
    public String getPassword() {
        return super.password;
    }
    
    @Override
    public String getNama() {
        return super.nama;
    }

    public String getPin() {
        return this.pin;
    }

    public String getNo_rekening() {
        return this.no_rekening;
    }
    
    public String getNo_identitas() {
        return this.no_identitas;
    }

    public long getSaldo() {
        return this.saldo;   
    }
    
    public void tambahSaldo(long nominal, short kode){
        this.saldo+=nominal;
        transaksi.add(new Transaksi(kode,"",Long.toString(nominal),Long.toString(this.saldo)));
    }
    
    public void kurangiSaldo(long nominal, short kode){
        this.saldo-=nominal;
        transaksi.add(new Transaksi(kode,Long.toString(nominal),"",Long.toString(this.saldo)));
    }

    @Override
    public void setUsername(String username) {
        super.username = username;
    }

    @Override
    public void setPassword(String password) {
        super.password = password;
    }
    
    public void setPin(String pin){
        this.pin = pin;
    }
    
    public void setATM(String atm){
        this.no_atm = atm;
    }
     
    public String getATM(){
        return this.no_atm;
    }
    
    /*
    
    Mungkin tambah informasi seperti
    ttl , jenis kelamin, no_telpon, alamat, dll
    
    */
}
