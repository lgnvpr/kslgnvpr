/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author LGNV
 */
public class Welcome extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public Welcome() {
        initComponents();
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
        lblValueLoad = new javax.swing.JLabel();
        lblImgLoad = new javax.swing.JLabel();
        pprLoad = new javax.swing.JProgressBar();
        lblContentLoad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lgnvPanel1.setBackground(new java.awt.Color(255, 255, 255));
        lgnvPanel1.setLGNV_lineAllow(false);
        lgnvPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblValueLoad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblValueLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValueLoad.setText("30%");
        lgnvPanel1.add(lblValueLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 94, 70, 40));

        lblImgLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/loading.gif"))); // NOI18N
        lgnvPanel1.add(lblImgLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 260, 130));
        lgnvPanel1.add(pprLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 470, 20));

        lblContentLoad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblContentLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContentLoad.setText("Đang Load Data...");
        lgnvPanel1.add(lblContentLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 250, -1));

        getContentPane().add(lgnvPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 320));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblContentLoad;
    private javax.swing.JLabel lblImgLoad;
    public javax.swing.JLabel lblValueLoad;
    private LIBRARY.lgnvPanel lgnvPanel1;
    public javax.swing.JProgressBar pprLoad;
    // End of variables declaration//GEN-END:variables
}