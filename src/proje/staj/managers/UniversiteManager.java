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
import proje.staj.db.Universite;

/**
 *
 * @author Zeynepnida
 */
public class UniversiteManager {
    
    
    
    public ArrayList<Universite> getAllUni() throws SQLException{
        ArrayList<Universite> list=new ArrayList<>();
        
        Connection con=MysqlConn.getConnection().getConn();
         PreparedStatement st = null;
            ResultSet rs = null;
        
        try{
            String sql = "select * from universite order by adi";
            st = con.prepareStatement(sql);
        
            rs = st.executeQuery();
            while (rs.next()) {
                Universite uni=new Universite();
                uni.setId(rs.getInt(1));
                uni.setAdi(rs.getString(2));
                list.add(uni);
            }
        }catch(SQLException e){
            throw e;
        }  finally{
            try{
                st.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
        
        return list;
    }
    
    
    public Universite getUniversite(int id) throws SQLException{
       
        Connection con=MysqlConn.getConnection().getConn();
         PreparedStatement st = null;
            ResultSet rs = null;
        
        try{
            String sql = "select * from universite where id=?";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                Universite uni=new Universite();
                uni.setId(rs.getInt(1));
                uni.setAdi(rs.getString(2));
                return uni;
            }
        }catch(SQLException e){
            throw e;
        }  finally{
            try{
                st.close();
                rs.close();
            }catch(Exception e){
                
            }
        }
        
        return null;
    }
}
