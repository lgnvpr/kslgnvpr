/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class Dao_ConnectSQL {

    Connection conn;
    public static String user = "sa";
    public static String Pass = "songlong";
    public static String Server = "localhost";
    public static String DataBaseName = "QuanLiKhachSan_Nhom1";

    public Dao_ConnectSQL() {
        connect();
    }

    public void connect() {
        try {
            String DBSQL = "jdbc:sqlserver://localhost;databaseName=" + DataBaseName + ";user=" + user + ";password=" + Pass + "";
            conn = DriverManager.getConnection(DBSQL);
            resultConnect = true;
        } catch (SQLException ex) {
            resultConnect = false;
            System.out.println(ex);
            Logger.getLogger(Dao_ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean resultConnect = true;

    public PreparedStatement preparedStatement(String sql, Object... ob) {
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            for (int i = 0; i < ob.length; i++) {
                ps.setObject(i + 1, ob[i]);
            }

            return ps;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(Dao_ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet resultSet(String sql, Object... ob) {
        try {

            ResultSet rs = preparedStatement(sql, ob).executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean executeUpdate(String sql, Object... ob) {
        PreparedStatement Statement = preparedStatement(sql, ob);
        try {
            Statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ConnectSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
