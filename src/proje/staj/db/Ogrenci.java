/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.db;

/**
 *
 * @author Zeynepnida
 */
public class Ogrenci {

    private Long Tc;
    private String ad;
    private String soyad;
    private Universite okul;
    private Bolum bolum;

    public Long getTc() {
        return Tc;
    }

    public void setTc(Long Tc) {
        this.Tc = Tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Universite getOkul() {
        return okul;
    }

    public void setOkul(Universite okul) {
        this.okul = okul;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    @Override
    public String toString() {
        return this.getAd() + " " + this.getSoyad();
    }

}
