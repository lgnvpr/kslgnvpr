/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DAL_KhuVuc;
import DAL.DAL_LoaiPhong;
import DTO.DTO_KhuVuc;
import DTO.DTO_LoaiPhong;
import HELPER.MyComBoBox;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author LGNV
 */
public class BLL_KhuVuc {
    public static void setDataToCombobox(JComboBox Mycbb, boolean  all){
        ArrayList<DTO_KhuVuc> list = DAL_KhuVuc.select();
        DefaultComboBoxModel cbb = (DefaultComboBoxModel) Mycbb.getModel();
        cbb.removeAllElements();
        if(all){
            MyComBoBox mycbb = new MyComBoBox("", "Tất Cả");
            cbb.addElement(mycbb);
        }
        for(DTO_KhuVuc khuVuc : list){
            MyComBoBox mycbb = new MyComBoBox(khuVuc.getMaKhuVuc(), khuVuc.getTenKhuVuc());
            cbb.addElement(mycbb);
        }

    }
    
   
}
