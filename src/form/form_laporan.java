/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import form.function_laporan;

/**
 *
 * @author NEVE
 */
public class form_laporan extends javax.swing.JFrame {

    /**
     * Creates new form form_laporan
     */
    public form_laporan() {
        initComponents();
        cbKodeKelas.setEnabled(false);
        txtnis.setEnabled(false);
        function_laporan.TahunAjaran(cbTahunAjaran);
        function_laporan.kodekelas(cbKodeKelas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbKodeKelas = new javax.swing.JComboBox<>();
        cbJenisLaporan = new javax.swing.JComboBox<>();
        cbBulan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbTahunAjaran = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtnis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LAPORAN");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 480, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 80));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laporan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.add(cbKodeKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 360, 30));

        cbJenisLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laporan Pembayaran Bulanan", "Laporan Tunggakan Bulanan", "Laporan Pembayaran Bulanan per Kelas", "Laporan Tunggakan Bulanan per Kelas", "Laporan Pembayaran Siswa" }));
        cbJenisLaporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJenisLaporanItemStateChanged(evt);
            }
        });
        jPanel3.add(cbJenisLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 360, 30));

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jPanel3.add(cbBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 170, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nomor Induk Siswa");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 120, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Laporan");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bulan");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 30));

        jPanel3.add(cbTahunAjaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 170, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tahun Ajaran");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 90, 30));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 80, 30));
        jPanel3.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 160, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kode Kelas");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

        jButton2.setText("Cetak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 80, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 400, 350));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 500, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbJenisLaporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJenisLaporanItemStateChanged
        switch (cbJenisLaporan.getSelectedIndex()) {
            case 0:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(false);
                txtnis.setEnabled(false);
                break;
            case 1:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(false);
                txtnis.setEnabled(false);
                break;
            case 2:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 3:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 4:
                cbBulan.setEnabled(false);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(false);
                txtnis.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_cbJenisLaporanItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String thaj = cbTahunAjaran.getSelectedItem().toString().replace("-", " - ");
        String bulan = cbBulan.getSelectedItem().toString();
        switch (cbJenisLaporan.getSelectedIndex()) {
            case 0:
                function_laporan.laporanPembayaranBulanan(cbBulan, cbTahunAjaran, thaj, bulan);
                break;
            case 1:
                function_laporan.laporanTunggakanBulanan(cbBulan, cbTahunAjaran, thaj, bulan);
                break;
            case 2:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 3:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 4:
                cbBulan.setEnabled(false);
                cbTahunAjaran.setEnabled(true);
                cbKodeKelas.setEnabled(false);
                txtnis.setEnabled(true);
                break;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JComboBox<String> cbJenisLaporan;
    private javax.swing.JComboBox<String> cbKodeKelas;
    private javax.swing.JComboBox<String> cbTahunAjaran;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtnis;
    // End of variables declaration//GEN-END:variables
}