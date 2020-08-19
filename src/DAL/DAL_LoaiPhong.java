/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_LoaiPhong;
import GUI.main;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LGNV
 */
public class DAL_LoaiPhong {

    public static ArrayList<DTO_LoaiPhong> getLoaiPhong(String sql, Object... obj) {
        ArrayList<DTO_LoaiPhong> list = new ArrayList<>();
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

    public static DTO_LoaiPhong convertRStoObject(ResultSet rs) {
        DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong();
        try {
            loaiPhong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
            loaiPhong.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
            loaiPhong.setGiaPhong(rs.getBigDecimal("GiaPhong"));
            loaiPhong.setMoTa(rs.getString("MoTa"));
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiPhong;
    }

    public static void delete(String MaLoaiPhong) {
        String sql = "delete LoaiPhong where LoaiPhong.MaLoaiPhong = ?";
        main.conn.executeUpdate(sql, MaLoaiPhong);
    }

    public static ArrayList<DTO_LoaiPhong> select() {

        String sql = "select * from LoaiPhong";

        return getLoaiPhong(sql);
    }

    public static void update(DTO_LoaiPhong loaiPhong) {
        String sql = "UPDATE LoaiPhong SET TenLoaiPhong = ?,GiaPhong = ? ,MoTa = ?  WHERE MaLoaiPhong = ?";
        main.conn.executeUpdate(sql,
                loaiPhong.getTenLoaiPhong(),
                loaiPhong.getGiaPhong(),
                loaiPhong.getMoTa(),
                loaiPhong.getMaLoaiPhong()
        );
    }

    public static void insert(DTO_LoaiPhong loaiPhong) {
        String sql = "insert into LoaiPhong values(?,?,?,?)";
        main.conn.executeUpdate(sql,
                loaiPhong.getMaLoaiPhong(),
                loaiPhong.getTenLoaiPhong(),
                loaiPhong.getGiaPhong(),
                loaiPhong.getMoTa()
        );
    }

    public static DTO_LoaiPhong findByID(String MaLoaiPhong) {
        String sql = "select * from LoaiPhong where LoaiPhong.MaLoaiPhong = ?";
        ResultSet rs = main.conn.resultSet(sql, MaLoaiPhong);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<DTO_LoaiPhong> fiterPhong( String MaLoaiPhong,BigDecimal min , BigDecimal max ){
        String sql = "exec sp_LocPhong ?, ?, ?, ?, ?";
        ResultSet rs =  main.conn.resultSet(sql,
            "",
            MaLoaiPhong, 
            min,
            max,
            ""
        );
        ArrayList<DTO_LoaiPhong> list = new ArrayList<>();
        
        try {
            while (rs.next()) {                
                DTO_LoaiPhong loaiphong = convertRStoObject(rs);
                list.add(loaiphong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
