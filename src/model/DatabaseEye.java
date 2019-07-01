/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Admin;
import Database.Database;
import Database.Nasabah;
import Database.TellerAdmin;
import controller.FilterInputControl;
import controller.LogControl;
import controller.MesinUtama;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class DatabaseEye {
    
    private static DatabaseEye dbeye;
    
    public static DatabaseEye getInstance(){
        if(dbeye == null){
            dbeye = new DatabaseEye();
        }
        return dbeye;
    }
    
    //<editor-fold defaultstate="collapsed" desc="PENCARIAN DATA USER (Nasabah / Admin)">
    
    public boolean adminBerdasarkanUsernamedanPassword(String uname, String pass, javax.swing.JFrame frame){
        MesinUtama.getMesin().setStatus(false);
        MesinUtama.getMesin().setUserAdminNull();
        
        try{
            for(Admin admin : Database.getInstance().getAdmin()){
                if(admin.getUsername().equals(uname) & admin.getPassword().equals(pass)){
                    MesinUtama.getMesin().setUserAdmindanStatus(admin, true);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari User Admin",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean tellerBerdasarkanUsernamedanPassword(String uname, String pass, javax.swing.JFrame frame){
        MesinUtama.getMesin().setStatus(false);
        MesinUtama.getMesin().setUserTellerNull();
        
        try{
            for(TellerAdmin teller : Database.getInstance().getTellerAdmin()){
                if(teller.getUsername().equals(uname) & teller.getPassword().equals(pass)){
                    MesinUtama.getMesin().setUserTellerdanStatus(teller, true);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari User Admin",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahBerdasarkanRekening(String rekening, javax.swing.JFrame frame){
        MesinUtama.getMesin().initNasabahNullAndStatusFalse();
        try{
            for(Nasabah nasabah : Database.getInstance().getNasabah()){
                if(nasabah.getNo_rekening().equals(rekening)){
                    MesinUtama.getMesin().setUserNasabahdanStatus(nasabah, true);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Rekening",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahBerdasarkanRekening2(String rekening, javax.swing.JFrame frame){
        MesinUtama.getMesin().setStatus(false);
        MesinUtama.getMesin().setUserNasabah2Null();
        try{
            for(Nasabah nasabah : Database.getInstance().getNasabah()){
                if(nasabah.getNo_rekening().equals(rekening)){
                    MesinUtama.getMesin().setUserNasabah2danStatus(nasabah, true);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Rekening Tujuan",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahBerdasarkanAtmdanPin(String atm, String pin, javax.swing.JFrame frame){
        MesinUtama.getMesin().initNasabahNullAndStatusFalse();
        try{
                for(Nasabah nasabah : Database.getInstance().getNasabah()){
                    if(nasabah.getATM().equals(atm) & nasabah.getPin().equals(pin)){
                        MesinUtama.getMesin().setUserNasabahdanStatus(nasabah, true);
                        break;
                    }
                }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Rek dan PIN",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahBerdasarkanUsername(String uname, javax.swing.JFrame frame){
        MesinUtama.getMesin().initNasabahNullAndStatusFalse();
        System.out.println(MesinUtama.getMesin().getStatus()+ " statusnya");
        try{
            for(Nasabah nasabah : Database.getInstance().getNasabah()){
                if(nasabah.getUsername().equals(uname)){
                    MesinUtama.getMesin().setUserNasabahdanStatus(nasabah, true);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Username",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahBerdasarkanUsernamedanPassword(String uname, String pass, javax.swing.JFrame frame){
        MesinUtama.getMesin().initNasabahNullAndStatusFalse();
        try{
                for(Nasabah nasabah : Database.getInstance().getNasabah()){
                    if(nasabah.getUsername().equals(uname) & nasabah.getPassword().equals(pass)){
                        MesinUtama.getMesin().setUserNasabahdanStatus(nasabah, true);
                        break;
                    }
                }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Username dan Password",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahMencariUsername(String uname, javax.swing.JLabel label, javax.swing.JFrame frame){
        MesinUtama.getMesin().initStatusdanLabel(true, label);
        try{
            if(uname.equalsIgnoreCase("admin")){
                    label.setText("username tidak diperbolehkan");
                    MesinUtama.getMesin().setStatus(false);
            }
            else{
                for(Nasabah nasabah : Database.getInstance().getNasabah()){
                    if(nasabah.getUsername().equals(uname)){
                        label.setText("username sudah ada");
                        MesinUtama.getMesin().setStatus(false);
                        break;
                    }
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e,"Gagal Mencari Username",frame);
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    public boolean nasabahMencariNoIdentitas(String id, javax.swing.JLabel label){
        MesinUtama.getMesin().initStatusdanLabel(true, label);
        try{
            if(FilterInputControl.getInstance().cekKekosongan(id,label)){
                MesinUtama.getMesin().setStatus(false);
                return MesinUtama.getMesin().getStatus();
            }
            else if(FilterInputControl.getInstance().cekKevalidanAngka(id,label)){
                MesinUtama.getMesin().setStatus(false);
                return MesinUtama.getMesin().getStatus();
            }
            else if(Long.parseLong(id)<=0){
                label.setText("Tidak boleh <= 0");
            }
            for (Nasabah nasabah : Database.getInstance().getNasabah()) {
                if(nasabah.getNo_identitas().equals(id)){
                    label.setText("Nomor sudah terdaftar");
                    MesinUtama.getMesin().setStatus(false);
                    break;
                }
            }
            return MesinUtama.getMesin().getStatus();
        }
        catch(Exception e){
            label.setText("Harus Angka");
            return MesinUtama.getMesin().getStatus();
        }
    }
    
    //</editor-fold>
}
