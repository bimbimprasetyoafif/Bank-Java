/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Abstracts.Users;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class TellerAdmin extends Users{

    public TellerAdmin(String nama, String username, String password) {
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
