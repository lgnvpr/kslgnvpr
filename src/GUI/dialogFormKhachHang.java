/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author LGNV
 */
public class dialogFormKhachHang extends javax.swing.JDialog {

    /**
     * Creates new form FormPhong
     */
    public dialogFormKhachHang(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        css();
        
    }
    
    public void css(){
        this.getRootPane ().setOpaque (false);
        this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
        this.setBackground (new Color (0, 0, 0, 0));
         
        
    }
    String ID = "";
    boolean checkNew = true;
    
    public  void checkNew(boolean check){
        checkNew = check;
        
        if(checkNew){
            
            btnThem.setText("Thêm");
            btnDelete.setVisible(false);
        }
        else {
            ID = BLL.BLL_KhachHang.getIDTable();
            btnThem.setText("Cập Nhật");
            btnDelete.setVisible(true);
        }
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sex = new javax.swing.ButtonGroup();
        lgnvPanel1 = new LIBRARY.lgnvPanel();
        txtErrroMoTa = new javax.swing.JLabel();
        btnThem = new LIBRARY.lgnvButton();
        lgnvButton1 = new LIBRARY.lgnvButton();
        btnDelete = new LIBRARY.lgnvButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenKhachHang = new LIBRARY.lgnvTextField();
        txtCMND = new LIBRARY.lgnvTextField();
        txtDiaChi = new LIBRARY.lgnvTextField();
        txtMoTa = new LIBRARY.lgnvTextField();
        txtSDT = new LIBRARY.lgnvTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtErrorTenKhachHang = new javax.swing.JLabel();
        txtErrorCMND = new javax.swing.JLabel();
        txtErrorSDT = new javax.swing.JLabel();
        txtErrorDiaChi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rdoKhac = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        lgnvPanel1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLGNV_ShaDownAllow(true);
        lgnvPanel1.setLGNV_ShadownColor(100);
        lgnvPanel1.setLGNV_ShadownPixel(40);
        lgnvPanel1.setLGNV_lineAllow(false);
        lgnvPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtErrroMoTa.setForeground(new java.awt.Color(255, 51, 51));
        txtErrroMoTa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtErrroMoTa.setText("Không được để trống tên phòng");
        lgnvPanel1.add(txtErrroMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 285, -1));

        btnThem.setBackground(new java.awt.Color(100, 89, 242));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setLGNV_ShadowAllow(true);
        btnThem.setLGNV_borderRadius(60);
        btnThem.setLGNV_lineAllow(false);
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        lgnvPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 194, 79));

        lgnvButton1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_close_window_25px_1.png"))); // NOI18N
        lgnvButton1.setLGNV_backgroundAllow(false);
        lgnvButton1.setLGNV_hoverAllow(false);
        lgnvButton1.setLGNV_lineAllow(false);
        lgnvButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgnvButton1ActionPerformed(evt);
            }
        });
        lgnvPanel1.add(lgnvButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 26, 38, 32));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_remove_25px.png"))); // NOI18N
        btnDelete.setToolTipText("Xóa khách hàng này");
        btnDelete.setLGNV_backgroundAllow(false);
        btnDelete.setLGNV_hoverAllow(false);
        btnDelete.setLGNV_lineAllow(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        lgnvPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 38, 32));

        jLabel6.setText("Ngày sinh");
        lgnvPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 530, 60, 20));

        jLabel1.setBackground(new java.awt.Color(100, 89, 242));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 89, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Khách Hàng");
        lgnvPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 50));

        jLabel9.setText("Tên Khách Hàng");
        lgnvPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 211, -1));

        txtTenKhachHang.setLGNV_placeholderText("Nhập Tên Phòng");
        lgnvPanel1.add(txtTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 285, 41));

        txtCMND.setLGNV_placeholderText("Nhập Tên Phòng");
        lgnvPanel1.add(txtCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 285, 41));

        txtDiaChi.setLGNV_placeholderText("Nhập Tên Phòng");
        lgnvPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 285, 41));

        txtMoTa.setLGNV_placeholderText("Nhập Tên Phòng");
        lgnvPanel1.add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 285, 41));

        txtSDT.setLGNV_placeholderText("Nhập Tên Phòng");
        lgnvPanel1.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 285, 41));

        jLabel10.setText("CMND");
        lgnvPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 211, -1));

        jLabel11.setText("Số điệnthoại");
        lgnvPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 211, -1));

        jLabel12.setText("Địa chỉ");
        lgnvPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 211, -1));

        txtErrorTenKhachHang.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorTenKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtErrorTenKhachHang.setText("Không được để trống tên phòng");
        lgnvPanel1.add(txtErrorTenKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 285, -1));

        txtErrorCMND.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorCMND.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtErrorCMND.setText("Không được để trống tên phòng");
        lgnvPanel1.add(txtErrorCMND, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 285, -1));

        txtErrorSDT.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorSDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtErrorSDT.setText("Không được để trống tên phòng");
        lgnvPanel1.add(txtErrorSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 285, -1));

        txtErrorDiaChi.setForeground(new java.awt.Color(255, 51, 51));
        txtErrorDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtErrorDiaChi.setText("Không được để trống tên phòng");
        lgnvPanel1.add(txtErrorDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 285, -1));

        jLabel7.setText("Mô Tả");
        lgnvPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 211, -1));

        rdoKhac.setBackground(new java.awt.Color(255, 255, 255));
        sex.add(rdoKhac);
        rdoKhac.setText("Khác");
        lgnvPanel1.add(rdoKhac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 60, 20));

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        sex.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        lgnvPanel1.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 60, 20));

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        sex.add(rdoNu);
        rdoNu.setText("Nữ");
        lgnvPanel1.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 60, 20));

        jLabel8.setText("Giới tính");
        lgnvPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 40, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(checkNew){
            BLL.BLL_KhachHang.insert(BLL.BLL_KhachHang.getDataForm());
        }
        else {
            BLL.BLL_KhachHang.update(BLL.BLL_KhachHang.getDataForm());
        }
        this.setVisible(false);
        BLL.BLL_KhachHang.getALLData();
    }//GEN-LAST:event_btnThemActionPerformed
    
    
    private void lgnvButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgnvButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_lgnvButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        BLL.BLL_KhachHang.deleteByID(ID);
        this.setVisible(false);
        BLL.BLL_KhachHang.getALLData();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(dialogFormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogFormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogFormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogFormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogFormKhachHang dialog = new dialogFormKhachHang(new javax.swing.JFrame(), true);
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
    private LIBRARY.lgnvButton btnDelete;
    private LIBRARY.lgnvButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private LIBRARY.lgnvButton lgnvButton1;
    private LIBRARY.lgnvPanel lgnvPanel1;
    public javax.swing.JRadioButton rdoKhac;
    public javax.swing.JRadioButton rdoNam;
    public javax.swing.JRadioButton rdoNu;
    private javax.swing.ButtonGroup sex;
    public LIBRARY.lgnvTextField txtCMND;
    public LIBRARY.lgnvTextField txtDiaChi;
    private javax.swing.JLabel txtErrorCMND;
    private javax.swing.JLabel txtErrorDiaChi;
    private javax.swing.JLabel txtErrorSDT;
    private javax.swing.JLabel txtErrorTenKhachHang;
    private javax.swing.JLabel txtErrroMoTa;
    public LIBRARY.lgnvTextField txtMoTa;
    public LIBRARY.lgnvTextField txtSDT;
    public LIBRARY.lgnvTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}