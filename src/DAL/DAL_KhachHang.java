/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_KhachHang;
import GUI.main;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5450i5
 */
public class DAL_KhachHang {

    public static ArrayList<DTO_KhachHang> getKhachHang(String sql, Object... obj) {
        ArrayList<DTO_KhachHang> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {
                list.add(convertRStoObject(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static DTO_KhachHang convertRStoObject(ResultSet rs) {
        DTO_KhachHang KhachHang = new DTO_KhachHang();
        try {
            KhachHang.setMaKhachHang(rs.getString("MaKhachHang"));
            KhachHang.setTenKhachHang(rs.getString("TenKhachHang"));
            KhachHang.setCMND(rs.getString("CMND"));
            KhachHang.setMaLoaiKhachHang("Thường");
            KhachHang.setSDT(rs.getString("SDT"));
            KhachHang.setDiaChi(rs.getString("DiaChi"));
            KhachHang.setNgaySinh(rs.getDate("NgaySinh"));
            KhachHang.setGioiTinh(rs.getBoolean("GioiTinh"));
            KhachHang.setMoTa(rs.getString("MoTa"));

        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return KhachHang;
    }

    public static void delete(String MaKhachHang) {
        String sql = "delete KhachHang where MaKhachHang = ?";
        main.conn.executeUpdate(sql, MaKhachHang);
    }

    public static ArrayList<DTO_KhachHang> select() {
        String sql = "select * from KhachHang";

        return getKhachHang(sql);
    }

    public static void update(DTO_KhachHang KhachHang) {
        
        System.out.println("đã vào dal update khách hàng");
        String sql = "update KhachHang set TenKhachHang = ?, CMND = ?, MaLoaiKhachHang =?,"
                + " SDT = ?, DiaChi = ?, NgaySinh = ?, GioiTinh = ?, MoTa = ?"
                + " where MaKhachHang = ?";
        main.conn.executeUpdate(sql,
                KhachHang.getTenKhachHang(),
                KhachHang.getCMND(),
                "LKH01",
                KhachHang.getSDT(),
                KhachHang.getDiaChi(),
                KhachHang.getNgaySinh(),
                KhachHang.isGioiTinh(),
                KhachHang.getMoTa(),
                KhachHang.getMaKhachHang()
        );
    }

    
    
    public static void insert(DTO_KhachHang KhachHang) {
        String sql = "insert into KhachHang"
                + " (TenKhachHang, CMND, MaLoaiKhachHang, SDT, DiaChi, GioiTinh, NgaySinh, MoTa)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?)";
        main.conn.executeUpdate(sql,
                KhachHang.getTenKhachHang(),
                KhachHang.getCMND(),
                "LKH01",
                KhachHang.getSDT(),
                KhachHang.getDiaChi(),
                KhachHang.isGioiTinh(),
                KhachHang.getNgaySinh(),
                
                KhachHang.getMoTa()
        );
    }

    public static DTO_KhachHang findByID(String MaKhachHang) {
        String sql = "select * from KhachHang where MaKhachHang = ?";
        ResultSet rs = main.conn.resultSet(sql, MaKhachHang);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static DTO_KhachHang findByCMND(String CMND) {
        String sql = "select * from KhachHang where CMND = ?";
        ResultSet rs = main.conn.resultSet(sql, CMND);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static ArrayList<DTO_KhachHang> filter(String TuKhoa, String gioiTinh, String maLoaiKhachHang, int FromNamSinh, int toNamSinh){
        String sql = "exec sp_locKhachHang ?,?,?,?,?";
        ResultSet rs = main.conn.resultSet(sql,
            TuKhoa,
            maLoaiKhachHang,
            FromNamSinh,
            toNamSinh,
            gioiTinh
        );
        ArrayList<DTO_KhachHang> list = new ArrayList<>();
        
        try {
            while (rs.next()) {                
                DTO_KhachHang khachHang = convertRStoObject(rs);
                list.add(khachHang);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
