/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zeynepnida
 */
public class MysqlConn {

    private static MysqlConn mysqlConn;
    private Connection con;

    private MysqlConn() {
        try {

            //  Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/stajer", "root", "123456");

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
    public static MysqlConn getConnection() {
        if (mysqlConn == null) {
            mysqlConn = new MysqlConn();
        }
        return mysqlConn;
    }
    public Connection getConn() {
        return this.con;
    }
}
