/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author LGNV
 */
public class DTO_LoaiPhong {
    String maLoaiPhong;
    BigDecimal GiaPhong;
    String MoTa;
    String TenLoaiPhong;

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }
    
    

    public BigDecimal getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(BigDecimal GiaPhong) {
        this.GiaPhong = GiaPhong;
    }
    
    

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }


   

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
