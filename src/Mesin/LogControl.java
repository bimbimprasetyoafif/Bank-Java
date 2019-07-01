/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mesin;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class LogControl{
    private static LogControl log;
    
    public static LogControl getInstance(){
        if(log == null){
            log = new LogControl();
        }
        return log;
    }
    
    //<editor-fold defaultstate="collapsed" desc="PENGATURAN PESAN (Berhasil, Warning, Error)">
    
    public void cetakLogException(Exception e, String pesan, javax.swing.JFrame frame){
        System.out.println("---------------------------------------------------------");
        MesinUtama.getMesin().getPesanpopup().show(pesan, frame);
        System.out.println(pesan);
        System.out.println(e+" @ "+e.getMessage());
    }
    
    public void TampilkanPesan(String pesan, javax.swing.JFrame frame){
        MesinUtama.getMesin().getPesanpopup().setFramemya(frame);
        frame.disable();
    }
    
    public void TutupPesan(javax.swing.JFrame frame){
        frame.enable();
    }
    
    //</editor-fold>
}
