/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DTO_KhuVuc;
import DTO.DTO_LoaiPhong;
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
public class DAL_KhuVuc {
    public static ArrayList<DTO_KhuVuc> getKhuVuc(String sql, Object... obj) {
        ArrayList<DTO_KhuVuc> list = new ArrayList<>();
        ResultSet rs = main.conn.resultSet(sql, obj);
        try {
            while (rs.next()) {
                list.add(convertRStoObject(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_KhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static DTO_KhuVuc convertRStoObject(ResultSet rs) {
        DTO_KhuVuc khuVuc = new DTO_KhuVuc();
        try {
            khuVuc.setMaKhuVuc(rs.getString("MaKhuVuc"));
            khuVuc.setTenKhuVuc(rs.getString("TenKhuVuc"));
            khuVuc.setMoTa(rs.getString("MoTa"));

        } catch (SQLException ex) {
            Logger.getLogger(DAL_KhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khuVuc;
    }

    public static void delete(String khuVuc) {
        String sql = "delete KhuVuc where KhuVuc.MaKhuVuc = ?";
        main.conn.executeUpdate(sql, khuVuc);
    }

    public static ArrayList<DTO_KhuVuc> select() {

        String sql = "select * from KhuVuc";

        return getKhuVuc(sql);
    }

    public static void update(DTO_KhuVuc khuVuc) {
        String sql = "UPDATE KhuVuc SET TenKhuVuc = ?,MoTa = ?   WHERE MaKhuVuc = ?";
        main.conn.executeUpdate(sql,
                khuVuc.getTenKhuVuc(),
                khuVuc.getMoTa(),
                khuVuc.getMaKhuVuc()
        );
    }

    public static void insert(DTO_KhuVuc khuVuc) {
        String sql = "insert into KhuVuc values(?,?,?)";
        main.conn.executeUpdate(sql,
                khuVuc.getMaKhuVuc(),
                khuVuc.getTenKhuVuc(),
                khuVuc.getMoTa()
        );
    }

    public static DTO_KhuVuc findByID(String MakhuVuc) {
        String sql = "select * from KhuVuc where KhuVuc.MaKhuVuc = ?";
        ResultSet rs = main.conn.resultSet(sql, MakhuVuc);
        try {
            if (rs.next()) {
                return convertRStoObject(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAL_KhuVuc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
