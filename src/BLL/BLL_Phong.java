/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiPhong;
import DAL.DAL_Phong;
import DTO.DTO_KhachHang;
import DTO.DTO_LoaiPhong;
import DTO.DTO_Phong;
import GUI.diaLogLocPhong;
import GUI.dialogFormKhachHang;
import GUI.dialogFormPhong;

import GUI.main;
import HELPER.MyComBoBox;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lương
 */
public class BLL_Phong {

    public static void getALLData() {
        ArrayList<DTO_Phong> list = DAL.DAL_Phong.select();
        doDuLieuVaoBang(list);
    }

    public static void doDuLieuVaoBang(ArrayList<DTO_Phong> list) {
        DefaultTableModel table = (DefaultTableModel) main.tabPhong.tblPhong.getModel();
        table.setRowCount(0);

        for (int i = 0; i < list.size(); i++) {
            DTO_Phong Phong = list.get(i);
            DTO_LoaiPhong loaiPhong = DAL.DAL_LoaiPhong.findByID(Phong.getMaLoaiPhong());
            table.addRow(new Object[]{
                i + 1,
                Phong.getMaPhong(),
                loaiPhong.getGiaPhong(),
                DAL.DAL_KhuVuc.findByID(Phong.getMaKhuVuc()).getTenKhuVuc(),
                loaiPhong.getTenLoaiPhong(),
                DAL.DAL_TinhTrang.findByID(Phong.getMaTinhTrang()).getTenTinhTrang(),
                Phong.getMoTa(),});
        }
    }

    public static void setDataToCombobox(JComboBox Mycbb, boolean all) {
        ArrayList<DTO_Phong> list = DAL_Phong.select();
        DefaultComboBoxModel cbb = (DefaultComboBoxModel) Mycbb.getModel();
        cbb.removeAllElements();
        if (all) {
            MyComBoBox mycbb = new MyComBoBox("", "Tất Cả");
            cbb.addElement(mycbb);
        }
        for (DTO_Phong phong : list) {
            MyComBoBox mycbb = new MyComBoBox(phong.getMaPhong(), phong.getMaPhong());
            cbb.addElement(mycbb);
        }

    }

    public static String getIDTable() {
        JTable tblPhong = main.tabPhong.tblPhong;
        int row = tblPhong.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tblPhong.getModel();
        String ID = tblPhong.getValueAt(row, 1).toString();
        return ID;
    }

    public static DTO_Phong getDataForm() {
        DTO_Phong phong = new DTO_Phong();
        dialogFormPhong form = main.dialogFormPhong;
        phong.setMaPhong(form.txtTenPhong.getTextValue());
        phong.setMaLoaiPhong(HELPER.support.getIDCombobox(form.cbbLoaiPhong));
        phong.setMaKhuVuc(HELPER.support.getIDCombobox(form.cbbKhuVuc));
        phong.setMaTinhTrang(HELPER.support.getIDCombobox(form.cbbTinhTrang));
        phong.setMoTa(form.txtMoTa.getTextValue());
        return phong;
    }

    public static void setDataToForm(String ID) {

        DTO_Phong phong = new DTO_Phong();
        phong = DAL.DAL_Phong.findByID(ID);
        dialogFormPhong form = main.dialogFormPhong;
        BLL_LoaiPhong.setDataToCombobox(form.cbbLoaiPhong, false);
        BLL.BLL_KhuVuc.setDataToCombobox(form.cbbKhuVuc, false);
        BLL.BLL_TinhTrang.setDataToCombobox(form.cbbTinhTrang, false);
        form.txtTenPhong.setText(phong.getMaPhong());
        form.txtMoTa.setText(phong.getMoTa());

    }

    public static void insert(DTO_Phong Phong) {
        System.out.println(Phong.getMaKhuVuc());
        System.out.println(Phong.getMaLoaiPhong());
        System.out.println(Phong.getMaPhong());
        System.out.println(Phong.getMaTinhTrang());
        System.out.println(Phong.getMoTa());
        DAL.DAL_Phong.insert(Phong);
    }

    public static void deleteByID(String ID) {
        DAL.DAL_Phong.delete(ID);
    }

    public static void update(DTO_Phong Phong) {

        DAL.DAL_Phong.update(Phong, BLL_Phong.getIDTable());
    }

    public static void update2(DTO_Phong Phong) {

        DAL.DAL_Phong.update(Phong, Phong.getMaPhong());
    }
    public static DTO_Phong findById(String ID){
        return DAL_Phong.findByID(ID);
    }

    public static void getFilter() {
        diaLogLocPhong filter = main.diaLogLocPhong;
        String tuKhoa = filter.txtTenPhong.getTextValue();
        if (tuKhoa.isBlank()) {
            tuKhoa = "";
        }
        String LoaiPhong = HELPER.support.getIDCombobox(filter.cbbLoaiPhong);
        String KhuVuc = HELPER.support.getIDCombobox(filter.cbbKhuVuc);
        String tinhTrang = HELPER.support.getIDCombobox(filter.cbbTinhTrang);
        if (filter.txtToPrice.getTextValue().isBlank()) {
            filter.txtToPrice.setText("0");
        }
        if (filter.txtFromPrice.getTextValue().isBlank()) {
            filter.txtFromPrice.setText("0");
        }
        BigDecimal min = BigDecimal.valueOf(Double.valueOf(filter.txtFromPrice.getTextValue()));
        BigDecimal max = BigDecimal.valueOf(Double.valueOf(filter.txtToPrice.getTextValue()));

        doDuLieuVaoBang(DAL.DAL_Phong.fiterPhong(tuKhoa, LoaiPhong, min, max, tinhTrang));

    }
}
