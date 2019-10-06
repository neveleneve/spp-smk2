/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
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
 * @author NEVE
 */
public class function_laporan {

    public static String SQL;
    public static ResultSet rs;
    public static Statement stm;
    public static Connection conn;

    public static void kodekelas(JComboBox cb) {
        try {
            conn = new DBConnection().connect();
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
            conn = new DBConnection().connect();
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
            parameters.put("paraKelas", kls);
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
}
