/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Bimo Prasetyo Afif
 */
public class FilterInputControl{
    
    private static FilterInputControl filter;
    
    public static FilterInputControl getInstance(){
        if(filter == null){
            filter = new FilterInputControl();
        }
        return filter;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="CEK PARAMETER INPUT DARI USER">
 
    public boolean cekKekosongan(String sesuatu, javax.swing.JLabel label){
        if(sesuatu.length()<1){
            label.setText("Tidak Boleh Kosong");
            return true;
        }
        else{
            label.setText(null);
            return false;
        }
    }
    
    public boolean cekKevalidanAngka(String sesuatu, javax.swing.JLabel label){
        if(sesuatu.startsWith("0") || Long.parseLong(sesuatu) < 1 || !sesuatu.matches("\\d+")){
            label.setText("Angka Tidak Valid");
            return true;
        }
        else{
            label.setText(null);
            return false;
        }
    }
    
    public boolean cekRekening(String rekening, javax.swing.JLabel label){
        try{
            if(cekKekosongan(rekening,label)){
                return false;
            }
            else if(rekening.length() != 9 || Long.parseLong(rekening) < 101213001){
                label.setText("Rekening Tidak Valid");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
            
        }
        catch(Exception e){    
            label.setText("Harus Angka");
            return false;
        }
        
    }
    
    public boolean cekAtm(String atm, javax.swing.JLabel label){
        try{
            if(cekKekosongan(atm,label)){
                return false;
            }
            else if(atm.length() != 8 & Long.parseLong(atm) < 19216811){
                label.setText("ATM Tidak Valid");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
            
        }
        catch(Exception e){    
            label.setText("Harus Angka");
            return false;
        }
        
    }
    
    public boolean cekNama(String nama, javax.swing.JLabel label){
        try{
            if(cekKekosongan(nama,label)){
                return false;
            }
            else if(!(nama.matches("^[a-zA-Z\\s]+"))){
                label.setText("Nama Tidak Valid");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
        }
        catch(Exception e){
            label.setText("Nama Tidak Valid");
            return false;
        }
    }
    
    public boolean cekPin(String pin, javax.swing.JLabel label){ //Biasanya untuk pendaftaran nasabah
        try{
            if(cekKekosongan(pin,label)){
                return false;
            }
            else if(!pin.matches("^[0-9]+")){
                label.setText("Harus Angka");
                return false;
            }
            else if(pin.length()!=6){
                label.setText("Harus 6 Digit");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
            
        }
        catch(Exception e){            
            label.setText("Harus Angka");
            return false;
        }
        
    }
    
    public boolean cekNominal(String nominal, javax.swing.JLabel label){
        try{
            if(cekKekosongan(nominal,label)){
                return false;
            }
            else if(cekKevalidanAngka(nominal,label)){
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
            
        }
        catch(Exception e){            
            label.setText("Harus Angka");
            return false;
        }
    }
    
    public boolean cekRekTujuanTransfer(String rektujuan, javax.swing.JLabel label){
        try{
            if(rektujuan.equals(MesinUtama.getMesin().getUserNasabah().getNo_rekening())){
                label.setText("Harus Rek Tujuan");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
        }
        catch(Exception e){
            label.setText("Harus Angka");
            return false;
        }
    }
    
    public boolean cekNominaldanMinimal(String nominal, Long minimal, javax.swing.JLabel label){
        
            if(cekNominal(nominal, label)){
                if(Long.parseLong(nominal)<minimal){
                    label.setText("Minimal Rp."+minimal);
                    return false;
                }
                else{
                    label.setText(null);
                    return true;
                }
            }
            return false;
            
    }
     
    public boolean cekUsernameatauPasswordBaru(String str, javax.swing.JLabel label){
        try{
            if(cekKekosongan(str,label)){
                return false;
            }
            else if(str.length() < 8){
                label.setText("Minimal 8 Karakter");
                return false;
            }
            else{
                label.setText(null);
                return true;
            }
        }
        catch(Exception e){
            label.setText("Input Tidak Valid");
            return false;
        }
    }
    
    
    //</editor-fold>     
    
}
