/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
 * @author NEVE
 */
public class FunctionClass {

    public static String SQL;
    public static ResultSet rs;
    public static Connection conn = new DBConnection().connect();
    public static Statement stm;
//======================Untuk Form Laporan======================//

    public static void kodekelas(JComboBox cb) {
        try {
            SQL = "select * from kelas";
            stm = conn.createStatement();
            rs = stm.executeQuery(SQL);
            while (rs.next()) {
                String kode = rs.getString("kodekelas");
                cb.addItem(kode);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }

    public static void TahunAjaran(JComboBox cb) {
        try {
            SQL = "select * from tahunajaran";
            stm = conn.createStatement();
            rs = stm.executeQuery(SQL);
            while (rs.next()) {
                String kode = rs.getString("tahun");
                cb.addItem(kode);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }

    public static void sumDataBulanan() {

    }

    public static void laporanPembayaranBulanan(JComboBox bln, JComboBox taun, String ta, String bulan) {
        try {
            File file = new File("src/laporan/pembayaran.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select * from bayar where bulanpembayaran = '" + bln.getSelectedItem().toString() + "' and tahunajaran = '" + taun.getSelectedItem().toString() + "'";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("JudulLaporan", "Laporan Pembayaran Bulanan");
            parameters.put("txtBulan", "Bulan               :");
            parameters.put("paraBulan", bulan);
            parameters.put("txtTahun", "Tahun Ajaran   :");
            parameters.put("paraTahun", ta);
            parameters.put("txtKelas", "");
            parameters.put("paraKelas", "");
            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void laporanTunggakanBulanan(JComboBox bln, JComboBox taun, String ta, String bulan) {
        try {
            File file = new File("src/laporan/siswa.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select nis, nama, jeniskelamin, tgllahir, tempatlahir, alamat, Telpon, Agama, Kelas, kodekelas from siswa where nis not in (select nis from bayar where bulanpembayaran = '" + bln.getSelectedItem().toString() + "' and tahunajaran = '" + taun.getSelectedItem().toString() + "')";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("JudulLaporan", "Laporan Tunggakan Bulanan");
            parameters.put("txtBulan", "Bulan               :");
            parameters.put("paraBulan", bulan);
            parameters.put("txtTahun", "Tahun Ajaran   :");
            parameters.put("paraTahun", ta);
            parameters.put("txtKelas", "");
            parameters.put("paraKelas", "");
            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void LaporanPembayaranBulananPerKelas(JComboBox bln, JComboBox taun, JComboBox kls, String ta, String bulan) {
        try {
            File file = new File("src/laporan/pembayaran.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            String sql = "select * from bayar where kodekelas = '" + kls.getSelectedItem().toString() + "' and bulanpembayaran = '" + bln.getSelectedItem().toString() + "' and tahunajaran = '" + taun.getSelectedItem().toString() + "'";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("JudulLaporan", "Laporan Pembayaran Bulanan Kelas");
            parameters.put("txtBulan", "Bulan   :");
            parameters.put("paraBulan", bulan);
            parameters.put("txtTahun", "Tahun Ajaran    :");
            parameters.put("paraTahun", ta);
            parameters.put("txtKelas", "Kode Kelas  :");
            parameters.put("paraKelas", kls.getSelectedItem().toString());
            jrq.setText(sql);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void laporanTunggakanBulananPerKelas(JComboBox bln, JComboBox taun, JComboBox kls, String ta, String bulan) {
        try {
            File file = new File("src/laporan/siswa.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select nis, nama, jeniskelamin, tgllahir, tempatlahir, alamat, Telpon, Agama, Kelas, kodekelas from siswa where KodeKelas = '" + kls.getSelectedItem().toString() + "' and nis not in (select nis from bayar where bulanpembayaran = '" + bln.getSelectedItem().toString() + "' and tahunajaran = '" + taun.getSelectedItem().toString() + "')";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("JudulLaporan", "Laporan Tunggakan Bulanan");
            parameters.put("txtBulan", "Bulan               :");
            parameters.put("paraBulan", bulan);
            parameters.put("txtTahun", "Tahun Ajaran   :");
            parameters.put("paraTahun", ta);
            parameters.put("txtKelas", "Kode Kelas :");
            parameters.put("paraKelas", kls.getSelectedItem().toString());
            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    public static void StrukSiswa(JTextField nis) {
        try {
            File file = new File("src/laporan/pembayaran.jrxml");
            JasperDesign jdesign = JRXmlLoader.load(file);
            SQL = "select * from bayar where nis = '" + nis.getText() + "' order by Nopembayaran";
            JRDesignQuery jrq = new JRDesignQuery();
            Map<String, Object> parameters;
            parameters = new HashMap<>();
            parameters.put("JudulLaporan", "Laporan Pembayaran Siswa");
            parameters.put("txtBulan", "");
            parameters.put("paraBulan", "");
            parameters.put("txtTahun", "");
            parameters.put("paraTahun", "");
            parameters.put("txtKelas", "");
            parameters.put("paraKelas", "");
            jrq.setText(SQL);
            jdesign.setQuery(jrq);
            JasperReport jr = JasperCompileManager.compileReport(jdesign);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            if (jp.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            } else {
                JasperViewer.viewReport(jp, false);
            }
        } catch (JRException e) {
            System.out.println(e);
        }
    }

    //======================Untuk Form Pembayaran======================//
    public static void autoGenerateNoPembayaran(JLabel label) {
        try {
            SQL = "select max(right(Nopembayaran,4)) as nomor from bayar";
            stm = conn.createStatement();
            rs = stm.executeQuery(SQL);
            if (rs.next()) {
                int i = Integer.parseInt(rs.getString("nomor"));
                String no = String.valueOf(i + 1);
                int noLong = no.length();
                for (int a = 0; a < 4 - noLong; a++) {
                    no = "0" + no;
                }
                label.setText("PM-" + no);
                System.out.println(i);
            } else {
                //System.out.println(q.uniqueResult());
                label.setText("PM-0000");
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }

    }

    public static void deleteDataPembayaran(String no, String bln, String ta) {
        try {
            String sql = "Delete from bayar where nopembayaran = '" + no + "' and bulanpembayaran = '" + bln + "' and tahunajaran = '" + ta + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sukses menghapus Data Pembayaran");
            //isitabel();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
