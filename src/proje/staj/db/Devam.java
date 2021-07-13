/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.db;

import java.util.Date;

/**
 *
 * @author Zeynepnida
 */
public class Devam {
    
    private Staj staj;
    private Date tarih;
    private char durum;

    public Staj getStaj() {
        return staj;
    }

    public void setStaj(Staj staj) {
        this.staj = staj;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public char getDurum() {
        return durum;
    }

    public void setDurum(char durum) {
        this.durum = durum;
    }


    

  
    
    
}
