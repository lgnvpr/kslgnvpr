/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.PhieuThue;
import GUI.FormChoThue;
import GUI.main;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LGNV
 */
public class BLL_Thue {
    public static ArrayList<PhieuThue> getDataChoThue(){
        return DAL.DAL_ChoThue.select();
    }
    
    public static void fillDataToTableReport(ArrayList<PhieuThue> list){
        DefaultTableModel table = (DefaultTableModel) main.tabLichSuThue.tblLichSu.getModel();
        table.setRowCount(0);
        
        for (int i = 0; i < list.size(); i++) {
            PhieuThue phieuThue = list.get(i);
            
            table.addRow(new Object[]{
                phieuThue.getMaPhieuThue(),
                phieuThue.getMaPhong(),
                phieuThue.getMaLoaiThue(),
                phieuThue.getMaNhanVien(),
                phieuThue.getNgayThue(),
                phieuThue.getTienDatCoc(),
                phieuThue.getMoTa(),
                phieuThue.isTinhTrang(),
                phieuThue.getMaKhachHang()
            });
        }
    }
    
    

    

    
    public static ArrayList<DTO.DTO_DichVu> getAllDataDichVu(){
        return  DAL.DAL_DichVu.select();
    }
    

    
    public static DTO.PhieuThue checkPhong(String maPhong){
         DTO.PhieuThue phieuThue = DAL.DAL_ChoThue.checkPhong(maPhong);
        if(phieuThue != null){
            return phieuThue;
        } 
        return null;
    }
    
    
    public static PhieuThue getInFoForm(){
        FormChoThue form = main.dialogFormChoThue;
        PhieuThue phieuThue = new PhieuThue();
        phieuThue.setMaKhachHang(DAL.DAL_KhachHang.findByCMND(form.lblInfoCMND.getText()).getMaKhachHang());
        phieuThue.setMaLoaiThue("LT001");
        phieuThue.setMaNhanVien("NV001");
        try {
            phieuThue.setMaPhieuThue(BLL_Thue.checkPhong(main.dialogFormChoThue.IDPhongNow).getMaPhieuThue());////////////////////
        } catch (Exception e) {
        }
        phieuThue.setMaPhong(form.lblInfoPhong.getText()+"");
        phieuThue.setMoTa(form.txtMota.getText());
        phieuThue.setTienDatCoc(BigDecimal.valueOf(0));
        return phieuThue;
    }
    
    public static void updatePhieuThue(PhieuThue phieuThue){

        phieuThue.setTinhTrang(false);
        DAL.DAL_ChoThue.updataPhieuThue(phieuThue);
    }
    
    public static String checkError(){
        FormChoThue form = main.dialogFormChoThue;
        if(DAL.DAL_KhachHang.findByCMND(form.lblInfoCMND.getText())==null){
            return "Không tìm thấy khách hàng này";
        }
        if(BLL.BLL_Thue.checkPhong(form.lblInfoPhong.getText())!= null){
            return "Phòng này đã cho thuê";
        }
        if(!BLL_Phong.findById(form.lblInfoPhong.getText()).getMaTinhTrang().equalsIgnoreCase("TRO")){
            return "Phòng này không đủ điều kiện";
        }
        
        return null;
    }
    

    
    
    
    public static void createPhieuThue(PhieuThue phieuThue){
        phieuThue.setTinhTrang(false);
        phieuThue.setNgayThue(new Date());
        DAL.DAL_ChoThue.ConfirmThue(phieuThue);
    }
    
    
    
    public static void traPhong(PhieuThue phieuThue){
        updatePhieuThue(phieuThue);
        phieuThue.setNgayTra(new Date());
        phieuThue.setTinhTrang(true);
        phieuThue.setMaPhong(checkPhong(phieuThue.getMaPhong()).getMaPhieuThue());
        DAL.DAL_ChoThue.thanhToan(phieuThue);
    }
    
    public static String getIdDichVu(){
//        int row = main.dialogFormChoThue.tblDichVu.getSelectedRow();
//        String ID = (String) main.dialogFormChoThue.tblDichVu.getValueAt(row,0);
       return "";
    }
    
    public static DTO.DTO_Phong findPhongByID(String ID ){
        return  DAL.DAL_Phong.findByID(ID);
    }
    public static DTO.DTO_LoaiPhong findLoaiPhongbyID(String ID){
        return DAL.DAL_LoaiPhong.findByID(ID);
    }
    public static DTO.DTO_DichVu findDichVubyID(String ID){
        return DAL.DAL_DichVu.findByID(ID);
    }
}
