package Abstracts;

public abstract class Users {
    
    protected String nama;
    protected String username = "";
    protected String password = "";
    

    public Users(String nama) {
        this.nama = nama;
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
    
}

