/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import DTO.DTO_TinhTrang;
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
public class DAL_TinhTrang {
    public static ArrayList<DTO_TinhTrang> getTinhTrang(String sql, Object... obj) {
        ArrayList<DTO_TinhTrang> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {
                list.add(convertRStoObject(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_TinhTrang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static DTO_TinhTrang convertRStoObject(ResultSet rs) {
        DTO_TinhTrang tinhTrang = new DTO_TinhTrang();
        try {
            tinhTrang.setMaTinhTrang(rs.getString("MaTinhTrang"));
            tinhTrang.setTenTinhTrang(rs.getString("TenTinhTrang"));
            tinhTrang.setMoTa(rs.getString("MoTa"));

        } catch (SQLException ex) {
            Logger.getLogger(DAL_TinhTrang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tinhTrang;
    }

    public static void delete(String khuVuc) {
        String sql = "delete tinhTrangPhong where tinhTrangPhong.MaTinhTrang = ?";
        main.conn.executeUpdate(sql, khuVuc);
    }

    public static ArrayList<DTO_TinhTrang> select() {

        String sql = "select * from tinhTrangPhong";

        return getTinhTrang(sql);
    }

    public static void update(DTO_TinhTrang tinhTrang) {
        String sql = "UPDATE tinhTrangPhong SET TenTinhTrang = ?,MoTa = ?   WHERE MaTinhTrang = ?";
        main.conn.executeUpdate(sql,
                tinhTrang.getTenTinhTrang(),
                tinhTrang.getMoTa(),
                tinhTrang.getMaTinhTrang()
        );
    }

    public static void insert(DTO_TinhTrang tinhTrang) {
        String sql = "insert into tinhTrangPhong values(?,?,?)";
        main.conn.executeUpdate(sql,
                tinhTrang.getMaTinhTrang(),
                tinhTrang.getTenTinhTrang(),
                tinhTrang.getMoTa()
        );
    }

    public static DTO_TinhTrang findByID(String MaTinhTrang) {
        String sql = "select * from tinhTrangPhong where tinhTrangPhong.MaTinhTrang = ?";
        ResultSet rs = main.conn.resultSet(sql, MaTinhTrang);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_TinhTrang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
