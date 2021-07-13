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
public class Staj {
    private Ogrenci ogrenci;
    private Birim birim;
    private Long id;
    private Date baslama_tarihi;
    private Date bitis_tarihi;
    private int staj_gun;

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Birim getBirim() {
        return birim;
    }

    public void setBirim(Birim birim) {
        this.birim = birim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBaslama_tarihi() {
        return baslama_tarihi;
    }

    public void setBaslama_tarihi(Date baslama_tarihi) {
        this.baslama_tarihi = baslama_tarihi;
    }

    public Date getBitis_tarihi() {
        return bitis_tarihi;
    }

    public void setBitis_tarihi(Date bitis_tarihi) {
        this.bitis_tarihi = bitis_tarihi;
    }

    public int getStaj_gun() {
        return staj_gun;
    }

    public void setStaj_gun(int staj_gun) {
        this.staj_gun = staj_gun;
    }

   
 @Override
    public String toString() {
        return this.getOgrenci().getTc()+" "+this.getOgrenci().getAd()+" "+this.getOgrenci().getSoyad();
    }

    
    
}
