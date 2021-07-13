/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proje.java.sql.MysqlConn;
import proje.staj.db.Sifre;

/**
 *
 * @author Zeynepnida
 */
public class SifreManager {

    public void eklesifre(Sifre sifreee) throws SQLException {
        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {

            String sql = "INSERT INTO sifre "
                    + "(Personel_adi,Personel_soyadi,kullanici_adi,parola ) "
                    + " VALUES (?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setString(1, sifreee.getP_ad());
            st.setString(2, sifreee.getP_soyad());
            st.setString(3, sifreee.getKullanici_ad());
            st.setInt(4, sifreee.getSifre());
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

    public void duzenlesifre(Sifre sifre) throws SQLException {

        Connection con = MysqlConn.getConnection().getConn();
        PreparedStatement st = null;
        try {
            String sql = " UPDATE sifre  SET Personel_adi=?, Personel_soyadi=?, kullanici_adi=?, parola=? where kullanici_adi=?";
            st = con.prepareStatement(sql);

            st.setString(1, sifre.getP_ad());
            st.setString(2, sifre.getP_soyad());
            st.setString(3, sifre.getKullanici_ad());
            st.setInt(4, sifre.getSifre());
             st.setString(5, sifre.getKullanici_ad());
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
