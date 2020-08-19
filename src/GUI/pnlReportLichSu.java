/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;

/**
 *
 * @author LGNV
 */
public class pnlReportLichSu extends javax.swing.JPanel {

    /**
     * Creates new form pnlManagerKhachHang
     */
    public pnlReportLichSu() {
        initComponents();
        css();
    }
    private void css(){
        scroll.setBackground(Color.white);
        scroll.setOpaque(true);
    }
    public void compile(){
        BLL.BLL_Thue.fillDataToTableReport(BLL.BLL_Thue.getDataChoThue());
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
        pnlHeader = new LIBRARY.lgnvPanel();
        btnSua1 = new LIBRARY.lgnvButton();
        scroll = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        pnlPaddingLeft = new LIBRARY.lgnvPanel();

        setLayout(new java.awt.CardLayout());

        lgnvPanel1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLGNV_lineAllow(false);
        lgnvPanel1.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setLGNV_lineAllow(false);
        pnlHeader.setPreferredSize(new java.awt.Dimension(889, 80));

        btnSua1.setBackground(new java.awt.Color(100, 89, 242));
        btnSua1.setForeground(new java.awt.Color(255, 255, 255));
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_synchronize_25px.png"))); // NOI18N
        btnSua1.setText("Reload");
        btnSua1.setLGNV_ShadowAllow(true);
        btnSua1.setLGNV_borderRadius(60);
        btnSua1.setLGNV_lineAllow(false);
        btnSua1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(785, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSua1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        lgnvPanel1.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiêu Thuê", "Mã Phòng", "Mã Loại Thuê", "Nhân Viên", "Ngày Thuê", "Tiền đặt cọc", "Mô Tả", "Tình trạng", "Mã khách hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLichSu.setRowHeight(30);
        tblLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLichSuMouseClicked(evt);
            }
        });
        scroll.setViewportView(tblLichSu);

        lgnvPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        pnlPaddingLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnlPaddingLeft.setLGNV_lineAllow(false);
        pnlPaddingLeft.setPreferredSize(new java.awt.Dimension(50, 447));

        javax.swing.GroupLayout pnlPaddingLeftLayout = new javax.swing.GroupLayout(pnlPaddingLeft);
        pnlPaddingLeft.setLayout(pnlPaddingLeftLayout);
        pnlPaddingLeftLayout.setHorizontalGroup(
            pnlPaddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        pnlPaddingLeftLayout.setVerticalGroup(
            pnlPaddingLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        lgnvPanel1.add(pnlPaddingLeft, java.awt.BorderLayout.LINE_START);

        add(lgnvPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void tblLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLichSuMouseClicked
        if(evt.getClickCount()>=2){
            main.dialogFormPhong.checkNew(false);
        }
    }//GEN-LAST:event_tblLichSuMouseClicked

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        compile();
    }//GEN-LAST:event_btnSua1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIBRARY.lgnvButton btnSua1;
    private LIBRARY.lgnvPanel lgnvPanel1;
    private LIBRARY.lgnvPanel pnlHeader;
    private LIBRARY.lgnvPanel pnlPaddingLeft;
    private javax.swing.JScrollPane scroll;
    public javax.swing.JTable tblLichSu;
    // End of variables declaration//GEN-END:variables
}
