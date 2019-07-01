/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Database.Nasabah;
import Mesin.DatabaseEye;
import Mesin.FilterInputControl;
import Mesin.LogControl;
import Mesin.MesinUtama;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class AdminControl {
    
    DefaultTableModel model = (DefaultTableModel) MesinUtama.getMesin().getListnasabah().getjTable1().getModel();
    private static AdminControl list;
    int index;
    int allIndex;
    
    public static AdminControl getInstance(){
        if(list == null){
            list = new AdminControl();
        }
        return list;
    }
    
    public void resetPIN(String pin, javax.swing.JFrame frame){
        if(FilterInputControl.getInstance().cekPin(pin, MesinUtama.getMesin().getResetpin().getjLabel2())){
            MesinUtama.getMesin().getUserNasabah().setPin(pin);
            MesinUtama.getMesin().getPesanpopup().show("Berhasil Diganti", MesinUtama.getMesin().getListnasabah());
            frame.dispose();
        }
    }
    
    public void resetPASS(String pass, javax.swing.JFrame frame){
        
        if(FilterInputControl.getInstance().cekUsernameatauPasswordBaru(pass, MesinUtama.getMesin().getResetpass().getjLabel2())){
            MesinUtama.getMesin().getUserNasabah().setPassword(pass);
            MesinUtama.getMesin().getPesanpopup().show("Berhasil Diganti", MesinUtama.getMesin().getListnasabah());
            frame.dispose();
        }
        
    }
    
    public void hapusNasabah(String rek, javax.swing.JFrame frame){
        index = 0;
        try{
            if(FilterInputControl.getInstance().cekRekening(rek, MesinUtama.getMesin().getListnasabah().getjLabel3()) & DatabaseEye.getInstance().nasabahBerdasarkanRekening(rek, frame)){
                for(Nasabah nasabah : Database.Database.getInstance().getNasabah()){
                    if(nasabah.getNo_rekening().equals(rek)){
                        Database.Database.getInstance().getNasabah().remove(index);
                        break;
                    }
                    index++;
                }
            }
            updateTable();
            
        }
        catch(Exception e){
            LogControl.getInstance().cetakLogException(e, "Gagal Mengahpus Nasabah", frame);
        }
    }
    
    public void updateTable() {
        model.setRowCount(0);
        for(Nasabah nasabah : Database.Database.getInstance().getNasabah()){
            model.addRow(new Object[]{nasabah.getNo_rekening(), nasabah.getNama(), nasabah.getNo_identitas(), nasabah.getATM(), nasabah.getUsername()});
            
        }
    }
}
