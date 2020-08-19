/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyData;

import DTO.DTO_ChiTietDichVu;
import DTO.DTO_DichVu;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LGNV
 */
public class DataLuuTamDichVu {
    static ArrayList<DTO_ChiTietDichVu> listChiTietDichVu = new ArrayList<>();
    
    public static ArrayList<DTO_ChiTietDichVu> getChiTietDichVu(){
        return listChiTietDichVu;
    }
    
    public static void addChiTietDichVu(String ID){
        DTO_DichVu dichVu = DAL.DAL_DichVu.findByID(ID);
        DTO_ChiTietDichVu chiTietDichVu = new DTO_ChiTietDichVu();
        chiTietDichVu.setMaDichVu(ID);
        chiTietDichVu.setSoLuong(1);
        chiTietDichVu.setNgaySuDung(new Date());
        for (int i = 0; i < listChiTietDichVu.size(); i++) {
            DTO_ChiTietDichVu chiTietDichVuIteam = listChiTietDichVu.get(i);
            if(chiTietDichVuIteam.getMaDichVu().equalsIgnoreCase(ID)){
                listChiTietDichVu.get(i).setSoLuong(chiTietDichVuIteam.getSoLuong()+1);
                return;
            }
        }
        
        
        listChiTietDichVu.add(chiTietDichVu);
    }
    
    public static void deleteChiTietDichvu(String ID){
        for (int i = 0; i < listChiTietDichVu.size(); i++) {
            DTO_ChiTietDichVu chiTietDichVu = listChiTietDichVu.get(i);
            if(chiTietDichVu.getMaDichVu().equalsIgnoreCase(ID)){
                listChiTietDichVu.remove(i);
                break;
            }  
        }
    }
    
    public static void EditSLChiTietDichvu(String ID , int SoLuong){
        for (int i = 0; i < listChiTietDichVu.size(); i++) {
            DTO_ChiTietDichVu chiTietDichVu = listChiTietDichVu.get(i);
            if(chiTietDichVu.getMaDichVu().equalsIgnoreCase(ID)){
                listChiTietDichVu.get(i).setSoLuong(chiTietDichVu.getSoLuong()+SoLuong);
                break;
            }  
        }
    }
    
    
}
