/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.managers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proje.java.sql.MysqlConn;
import proje.staj.db.Devam;
import proje.staj.db.Staj;

/**
 *
 * @author Zeynepnida
 */
public class DevamManager {

    public void geldi(Devam devam) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = "REPLACE  INTO devam (Staj_ID,Tarih,Durum) VALUES (?,?,?) ";
            st = con.prepareStatement(sql);
            st.setLong(1, devam.getStaj().getId());
            st.setDate(2, (new java.sql.Date(devam.getTarih().getTime())));
            st.setString(3, devam.getDurum() + "");
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

    public void gelmedi(Devam devam) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = "REPLACE  INTO devam (Staj_ID,Tarih,Durum) VALUES (?,?,?) ";
            st = con.prepareStatement(sql);
            st.setLong(1, devam.getStaj().getId());
            st.setDate(2, (new java.sql.Date(devam.getTarih().getTime())));
            st.setString(3, devam.getDurum() + "");
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

    public ArrayList<Devam> getAllOgrenci(Staj staj) throws SQLException {
      
      ArrayList<Devam> devamList = new ArrayList<>();
        Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        StajManager stajMan = new StajManager();

        try {
            String sql="SELECT * FROM devam where Staj_id=?";
            stmt=con.prepareStatement(sql);
            
            stmt.setLong(1, staj.getId());

            rs = stmt.executeQuery();
            while (rs.next()) {
                Devam devam = new Devam();
                devam.setStaj(stajMan.getStaj(rs.getLong("Staj_id")));
                devam.setTarih(rs.getDate("Tarih"));
                devam.setDurum(rs.getString("Durum").charAt(0));
               
                devamList.add(devam);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devamList;

    }

    public Boolean getDurum(java.util.Date time, Staj selectedStaj) {
         Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        StajManager stajMan = new StajManager();

        try {

            String sql="SELECT * FROM devam where Staj_id=? and Tarih=? ";
           stmt= con.prepareStatement(sql);
                    
           stmt.setLong(1, selectedStaj.getId());
           stmt.setDate(2, new Date(time.getTime()));
           
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("Durum").charAt(0)=='E';
              

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return false;
    }
}
