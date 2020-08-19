/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLL_Thue;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author LGNV
 */
public class pnlShowPhong extends javax.swing.JPanel {

    /**
     * Creates new form pnlShowPhong
     */
    public pnlShowPhong() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
        this.setOpaque(true);
    }
    private  String ID = "";
    private String IDPhieuThue = "";
    
    public void setIDPhieuThue(String id ){
        IDPhieuThue = id;
    }
    public String getIDPhieuThue(){
        return IDPhieuThue;
    }
    
    public void setID(String id ){
        ID = id;
    }
    public String getID(){
        return ID;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAllPhong = new LIBRARY.lgnvPanel();
        lblTimePhong = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        lblTenPhong = new javax.swing.JLabel();

        pnlAllPhong.setBackground(new java.awt.Color(4, 163, 11));
        pnlAllPhong.setLGNV_ShaDownAllow(true);
        pnlAllPhong.setLGNV_borderRadius(30);
        pnlAllPhong.setLGNV_lineAllow(false);
        pnlAllPhong.setMinimumSize(new java.awt.Dimension(210, 130));
        pnlAllPhong.setPreferredSize(new java.awt.Dimension(210, 136));
        pnlAllPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAllPhongMouseClicked(evt);
            }
        });
        pnlAllPhong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimePhong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTimePhong.setForeground(new java.awt.Color(255, 255, 255));
        lblTimePhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimePhong.setText("1 ngày 3 giờ");
        pnlAllPhong.add(lblTimePhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 30));

        lblThongBao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(255, 255, 255));
        lblThongBao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThongBao.setText("Nguyễn Văn Lương");
        pnlAllPhong.add(lblThongBao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 190, 20));

        lblTenPhong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTenPhong.setForeground(new java.awt.Color(255, 255, 255));
        lblTenPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong.setText("Phòng 101");
        pnlAllPhong.add(lblTenPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAllPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAllPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAllPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAllPhongMouseClicked
        if(evt.getClickCount()>=2){
            
            main.dialogFormChoThue.fillDataForm(ID);
            
            
        }
    }//GEN-LAST:event_pnlAllPhongMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblTenPhong;
    public javax.swing.JLabel lblThongBao;
    public javax.swing.JLabel lblTimePhong;
    public LIBRARY.lgnvPanel pnlAllPhong;
    // End of variables declaration//GEN-END:variables
}
