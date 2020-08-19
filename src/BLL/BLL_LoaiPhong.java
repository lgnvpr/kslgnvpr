/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_LoaiPhong;
import DTO.DTO_LoaiPhong;
import GUI.diaLogLocLoaiPhong;
import GUI.dialogFormLoaiPhong;
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
 * @author LGNV
 */
public class BLL_LoaiPhong {

    public static void getALLData() {
        ArrayList<DTO_LoaiPhong> list = DAL_LoaiPhong.select();
        doDuLieuVaoBang(list);
    }

    public static void doDuLieuVaoBang(ArrayList<DTO_LoaiPhong> list) {
        DefaultTableModel table = (DefaultTableModel) main.tabLoaiPhong.tblLoaiPhong.getModel();
        table.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            DTO_LoaiPhong loaiPhong = list.get(i);
            table.addRow(new Object[]{
                i + 1,
                loaiPhong.getMaLoaiPhong(),
                loaiPhong.getTenLoaiPhong(),
                loaiPhong.getGiaPhong(),
                loaiPhong.getMoTa()
            });
        }
    }

    public static String getIDTable() {
        JTable tblLoaiPhong = main.tabLoaiPhong.tblLoaiPhong;
        int row = tblLoaiPhong.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tblLoaiPhong.getModel();
        String ID = tblLoaiPhong.getValueAt(row, 1).toString();
        return ID;

    }
    
    public static void setDataToCombobox(JComboBox Mycbb , boolean  all){
        ArrayList<DTO_LoaiPhong> list = DAL_LoaiPhong.select();
        DefaultComboBoxModel cbb = (DefaultComboBoxModel) Mycbb.getModel();
        cbb.removeAllElements();
        if(all){
            MyComBoBox mycbb = new MyComBoBox("", "Tất Cả");
            cbb.addElement(mycbb);
        }
        for(DTO_LoaiPhong loaiPhong : list){
            MyComBoBox mycbb = new MyComBoBox(loaiPhong.getMaLoaiPhong(), loaiPhong.getTenLoaiPhong());
            cbb.addElement(mycbb);
        }

    }
    
    

    public static DTO_LoaiPhong getDataForm() {
        DTO_LoaiPhong loaiPhong = new DTO_LoaiPhong();
        dialogFormLoaiPhong form = main.dialogFormLoaiPhong;
        loaiPhong.setTenLoaiPhong(form.txtTenLoaiPhong.getTextValue());
        loaiPhong.setMoTa(form.txtMoTa.getTextValue());
        loaiPhong.setGiaPhong(BigDecimal.valueOf(Double.valueOf(form.txtGiaPhong.getTextValue())));

        return loaiPhong;
    }

    public static void setDataToForm(String ID) {
           dialogFormLoaiPhong form = main.dialogFormLoaiPhong;
           DTO_LoaiPhong loaiPhong = DAL_LoaiPhong.findByID(ID);
           form.txtTenLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
           form.txtMoTa.setText(loaiPhong.getMoTa());
           form.txtGiaPhong.setText(loaiPhong.getGiaPhong()+"");
    }

    public static String createID() {
        ArrayList<DTO_LoaiPhong> list = DAL.DAL_LoaiPhong.select();

        int returnMaLoaiPhong = 1;
        int getMaLoaiPhong = 1;
        for (DTO_LoaiPhong loaiPhong : list) {
            getMaLoaiPhong = Integer.parseInt(loaiPhong.getMaLoaiPhong().substring(2).trim());
            if (getMaLoaiPhong != returnMaLoaiPhong) {
                break;
            }
            returnMaLoaiPhong++;
        }

        if (returnMaLoaiPhong < 10) {
            return "L0" + returnMaLoaiPhong;
        }
        if (returnMaLoaiPhong < 100) {
            return "L" + returnMaLoaiPhong;
        }

        return null;
    }

    public static void insert(DTO_LoaiPhong loaiPhong) {
        loaiPhong.setMaLoaiPhong(createID());
        DAL_LoaiPhong.insert(loaiPhong);
    }

    public static void deleteByID(String ID) {
        DAL_LoaiPhong.delete(ID);
    }

    public static void update(DTO_LoaiPhong loaiPhong) {
        loaiPhong.setMaLoaiPhong(getIDTable());
        DAL_LoaiPhong.update(loaiPhong);
    }
    
    public static void filte(){
        diaLogLocLoaiPhong filter = main.dialogLocLoaiPhong;

        String LoaiPhong = HELPER.support.getIDCombobox(filter.cbbLoaiPhong);

        if(filter.txtToPrice.getTextValue().isBlank()) filter.txtToPrice.setText("0");
        if(filter.txtFromPrice.getTextValue().isBlank()) filter.txtFromPrice.setText("0");
        BigDecimal min = BigDecimal.valueOf(Double.valueOf(filter.txtFromPrice.getTextValue()));
        BigDecimal max = BigDecimal.valueOf(Double.valueOf(filter.txtToPrice.getTextValue()));
        
        doDuLieuVaoBang(DAL_LoaiPhong.fiterPhong(LoaiPhong, min, max));
    }

}
