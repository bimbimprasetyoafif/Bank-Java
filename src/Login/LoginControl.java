/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
import Mesin.DatabaseEye;
import Mesin.FilterInputControl;
import Mesin.LogControl;
import Mesin.MesinUtama;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class LoginControl{
    
    private static LoginControl logincontrol;
    
    public static LoginControl getInstance(){
        if(logincontrol == null){
            logincontrol = new LoginControl();
        }
        return logincontrol;
    }
    
    //<editor-fold defaultstate="collapsed" desc="FUNGSI LOGIN DAN MASUK">
    
    public void masuk(String atm, String pin){
        try{
            if(FilterInputControl.getInstance().cekAtm(atm, MesinUtama.getMesin().getLoginkartu().getjLabel3()) & FilterInputControl.getInstance().cekPin(pin, MesinUtama.getMesin().getLoginkartu().getjLabel4())){
                if(pengecekanAtmdanPin(atm,pin,MesinUtama.getMesin().getLoginkartu())){
                    if(MesinUtama.getMesin().getMode() == 2){
                        MesinUtama.getMesin().mode(3, MesinUtama.getMesin().getLoginkartu());
                    }
                    else if(MesinUtama.getMesin().getMode() == 5){
                        MesinUtama.getMesin().mode(10, MesinUtama.getMesin().getLoginkartu());
                    }
                    else{
                        System.out.println("-- Tidak kemanapun --");
                    }
                }
                else{
                    MesinUtama.getMesin().getPesanpopup().show("ATM atau Pin salah", MesinUtama.getMesin().getLoginkartu());
                }
            }
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Login Kartu",MesinUtama.getMesin().getLoginkartu());
        }
    }
    
    public void login(String uname, String pass){
        long rek;
        try{
            if(!FilterInputControl.getInstance().cekKekosongan(uname, MesinUtama.getMesin().getLoginakun().getjLabel3()) & !FilterInputControl.getInstance().cekKekosongan(pass, MesinUtama.getMesin().getLoginakun().getjLabel4())){
                if(pengecekanUsernamedanPassword(uname,pass, MesinUtama.getMesin().getLoginakun())){
                    rek = cariRekening(uname, MesinUtama.getMesin().getLoginakun());
                    if(MesinUtama.getMesin().getMode() == 3){
                        MesinUtama.getMesin().mode(4, MesinUtama.getMesin().getLoginakun());
                    }
                    else{
                        MesinUtama.getMesin().getPesanpopup().show("FORBIDEN (YOU NOT ADMIN)",MesinUtama.getMesin().getView());
                        MesinUtama.getMesin().mode(0,MesinUtama.getMesin().getLoginakun());
                    }
                }
                else if(pengecekanAdmin(uname,pass, MesinUtama.getMesin().getLoginakun())){
                    if(MesinUtama.getMesin().getMode() == 1){
                        System.out.println("++ Login Admin Berhasil+ +");
                        MesinUtama.getMesin().mode(9, MesinUtama.getMesin().getLoginakun());
                    }
                    else if(MesinUtama.getMesin().getMode() == 5){
                        System.out.println("++ Login Admin Berhasil+ +");
                        MesinUtama.getMesin().mode(2, MesinUtama.getMesin().getLoginakun());
                    }
                    else{
                        MesinUtama.getMesin().getPesanpopup().show("GUNAKAN AKUN TERTENTU", MesinUtama.getMesin().getLoginakun());
                    }
                }
                else if(pengecekanTeller(uname,pass, MesinUtama.getMesin().getLoginakun())){
                    if(MesinUtama.getMesin().getMode() == 4){
                        System.out.println("++ Login Teller Berhasil+ +");
                        MesinUtama.getMesin().mode(5, MesinUtama.getMesin().getLoginakun());
                    }
                    else{
                        MesinUtama.getMesin().getPesanpopup().show("GUNAKAN AKUN TERTENTU", MesinUtama.getMesin().getLoginakun());
                    }
                }
                else{
                    MesinUtama.getMesin().getPesanpopup().show("Username atau Password salah", MesinUtama.getMesin().getLoginakun());
                }
            }
                 
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Login Akun",MesinUtama.getMesin().getLoginakun());
        }
    }  
    
    private boolean pengecekanAtmdanPin(String atm, String pin, javax.swing.JFrame frame){
        try{
            return DatabaseEye.getInstance().nasabahBerdasarkanAtmdanPin(atm, pin, frame);
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari ATM dan PIN",frame);
            return false;
        }
    }
    
    private boolean pengecekanUsernamedanPassword(String uname, String pass, javax.swing.JFrame frame){
        try{
            return DatabaseEye.getInstance().nasabahBerdasarkanUsernamedanPassword(uname,pass, frame);
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Username dan Password",frame);
            return false;
        }  
    }
    
    private boolean pengecekanAdmin(String uname, String pass, javax.swing.JFrame frame){
        try{    
            return DatabaseEye.getInstance().adminBerdasarkanUsernamedanPassword(uname, pass, frame);
        }       
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Verivikasi Admin",frame);
            return false;
        }    
    }
    
    private boolean pengecekanTeller(String uname, String pass, javax.swing.JFrame frame){
        try{    
            return DatabaseEye.getInstance().tellerBerdasarkanUsernamedanPassword(uname, pass, frame);
        }       
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Verivikasi Teller",frame);
            return false;
        }    
    }
    
    private long cariRekening(String uname, javax.swing.JFrame frame){
        if(DatabaseEye.getInstance().nasabahBerdasarkanUsername(uname, frame)){
            return Long.parseLong(MesinUtama.getMesin().getUserNasabah().getNo_rekening());
        }
        return 0;
    }
    
    //</editor-fold>
}
