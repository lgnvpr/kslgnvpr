/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_KhachHang;
import BLL.BLL_Phong;
import BLL.BLL_Thue;
import DTO.DTO_ChiTietDichVu;
import DTO.DTO_DichVu;
import DTO.DTO_KhachHang;
import DTO.DTO_Phong;
import DTO.PhieuThue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author LGNV
 */
public class FormChoThue extends javax.swing.JDialog {

    boolean checkThue = true;
    public String IDPhongNow = "";

    /**
     * Creates new form FormChoThue
     */
    public FormChoThue(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        css();
    }

    public void compile() {
        fillPanelDichVu();
    }

    private void css() {
        this.getRootPane().setOpaque(false);
        this.getContentPane().setBackground(new Color(0, 0, 0, 0));
        this.setBackground(new Color(0, 0, 0, 0));

    }

    public void fillDataForm(String IDPhong) {

        IDPhongNow = IDPhong;
        DTO.DTO_Phong phong = BLL_Thue.findPhongByID(IDPhong);
        DTO.DTO_LoaiPhong loaiPhong = BLL_Thue.findLoaiPhongbyID(phong.getMaLoaiPhong());
        DTO.PhieuThue phieuThue = BLL_Thue.checkPhong(IDPhong);

        lblInfoPhong.setText(IDPhong);
        lblLoaiPhong.setText(loaiPhong.getTenLoaiPhong());
        lblInfoNhanVien.setText("Long Thị Thu");

        BLL_Phong.setDataToCombobox(cbbDoiPhong, false); //đổ data vào combobox phòng
        if (phieuThue != null) {
            DTO_KhachHang khachHang = BLL_KhachHang.findByID(phieuThue.getMaKhachHang());
            lblInfoKhachHang.setText(khachHang.getTenKhachHang());
            lblInfoCMND.setText(khachHang.getCMND());
            lblInfoNhanVien.setText("Long Thị Thu");

            lblInfoPhong.setText(loaiPhong.getTenLoaiPhong());
            lblThoiGianThue.setText(phieuThue.getNgayThue() + "");
            txtTienDatCoc.setText(phieuThue.getTienDatCoc() + "");
            txtMota.setText(phieuThue.getMoTa());
            btnThanhToan.setVisible(true);
            btnConfirm.setText("Cập nhât");
            checkThue = false;
        } else {
            checkThue = true;
            btnThanhToan.setVisible(false);
            btnConfirm.setText("Xác Nhận");
        }
        lblInfoPhong.setText(phong.getMaPhong());

        fillPanelDichVu();
        lblThoiGianThue.setText(new Date() + "");

        this.setVisible(true);
    }

    public void fillPanelDichVu() {
        ArrayList<DTO.DTO_DichVu> list = BLL_Thue.getAllDataDichVu();
        repaint();

        System.out.println(list.size());

        JPanel pnlALLShowDichVu = new javax.swing.JPanel();
        pnlDichVuFull.removeAll();
        for (int i = 0; i < list.size(); i++) {
            DTO_DichVu dichVu = list.get(i);

            if (i % 2 == 0) {
                pnlALLShowDichVu = new javax.swing.JPanel();
                pnlALLShowDichVu.setSize(new Dimension(0, 150));
                pnlALLShowDichVu.setLayout(new java.awt.GridBagLayout());
                pnlALLShowDichVu.setBackground(Color.WHITE);
            }

            pnlDichVu pnlDichVu2 = new GUI.pnlDichVu();
            pnlDichVu2.lblTenDichVu.setText(dichVu.getTenDichVu());
            pnlDichVu2.lblGia.setText(dichVu.getDonGia() + "");
            pnlALLShowDichVu.add(pnlDichVu2, new java.awt.GridBagConstraints());
            pnlDichVu2.setID(dichVu.getMaDichVu());

            if (i % 2 == 0) {
                pnlDichVuFull.add(pnlALLShowDichVu);
            }
        }
        this.setVisible(false);
        repaint();
    }

    public void fillListKhachHang() {
        ArrayList<DTO_KhachHang> list = MyData.DataLuuTamListKhachHang.getList();
        pnlListKhachHang.removeAll();

        for (int i = 0; i < list.size(); i++) {
            DTO_KhachHang khachHang = list.get(i);
            pnlItemkhachHangChoThue pnlItemKhachHang = new pnlItemkhachHangChoThue();
            pnlItemKhachHang.setCMND(khachHang.getCMND());
            pnlItemKhachHang.lblCmnd.setText(khachHang.getCMND());
            pnlItemKhachHang.lblTen.setText(khachHang.getTenKhachHang());
            pnlListKhachHang.add(pnlItemKhachHang);

        }
        this.setVisible(true);

    }

