/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyData;

import DTO.DTO_KhachHang;
import java.util.ArrayList;

/**
 *
 * @author LGNV
 */
public class DataLuuTamListKhachHang {
    static ArrayList<DTO.DTO_KhachHang> list = new ArrayList<>();
    
    public static ArrayList<DTO.DTO_KhachHang> getList(){
        return list;
    }
    
    public static void add(DTO.DTO_KhachHang khachHang){
       
        for (int i = 0; i < list.size(); i++) {
            DTO_KhachHang khachHangItem = list.get(i);
            if(khachHang.getCMND().equalsIgnoreCase(khachHangItem.getCMND())) return;
        }
        
        list.add(khachHang);
    }
    
    public static void remove(String CMND){
        for (int i = 0; i < list.size(); i++) {
            DTO_KhachHang khachHangItem = list.get(i);
            if(khachHangItem.getCMND().equalsIgnoreCase(CMND)){
                list.remove(i);
            }
        }
    }
}
