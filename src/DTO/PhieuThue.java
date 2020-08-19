/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author LGNV
 */
public class PhieuThue {
    String MaPhieuThue;
    String MaPhong;
    String MaLoaiThue;
    String MaKhachHang;
    String MaNhanVien;
    Date NgayThue;
    BigDecimal TienDatCoc;
    String MoTa;
    boolean tinhTrang;
    Date NgayTra;
    BigDecimal TongTien;
    BigDecimal GiamGia;
    BigDecimal ThanhTien;

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public BigDecimal getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(BigDecimal GiamGia) {
        this.GiamGia = GiamGia;
    }

    public BigDecimal getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(BigDecimal ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    

    public String getMaPhieuThue() {
        return MaPhieuThue;
    }

    public void setMaPhieuThue(String MaPhieuThue) {
        this.MaPhieuThue = MaPhieuThue;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaLoaiThue() {
        return MaLoaiThue;
    }

    public void setMaLoaiThue(String MaLoaiThue) {
        this.MaLoaiThue = MaLoaiThue;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public Date getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(Date NgayThue) {
        this.NgayThue = NgayThue;
    }

    public BigDecimal getTienDatCoc() {
        return TienDatCoc;
    }

    public void setTienDatCoc(BigDecimal TienDatCoc) {
        this.TienDatCoc = TienDatCoc;
    }

    

    

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setTienDatCoc(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
