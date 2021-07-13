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
import proje.staj.db.Bolum;

/**
 *
 * @author Zeynepnida
 */
public class BolumManager {
      
    public ArrayList<Bolum> getAllBolum() throws SQLException {
        ArrayList<Bolum> list = new ArrayList<>();

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from bolum order by adi";
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Bolum bol = new Bolum();
                bol.setId(rs.getInt(1));
                bol.setAdi(rs.getString(2));
                list.add(bol);
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

    public Bolum getBolum(int id) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * from bolum where id=?";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Bolum bolum = new Bolum();
                bolum.setId(rs.getInt(1));
                bolum.setAdi(rs.getString(2));
                return bolum;
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
