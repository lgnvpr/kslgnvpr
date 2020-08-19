/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author LGNV
 */
public class DTO_ChiTietDichVu {
    String MaCTDV;
    String MaPhieuDichVu;
    String MaDichVu;
    int soLuong;
    Date NgaySuDung;
    String MoTa;

    public String getMaCTDV() {
        return MaCTDV;
    }

    public void setMaCTDV(String MaCTDV) {
        this.MaCTDV = MaCTDV;
    }

    public String getMaPhieuDichVu() {
        return MaPhieuDichVu;
    }

    public void setMaPhieuDichVu(String MaPhieuDichVu) {
        this.MaPhieuDichVu = MaPhieuDichVu;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgaySuDung() {
        return NgaySuDung;
    }

    public void setNgaySuDung(Date NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
