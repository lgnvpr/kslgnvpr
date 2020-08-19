/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_DichVu;
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
public class DAL_DichVu {


    public static ArrayList<DTO_DichVu> getDichVu(String sql, Object... obj) {
        System.out.println(sql);
        ArrayList<DTO_DichVu> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {

                list.add(convertRStoObject(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DTO_DichVu.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static DTO_DichVu convertRStoObject(ResultSet rs) {
        DTO_DichVu dichVu = new DTO_DichVu();
        try {
            dichVu.setMaDichVu(rs.getString("MaDichVu"));
            dichVu.setTenDichVu(rs.getString("TenDichVu"));
            dichVu.setMaLoaiDichVu(rs.getString("MaLoaiDichVu"));
            dichVu.setDonGia(rs.getBigDecimal("DonGia"));
            dichVu.setDonVi(rs.getString("DonVi"));
            dichVu.setMoTa(rs.getString("MoTa"));
        } catch (SQLException ex) {
            Logger.getLogger(DTO_DichVu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dichVu;
    }

    public static void delete(String MaLoaiPhong) {
        String sql = "delete dichVu where dichVu.MaDichVu = ?";
        main.conn.executeUpdate(sql, MaLoaiPhong);
    }

    public static ArrayList<DTO_DichVu> select() {

        String sql = "select * from dichVu";
      
        return getDichVu(sql);
    }

    public static void update(DTO_DichVu dichVu ) {
        String sql = "UPDATE dichVu SET TenDichVu = ?,MaLoaiDichVu   = ? ,DonGia = ?, DonVi=  ?, MoTa= ?  WHERE MaPhong = ?";
        main.conn.executeUpdate(sql,
                dichVu.getTenDichVu(),
                dichVu.getMaDichVu(),
                dichVu.getDonGia(),
                dichVu.getDonVi(),
                dichVu.getMoTa(),
                dichVu.getMaDichVu()
        );
    }

    public static void insert(DTO_DichVu dichVu) {
        String sql = "insert into Phong values(?,?,?,?,?,?)";
        main.conn.executeUpdate(sql,
                dichVu.getMaDichVu(),
                dichVu.getTenDichVu(),
                dichVu.getMaDichVu(),
                dichVu.getDonGia(),
                dichVu.getDonVi(),
                dichVu.getMoTa()
        );
    }

    public static DTO_DichVu findByID(String MaPhong) {
        String sql = "select * from dichVu where dichVu.MaDichVu = ?";
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
    
    
    public static ArrayList<DTO_DichVu> fiterDichVu(String tuKhoa, String MaLoaiPhong,BigDecimal min , BigDecimal max,String maTinhTrang ){
        String sql = "exec sp_LocPhong ?, ?, ?, ?, ?";
        ResultSet rs =  main.conn.resultSet(sql,
            tuKhoa,
            MaLoaiPhong, 
            min,
            max,
            maTinhTrang
        );
        ArrayList<DTO_DichVu> list = new ArrayList<>();
        
        try {
            while (rs.next()) {                
                DTO_DichVu dichVu = convertRStoObject(rs);
                list.add(dichVu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL_LoaiPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }

}