    public void fillPanelDichVuDangSuDung() {
        ArrayList<DTO.DTO_ChiTietDichVu> list = MyData.DataLuuTamDichVu.getChiTietDichVu();
        repaint();
        long sumMoneyDichVu = 0;
        System.out.println(list.size());

        pnlDichVuDangSuDung.removeAll();
        for (int i = 0; i < list.size(); i++) {
            DTO_ChiTietDichVu chiTietDichVu = list.get(i);
            DTO_DichVu dichVu = BLL_Thue.findDichVubyID(chiTietDichVu.getMaDichVu());

            pnlDichVuDangSuDung pnlDichVu3 = new GUI.pnlDichVuDangSuDung();
            pnlDichVu3.lblTenDichVu.setText(dichVu.getTenDichVu());
            BigDecimal Gia = HELPER.support.multiply(chiTietDichVu.getSoLuong(), dichVu.getDonGia());
            double giaDouble = Double.valueOf(Gia.toString());
            sumMoneyDichVu += giaDouble;
            pnlDichVu3.lblGia.setText(Gia + "");
            pnlDichVu3.setID(dichVu.getMaDichVu());
            pnlDichVu3.lblSoLuong.setText(chiTietDichVu.getSoLuong() + "");
            pnlDichVuDangSuDung.add(pnlDichVu3);

        }
        lblChiPhiDichVu.setText(sumMoneyDichVu + "");

        this.setVisible(true);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lgnvPanel1 = new LIBRARY.lgnvPanel();
        lgnvPanel2 = new LIBRARY.lgnvPanel();
        jLabel2 = new javax.swing.JLabel();
        lgnvTextField1 = new LIBRARY.lgnvTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlDichVuFull = new LIBRARY.lgnvPanel();
        lgnvPanel3 = new LIBRARY.lgnvPanel();
        jLabel3 = new javax.swing.JLabel();
        lgnvPanel4 = new LIBRARY.lgnvPanel();
        txtKhachHang = new LIBRARY.lgnvTextField();
        cbKhachHang = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        pnlListKhachHang = new LIBRARY.lgnvPanel();
        lgnvPanel5 = new LIBRARY.lgnvPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblInfoKhachHang = new javax.swing.JLabel();
        lblInfoNhanVien = new javax.swing.JLabel();
        lblThoiGianThue = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblChiPhiDichVu = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblPhiPhong = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnCancel = new LIBRARY.lgnvButton();
        btnThanhToan = new LIBRARY.lgnvButton();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lblInfoCMND = new javax.swing.JLabel();
        lgnvPanel7 = new LIBRARY.lgnvPanel();
        lgnvPanel8 = new LIBRARY.lgnvPanel();
        btnChuyenPhong = new LIBRARY.lgnvButton();
        cbbDoiPhong = new javax.swing.JComboBox<>();
        lblInfoPhong = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTienDatCoc = new LIBRARY.lgnvTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        btnConfirm = new LIBRARY.lgnvButton();
        jLabel1 = new javax.swing.JLabel();
        lgnvPanel6 = new LIBRARY.lgnvPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        pnlDichVuDangSuDung = new LIBRARY.lgnvPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        lgnvPanel1.setBackground(new java.awt.Color(4, 163, 11));
        lgnvPanel1.setLGNV_ShaDownAllow(true);
        lgnvPanel1.setLGNV_borderRadius(30);
        lgnvPanel1.setLGNV_lineColor(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lgnvPanel2.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel2.setLGNV_borderRadius(50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 163, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Dịch Vụ");

        lgnvTextField1.setLGNV_placeholderText("Tìm dịch vụ..");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        pnlDichVuFull.setBackground(new java.awt.Color(255, 255, 255));
        pnlDichVuFull.setLGNV_lineAllow(false);
        pnlDichVuFull.setLayout(new javax.swing.BoxLayout(pnlDichVuFull, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnlDichVuFull);

        javax.swing.GroupLayout lgnvPanel2Layout = new javax.swing.GroupLayout(lgnvPanel2);
        lgnvPanel2.setLayout(lgnvPanel2Layout);
        lgnvPanel2Layout.setHorizontalGroup(
            lgnvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel2Layout.createSequentialGroup()
                .addGroup(lgnvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lgnvPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lgnvPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lgnvTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lgnvPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        lgnvPanel2Layout.setVerticalGroup(
            lgnvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lgnvTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        lgnvPanel1.add(lgnvPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 370, 620));

        lgnvPanel3.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel3.setLGNV_borderRadius(50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(4, 163, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Khách Hàng");

        lgnvPanel4.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel4.setLGNV_lineAllow(false);
        lgnvPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKhachHang.setLGNV_placeholderText("CMND khách hàng");
        txtKhachHang.setLGNV_radius(0);
        txtKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhachHangActionPerformed(evt);
            }
        });
        txtKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKhachHangKeyReleased(evt);
            }
        });
        lgnvPanel4.add(txtKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 37));

        cbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lgnvPanel4.add(cbKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 320, 40));

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlListKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnlListKhachHang.setLGNV_lineAllow(false);
        pnlListKhachHang.setPreferredSize(new java.awt.Dimension(320, 110));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout();
        flowLayout2.setAlignOnBaseline(true);
        pnlListKhachHang.setLayout(flowLayout2);
        jScrollPane5.setViewportView(pnlListKhachHang);

