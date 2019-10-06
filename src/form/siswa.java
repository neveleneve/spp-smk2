package form;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class siswa extends javax.swing.JFrame {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
    Date tgl;

    public siswa() {
        initComponents();
        fill_table();
        fill_kodekelas();
        settingtabel(tblsiswa);
        filltahunajaran();
        this.setLocationRelativeTo(null);
        tblsiswa.getTableHeader().setForeground(Color.white);
        tblsiswa.getTableHeader().setBackground(new Color(34, 49, 63));
    }

    public void settingtabel(JTable tabel) {
        tblsiswa.setDefaultEditor(Object.class, null);
        tblsiswa.getTableHeader().setReorderingAllowed(false);
        tblsiswa.getTableHeader().setResizingAllowed(false);

        tblsiswa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        DefaultTableCellRenderer mid = new DefaultTableCellRenderer();
        mid.setHorizontalAlignment(JLabel.CENTER);
        tblsiswa.getColumnModel().getColumn(0).setPreferredWidth(60);//NIS
        tblsiswa.getColumnModel().getColumn(0).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(1).setPreferredWidth(150);//Nama
        tblsiswa.getColumnModel().getColumn(1).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(2).setPreferredWidth(100);//Jenis Kelamin
        tblsiswa.getColumnModel().getColumn(2).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(3).setPreferredWidth(120);//Tgl Lahir
        tblsiswa.getColumnModel().getColumn(3).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(4).setPreferredWidth(130);//Tpt Lahir
        tblsiswa.getColumnModel().getColumn(4).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(5).setPreferredWidth(150);//Alamat
        tblsiswa.getColumnModel().getColumn(5).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(6).setPreferredWidth(110);//Telpon
        tblsiswa.getColumnModel().getColumn(6).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(7).setCellRenderer(mid);//Agama

        tblsiswa.getColumnModel().getColumn(8).setPreferredWidth(110);//Tahun Ajaran
        tblsiswa.getColumnModel().getColumn(8).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(9).setPreferredWidth(110);//Kode Kelas
        tblsiswa.getColumnModel().getColumn(9).setCellRenderer(mid);

        tblsiswa.getColumnModel().getColumn(10).setCellRenderer(mid);//Kelas

        JTableHeader header = tblsiswa.getTableHeader();
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    public void baru() {
        txtnis.setText("");
        txtnama.setText("");
        cbkelamin.setSelectedIndex(0);
        jdtgllahir.setCalendar(null);
        txttmptlahir.setText("");
        txtalamat.setText("");
        txttelpon.setText("");
        txtagama.setText("");
        cbta.setSelectedIndex(0);
        cbkodekelas.setSelectedIndex(0);
        cbkelas.setSelectedIndex(0);
    }

    public void fill_table() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIS");
        model.addColumn("NAMA");
        model.addColumn("JENIS KELAMIN");
        model.addColumn("TANGGAL LAHIR");
        model.addColumn("TEMPAT LAHIR");
        model.addColumn("ALAMAT");
        model.addColumn("TELEPON");
        model.addColumn("Agama");
        model.addColumn("TAHUN AJARAN");
        model.addColumn("KODE KELAS");
        model.addColumn("KELAS");

        try {
            String sql = "Select * from siswa";
            Connection conn = new DBConnection().connect();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    df.format(rs.getDate(4)),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11)});
            }
            tblsiswa.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void fill_kodekelas() {
        try {
            Connection conn = new DBConnection().connect();
            String sql = "select * from kelas";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String kode = rs.getString("kodekelas");
                cbkodekelas.addItem(kode);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void filltahunajaran() {
        try {
            Connection conn = new DBConnection().connect();
            String sql = "select * from tahunajaran";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String tahunajaran = rs.getString("tahun");
                cbta.addItem(tahunajaran);
            }
        } catch (SQLException e) {
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
        jLabel12 = new javax.swing.JLabel();
        lblminimize = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnubahta = new javax.swing.JButton();
        btnkembali = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnbaru = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        cbkelamin = new javax.swing.JComboBox<>();
        jdtgllahir = new com.toedter.calendar.JDateChooser();
        txttmptlahir = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsiswa = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbkelas = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbkodekelas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbta = new javax.swing.JComboBox<>();
        txtagama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txttelpon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DATA SISWA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 80));

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
        jPanel1.add(lblminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 30, 30));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("X");
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 79));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnubahta.setText("Ubah Tahun Ajaran");
        btnubahta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahtaActionPerformed(evt);
            }
        });
        jPanel2.add(btnubahta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, -1, 30));

        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 80, 30));

        btnupdate.setText("Perbarui");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 80, 30));

        btnbaru.setText("Baru");
        btnbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbaruActionPerformed(evt);
            }
        });
        jPanel2.add(btnbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 80, 30));

        btntambah.setText("Input");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel2.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 80, 30));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel2.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        cbkelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Jenis Kelamin--", "Laki-Laki", "Perempuan" }));
        cbkelamin.setBorder(null);
        jPanel2.add(cbkelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 25));

        jdtgllahir.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jdtgllahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, 25));

        txttmptlahir.setBackground(new java.awt.Color(0, 0, 0));
        txttmptlahir.setForeground(new java.awt.Color(255, 255, 255));
        txttmptlahir.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txttmptlahir.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txttmptlahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 150, 20));

        tblsiswa.setBackground(new java.awt.Color(0, 0, 0));
        tblsiswa.setForeground(new java.awt.Color(255, 255, 255));
        tblsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsiswa);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 830, 280));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 80, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tempat Lahir :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tanggal Lahir :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 110, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Jenis Kelamin :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 110, 20));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nama :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, 20));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NIS:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 110, 20));

        txtalamat.setBackground(new java.awt.Color(0, 0, 0));
        txtalamat.setForeground(new java.awt.Color(255, 255, 255));
        txtalamat.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtalamat.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 150, 20));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Kelas :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, 20));

        cbkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Kelas--", "10", "11", "12" }));
        jPanel2.add(cbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 150, 25));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Kode Kelas :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 80, 20));

        cbkodekelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Kode Kelas--" }));
        jPanel2.add(cbkodekelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 150, 25));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Tahun Ajaran :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 80, 20));

        cbta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Tahun--" }));
        jPanel2.add(cbta, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 150, 25));

        txtagama.setBackground(new java.awt.Color(0, 0, 0));
        txtagama.setForeground(new java.awt.Color(255, 255, 255));
        txtagama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtagama.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtagama, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 150, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Agama :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 80, 20));

        txttelpon.setBackground(new java.awt.Color(0, 0, 0));
        txttelpon.setForeground(new java.awt.Color(255, 255, 255));
        txttelpon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txttelpon.setCaretColor(new java.awt.Color(255, 255, 255));
        txttelpon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelponKeyTyped(evt);
            }
        });
        jPanel2.add(txttelpon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 150, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Telepon :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 80, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Alamat :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 80, 20));

        txtnis.setBackground(new java.awt.Color(0, 0, 0));
        txtnis.setForeground(new java.awt.Color(255, 255, 255));
        txtnis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtnis.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnisKeyTyped(evt);
            }
        });
        jPanel2.add(txtnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 150, 20));

        txtnama.setBackground(new java.awt.Color(0, 0, 0));
        txtnama.setForeground(new java.awt.Color(255, 255, 255));
        txtnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtnama.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamaKeyTyped(evt);
            }
        });
        jPanel2.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 150, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 850, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        Date date;
        date = jdtgllahir.getDate();
        if (txtnama.getText().equals("") || txtnis.getText().equals("")
                || cbkelamin.getSelectedItem().equals("--Pilih Jenis Kelamin--") || txttmptlahir.getText().equals("")
                || txtalamat.getText().equals("") || txttelpon.getText().equals("")
                || txtagama.getText().equals("") || cbta.getSelectedItem().equals("--Pilih Tahun--")
                || cbkodekelas.getSelectedItem().equals("--Pilih Kode Kelas--") || cbkelas.getSelectedItem().equals("--Pilih Kelas--") || date == null) {
            JOptionPane.showMessageDialog(null, "Silahkan Isi Bagian Yang masih Kosong/Kurang Lengkap");
        } else {
            try {
                Connection conn = new DBConnection().connect();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String sql = "insert into siswa(nis,nama,JenisKelamin,tgllahir,tempatlahir,alamat,telpon,agama,tahunajaran,kodekelas,kelas)  values('" + txtnis.getText() + "','" + txtnama.getText() + "','" + cbkelamin.getSelectedItem() + "','" + sdf.format(jdtgllahir.getDate()) + "','" + txttmptlahir.getText() + "','" + txtalamat.getText() + "','" + txttelpon.getText() + "','" + txtagama.getText() + "','" + cbta.getSelectedItem() + "','" + cbkodekelas.getSelectedItem() + "','" + cbkelas.getSelectedItem() + "')";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Sukses Menyimpan Data");
                fill_table();
                settingtabel(tblsiswa);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbaruActionPerformed
        Date date;
        date = jdtgllahir.getDate();
        if (btnbaru.getText().equals("Batal")) {
            btntambah.setEnabled(true);
            btnbaru.setText("Baru");
        } else if (btnbaru.getText().equals("Baru")) {
            baru();
            fill_table();
            settingtabel(tblsiswa);
            txtnis.requestFocus();
        }
    }//GEN-LAST:event_btnbaruActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            Connection conn = new DBConnection().connect();
            String sql = "Delete from siswa where NIS='" + txtnis.getText() + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses Menghapus Data");
            fill_table();
            settingtabel(tblsiswa);
            btntambah.setEnabled(true);
            btnbaru.setText("Baru");
            baru();
        } catch (SQLException ex) {
            Logger.getLogger(siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tblsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsiswaMouseClicked
        try {
            int baris = tblsiswa.getSelectedRow();
            txtnis.setText(tblsiswa.getValueAt(baris, 0).toString());
            txtnama.setText(tblsiswa.getValueAt(baris, 1).toString());
            cbkelamin.setSelectedItem(tblsiswa.getValueAt(baris, 2).toString());
            Date tanggal = new SimpleDateFormat("dd MMMM yyyy").parse((String) tblsiswa.getValueAt(baris, 3));
            jdtgllahir.setDate(tanggal);
            txttmptlahir.setText(tblsiswa.getValueAt(baris, 4).toString());
            txtalamat.setText(tblsiswa.getValueAt(baris, 5).toString());
            txttelpon.setText(tblsiswa.getValueAt(baris, 6).toString());
            txtagama.setText(tblsiswa.getValueAt(baris, 7).toString());
            cbta.setSelectedItem(tblsiswa.getValueAt(baris, 8).toString());
            cbkodekelas.setSelectedItem(tblsiswa.getValueAt(baris, 9).toString());
            cbkelas.setSelectedItem(tblsiswa.getValueAt(baris, 10).toString());
            btntambah.setEnabled(false);
            btnbaru.setText("Batal");
        } catch (ParseException ex) {
            Logger.getLogger(siswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblsiswaMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            int baris = tblsiswa.getSelectedRow();
            String nislama = tblsiswa.getValueAt(baris, 0).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Connection conn = new DBConnection().connect();
            String sql = "update siswa set nis='" + txtnis.getText() + "',nama='" + txtnama.getText() + "',jeniskelamin='" + cbkelamin.getSelectedItem() + "',tgllahir='" + sdf.format(jdtgllahir.getDate()) + "',tempatlahir='" + txttmptlahir.getText() + "',Alamat='" + txtalamat.getText() + "',telpon='" + txttelpon.getText() + "',agama='" + txtagama.getText() + "',tahunajaran='" + cbta.getSelectedItem() + "',kodekelas='" + cbkodekelas.getSelectedItem() + "',kelas='" + cbkelas.getSelectedItem() + "'where nis='" + nislama + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Memperbaharui Data");
            fill_table();
            settingtabel(tblsiswa);
            baru();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void txttelponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelponKeyTyped
        char masuk = evt.getKeyChar();
        if (!(Character.isDigit(masuk))) {
            evt.consume();
        }
    }//GEN-LAST:event_txttelponKeyTyped

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        if (txtnis.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan isi nama yang akan di cari");
        } else {
            try {
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("NIS");
                model.addColumn("NAMA");
                model.addColumn("JENIS KELAMIN");
                model.addColumn("TANGGAL LAHIR");
                model.addColumn("TEMPAT LAHIR");
                model.addColumn("ALAMAT");
                model.addColumn("TELEPON");
                model.addColumn("AGAMA");
                model.addColumn("TAHUN AJARAN");
                model.addColumn("KODE KELAS");
                model.addColumn("KELAS");
                Connection conn = new DBConnection().connect();
                String sql = "Select * from siswa where nis like '%" + txtnis.getText() + "%'";
                Statement stm = conn.createStatement();
                ResultSet rscari = stm.executeQuery(sql);
                while (rscari.next()) {
                    DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                    model.addRow(new Object[]{
                        rscari.getString(1),
                        rscari.getString(2),
                        rscari.getString(3),
                        df.format(rscari.getDate(4)),
                        rscari.getString(5),
                        rscari.getString(6),
                        rscari.getString(7),
                        rscari.getString(8),
                        rscari.getString(9),
                        rscari.getString(10),
                        rscari.getString(11)});
                }
                tblsiswa.setModel(model);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println(e);
            }
            settingtabel(tblsiswa);
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void btnubahtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahtaActionPerformed
        if (cbta.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih tahun ajaran untuk mengganti tahun");
        } else {
            int pilihan = JOptionPane.showConfirmDialog(this, "Apakah anda ingin mengganti tahun ajaran menjadi seperti yang anda pilih? " + String.valueOf(cbta.getSelectedItem()));
            switch (pilihan) {
                case JOptionPane.YES_OPTION:
                    try {
                        Connection conn = new DBConnection().connect();
                        String sql = "Update siswa set tahunajaran = '" + String.valueOf(cbta.getSelectedItem()) + "'";
                        PreparedStatement pst = conn.prepareCall(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Sukses Memprbaharui Tahun ajaran");
                        fill_table();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.getRootFrame().dispose();
                    break;
            }
        }
    }//GEN-LAST:event_btnubahtaActionPerformed

    private void lblminimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizeMouseClicked
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_lblminimizeMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void txtnisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnisKeyTyped
        char masuk = evt.getKeyChar();
        if (!(Character.isDigit(masuk))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnisKeyTyped

    private void txtnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyTyped
        char masuk = evt.getKeyChar();
        if ((Character.isDigit(masuk))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnamaKeyTyped

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
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbaru;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubahta;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbkelamin;
    private javax.swing.JComboBox<String> cbkelas;
    private javax.swing.JComboBox<String> cbkodekelas;
    private javax.swing.JComboBox<String> cbta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdtgllahir;
    private javax.swing.JLabel lblminimize;
    private javax.swing.JTable tblsiswa;
    private javax.swing.JTextField txtagama;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    private javax.swing.JTextField txttelpon;
    private javax.swing.JTextField txttmptlahir;
    // End of variables declaration//GEN-END:variables
}
