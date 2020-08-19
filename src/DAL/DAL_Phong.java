/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;
import GUI.main;
import java.math.BigDecimal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quyet
 */
public class DAL_Phong {


    public static ArrayList<DTO_Phong> getPhong(String sql, Object... obj) {
        ArrayList<DTO_Phong> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {
                list.add(convertRStoObject(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static DTO_Phong convertRStoObject(ResultSet rs) {
        DTO_Phong phong = new DTO_Phong();
        try {
            phong.setMaPhong(rs.getString("MaPhong"));
            phong.setMaKhuVuc(rs.getString("MaKhuVuc"));
            phong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
            phong.setMaTinhTrang(rs.getString("MaTinhTrang"));
            phong.setMoTa(rs.getString("MoTa"));
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phong;
    }

    public static void delete(String MaLoaiPhong) {
        String sql = "delete phong where phong.MaPhong = ?";
        main.conn.executeUpdate(sql, MaLoaiPhong);
    }

    public static ArrayList<DTO_Phong> select() {

        String sql = "select * from phong";

        return getPhong(sql);
    }

    public static void update(DTO_Phong Phong,String MaPhongHienTai ) {
        String sql = "UPDATE Phong SET MaPhong = ?,MaKhuVuc = ? ,MaLoaiPhong = ?, MaTinhTrang=  ?, MoTa= ?  WHERE MaPhong = ?";
        main.conn.executeUpdate(sql,
                Phong.getMaPhong(),
                Phong.getMaKhuVuc(),
                Phong.getMaLoaiPhong(),
                Phong.getMaTinhTrang(),
                Phong.getMoTa(),
                MaPhongHienTai
        );
    }

    public static void insert(DTO_Phong Phong) {
        String sql = "insert into Phong values(?,?,?,?,?)";
        main.conn.executeUpdate(sql,
                Phong.getMaPhong(),
                Phong.getMaKhuVuc(),
                Phong.getMaLoaiPhong(),
                Phong.getMaTinhTrang(),
                Phong.getMoTa()
        );
    }

    public static DTO_Phong findByID(String MaPhong) {
        String sql = "select * from Phong where Phong.MaPhong = ?";
        ResultSet rs = main.conn.resultSet(sql, MaPhong);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<DTO_Phong> fiterPhong(String tuKhoa, String MaLoaiPhong,BigDecimal min , BigDecimal max,String maTinhTrang ){
        String sql = "exec sp_LocPhong ?, ?, ?, ?, ?";
        ResultSet rs =  main.conn.resultSet(sql,
            tuKhoa,
            MaLoaiPhong, 
            min,
            max,
            maTinhTrang
        );
        ArrayList<DTO_Phong> list = new ArrayList<>();
        
        try {
            while (rs.next()) {                
                DTO_Phong phong = convertRStoObject(rs);
                list.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

}