        javax.swing.GroupLayout lgnvPanel3Layout = new javax.swing.GroupLayout(lgnvPanel3);
        lgnvPanel3.setLayout(lgnvPanel3Layout);
        lgnvPanel3Layout.setHorizontalGroup(
            lgnvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(lgnvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lgnvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lgnvPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(lgnvPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        lgnvPanel3Layout.setVerticalGroup(
            lgnvPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lgnvPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        lgnvPanel1.add(lgnvPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 480, 240));

        lgnvPanel5.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel5.setLGNV_borderRadius(70);
        lgnvPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(4, 163, 11));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chi tiết");
        lgnvPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 11, 378, 32));

        jLabel6.setText("Tên Phòng");
        lgnvPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 59, 22));

        jLabel7.setText("Người đại diện");
        lgnvPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 95, 100, 22));

        jLabel8.setText("Người lập phiếu");
        lgnvPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 320, 100, 22));

        jLabel9.setText("Ngày Thuê");
        lgnvPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 168, 100, 22));

        jLabel10.setText("Loại Phòng");
        lgnvPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 100, 22));

        lblInfoKhachHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoKhachHang.setText("Nguyễn Văn Lương");
        lgnvPanel5.add(lblInfoKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 98, 194, -1));

        lblInfoNhanVien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoNhanVien.setText("Long Thị Thu");
        lgnvPanel5.add(lblInfoNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 194, -1));

        lblThoiGianThue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThoiGianThue.setText("00:11 11/8/2020");
        lgnvPanel5.add(lblThoiGianThue, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 194, -1));

        lblLoaiPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLoaiPhong.setText("Hai Gường VIP");
        lgnvPanel5.add(lblLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 194, -1));

        jLabel15.setText("Tổng Chi Phí Dịch Vụ ");
        lgnvPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 22));

        lblChiPhiDichVu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblChiPhiDichVu.setText("0Đ");
        lgnvPanel5.add(lblChiPhiDichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 194, -1));

        jLabel17.setText("Phí Phòng Hiện Tại");
        lgnvPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 281, 100, 22));

        lblPhiPhong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhiPhong.setText("100,000 đ");
        lgnvPanel5.add(lblPhiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 194, -1));

        jLabel19.setText("Mô tả");
        lgnvPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setForeground(new java.awt.Color(4, 163, 11));
        btnCancel.setText("Hủy");
        btnCancel.setLGNV_ShadowAllow(true);
        btnCancel.setLGNV_ShadownPixel(10);
        btnCancel.setLGNV_borderRadius(40);
        btnCancel.setLGNV_lineColor(new java.awt.Color(4, 163, 11));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        lgnvPanel5.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 117, 64));

        btnThanhToan.setBackground(new java.awt.Color(4, 163, 11));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setLGNV_ShadowAllow(true);
        btnThanhToan.setLGNV_ShadownPixel(10);
        btnThanhToan.setLGNV_borderRadius(40);
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        lgnvPanel5.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 117, 64));

        jLabel20.setText("Loại Hình Thuê");
        lgnvPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GIờ", "Ngày" }));
        lgnvPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 200, 30));

        jLabel11.setText("CMND");
        lgnvPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 128, 100, 22));

        lblInfoCMND.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblInfoCMND.setText(" ");
        lgnvPanel5.add(lblInfoCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 131, 194, -1));

        lgnvPanel7.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel7.setLGNV_lineAllow(false);
        lgnvPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lgnvPanel8.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel8.setLGNV_lineAllow(false);

        btnChuyenPhong.setBackground(new java.awt.Color(4, 163, 11));
        btnChuyenPhong.setForeground(new java.awt.Color(255, 255, 255));
        btnChuyenPhong.setText("Chuyển");
        btnChuyenPhong.setLGNV_borderRadius(10);
        btnChuyenPhong.setLGNV_lineAllow(false);
        btnChuyenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lgnvPanel8Layout = new javax.swing.GroupLayout(lgnvPanel8);
        lgnvPanel8.setLayout(lgnvPanel8Layout);
        lgnvPanel8Layout.setHorizontalGroup(
            lgnvPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChuyenPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        lgnvPanel8Layout.setVerticalGroup(
            lgnvPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChuyenPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        lgnvPanel7.add(lgnvPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        cbbDoiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDoiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDoiPhongActionPerformed(evt);
            }
        });
        lgnvPanel7.add(cbbDoiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        lgnvPanel5.add(lgnvPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 160, 30));

        lblInfoPhong.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblInfoPhong.setText("P2002");
        lgnvPanel5.add(lblInfoPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 71, -1));

        jLabel21.setText("Tiền đặt cọc");
        lgnvPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 361, -1, -1));

        txtTienDatCoc.setLGNV_placeholderText("Số Tiền đặt cọc");
        lgnvPanel5.add(txtTienDatCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane3.setViewportView(txtMota);

        lgnvPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 200, 100));

        btnConfirm.setBackground(new java.awt.Color(4, 163, 11));
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("Xác Nhận");
        btnConfirm.setLGNV_ShadowAllow(true);
        btnConfirm.setLGNV_ShadownPixel(10);
        btnConfirm.setLGNV_borderRadius(40);
        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        lgnvPanel5.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 117, 64));

        lgnvPanel1.add(lgnvPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 410, 630));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thuê Phòng ");
        lgnvPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, 1263, 39));

        lgnvPanel6.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel6.setLGNV_borderRadius(50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(4, 163, 11));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dịch Vụ Đang Sử Dụng");

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlDichVuDangSuDung.setBackground(new java.awt.Color(255, 255, 255));
        pnlDichVuDangSuDung.setLGNV_lineAllow(false);
        pnlDichVuDangSuDung.setPreferredSize(new java.awt.Dimension(320, 110));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        pnlDichVuDangSuDung.setLayout(flowLayout1);
        jScrollPane4.setViewportView(pnlDichVuDangSuDung);

        javax.swing.GroupLayout lgnvPanel6Layout = new javax.swing.GroupLayout(lgnvPanel6);
        lgnvPanel6.setLayout(lgnvPanel6Layout);
        lgnvPanel6Layout.setHorizontalGroup(
            lgnvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lgnvPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lgnvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                .addContainerGap())
        );
        lgnvPanel6Layout.setVerticalGroup(
            lgnvPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        lgnvPanel1.add(lgnvPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 480, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1379, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKhachHangKeyReleased

        int nowSelect = cbKhachHang.getSelectedIndex();
        switch (evt.getKeyCode()) {
            case 10: {///nút enter
                String id = HELPER.support.getIDCombobox(cbKhachHang);
                DTO.DTO_KhachHang khachHang = DAL.DAL_KhachHang.findByID(id);
                MyData.DataLuuTamListKhachHang.add(khachHang);
                if (!lblInfoKhachHang.getText().isBlank()) {
                    lblInfoKhachHang.setText(khachHang.getTenKhachHang());
                    lblInfoCMND.setText(khachHang.getCMND());
                }
                main.dialogFormChoThue.fillListKhachHang();
                txtKhachHang.setText("");
                cbKhachHang.setPopupVisible(false);
                break;
            }
            case 40: {//nút xuống

                try {
                    cbKhachHang.setSelectedIndex(nowSelect + 1);
                    repaint();
                    cbKhachHang.showPopup();
                    repaint();
                } catch (Exception e) {
                }
                break;
            }
            case 38: {//nút lên
                try {
                    cbKhachHang.setSelectedIndex(nowSelect - 1);
                    cbKhachHang.showPopup();

                } catch (Exception e) {
                }
                break;
            }
            default: {
                String tuKhoa = txtKhachHang.getTextValue();

                BLL_KhachHang.setDataToCombobox(cbKhachHang, BLL_KhachHang.findKhachHang(tuKhoa));
                try {
                    cbKhachHang.showPopup();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_txtKhachHangKeyReleased

    private void txtKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhachHangActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        main.showOption.content("Có chắc chắn thoát không nà !");
        if (main.showOption.getResult()) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        if (BLL_Thue.checkError() == null) {
            System.out.println(BLL_Thue.checkError());
            main.showOption.content("Hệ thống sẽ lưu lại nà !");
            if (main.showOption.getResult()) {
                this.setVisible(false);
                PhieuThue phieuThue = BLL_Thue.getInFoForm();
                DTO_Phong phong = BLL.BLL_Thue.findPhongByID(phieuThue.getMaPhong());
                phong.setMaTinhTrang("BAN");
                BLL.BLL_Thue.traPhong(phieuThue);

                main.tabHome.compile();

            }
        }
        else {
            main.showMessage.content(BLL_Thue.checkError());
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChuyenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenPhongActionPerformed

        cbbDoiPhong.showPopup();
    }//GEN-LAST:event_btnChuyenPhongActionPerformed

    private void cbbDoiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDoiPhongActionPerformed

        try {
            lblInfoPhong.setText(cbbDoiPhong.getSelectedItem().toString());
            cbbDoiPhong.repaint();
            btnChuyenPhong.repaint();

            repaint();
        } catch (Exception e) {
        }


    }//GEN-LAST:event_cbbDoiPhongActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if (BLL_Thue.checkError() == null) {
            System.out.println(BLL_Thue.checkError());
            this.setVisible(false);
            if (checkThue) {
                BLL_Thue.createPhieuThue(BLL.BLL_Thue.getInFoForm());
            } else {

                BLL_Thue.updatePhieuThue(BLL.BLL_Thue.getInFoForm());
            }

            main.tabHome.compile();
        } else {
            main.showMessage.content(BLL_Thue.checkError());
        }

    }//GEN-LAST:event_btnConfirmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormChoThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormChoThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormChoThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormChoThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormChoThue dialog = new FormChoThue(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIBRARY.lgnvButton btnCancel;
    private LIBRARY.lgnvButton btnChuyenPhong;
    private LIBRARY.lgnvButton btnConfirm;
    private LIBRARY.lgnvButton btnThanhToan;
    public javax.swing.JComboBox<String> cbKhachHang;
    private javax.swing.JComboBox<String> cbbDoiPhong;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JLabel lblChiPhiDichVu;
    public javax.swing.JLabel lblInfoCMND;
    public javax.swing.JLabel lblInfoKhachHang;
    public javax.swing.JLabel lblInfoNhanVien;
    public javax.swing.JLabel lblInfoPhong;
    public javax.swing.JLabel lblLoaiPhong;
    public javax.swing.JLabel lblPhiPhong;
    public javax.swing.JLabel lblThoiGianThue;
    private LIBRARY.lgnvPanel lgnvPanel1;
    private LIBRARY.lgnvPanel lgnvPanel2;
    private LIBRARY.lgnvPanel lgnvPanel3;
    private LIBRARY.lgnvPanel lgnvPanel4;
    private LIBRARY.lgnvPanel lgnvPanel5;
    private LIBRARY.lgnvPanel lgnvPanel6;
    private LIBRARY.lgnvPanel lgnvPanel7;
    private LIBRARY.lgnvPanel lgnvPanel8;
    public LIBRARY.lgnvTextField lgnvTextField1;
    public LIBRARY.lgnvPanel pnlDichVuDangSuDung;
    public LIBRARY.lgnvPanel pnlDichVuFull;
    public LIBRARY.lgnvPanel pnlListKhachHang;
    public LIBRARY.lgnvTextField txtKhachHang;
    public javax.swing.JTextArea txtMota;
    private LIBRARY.lgnvTextField txtTienDatCoc;
    // End of variables declaration//GEN-END:variables
}
