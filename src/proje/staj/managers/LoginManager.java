/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.managers;

import java.sql.Connection;
import java.sql.DriverManager;
import proje.java.sql.MysqlConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeynepnida
 */
public class LoginManager {

 

    public LoginManager() {
    }

    public boolean isValidUser(String username, String password) throws SQLException {

            Connection con = MysqlConn.getConnection().getConn();
            PreparedStatement st = null;
            ResultSet rs = null;
            String sql = "select * from sifre where kullanici_adi=? and parola=?";
            st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();
            if (rs.next()) {
                return true;
                 }
                 else
                 {
                    return false;
            }

       
    }
}
