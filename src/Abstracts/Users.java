package Abstracts;

public abstract class Users {
    
    protected String nama;
    protected String username = "";
    protected String password = "";
    protected String no_rekening = "";
    protected String no_identitas = "";
    protected String no_atm = "";
    protected String pin;
    protected long saldo;
    

    public Users(String nama, String no_rekening, long saldo, String id) {
        this.nama = nama;
        this.no_rekening = no_rekening;
        this.saldo = saldo;
        this.no_identitas = id;
    }
    
    public Users(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        
    }

    public abstract String getNama();

    public abstract String getUsername();

    public abstract String getPassword();
    
    
    public void setUsername(String username) {   
    }

    public void setPassword(String password) {
    }
    
    public String getPin() {
        return "";
    }

    public void setPin(String pin) {
        
    }
    
    public String getNo_rekening() {
        return "";
    }
    
    public String getNo_identitas() {
        return "";
    }

    public long getSaldo() {
        return 0;   
    }
    
    public void setATM(String atm){
        
    }
    
    public String getATM(){
        return "";
    }
    
    public void tambahSaldo(long nominal, short kode){
    }
    
    public void kurangiSaldo(long nominal, short kode){
    }
    
    public int getId() {
        return 0;
    }
    
}

