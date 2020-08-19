/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.CardLayout;

/**
 *
 * @author LGNV
 */
public class pnlTabReport extends javax.swing.JPanel {
    pnlReportLichSu tabLichSu = main.tabLichSuThue;
    /**
     * Creates new form pnlTabManager
     */
    public pnlTabReport() {
        initComponents();
        addTab();
    }
    
    public void addTab(){
        pnlCenter.add(tabLichSu, "lichSu");
        
    }
    
    public void showLayout(String nameLayout){
        CardLayout layout = (CardLayout) pnlCenter.getLayout();
        layout.show(pnlCenter, nameLayout);
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
        lgnvPanel3 = new LIBRARY.lgnvPanel();
        btnNhanVien = new LIBRARY.lgnvButton();
        pnlCenter = new LIBRARY.lgnvPanel();

        setLayout(new java.awt.CardLayout());

        lgnvPanel1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLGNV_lineAllow(false);
        lgnvPanel1.setLayout(new java.awt.BorderLayout());

        lgnvPanel2.setBackground(new java.awt.Color(100, 89, 242));
        lgnvPanel2.setLGNV_lineAllow(false);
        lgnvPanel2.setPreferredSize(new java.awt.Dimension(250, 457));

        lgnvPanel3.setBackground(new java.awt.Color(100, 89, 242));
        lgnvPanel3.setLGNV_lineAllow(false);
        lgnvPanel3.setLayout(new java.awt.GridLayout(0, 1));

        btnNhanVien.setBackground(new java.awt.Color(100, 89, 242));
        btnNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        btnNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/icons8_user_groups_25px.png"))); // NOI18N
        btnNhanVien.setText("Lịch sử cho thuê");
        btnNhanVien.setLGNV_lineAllow(false);
        btnNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNhanVien.setIconTextGap(20);
        btnNhanVien.setMargin(new java.awt.Insets(2, 20, 2, 14));
        btnNhanVien.setMultiClickThreshhold(10L);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        lgnvPanel3.add(btnNhanVien);

        javax.swing.GroupLayout lgnvPanel2Layout = new javax.swing.GroupLayout(lgnvPanel2);
        lgnvPanel2.setLayout(lgnvPanel2Layout);
        lgnvPanel2Layout.setHorizontalGroup(
            lgnvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lgnvPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lgnvPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
        );
        lgnvPanel2Layout.setVerticalGroup(
            lgnvPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lgnvPanel2Layout.createSequentialGroup()
                .addComponent(lgnvPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 220, Short.MAX_VALUE))
        );

        lgnvPanel1.add(lgnvPanel2, java.awt.BorderLayout.LINE_START);

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setLGNV_lineAllow(false);
        pnlCenter.setLayout(new java.awt.CardLayout());
        lgnvPanel1.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(lgnvPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        
    }//GEN-LAST:event_btnNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private LIBRARY.lgnvButton btnNhanVien;
    private LIBRARY.lgnvPanel lgnvPanel1;
    private LIBRARY.lgnvPanel lgnvPanel2;
    private LIBRARY.lgnvPanel lgnvPanel3;
    private LIBRARY.lgnvPanel pnlCenter;
    // End of variables declaration//GEN-END:variables
}