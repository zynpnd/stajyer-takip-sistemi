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
import proje.staj.db.Proje;
import proje.staj.db.ProjeStaj;
import proje.staj.db.Staj;

/**
 *
 * @author Zeynepnida
 */
public class ProjeManager {

    public ArrayList<Proje> getAllOgrenci() throws SQLException {

        ArrayList<Proje> projeList = new ArrayList<>();
        Connection con = MysqlConn.getConnection().getConn();
        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM proje";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Proje prj = new Proje();

                prj.setAdi(rs.getString("adi"));
                prj.setAciklama(rs.getString("aciklama"));
                prj.setId(rs.getLong("proje_id"));
                projeList.add(prj);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return projeList;

    }

    public void ekleProje(Proje proje) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO proje"
                    + "(adi,aciklama)"
                    + " VALUES (?,?)";
            st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, proje.getAdi());
            st.setString(2, proje.getAciklama());

            st.executeUpdate();

            rs = st.getGeneratedKeys();
            if (rs.next()) {
                proje.setId(rs.getLong(1));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                st.close();
            } catch (Exception e) {

            }
        }

    }

    public ArrayList<Proje> getProjeListByAd(String projeadi) throws SQLException {

        ArrayList<Proje> projelist = new ArrayList<>();
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from proje where upper(adi) like ?";
        // System.out.println(sql);
        st = con.prepareStatement(sql);
        st.setString(1, "%" + projeadi.toUpperCase() + "%");

        rs = st.executeQuery();

        if (rs.next()) {

            Proje staj = new Proje();
            staj.setId(rs.getLong(1));
            staj.setAdi(rs.getString(2));
            staj.setAciklama(rs.getString(3));

            projelist.add(staj);

        }

        return projelist;
    }

    public void silProje(Proje projee) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;

        try {
            String sql = "delete from proje where proje_id=?";
            st = con.prepareStatement(sql);
            st.setLong(1, projee.getId());
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

    public void duzenleProje(Proje projee) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = " UPDATE proje  SET adi=?, aciklama=? where proje_id=?";
            st = con.prepareStatement(sql);
            st.setString(1, projee.getAdi());
            st.setString(2, projee.getAciklama());
            st.setLong(3, projee.getId());

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

    public void ekleProje(Proje proje, Staj staj) throws SQLException {
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO projestaj (Staj_Id,P_Id) VALUES (?,?)";

            st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setLong(1, staj.getId());
            st.setLong(2, proje.getId());
          

            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if (rs.next()) {
                proje.setId(rs.getLong(1));
                staj.setId(rs.getLong(2));
            }

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