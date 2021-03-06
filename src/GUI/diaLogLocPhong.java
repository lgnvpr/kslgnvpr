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
public class diaLogLocPhong extends javax.swing.JDialog {

    /**
     * Creates new form FormPhong
     */
    public diaLogLocPhong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        css();
        
    }
    
    public void css(){
        this.getRootPane ().setOpaque (false);
        this.getContentPane ().setBackground (new Color (0, 0, 0, 0));
        this.setBackground (new Color (0, 0, 0, 0));
         
        
        UIManager.put("ComboBox.background", new ColorUIResource(Color.white));
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(new Color(100, 89, 242)));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(Color.WHITE));
        cbbLoaiPhong.getEditor().getEditorComponent().setBackground(Color.white);
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
        txtToPrice = new LIBRARY.lgnvTextField();
        jLabel2 = new javax.swing.JLabel();
        cbbLoaiPhong = new javax.swing.JComboBox<>();
        cbbKhuVuc = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new LIBRARY.lgnvButton();
        btnClose = new LIBRARY.lgnvButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenPhong = new LIBRARY.lgnvTextField();
        txtFromPrice = new LIBRARY.lgnvTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbTinhTrang = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        lgnvPanel1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLGNV_ShaDownAllow(true);
        lgnvPanel1.setLGNV_ShadownColor(100);
        lgnvPanel1.setLGNV_ShadownPixel(40);
        lgnvPanel1.setLGNV_lineAllow(false);
        lgnvPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtToPrice.setLGNV_placeholderText("Đến");
        txtToPrice.setLGNV_textType(LIBRARY.lgnvTextField.textTypeEnum.NUMBER_FORMAT);
        lgnvPanel1.add(txtToPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 120, 41));

        jLabel2.setText("Khu Vực");
        lgnvPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 211, -1));

        cbbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khu Vực 1", "Khu Vực 2", "Khu Vực 3", " " }));
        cbbLoaiPhong.setBorder(null);
        cbbLoaiPhong.setFocusable(false);
        cbbLoaiPhong.setOpaque(false);
        lgnvPanel1.add(cbbLoaiPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 290, 32));

        cbbKhuVuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khu Vực 1", "Khu Vực 2", "Khu Vực 3", " " }));
        cbbKhuVuc.setBorder(null);
        cbbKhuVuc.setFocusable(false);
        cbbKhuVuc.setOpaque(false);
        lgnvPanel1.add(cbbKhuVuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 290, 32));

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nhập cái đéo gì vậy");
        lgnvPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 285, -1));

        btnThem.setBackground(new java.awt.Color(100, 89, 242));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Lọc");
        btnThem.setLGNV_ShadowAllow(true);
        btnThem.setLGNV_borderRadius(60);
        btnThem.setLGNV_lineAllow(false);
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        lgnvPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 194, 79));

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_close_window_25px_1.png"))); // NOI18N
        btnClose.setLGNV_backgroundAllow(false);
        btnClose.setLGNV_hoverAllow(false);
        btnClose.setLGNV_lineAllow(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        lgnvPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 26, 38, 32));

        jLabel6.setText("Nhập Từ Khóa");
        lgnvPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 211, -1));

        jLabel7.setText("Loại Phòng");
        lgnvPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 211, -1));

        jLabel1.setBackground(new java.awt.Color(100, 89, 242));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(100, 89, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lọc Phòng");
        lgnvPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 50));

        jLabel8.setText("Khoảng Giá");
        lgnvPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 211, -1));

        txtTenPhong.setLGNV_placeholderText("Nhập Tên Phòng");
        txtTenPhong.setLGNV_textType(LIBRARY.lgnvTextField.textTypeEnum.ID);
        lgnvPanel1.add(txtTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 285, 41));

        txtFromPrice.setLGNV_placeholderText("Từ");
        txtFromPrice.setLGNV_textType(LIBRARY.lgnvTextField.textTypeEnum.NUMBER_FORMAT);
        lgnvPanel1.add(txtFromPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 120, 41));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_right_25px.png"))); // NOI18N
        lgnvPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 40, 40));

        jLabel3.setText("Tình Trạng");
        lgnvPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 211, -1));

        cbbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khu Vực 1", "Khu Vực 2", "Khu Vực 3", " " }));
        cbbTinhTrang.setBorder(null);
        cbbTinhTrang.setFocusable(false);
        cbbTinhTrang.setOpaque(false);
        lgnvPanel1.add(cbbTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 290, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lgnvPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.setVisible(false);
        BLL.BLL_Phong.getFilter();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(diaLogLocPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(diaLogLocPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(diaLogLocPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(diaLogLocPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                diaLogLocPhong dialog = new diaLogLocPhong(new javax.swing.JFrame(), true);
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
    private LIBRARY.lgnvButton btnClose;
    private LIBRARY.lgnvButton btnThem;
    public javax.swing.JComboBox<String> cbbKhuVuc;
    public javax.swing.JComboBox<String> cbbLoaiPhong;
    public javax.swing.JComboBox<String> cbbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private LIBRARY.lgnvPanel lgnvPanel1;
    public LIBRARY.lgnvTextField txtFromPrice;
    public LIBRARY.lgnvTextField txtTenPhong;
    public LIBRARY.lgnvTextField txtToPrice;
    // End of variables declaration//GEN-END:variables
}
