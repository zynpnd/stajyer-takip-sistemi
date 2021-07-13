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
import java.util.ArrayList;
import proje.java.sql.MysqlConn;
import proje.staj.db.Birim;

/**
 *
 * @author Zeynepnida
 */
public class BirimManager {
    
    
    public ArrayList<Birim> getAllBirim() throws SQLException{
        ArrayList<Birim> list = new ArrayList<>();

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            String sql = "select * from birim order by adi";
            st = con.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                Birim birim = new Birim();
                birim.setId(rs.getInt(1));
                birim.setAdi(rs.getString(2));
                list.add(birim);
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

        return list;
    }


 public Birim getBirim(int id) throws SQLException {
        
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from birim where id=?";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Birim birim = new Birim();
                birim.setId(rs.getInt(1));
                birim.setAdi(rs.getString(2));
                return birim;
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