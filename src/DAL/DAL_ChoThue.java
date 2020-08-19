/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_KhachHang;
import DTO.PhieuThue;
import GUI.main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LGNV
 */
public class DAL_ChoThue {
    
    public static ArrayList<PhieuThue> getData(String sql, Object... obj) {
        ArrayList<PhieuThue> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {
                list.add(convertRStoObject(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_ChoThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static PhieuThue convertRStoObject(ResultSet rs) {
        PhieuThue phieuThue = new PhieuThue();
        try {
            phieuThue.setMaPhieuThue(rs.getString("MaPhieuThue"));
            phieuThue.setMaPhong(rs.getString("MaPhong"));
            phieuThue.setMaLoaiThue(rs.getString("MaLoaiThue"));
            phieuThue.setMaNhanVien(rs.getString("MaNhanVien"));
            phieuThue.setNgayThue(rs.getDate("NgayThue"));
            phieuThue.setTienDatCoc(rs.getBigDecimal("TienDatCoc"));
            phieuThue.setMoTa(rs.getString("MoTa"));
            phieuThue.setTinhTrang(rs.getBoolean("TinhTrang"));
            phieuThue.setMaKhachHang(rs.getString("MaKhachHang"));
            phieuThue.setNgayTra(rs.getDate("NgayTra"));
            phieuThue.setTongTien(rs.getBigDecimal("TongTien"));
            phieuThue.setGiamGia(rs.getBigDecimal("GiamGia"));
            phieuThue.setThanhTien(rs.getBigDecimal("ThanhTien"));

        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuThue;
    }
    
    public static ArrayList<PhieuThue> select(){
        String sql = "select * from PhieuThue";
        return getData(sql);
    }
    
    
    public static void ConfirmThue(PhieuThue phieuThue){
        
        String sql = "insert into PhieuThue values (?,?,?,?,?,?,?,?,?,?,?,?)";
        main.conn.executeUpdate(sql,
            phieuThue.getMaPhong(),
            phieuThue.getMaLoaiThue(),
            phieuThue.getMaNhanVien(),
            phieuThue.getNgayThue(),
            phieuThue.getTienDatCoc(),
            phieuThue.getMoTa(),
            false,
            phieuThue.getMaKhachHang(),
            null,
            phieuThue.getTongTien(),
            phieuThue.getGiamGia(),
            0
        );
    }
    
    public static void updateTinhTrangPhong(DTO.DTO_Phong phong){
        String sql = "UPDATE Phong SET  MaTinhTrang=  ? WHERE MaPhong = ? ";
        main.conn.executeUpdate(sql,
            phong.getMaTinhTrang(),
            phong.getMaPhong()
        );
    }
    public static void updataPhieuThue(PhieuThue phieuThue){
        String sql = "Update PhieuThue set MaPhong = ?, MaKhachHang = ?, MaLoaiThue = ?, TienDatCoc= ?, MoTa= ? where MaPhieuThue = ?";
        main.conn.executeUpdate(sql,
            phieuThue.getMaPhong(),
            phieuThue.getMaKhachHang(),
            phieuThue.getMaLoaiThue(),
            phieuThue.getTienDatCoc(),
            phieuThue.getMoTa(),
            phieuThue.getMaPhieuThue()
        );
    }
    
    public static void thanhToan(PhieuThue phieuThue){
        String sql = "update PhieuThue set TinhTrang = ?, NgayTra = ?, TongTien = ?, GiamGia = ? , ThanhTien = ? where MaPhieuThue = ?";
        main.conn.executeUpdate(sql, 
            true,
            phieuThue.getNgayTra(),
            phieuThue.getTongTien(),
            phieuThue.getGiamGia(),
            phieuThue.getThanhTien(),
            phieuThue.getMaPhieuThue()   
        );
    }
    
    public static PhieuThue checkPhong(String maPhong){
        String sql =  "select * from PhieuThue where MaPhong = ? and TinhTrang = ?";
        
        ResultSet rs = main.conn.resultSet(sql, maPhong, false);
        
        try {
            if(rs.next()){
                return convertRStoObject(rs);
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_ChoThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
