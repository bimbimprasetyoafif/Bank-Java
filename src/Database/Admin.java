package Database;

import Abstracts.Users;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class Admin extends Users{

    public Admin(String nama, String username, String password) {
        super(nama, username, password);
    }
            
    @Override
    public String getNama() {
        return super.nama;
    }

    @Override
    public String getUsername() {
        return super.username;
    }

    @Override
    public String getPassword() {
        return super.password;
    }
    
}
