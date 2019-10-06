
package form;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rafog
 */
public class laporan extends javax.swing.JFrame {
    public laporan() {
        initComponents();
        cmbJenisLaporan.setSelectedIndex(0);
        cbBulan.setEnabled(true);
        cbTahunAjaran.setEnabled(true);
        kodekelas();
        TahunAjaran();
        this.setLocationRelativeTo(null);         
    }    
    public void kodekelas(){
        try{
            Connection conn = new DBConnection().connect();
            String sql = "select * from kelas";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String kode=rs.getString("kodekelas");
                cbkodekelasbayar.addItem(kode);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void TahunAjaran(){
        try{
            Connection conn = new DBConnection().connect();
            String sql = "select * from tahunajaran";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String kode = rs.getString("tahun");
                cbTahunAjaran.addItem(kode);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnbayar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnlaporanpembayaran = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbkodekelasbayar = new javax.swing.JComboBox<>();
        txtnis = new javax.swing.JTextField();
        cmbJenisLaporan = new javax.swing.JComboBox<>();
        cbBulan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbTahunAjaran = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblminimize = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Laporan pembayaran:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlaporanpembayaran.setText("Cetak");
        btnlaporanpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanpembayaranActionPerformed(evt);
            }
        });
        jPanel3.add(btnlaporanpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 25));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nomor Induk Siswa :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        cbkodekelasbayar.setEnabled(false);
        jPanel3.add(cbkodekelasbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 240, 25));

        txtnis.setEnabled(false);
        jPanel3.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 25));

        cmbJenisLaporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laporan Pembayaran Bulanan", "Laporan Tunggakan Bulanan", "Laporan Pembayaran Bulanan Per Kelas", "Laporan Tunggakan Bulanan Per Kelas", "Laporan Pembayaran Siswa" }));
        cmbJenisLaporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbJenisLaporanItemStateChanged(evt);
            }
        });
        jPanel3.add(cmbJenisLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 25));

        cbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cbBulan.setEnabled(false);
        jPanel3.add(cbBulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 25));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis Laporan :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tahun Ajaran :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bulan :");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        cbTahunAjaran.setEnabled(false);
        jPanel3.add(cbTahunAjaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, 25));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kelas :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 550, 290));

        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, -1, -1));

        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 90, 25));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 610, 350));

        jPanel4.setBackground(new java.awt.Color(34, 49, 63));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LAPORAN");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 18, 590, 60));

        lblminimize.setBackground(new java.awt.Color(0, 0, 255));
        lblminimize.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblminimize.setForeground(new java.awt.Color(255, 255, 255));
        lblminimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblminimize.setText("-");
        lblminimize.setOpaque(true);
        lblminimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblminimizeMouseClicked(evt);
            }
        });
        jPanel4.add(lblminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("X");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 30, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlaporanpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanpembayaranActionPerformed
        String bln = cbBulan.getSelectedItem().toString();
        String ta = cbTahunAjaran.getSelectedItem().toString().replace("-", " - ");
        String taun = cbTahunAjaran.getSelectedItem().toString();
        String kls = cbkodekelasbayar.getSelectedItem().toString();
        Connection con = new DBConnection().connect();
        switch (cmbJenisLaporan.getSelectedIndex()) {
            case 0:
                try {
                    File file = new File("src/laporan/pembayaran.jrxml");
                    JasperDesign jdesign = JRXmlLoader.load(file);
                    String sql = "select * from bayar where bulanpembayaran = '" + bln + "' and tahunajaran = '" + taun + "'";
                    JRDesignQuery jrq = new JRDesignQuery();
                    Map<String, Object> parameters;
                    parameters = new HashMap<>();
                    parameters.put("JudulLaporan", "Laporan Pembayaran Bulanan");
                    parameters.put("txtBulan", "Bulan               :");
                    parameters.put("paraBulan", bln);
                    parameters.put("txtTahun", "Tahun Ajaran   :");
                    parameters.put("paraTahun", ta);
                    parameters.put("txtKelas", "");
                    parameters.put("paraKelas", "");
                    jrq.setText(sql);
                    jdesign.setQuery(jrq);
                    JasperReport jr = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
                    if(jp.getPages().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
                    }else{
                          JasperViewer.viewReport(jp, false);
                    }
                } catch (JRException e) {
                    System.out.println(e);
                }
                break;
            case 1:
                try{                                
                    File file = new File("src/laporan/siswa.jrxml");
                    JasperDesign jdesign = JRXmlLoader.load(file);
                    String sql = "select nis, nama, jeniskelamin, tgllahir, tempatlahir, alamat, Telpon, Agama, Kelas, kodekelas from siswa where nis not in (select nis from bayar where bulanpembayaran = '" + bln + "' and tahunajaran = '" + taun + "')";
                    JRDesignQuery jrq = new JRDesignQuery();
                    jrq.setText(sql);
                    jdesign.setQuery(jrq);
                    Map<String, Object> parameters;
                    parameters = new HashMap<>();
                    parameters.put("JudulLaporan", "Laporan Tunggakan Bulanan");
                    parameters.put("txtBulan", "Bulan               :");
                    parameters.put("paraBulan", bln);
                    parameters.put("txtTahun", "Tahun Ajaran   :");
                    parameters.put("paraTahun", ta);
                    parameters.put("txtKelas", "");
                    parameters.put("paraKelas", "");
                    JasperReport jr = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);          
                    if(jp.getPages().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                    }else{
                          JasperViewer.viewReport(jp, false);
                    }
                }catch(JRException e){
                    System.out.println(e);
                }
                break;
            case 2:
                try {
                    File file = new File("src/laporan/pembayaran.jrxml");
                    JasperDesign jdesign = JRXmlLoader.load(file);
                    String sql = "select * from bayar where kodekelas = '" + cbkodekelasbayar.getSelectedItem().toString() + "' and bulanpembayaran = '" + bln + "' and tahunajaran = '" + cbTahunAjaran.getSelectedItem().toString() + "'";
                    JRDesignQuery jrq = new JRDesignQuery();
                    Map<String, Object> parameters;
                    parameters = new HashMap<>();
                    parameters.put("JudulLaporan", "Laporan Pembayaran Bulanan Kelas");
                    parameters.put("txtBulan", "Bulan   :");
                    parameters.put("paraBulan", bln);
                    parameters.put("txtTahun", "Tahun Ajaran    :");
                    parameters.put("paraTahun", ta);
                    parameters.put("txtKelas", "Kode Kelas  :");
                    parameters.put("paraKelas", kls);
                    jrq.setText(sql);
                    jdesign.setQuery(jrq);
                    JasperReport jr = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
                    if(jp.getPages().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
                    }else{
                          JasperViewer.viewReport(jp, false);
                    }
                } catch (JRException e) {
                    System.out.println(e);
                }                
                break;
            case 3:
                try{                                
                    File file = new File("src/laporan/siswa.jrxml");
                    JasperDesign jdesign = JRXmlLoader.load(file);
                    String sql = "select nis, nama, jeniskelamin, tgllahir, tempatlahir, alamat, Telpon, Agama, "
                            + "Kelas, kodekelas from siswa where "
                            + "kodekelas = '" + cbkodekelasbayar.getSelectedItem().toString() + "' and "
                            + "nis not in (select nis from bayar where bulanpembayaran = '" + bln + "' and "
                            + "tahunajaran = '" + taun + "')";
                    JRDesignQuery jrq = new JRDesignQuery();
                    jrq.setText(sql);
                    jdesign.setQuery(jrq);
                    Map<String, Object> parameters;
                    parameters = new HashMap<>();
                    parameters.put("JudulLaporan", "Laporan Tunggakan Bulanan Kelas");
                    parameters.put("txtBulan", "Bulan   :");
                    parameters.put("paraBulan", bln);
                    parameters.put("txtTahun", "Tahun Ajaran    :");
                    parameters.put("paraTahun", ta);
                    parameters.put("txtKelas", "Kelas   :");
                    parameters.put("paraKelas", kls);
                    JasperReport jr = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);          
                    if(jp.getPages().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                    }else{
                          JasperViewer.viewReport(jp, false);
                    }
                }catch(JRException e){
                    System.out.println(e);
                }
                break;
            case 4:
                if(txtnis.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Silahkan Mengisi Nomor Induk Siswa!");
                }else {
                    try {
                        Connection conn = new DBConnection().connect();
                        String sql = "Select * from siswa where nis = '" + txtnis.getText() + "%'";
                        Statement stm = conn.createStatement();
                        ResultSet rscari = stm.executeQuery(sql);
                        if(rscari.next() == false){
                            try {
                                File file = new File("src/laporan/pembayaran.jrxml");
                                JasperDesign jdesign = JRXmlLoader.load(file);
                                String sqlreport = "select * from bayar where nis = '" + txtnis.getText() + "'";
                                JRDesignQuery jrq = new JRDesignQuery();
                                Map<String, Object> parameters = new HashMap<>();
                                parameters.put("JudulLaporan", "Laporan Pembayaran Siswa");
                                parameters.put("txtBulan", "");
                                parameters.put("paraBulan", "");
                                parameters.put("txtTahun", "");
                                parameters.put("paraTahun", "");
                                parameters.put("txtKelas", "");
                                parameters.put("paraKelas", "");
                                jrq.setText(sqlreport);
                                jdesign.setQuery(jrq);
                                JasperReport jr = JasperCompileManager.compileReport(jdesign);
                                JasperPrint jp = JasperFillManager.fillReport(jr, parameters, con);
                                if(jp.getPages().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Data Pembayaran Tidak Ada!");
                                    txtnis.setText("");
                                    txtnis.requestFocus();
                                }else{
                                    JasperViewer.viewReport(jp, false);
                                    txtnis.setText("");
                                    txtnis.requestFocus();
                                }
                            }catch (JRException e){
                                System.out.println(e);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Nomor Induk SIswa Tidak Ditemukan! Silahkan Cari Lagi!");
                            txtnis.setText("");
                            txtnis.requestFocus();
                        }
                    }catch (SQLException e) {
                        System.out.println(e);
                    }
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnlaporanpembayaranActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void lblminimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lblminimizeMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbJenisLaporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbJenisLaporanItemStateChanged
        switch (cmbJenisLaporan.getSelectedIndex()) {
            case 0:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbkodekelasbayar.setEnabled(false);
                txtnis.setEnabled(false);
                break;
            case 1:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbkodekelasbayar.setEnabled(false);
                txtnis.setEnabled(false);
                break;
            case 2:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbkodekelasbayar.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 3:
                cbBulan.setEnabled(true);
                cbTahunAjaran.setEnabled(true);
                cbkodekelasbayar.setEnabled(true);
                txtnis.setEnabled(false);
                break;
            case 4:
                cbBulan.setEnabled(false);
                cbTahunAjaran.setEnabled(false);
                cbkodekelasbayar.setEnabled(false);
                txtnis.setEnabled(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbJenisLaporanItemStateChanged

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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnbayar;
    private javax.swing.JButton btnlaporanpembayaran;
    private javax.swing.JComboBox<String> cbBulan;
    private javax.swing.JComboBox<String> cbTahunAjaran;
    private javax.swing.JComboBox<String> cbkodekelasbayar;
    private javax.swing.JComboBox<String> cmbJenisLaporan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblminimize;
    private javax.swing.JTextField txtnis;
    // End of variables declaration//GEN-END:variables
}
