package Database;
import Abstracts.Users;
import java.util.ArrayList;
/**
 *
 * @author Bimo Prasetyo Afif
 */
public class Nasabah extends Users {    

    protected ArrayList<Transaksi> transaksi = new ArrayList<>();
    
    public Nasabah(String name, String no_rekening, long saldo, String id) {
        super(name, no_rekening, saldo, id);
        transaksi.add(new Transaksi((short)10,"",Long.toString(saldo),Long.toString(super.saldo)));
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

    @Override
    public String getPin() {
        return super.pin;
    }

    @Override
    public String getNo_rekening() {
        return super.no_rekening;
    }
    
    @Override
    public String getNo_identitas() {
        return super.no_identitas;
    }

    @Override
    public long getSaldo() {
        return super.saldo;   
    }
    
    @Override
    public void tambahSaldo(long nominal, short kode){
        super.saldo+=nominal;
        transaksi.add(new Transaksi(kode,"",Long.toString(nominal),Long.toString(super.saldo)));
    }
    
    @Override
    public void kurangiSaldo(long nominal, short kode){
        super.saldo-=nominal;
        transaksi.add(new Transaksi(kode,Long.toString(nominal),"",Long.toString(super.saldo)));
    }

    @Override
    public void setUsername(String username) {
        super.username = username;
    }

    @Override
    public void setPassword(String password) {
        super.password = password;
    }
    
    @Override
    public void setPin(String pin){
        super.pin = pin;
    }
    
    @Override
    public void setATM(String atm){
        super.no_atm = atm;
    }
     
    @Override
    public String getATM(){
        return super.no_atm;
    }
    
    /*
    
    Mungkin tambah informasi seperti
    ttl , jenis kelamin, no_telpon, alamat, dll
    
    */
}
