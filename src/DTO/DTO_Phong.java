/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author LGNV
 */
public class DTO_Phong {
    String maPhong;
    String maKhuVuc;
    String maLoaiPhong;
    String MaTinhTrang;
    String moTa;

    public DTO_Phong(String maPhong, String maKhuVuc, String maLoaiPhong, String MaTinhTrang, String moTa) {
        this.maPhong = maPhong;
        this.maKhuVuc = maKhuVuc;
        this.maLoaiPhong = maLoaiPhong;
        this.MaTinhTrang = MaTinhTrang;
        this.moTa = moTa;
    }

    public DTO_Phong() {
    }
    
    
    

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getMaTinhTrang() {
        return MaTinhTrang;
    }

    public void setMaTinhTrang(String tinhTrangPhong) {
        this.MaTinhTrang = tinhTrangPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
