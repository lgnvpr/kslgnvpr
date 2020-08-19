/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.Dao_ConnectSQL;

/**
 *
 * @author LGNV
 */
public class main {
    public static Dao_ConnectSQL conn;
    public static Welcome welcome = new Welcome();
    public static Login login;
    public static Home home;
    
    public static showMessage showMessage;
    public static showOption showOption;
    
    public static pnlTabHome tabHome;
    public static pnlTabManager tabManager;
    public static pnlTabReport tabReport;
    
    public static pnlManagerKhachHang tabKhachHang;
    public static pnlManagerPhong tabPhong;
    public static pnlManagerLoaiPhong tabLoaiPhong;
    public static pnlReportLichSu tabLichSuThue;
    
    public static dialogFormPhong dialogFormPhong;
    public static dialogFormKhachHang dialogFormKhachHang;
    public static dialogFormLoaiPhong dialogFormLoaiPhong;
    
    public static diaLogLocPhong diaLogLocPhong;
    public static diaLogLocKhachHang dialogLocKhachHang;
    public static diaLogLocLoaiPhong dialogLocLoaiPhong;
    
    public static FormChoThue dialogFormChoThue;
    
    public static void main(String[] args) throws InterruptedException {
        setLookAndFeel();
        welcome.setVisible(true);
        
        for (int i = 0; i < 100; i++) {
            welcome.lblValueLoad.setText(i+"%");
            welcome.pprLoad.setValue(i);
            
            
            switch(i){
                case (1) : {
                    welcome.lblContentLoad.setText("Đang Load dữ liệu...");
                    break;
                }
                
                case 2 : {
                    conn = new Dao_ConnectSQL();
                }
                case3 : {
                    showMessage = new showMessage(home, true);
                    showOption = new showOption(home, true);
                    break;
                }
                
                case 40 : {
                    welcome.lblContentLoad.setText("Khởi tạo tab khách hàng...");
                    tabKhachHang = new pnlManagerKhachHang();
                    tabKhachHang.compile();
                    break;
                }
                
                case 41 : {
                    welcome.lblContentLoad.setText("Khởi tạo tab phòng...");
                    tabPhong = new pnlManagerPhong();
                    tabPhong.compile();
                    break;
                }
                case 42 :{
                     welcome.lblContentLoad.setText("Khởi tạo tab loaiPhong...");
                    tabLoaiPhong = new pnlManagerLoaiPhong();
                    tabLoaiPhong.compile();
                    break;
                }
                
                case 45 :{
                     welcome.lblContentLoad.setText("Khởi tạo tab Lịch Sử...");
                    tabLichSuThue = new pnlReportLichSu();
                    break;
                }
                
                
                case 50 : {
                    tabHome = new pnlTabHome();
                    break;
                }
                case 51 : {
                    tabManager = new pnlTabManager();
                    break;
                }
                case 52 : {
                    tabReport = new pnlTabReport();
                }
                
                case 60: {
                    welcome.lblContentLoad.setText("Khởi dialog lọc phòng...");
                    diaLogLocPhong = new diaLogLocPhong(home, true);
                    break;
                }
                case 62 : {
                    welcome.lblContentLoad.setText("Khởi dialog lọc khách hàng...");
                    dialogLocKhachHang = new diaLogLocKhachHang(home, true);
                    break;
                }
                case 64 : {
                    welcome.lblContentLoad.setText("Khởi dialog lọc  loại phòng...");
                    dialogLocLoaiPhong = new diaLogLocLoaiPhong(home, true);
                    break;
                }
                case 66 : {
                    welcome.lblContentLoad.setText("Khởi dialog form cho thuê...");
                    dialogFormChoThue = new FormChoThue(home, true);
                }
                
                
                case 70 : {
                    welcome.lblContentLoad.setText("Khởi tạo Dialog Form Phòng...");
                    dialogFormPhong = new dialogFormPhong(home, true);
                    break;
                }
                case 72 : {
                    welcome.lblContentLoad.setText("Khởi tạo Dialog Form Khách Hàng...");
                    dialogFormKhachHang = new dialogFormKhachHang(home, true);
                    break;
                }
                case 74 : {
                    welcome.lblContentLoad.setText("Khởi tạo Dialog Form Loại Phòng...");
                    dialogFormLoaiPhong = new dialogFormLoaiPhong(home, true);
                    break;
                }
 
                
                case 80 : {
                    welcome.lblContentLoad.setText("Khởi tạo trang login...");
                    login = new Login();
                    break;
                }
                
                case 82 : {
                    welcome.lblContentLoad.setText("Khởi tạo trang home...");
                    home = new Home();
                    
                    break;
                }
                case 90 : {
                    welcome.lblContentLoad.setText("Đang khởi tạo dữ liệu");
                    tabHome.compile();
                    tabLichSuThue.compile();
                    break;
                }
                
                case 99 : {
                    welcome.lblContentLoad.setText("Hoàn thành...");
                    welcome.setVisible(false);
                    login.setVisible(true);
                    break;
                }
                
                
            }
        }
        
        
        
        
        
    }
    
    public static void setLookAndFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
