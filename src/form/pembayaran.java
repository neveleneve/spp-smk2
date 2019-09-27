package form;

import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date; 
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class pembayaran extends javax.swing.JFrame{   
    int totalbayar=0;
    Random rand=new Random();
    int no=rand.nextInt(10000);
    public pembayaran() {
        initComponents();
        lbltotal.setText(String.valueOf(totalbayar));
        baru();
        settingtabel(tblbayar);
        tahunajaran();
        this.setLocationRelativeTo(null);
        settable();       
    }
    
    public void settable(){
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("No pembayaran");
        model.addColumn("Tgl Bayar");
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Kode kelas");
        model.addColumn("Kelas");
        model.addColumn("Bulan pembayaran");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Tahun Bayar");
        model.addColumn("Tahun Ajaran");
        model.addColumn("Total Bayar");
        tblbayar.setModel(model);        
    }  
    
    public void tahunajaran(){
        try{
            Connection conn = new DBConnection().connect();
            String sql = "select * from tahunajaran";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);        
            while(rs.next()){
                String tahunajaran = rs.getString("tahun");
                cbta.addItem(tahunajaran);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    public void settingtabel(JTable tabel){
        tblbayar.setDefaultEditor(Object.class, null);
        tblbayar.getTableHeader().setReorderingAllowed(false);
        tblbayar.getTableHeader().setResizingAllowed(false);
        tblbayar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTableHeader header=tblbayar.getTableHeader();
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }    
    
    public void baru(){
        lblnopembayaran.setText("...");
        jdtglbayar.setCalendar(null);
        jdtglbayar.setEnabled(false);
        lblnis.setText("...");
        lblnama.setText("...");
        lblkelamin.setText("...");
        lblkodekelas.setText("...");
        lbkelas.setText("...");
        lbltotal.setText(0+"");
        btnbaru.setEnabled(false);
        btnbayar.setEnabled(false);        
        
        DefaultTableModel model = (DefaultTableModel)this.tblbayar.getModel();
        model.setRowCount(0);
        JCheckBox[] cb = new JCheckBox[]{
            cboxjanuari,cboxfebruari,cboxmaret,cboxapril,cboxmei,cboxjuni,cboxjuli,cboxagustus,cboxseptember,cboxoktober,cboxnovember,cboxdesember
        };
        for(JCheckBox cbox:cb){
            cbox.setEnabled(false);
            cbox.setSelected(false);           
        }
    }
    
    public void insertbayar(String nopembayaran,String tglbayar,String nis,String nama,String jk,String kodekls,String kelas,String bulan,double jmlbyr,String tahunbayar,String ta,double total){
        try{
            Connection conn = new DBConnection().connect();
            String sql = "insert into bayar values('"+nopembayaran+"','"+tglbayar+"','"+nis+"','"+nama+"','"+jk+"','"+kodekls+"','"+kelas+"','"+bulan+"','"+jmlbyr+"','"+tahunbayar+"','"+ta+"','"+total+"')";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void checkbox(JCheckBox cb){
        if(cb.isSelected() && cb.isEnabled()){
            totalbayar += 100000;
            lbltotal.setText(totalbayar+"");
        }else{
            totalbayar -= 100000;
            lbltotal.setText(totalbayar+"");
        }
    }
    
    public void caribayar(String nis,String tahun){        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No pembayaran");
        model.addColumn("Tgl Bayar");
        model.addColumn("Nis");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Kode kelas");
        model.addColumn("Kelas");
        model.addColumn("Bulan pembayaran");
        model.addColumn("Jumlah Bayar");
        model.addColumn("Tahun Bayar");
        model.addColumn("Tahun Ajaran");
        model.addColumn("Total Bayar");        
        JCheckBox [] cb = new JCheckBox[]{
            cboxjanuari,cboxfebruari,cboxmaret,cboxapril,cboxmei,cboxjuni,cboxjuli,cboxagustus,cboxseptember,cboxoktober,cboxnovember,cboxdesember
        };        
        lbltotal.setText(0+"");
        totalbayar = 0;
        Date tgl = new Date();
        jdtglbayar.setDate(tgl);        
        try{
            Connection conn = new DBConnection().connect();
            String sqlsiswa = "select * from siswa where nis='"+nis+"'";
            Statement st = conn.createStatement();
            ResultSet rsiswa = st.executeQuery(sqlsiswa);
            if(rsiswa.next()){
                lblnopembayaran.setEnabled(true);
                lblnis.setText(rsiswa.getString("Nis"));
                lblnama.setText(rsiswa.getString("Nama"));
                lblkelamin.setText(rsiswa.getString("JenisKelamin"));
                lblkodekelas.setText(rsiswa.getString("Kodekelas"));
                lbkelas.setText(rsiswa.getString("kelas"));
                btnbaru.setEnabled(true);
                btnbayar.setEnabled(true);            
                for(JCheckBox cbox:cb){
                    cbox.setEnabled(true);  
                    cbox.setSelected(false);
                }
                Connection connection = new DBConnection().connect();
                String sqlbayar = "select * from bayar where nis='" + txtcari.getText() + "'And tahunajaran='" + tahun + "'";
                Statement stm = connection.createStatement();
                ResultSet rsbayar = stm.executeQuery(sqlbayar);
                if(rsbayar == null){
                    JOptionPane.showMessageDialog(null,"Tidak ada rekor pembayaran");
                }else{
                    while(rsbayar.next()){
                        tblbayar.getTableHeader().setForeground(Color.white);
                        tblbayar.getTableHeader().setBackground(new Color(34,49,63));
                        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                        model.addRow(new Object[]{rsbayar.getString(1),df.format(rsbayar.getDate(2)),rsbayar.getString(3),rsbayar.getString(4),
                        rsbayar.getString(5),rsbayar.getString(6),rsbayar.getString(7),rsbayar.getString(8),
                        "Rp."+NumberFormat.getInstance().format(rsbayar.getDouble(9)),
                        rsbayar.getString(10),rsbayar.getString(11),"Rp."+NumberFormat.getInstance().format(rsbayar.getDouble(12))});                  
                        for(JCheckBox cbox:cb){
                            if(cbox.getText().equals(rsbayar.getString("BulanPembayaran"))){
                                cbox.setSelected(true);
                                cbox.setEnabled(false);
                            }
                        }
                        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                        tblbayar.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                        tblbayar.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
                        tblbayar.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
                        tblbayar.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Nis Tidak Ditemukan");
            }
            tblbayar.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgspp = new javax.swing.ButtonGroup();
        lblkelas = new javax.swing.JPanel();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jdtglbayar = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboxjanuari = new javax.swing.JCheckBox();
        cboxfebruari = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        cboxmaret = new javax.swing.JCheckBox();
        cboxapril = new javax.swing.JCheckBox();
        cboxmei = new javax.swing.JCheckBox();
        cboxjuni = new javax.swing.JCheckBox();
        cboxjuli = new javax.swing.JCheckBox();
        cboxagustus = new javax.swing.JCheckBox();
        cboxseptember = new javax.swing.JCheckBox();
        cboxoktober = new javax.swing.JCheckBox();
        cboxnovember = new javax.swing.JCheckBox();
        cboxdesember = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnbaru = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbayar = new javax.swing.JTable();
        btnkembali = new javax.swing.JButton();
        lblnis = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        lblkelamin = new javax.swing.JLabel();
        lblkodekelas = new javax.swing.JLabel();
        lbkelas = new javax.swing.JLabel();
        lblnopembayaran = new javax.swing.JLabel();
        btnhapus = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbta = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblminimize = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblkelas.setBackground(new java.awt.Color(0, 0, 0));
        lblkelas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcari.setBackground(new java.awt.Color(0, 0, 0));
        txtcari.setForeground(new java.awt.Color(255, 255, 255));
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtcari.setCaretColor(new java.awt.Color(255, 255, 255));
        lblkelas.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 129, 20));

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        lblkelas.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 80, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("No.Pembayaran :");
        lblkelas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 20));
        lblkelas.add(jdtglbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 180, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tanggal Bayar :");
        lblkelas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NIS :");
        lblkelas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nama :");
        lblkelas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Jenis Kelamin :");
        lblkelas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Kode Kelas :");
        lblkelas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 20));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SPP Bulan:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboxjanuari.setBackground(new java.awt.Color(0, 0, 0));
        cboxjanuari.setForeground(new java.awt.Color(255, 255, 255));
        cboxjanuari.setText("Januari");
        cboxjanuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxjanuariActionPerformed(evt);
            }
        });
        jPanel2.add(cboxjanuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 30));

        cboxfebruari.setBackground(new java.awt.Color(0, 0, 0));
        cboxfebruari.setForeground(new java.awt.Color(255, 255, 255));
        cboxfebruari.setText("Februari");
        cboxfebruari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxfebruariActionPerformed(evt);
            }
        });
        jPanel2.add(cboxfebruari, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 30));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total Bayar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("...");
        lbltotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(lbltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 90, 20));

        cboxmaret.setBackground(new java.awt.Color(0, 0, 0));
        cboxmaret.setForeground(new java.awt.Color(255, 255, 255));
        cboxmaret.setText("Maret");
        cboxmaret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxmaretActionPerformed(evt);
            }
        });
        jPanel2.add(cboxmaret, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 30));

        cboxapril.setBackground(new java.awt.Color(0, 0, 0));
        cboxapril.setForeground(new java.awt.Color(255, 255, 255));
        cboxapril.setText("April");
        cboxapril.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxaprilActionPerformed(evt);
            }
        });
        jPanel2.add(cboxapril, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, -1, 30));

        cboxmei.setBackground(new java.awt.Color(0, 0, 0));
        cboxmei.setForeground(new java.awt.Color(255, 255, 255));
        cboxmei.setText("Mei");
        cboxmei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxmeiActionPerformed(evt);
            }
        });
        jPanel2.add(cboxmei, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, 30));

        cboxjuni.setBackground(new java.awt.Color(0, 0, 0));
        cboxjuni.setForeground(new java.awt.Color(255, 255, 255));
        cboxjuni.setText("Juni");
        cboxjuni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxjuniActionPerformed(evt);
            }
        });
        jPanel2.add(cboxjuni, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 60, 30));

        cboxjuli.setBackground(new java.awt.Color(0, 0, 0));
        cboxjuli.setForeground(new java.awt.Color(255, 255, 255));
        cboxjuli.setText("Juli");
        cboxjuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxjuliActionPerformed(evt);
            }
        });
        jPanel2.add(cboxjuli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 30));

        cboxagustus.setBackground(new java.awt.Color(0, 0, 0));
        cboxagustus.setForeground(new java.awt.Color(255, 255, 255));
        cboxagustus.setText("Agustus");
        cboxagustus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxagustusActionPerformed(evt);
            }
        });
        jPanel2.add(cboxagustus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 30));

        cboxseptember.setBackground(new java.awt.Color(0, 0, 0));
        cboxseptember.setForeground(new java.awt.Color(255, 255, 255));
        cboxseptember.setText("September");
        cboxseptember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxseptemberActionPerformed(evt);
            }
        });
        jPanel2.add(cboxseptember, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 30));

        cboxoktober.setBackground(new java.awt.Color(0, 0, 0));
        cboxoktober.setForeground(new java.awt.Color(255, 255, 255));
        cboxoktober.setText("Oktober");
        cboxoktober.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxoktoberActionPerformed(evt);
            }
        });
        jPanel2.add(cboxoktober, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        cboxnovember.setBackground(new java.awt.Color(0, 0, 0));
        cboxnovember.setForeground(new java.awt.Color(255, 255, 255));
        cboxnovember.setText("November");
        cboxnovember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxnovemberActionPerformed(evt);
            }
        });
        jPanel2.add(cboxnovember, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 80, 30));

        cboxdesember.setBackground(new java.awt.Color(0, 0, 0));
        cboxdesember.setForeground(new java.awt.Color(255, 255, 255));
        cboxdesember.setText("Desember");
        cboxdesember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxdesemberActionPerformed(evt);
            }
        });
        jPanel2.add(cboxdesember, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 30));

        jButton5.setText("Struk");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        lblkelas.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 280, 190));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Kelas :");
        lblkelas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 20));

        btnbaru.setText("Baru");
        btnbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbaruActionPerformed(evt);
            }
        });
        lblkelas.add(btnbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        lblkelas.add(btnbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, -1));

        tblbayar.setBackground(new java.awt.Color(0, 0, 0));
        tblbayar.setForeground(new java.awt.Color(255, 255, 255));
        tblbayar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbayarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbayar);

        lblkelas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 650, 244));

        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        lblkelas.add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        lblnis.setForeground(new java.awt.Color(255, 255, 255));
        lblnis.setText("...");
        lblnis.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lblnis, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 180, 20));

        lblnama.setForeground(new java.awt.Color(255, 255, 255));
        lblnama.setText("...");
        lblnama.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lblnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 180, 20));

        lblkelamin.setForeground(new java.awt.Color(255, 255, 255));
        lblkelamin.setText("...");
        lblkelamin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lblkelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 180, 20));

        lblkodekelas.setForeground(new java.awt.Color(255, 255, 255));
        lblkodekelas.setText("...");
        lblkodekelas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lblkodekelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 180, 20));

        lbkelas.setForeground(new java.awt.Color(255, 255, 255));
        lbkelas.setText("...");
        lbkelas.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lbkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 20));

        lblnopembayaran.setForeground(new java.awt.Color(255, 255, 255));
        lblnopembayaran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblkelas.add(lblnopembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, 20));

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        lblkelas.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Tahun Ajaran :");
        lblkelas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, 20));

        cbta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtaItemStateChanged(evt);
            }
        });
        lblkelas.add(cbta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 180, 20));

        jPanel1.setBackground(new java.awt.Color(34, 49, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 30, 30));

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
        jPanel1.add(lblminimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 30, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PEMBAYARAN UANG SEKOLAH");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 690, 30));

        lblkelas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 80));

        getContentPane().add(lblkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        caribayar(txtcari.getText(), String.valueOf(cbta.getSelectedItem()));
        lblnopembayaran.setText("PM-"+String.valueOf(no));       
    }//GEN-LAST:event_btncariActionPerformed
    private void cboxjanuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxjanuariActionPerformed
       checkbox(cboxjanuari);
    }//GEN-LAST:event_cboxjanuariActionPerformed
    private void cboxfebruariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxfebruariActionPerformed
        checkbox(cboxfebruari);
    }//GEN-LAST:event_cboxfebruariActionPerformed
    private void cboxmaretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxmaretActionPerformed
        checkbox(cboxmaret);
    }//GEN-LAST:event_cboxmaretActionPerformed
    private void cboxaprilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxaprilActionPerformed
        checkbox(cboxapril);
    }//GEN-LAST:event_cboxaprilActionPerformed
    private void cboxmeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxmeiActionPerformed
        checkbox(cboxmei);         
    }//GEN-LAST:event_cboxmeiActionPerformed
    private void cboxjuniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxjuniActionPerformed
        checkbox(cboxjuni);
    }//GEN-LAST:event_cboxjuniActionPerformed
    private void cboxjuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxjuliActionPerformed
        checkbox(cboxjuli);
    }//GEN-LAST:event_cboxjuliActionPerformed
    private void cboxagustusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxagustusActionPerformed
        checkbox(cboxagustus);
    }//GEN-LAST:event_cboxagustusActionPerformed
    private void cboxseptemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxseptemberActionPerformed
        checkbox(cboxseptember);
    }//GEN-LAST:event_cboxseptemberActionPerformed
    private void cboxoktoberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxoktoberActionPerformed
        checkbox(cboxoktober);
    }//GEN-LAST:event_cboxoktoberActionPerformed
    private void cboxnovemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxnovemberActionPerformed
        checkbox(cboxnovember);
    }//GEN-LAST:event_cboxnovemberActionPerformed
    private void cboxdesemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxdesemberActionPerformed
        checkbox(cboxdesember);
    }//GEN-LAST:event_cboxdesemberActionPerformed
    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
            JCheckBox[] cb = new JCheckBox[]{
                cboxjanuari,cboxfebruari,cboxmaret,cboxapril,cboxmei,cboxjuni,cboxjuli,cboxagustus,cboxseptember,cboxoktober,cboxnovember,cboxdesember
            };
            for(JCheckBox cbox:cb){
                int tahun = Calendar.getInstance().get(Calendar.YEAR);
                String tahunconv = String.valueOf(tahun);
                if(cbox.isSelected() && cbox.isEnabled()){
                    insertbayar(lblnopembayaran.getText(),sdf.format(jdtglbayar.getDate()),lblnis.getText(),lblnama.getText(),lblkelamin.getText(),lblkodekelas.getText(),lbkelas.getText(),cbox.getText(),100000,tahunconv,String.valueOf(cbta.getSelectedItem()),100000);  
                    cbox.setEnabled(false);
                }
            }
            JOptionPane.showMessageDialog(null, "Sukses Membayar");
            lbltotal.setText(0+"");
            caribayar(txtcari.getText(),String.valueOf(cbta.getSelectedItem()));
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(null, e);
        }       
    }//GEN-LAST:event_btnbayarActionPerformed
    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btnkembaliActionPerformed
    private void btnbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbaruActionPerformed
        baru();
    }//GEN-LAST:event_btnbaruActionPerformed
    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        
    }//GEN-LAST:event_btnhapusActionPerformed
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked
    private void lblminimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizeMouseClicked
        this.setState(pembayaran.ICONIFIED);
    }//GEN-LAST:event_lblminimizeMouseClicked
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        java.sql.Connection conn = new DBConnection().connect();
            try{                
                File file = new File("src/laporan/struk1.jrxml");
                JasperDesign jasperdesign = JRXmlLoader.load(file);
                String sql = "select * from bayar where Nopembayaran = '" + lblnopembayaran.getText() + "' and nis = '" + txtcari.getText() + "'";
                JRDesignQuery newquery = new JRDesignQuery();
                newquery.setText(sql);
                jasperdesign.setQuery(newquery);
                JasperReport jasperreport = JasperCompileManager.compileReport(jasperdesign);
                JasperPrint jp = JasperFillManager.fillReport(jasperreport, null, conn);
                JasperViewer.viewReport(jp,false);
            }catch(JRException e){
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton5ActionPerformed
    private void cbtaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtaItemStateChanged
        if("".equals(txtcari.getText())){
            
        }else{
            caribayar(txtcari.getText(),String.valueOf(cbta.getSelectedItem()));
        }
    }//GEN-LAST:event_cbtaItemStateChanged
    private void tblbayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbayarMouseClicked
        int baris = tblbayar.getSelectedRow();
        
    }//GEN-LAST:event_tblbayarMouseClicked
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
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgspp;
    private javax.swing.JButton btnbaru;
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JCheckBox cboxagustus;
    private javax.swing.JCheckBox cboxapril;
    private javax.swing.JCheckBox cboxdesember;
    private javax.swing.JCheckBox cboxfebruari;
    private javax.swing.JCheckBox cboxjanuari;
    private javax.swing.JCheckBox cboxjuli;
    private javax.swing.JCheckBox cboxjuni;
    private javax.swing.JCheckBox cboxmaret;
    private javax.swing.JCheckBox cboxmei;
    private javax.swing.JCheckBox cboxnovember;
    private javax.swing.JCheckBox cboxoktober;
    private javax.swing.JCheckBox cboxseptember;
    private javax.swing.JComboBox<String> cbta;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private com.toedter.calendar.JDateChooser jdtglbayar;
    private javax.swing.JLabel lbkelas;
    private javax.swing.JLabel lblkelamin;
    private javax.swing.JPanel lblkelas;
    private javax.swing.JLabel lblkodekelas;
    private javax.swing.JLabel lblminimize;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblnis;
    private javax.swing.JLabel lblnopembayaran;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tblbayar;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
