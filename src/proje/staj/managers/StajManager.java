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
import proje.staj.db.Staj;

/**
 *
 * @author Zeynepnida
 */
public class StajManager {

    public ArrayList<Staj> getAllOgrenci() throws SQLException {

        OgrenciManager ogrMan = new OgrenciManager();
        BirimManager birimMann = new BirimManager();
        ArrayList<Staj> stajList = new ArrayList<>();
        Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
          String sql = "SELECT * FROM staj";
            stmt = con.prepareStatement(sql);
        
            rs = stmt.executeQuery();
           
            while (rs.next()) {
                Staj staj = new Staj();
                staj.setBaslama_tarihi(rs.getDate("Baslama_tarihi"));
                staj.setBitis_tarihi(rs.getDate("Bitis_tarihi"));
                staj.setStaj_gun(rs.getInt("Staj_gun"));
                staj.setBirim(birimMann.getBirim(rs.getInt("Birim_id")));
                staj.setOgrenci(new OgrenciManager().getOgrenci(rs.getLong("TC_no")));
                staj.setId(rs.getLong("ID"));
                stajList.add(staj);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stajList;
    }

    public void duzenleStaj(Staj staj) throws SQLException {
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = " UPDATE staj  SET Birim_id=?, Baslama_tarihi=?, Bitis_tarihi=?, Staj_gun=? where id=?";
            st = con.prepareStatement(sql);
            st.setInt(1, staj.getBirim().getId());
            st.setDate(2, new java.sql.Date(staj.getBaslama_tarihi().getTime()));
            st.setDate(3, new  java.sql.Date(staj.getBitis_tarihi().getTime()));
            st.setInt(4, staj.getStaj_gun());
            st.setLong(5, staj.getId());
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

    Staj getStaj(long id) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from staj where ID=?";
            st = con.prepareStatement(sql);
            st.setLong(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Staj stj = new Staj();
                stj.setId(rs.getLong(1));

                return stj;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                st.close();
                rs.close();
            } catch (Exception e) {

            }
        }

        return null;
    }

}
