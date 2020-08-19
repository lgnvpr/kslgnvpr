/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_KhachHang;
import DAL.DAL_LoaiPhong;
import DTO.DTO_KhachHang;
import DTO.DTO_LoaiPhong;
import GUI.diaLogLocKhachHang;
import GUI.dialogFormKhachHang;

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
public class BLL_KhachHang {
    
    public static void getALLData() {
        ArrayList<DTO_KhachHang> list = DAL.DAL_KhachHang.select();
        doDuLieuVaoBang(list);
    }
    
    public static void doDuLieuVaoBang(ArrayList<DTO_KhachHang> list) {
        DefaultTableModel table = (DefaultTableModel) main.tabKhachHang.tblKhachHang.getModel();
        table.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            DTO_KhachHang KhachHang = list.get(i);
            
            table.addRow(new Object[]{
                i + 1,
                KhachHang.getMaKhachHang(),
                KhachHang.getTenKhachHang(),
                KhachHang.getCMND(),
                "Thường",
                KhachHang.getSDT(),
                KhachHang.getDiaChi(),
                KhachHang.getNgaySinh(),
                KhachHang.isGioiTinh() ? "Nam" : "Nữ",
                KhachHang.getMoTa()
            });
        }
    }
    
    public static void setDataToCombobox(JComboBox Mycbb , ArrayList<DTO_KhachHang> list){

        DefaultComboBoxModel cbb = (DefaultComboBoxModel) Mycbb.getModel();
        cbb.removeAllElements();

        for(DTO_KhachHang khachHang : list){
            MyComBoBox mycbb = new MyComBoBox(khachHang.getMaKhachHang(), khachHang.getTenKhachHang());
            cbb.addElement(mycbb);
        }

    }
    
    public static String getIDTable() {
        JTable tblKhachHang = main.tabKhachHang.tblKhachHang;
        int row = tblKhachHang.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) tblKhachHang.getModel();
        String ID = tblKhachHang.getValueAt(row, 1).toString();
        return ID;
        
    }
    
    public static DTO_KhachHang getDataForm() {
        DTO_KhachHang KhachHang = new DTO_KhachHang();
        dialogFormKhachHang form = main.dialogFormKhachHang;
        
        KhachHang.setMaKhachHang(getIDTable());
        KhachHang.setTenKhachHang(form.txtTenKhachHang.getTextValue());
        KhachHang.setMaLoaiKhachHang("LKH01");
        KhachHang.setCMND(form.txtCMND.getTextValue());
        KhachHang.setSDT(form.txtSDT.getTextValue());
        KhachHang.setDiaChi(form.txtDiaChi.getTextValue());
        KhachHang.setNgaySinh(HELPER.MYFormat.layNgayDate("27/09/2001"));
        
        if(form.rdoNam.isSelected()){
            KhachHang.setGioiTinh(true);
        } else if(form.rdoNu.isSelected()){
            KhachHang.setGioiTinh(false);
        }else{
            KhachHang.setGioiTinh(false);
        }
        
        KhachHang.setMoTa(form.txtMoTa.getTextValue());
        
        return KhachHang;
    }
    
    
    public static void setDataToForm(String ID) {
        System.out.println(ID);
        DTO_KhachHang KhachHang = new DTO_KhachHang();
        KhachHang = DAL.DAL_KhachHang.findByID(ID);
        dialogFormKhachHang form = main.dialogFormKhachHang;
        
        form.txtCMND.setText(KhachHang.getCMND());
        form.txtTenKhachHang.setText(KhachHang.getTenKhachHang());
        form.txtSDT.setText(KhachHang.getSDT());
//        form.txtNgaySinh.setText(Helper.MYFormat.layNgayString(KhachHang.getNgaySinh()));
        form.txtDiaChi.setText(KhachHang.getDiaChi());
        form.txtMoTa.setText(KhachHang.getMoTa());
        form.rdoNu.setSelected(KhachHang.isGioiTinh());
    }
    
    public static void insert(DTO_KhachHang KhachHang) {
        DAL.DAL_KhachHang.insert(KhachHang);
    }
    
    public static void deleteByID(String ID) {
        DAL.DAL_KhachHang.delete(ID);
    }
    public static DTO_KhachHang findByID(String ID){
        return  DAL_KhachHang.findByID(ID);
    }
    
    public static DTO_KhachHang findByCMND(String CMND ){
        return DAL_KhachHang.findByCMND(CMND);
    }
    
    public static void update(DTO_KhachHang KhachHang) {
        KhachHang.setMaKhachHang(getIDTable());
        DAL.DAL_KhachHang.update(KhachHang);
    }
    
    public static  void filterKhachHang(){
        diaLogLocKhachHang form = main.dialogLocKhachHang;
        String gioiTinh ="";
        if(form.rdoNam.isSelected()) gioiTinh = "nam";
        if(form.rdoNu.isSelected()) gioiTinh = "nu";
        String tuKhoa = form.txtTuKhoa.getTextValue();
        if(tuKhoa.isBlank()) tuKhoa = "";
        int fromNamSinh = (form.txtFromNamSinh.getTextValue().isBlank()) ? 0 : Integer.valueOf(form.txtFromNamSinh.getTextValue());
        int ToNamSinh = (form.txtToNamSinh.getTextValue().isBlank()) ? 0 : Integer.valueOf(form.txtToNamSinh.getTextValue());
        
        
         
         doDuLieuVaoBang(DAL_KhachHang.filter(tuKhoa, gioiTinh, "", fromNamSinh, ToNamSinh));
    }
    public static ArrayList<DTO_KhachHang> findKhachHang(String tuKhoa){
        return DAL_KhachHang.filter(tuKhoa, "", "", 0, 0);
    }
}
