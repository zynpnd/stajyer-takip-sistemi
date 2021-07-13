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
import java.sql.Statement;
import java.util.ArrayList;
import proje.java.sql.MysqlConn;
import proje.staj.db.Bolum;
import proje.staj.db.Ogrenci;
import proje.staj.db.Staj;
import proje.staj.db.Universite;

/**
 *
 * @author Zeynepnida
 */
public class OgrenciManager {

    public void ekleOgrenci(Ogrenci ogrenci) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO ogrenciler "
                    + "(TC,Adi,Soyadi,Okul_id,Bolum_id)"
                    + " VALUES (?,?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setLong(1, ogrenci.getTc());
            st.setString(2, ogrenci.getAd());
            st.setString(3, ogrenci.getSoyad());
            st.setInt(4, ogrenci.getOkul().getId());
            st.setInt(5, ogrenci.getBolum().getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                st.close();
            } catch (Exception e) {

            }
        }
    }

    public ArrayList<Ogrenci> getAllOgrenci() throws SQLException {
        ArrayList<Ogrenci> ogrenciList = new ArrayList<>();
        Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        UniversiteManager uniMan = new UniversiteManager();
        BolumManager bolumMan = new BolumManager();
        try {

            String sql = "SELECT * FROM ogrenciler";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Ogrenci ogr = new Ogrenci();
                ogr.setOkul(new Universite());
                ogr.setBolum(new Bolum());
                ogr.setTc(rs.getLong("TC"));
                ogr.setAd(rs.getString("Adi"));
                ogr.setSoyad(rs.getString("Soyadi"));
                ogr.setOkul(uniMan.getUniversite(rs.getInt("Okul_id")));
                ogr.setBolum(bolumMan.getBolum(rs.getInt("Bolum_id")));
                ogrenciList.add(ogr);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return ogrenciList;

    }

    public Ogrenci getOgrenci(long tc) {
        Ogrenci ogrenci = null;
        Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        UniversiteManager uniMan = new UniversiteManager();
        BolumManager bolumMan = new BolumManager();
        try {
            String sql = "SELECT * FROM ogrenciler where TC=?";
            stmt = con.prepareStatement(sql);

            stmt.setLong(1, tc);
            rs = stmt.executeQuery();

            if (rs.next()) {
                ogrenci = new Ogrenci();
                ogrenci.setOkul(new Universite());
                ogrenci.setBolum(new Bolum());
                ogrenci.setTc(rs.getLong("TC"));
                ogrenci.setAd(rs.getString("Adi"));
                ogrenci.setSoyad(rs.getString("Soyadi"));
                ogrenci.setOkul(uniMan.getUniversite(rs.getInt("Okul_id")));
                ogrenci.setBolum(bolumMan.getBolum(rs.getInt("Bolum_id")));

            } else {
                System.out.println(tc + " ");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return ogrenci;
    }

    public void ekleuser(Staj staj) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO staj" + "(TC_no,birim_id,baslama_tarihi,bitis_tarihi,staj_gun)" + "VALUES(?,?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setLong(1, staj.getOgrenci().getTc());
            st.setInt(2, staj.getBirim().getId());
            st.setDate(3, new java.sql.Date(staj.getBaslama_tarihi().getTime()));
            st.setDate(4, new java.sql.Date(staj.getBitis_tarihi().getTime()));
            st.setInt(5, staj.getStaj_gun());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                st.close();
            } catch (Exception e) {

            }
        }
    }

    public void silOgrenci(Ogrenci ogrenci) throws SQLException {
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = "delete from ogrenciler where TC=?";
            st = con.prepareStatement(sql);
            st.setLong(1, ogrenci.getTc());
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                st.close();
            } catch (Exception e) {

            }
        }
    }

    public void duzenleOgrenci(Ogrenci ogrenci) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = " UPDATE ogrenciler  SET Adi=?,Soyadi=?,Okul_id=?,Bolum_id=? where TC=?";
            st = con.prepareStatement(sql);

            st.setString(1, ogrenci.getAd());
            st.setString(2, ogrenci.getSoyad());
            st.setInt(3, ogrenci.getOkul().getId());
            st.setInt(4, ogrenci.getBolum().getId());
            st.setLong(5, ogrenci.getTc());
            st.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                st.close();
            } catch (Exception e) {

            }
        }
    }
 
}
