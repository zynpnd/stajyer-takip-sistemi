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
public class Birim {
    
    private int id;
    private String adi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
    
    @Override
    public String toString() {
        return this.getAdi();
    }

    @Override
    public boolean equals(Object obj) {
       
        if(!(obj instanceof Birim))
            return false;
        return ((Birim)obj).getId()==this.getId();
        
        
    }

    
}
