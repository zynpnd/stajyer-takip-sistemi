/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import proje.java.sql.MysqlConn;
import proje.staj.db.Bolum;
import proje.staj.db.Ogrenci;
import proje.staj.db.Proje;
import proje.staj.db.ProjeStaj;
import proje.staj.db.Sifre;
import proje.staj.db.Staj;
import proje.staj.db.Universite;

/**
 *
 * @author Zeynepnida
 */
public class AramaManager {
    
    public Ogrenci arauser(int tc) throws SQLException {
        
        UniversiteManager uniMan = new UniversiteManager();
        Ogrenci ogrenci = null;
        BolumManager bolumMan = new BolumManager();
        
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from ogrenciler  where TC=?";
        st = con.prepareStatement(sql);
        st.setInt(1, tc);
        rs = st.executeQuery();
        
        if (rs.next()) {
            ogrenci = new Ogrenci();
            ogrenci.setTc(rs.getLong(1));
            ogrenci.setAd(rs.getString(2));
            ogrenci.setSoyad(rs.getString(3));
            ogrenci.setOkul(uniMan.getUniversite(rs.getInt(4)));
            ogrenci.setBolum(bolumMan.getBolum(rs.getInt(5)));
        }
        return ogrenci;
    }
    
    public Sifre arasifre(String adi) throws SQLException {
        Sifre sifre = null;
        Connection con = MysqlConn.getConnection().getConn();
        
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from sifre  where Personel_Adi=?";
        st = con.prepareStatement(sql);
        st.setString(1, adi);
        rs = st.executeQuery();
        
        if (rs.next()) {
            sifre = new Sifre();
            sifre.setP_ad(rs.getString(1));
            sifre.setP_soyad(rs.getString(2));
            sifre.setKullanici_ad(rs.getString(3));
            sifre.setSifre(rs.getInt(4));
        }
        
        return sifre;
    }


}
