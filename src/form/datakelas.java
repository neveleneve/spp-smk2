/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rafog
 */
public class datakelas extends javax.swing.JFrame {

    /**
     * Creates new form datakelas
     */
    
    
    public datakelas() {
        initComponents();
        isitabel();
        settingtabel(tblkelas);
        tahunajaran();
        this.setLocationRelativeTo(null);
        tblkelas.getTableHeader().setForeground(Color.white);
        tblkelas.getTableHeader().setBackground(new Color(34,49,63));
    }
    
    
   public void tahunajaran(){
       for(int i=2018;i<3000;i++){
           cbawalta.addItem(String.valueOf(i));
           cbakhirta.addItem(String.valueOf(i));
       }
       for(int a=2019;a<3001;a++){
           cbawalta.addItem(String.valueOf(a));
           cbakhirta.addItem(String.valueOf(a));
       }
   }
    
     public void settingtabel(JTable tabel){
        tblkelas.setDefaultEditor(Object.class, null);
        tblkelas.getTableHeader().setReorderingAllowed(false);
        tblkelas.getTableHeader().setResizingAllowed(false);        
    }
    
    public void isitabel(){
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("KODE KELAS");
        model.addColumn("KELAS");
        model.addColumn("JENIS KELAS");
        
        try{
            Connection conn = new DBConnection().connect();
            String sql="Select * from kelas";
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);    

                while(rs.next()){
                  model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                }
            tblkelas.setModel(model);
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null, e);
        }        
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
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblminimize = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkelas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtkodekelas = new javax.swing.JTextField();
        txtkelas = new javax.swing.JTextField();
        txtjeniskelas = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbawalta = new javax.swing.JComboBox<>();
        cbakhirta = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(34, 49, 63));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Data Kelas");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

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
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 30, 30));

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
        jPanel4.add(lblminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 30, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 90));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblkelas.setBackground(new java.awt.Color(0, 0, 0));
        tblkelas.setForeground(new java.awt.Color(255, 255, 255));
        tblkelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblkelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkelas);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 720, 301));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Data Kelas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kode Kelas :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 22));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kelas :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 22));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jenis Kelas :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 22));
        jPanel2.add(txtkodekelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 140, 22));

        txtkelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkelasKeyTyped(evt);
            }
        });
        jPanel2.add(txtkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, 22));
        jPanel2.add(txtjeniskelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, 22));

        btntambah.setBackground(new java.awt.Color(0, 204, 0));
        btntambah.setForeground(new java.awt.Color(255, 255, 255));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel2.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 80, 22));

        btnubah.setBackground(new java.awt.Color(255, 204, 0));
        btnubah.setForeground(new java.awt.Color(255, 255, 255));
        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });
        jPanel2.add(btnubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 80, 22));

        btnhapus.setBackground(new java.awt.Color(255, 0, 0));
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 80, 22));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, 140));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)), "Tahun Ajaran", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Awal Tahun Ajaran :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 110, 22));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Akhir Tahun Ajaran :");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 110, 22));

        jPanel3.add(cbawalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 120, 22));

        jPanel3.add(cbakhirta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 120, 22));

        jButton1.setBackground(new java.awt.Color(0, 204, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 80, 22));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 30, 340, 140));

        btnkembali.setBackground(new java.awt.Color(0, 0, 204));
        btnkembali.setForeground(new java.awt.Color(255, 255, 255));
        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        jPanel5.add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(641, 530, 100, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 760, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btnkembaliActionPerformed
 
    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        try{
            Connection conn = new DBConnection().connect();
            String sql="insert into kelas(kodekelas,kelas,jeniskelas) values('"+txtkodekelas.getText()+"','"+txtkelas.getText()+"','"+txtjeniskelas.getText()+"')";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            isitabel();
            JOptionPane.showMessageDialog(null, "Berhasil Menambah Kelas");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            Connection conn = new DBConnection().connect();
            String sql="Delete from kelas where kodekelas='"+txtkodekelas.getText()+"'";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Sukses menghapus kelas");
            isitabel();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }        
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tblkelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkelasMouseClicked
        int row=tblkelas.getSelectedRow();
        txtkodekelas.setText(tblkelas.getValueAt(row, 0).toString());
        txtkelas.setText(tblkelas.getValueAt(row,1).toString());
        txtjeniskelas.setText(tblkelas.getValueAt(row,2).toString());
    }//GEN-LAST:event_tblkelasMouseClicked

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        int baris = tblkelas.getSelectedRow();
        String kodelama = tblkelas.getValueAt(baris, 0).toString();
        try{
            Connection conn = new DBConnection().connect();
            String sql = "Update kelas set kodekelas='" + txtkodekelas.getText() + "',kelas='"+txtkelas.getText()+"',jeniskelas='"+txtjeniskelas.getText()+"'Where kodekelas='"+kodelama+"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Sukses mengubah kelas");
            isitabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }//GEN-LAST:event_btnubahActionPerformed

    private void txtkelasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkelasKeyTyped
        char masuk = evt.getKeyChar();
        if(!(Character.isDigit(masuk))){
            evt.consume();
        } 
    }//GEN-LAST:event_txtkelasKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            String tahunawal = String.valueOf(cbawalta.getSelectedItem());
            String  tahunakhir = String.valueOf(cbakhirta.getSelectedItem());
            String hasil = tahunawal + "-" + tahunakhir;

            Connection cekconn = new DBConnection().connect();
            String cek = "select * from tahunajaran where tahun='" + hasil + "'";
            Statement stm = cekconn.createStatement();
            ResultSet rs = stm.executeQuery(cek);
        
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Tahun Ajaran Sudah Ada");
            }else if(Integer.parseInt(tahunawal)>Integer.parseInt(tahunakhir)){
                JOptionPane.showMessageDialog(null, "Tahun Awal Ajaran Tidak Boleh Lebih Tinggi Dari Tahun Akhir Ajaran");
            }else if(Integer.parseInt(tahunawal)==Integer.parseInt(tahunakhir)){
                JOptionPane.showMessageDialog(null, "Tahun Awal Ajaran Tidak Boleh Sama Dengan Tahun Akhir Ajaran");
            }else if(Integer.parseInt(tahunakhir)-Integer.parseInt(tahunawal)>1){
                JOptionPane.showMessageDialog(null, "Tahun Ajaran tidak boleh lewat dari 1 tahun");
            }else{
                Connection conn = new DBConnection().connect();
                String sql="insert into tahunajaran values('" + hasil + "')";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Sukses Menambah Tahun Ajaran");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void lblminimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lblminimizeMouseClicked

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
            java.util.logging.Logger.getLogger(datakelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datakelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datakelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datakelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datakelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cbakhirta;
    private javax.swing.JComboBox<String> cbawalta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblminimize;
    private javax.swing.JTable tblkelas;
    private javax.swing.JTextField txtjeniskelas;
    private javax.swing.JTextField txtkelas;
    private javax.swing.JTextField txtkodekelas;
    // End of variables declaration//GEN-END:variables
}