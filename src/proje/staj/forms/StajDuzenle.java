/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje.staj.forms;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
import proje.java.sql.MysqlConn;
import proje.staj.db.Birim;
import proje.staj.db.Staj;
import proje.staj.managers.BirimManager;
import proje.staj.managers.StajManager;
import proje.staj.utils.StajTableModel;

/**
 *
 * @author Zeynepnida
 */
public class StajDuzenle extends javax.swing.JPanel {

    /**
     * Creates new form StajDuzenle
     */
    private Staj selectedStaj;

    public StajDuzenle() {
        try {
            initComponents();
            StajTableModel dtm = new StajTableModel(new StajManager().getAllOgrenci());
            dtm.setColumnIdentifiers(new Object[]{"TC", "İSİM", "SOYİSİM", "ÜNİVERSİTE", "BÖLÜM", "BAŞLAMA TARİHİ", "BİTİŞ TARİHİ", "STAJ GÜNÜ", "PROJE", "BİRİM"});
            table.setModel(dtm);
            
            ArrayList<Birim> birimList=new BirimManager().getAllBirim();
            for(Birim birim:birimList){
                ((DefaultComboBoxModel)this.cmbBirim.getModel()).addElement(birim);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StajDuzenle.class.getName()).log(Level.SEVERE, null, ex);
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

        txt_baslama = new javax.swing.JLabel();
        txt_bitis = new javax.swing.JLabel();
        txt_gun = new javax.swing.JLabel();
        txtGun = new javax.swing.JTextField();
        dtBaslangicTarihi = new org.jdesktop.swingx.JXDatePicker();
        dtBitisTarihi = new org.jdesktop.swingx.JXDatePicker();
        txtAd = new javax.swing.JTextField();
        txtTc = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        txt_tc = new javax.swing.JLabel();
        txt_ad = new javax.swing.JLabel();
        txt_soyad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        duzenle = new javax.swing.JButton();
        txt_birim = new javax.swing.JLabel();
        cmbBirim = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_baslama.setText("STAJ BAŞLANGIÇ TARİHİ");
        add(txt_baslama, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 167, 30));

        txt_bitis.setText("STAJ BİTİŞ TARİHİ");
        add(txt_bitis, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 130, 22));

        txt_gun.setText("STAJ GÜNÜ");
        add(txt_gun, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 140, 30));
        add(txtGun, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 320, 30));
        add(dtBaslangicTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 320, -1));
        add(dtBitisTarihi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 320, -1));
        add(txtAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 320, -1));
        add(txtTc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 320, -1));
        add(txtSoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 320, -1));

        txt_tc.setText("TC");
        add(txt_tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 167, -1));

        txt_ad.setText("AD");
        add(txt_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 150, 20));

        txt_soyad.setText("SOYAD");
        add(txt_soyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 167, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 1150, 353));

        duzenle.setText("DÜZENLE");
        duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzenleActionPerformed(evt);
            }
        });
        add(duzenle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 140, 60));

        txt_birim.setText("Birim Adı");
        add(txt_birim, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 100, 30));
        add(cmbBirim, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 320, 30));

        jButton1.setText("PDF YAZDIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 455, -1, 70));
    }// </editor-fold>//GEN-END:initComponents

    private void duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzenleActionPerformed

        String TC = txtTc.getText();
        String ad = txtAd.getText();
        String soyad = txtSoyad.getText();
        Date baslamaTarihi = dtBaslangicTarihi.getDate();
        Date bitisTarihi = dtBitisTarihi.getDate();
        String gun = txtGun.getText();
        Birim birim = (Birim) cmbBirim.getSelectedItem();
        try {

            this.selectedStaj.setBaslama_tarihi(baslamaTarihi);
            this.selectedStaj.setBitis_tarihi(bitisTarihi);
            this.selectedStaj.setStaj_gun(Integer.parseInt(gun));
            this.selectedStaj.setBirim(birim);

            StajManager stajMan = new StajManager();
            stajMan.duzenleStaj(this.selectedStaj);
            ((StajTableModel) this.table.getModel()).fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(OgrenciDuzenle.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_duzenleActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed

        this.selectedStaj = ((StajTableModel) this.table.getModel()).getStaj(table.getSelectedRow());

        txtTc.setText(selectedStaj.getOgrenci().getTc().toString());
        txtAd.setText(selectedStaj.getOgrenci().getAd());
        txtSoyad.setText(selectedStaj.getOgrenci().getSoyad());
        cmbBirim.setSelectedItem(selectedStaj.getBirim());
        dtBaslangicTarihi.setDate(selectedStaj.getBaslama_tarihi());
        dtBitisTarihi.setDate(selectedStaj.getBitis_tarihi());
        txtGun.setText(selectedStaj.getStaj_gun() + "");
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
/*

        try {
            String pdfFileName = "D:/C3_report.pdf";
            String jrxmlFileName = getClass().getResource("/report/staj.jrxml").getFile();
            JasperReport jr=JasperCompileManager.compileReport(jrxmlFileName);
          HashMap   parameters = new HashMap();
          String whereCase="";
          if(this.selectedStaj!=null)
              whereCase+=" and s.TC_no="+this.selectedStaj.getOgrenci().getTc();
           
          
          parameters.put("whereCase", whereCase);
           JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jr, parameters, MysqlConn.getConnection().getConn());
            JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
            
                File myFile = new File( pdfFileName); // ekranda gosterme
                Desktop.getDesktop().open(myFile);
            
// TODO add your handling code here:
        } catch (JRException ex) {
            Logger.getLogger(OgrenciDuzenle.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBirim;
    private org.jdesktop.swingx.JXDatePicker dtBaslangicTarihi;
    private org.jdesktop.swingx.JXDatePicker dtBitisTarihi;
    private javax.swing.JButton duzenle;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtGun;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTc;
    private javax.swing.JLabel txt_ad;
    private javax.swing.JLabel txt_baslama;
    private javax.swing.JLabel txt_birim;
    private javax.swing.JLabel txt_bitis;
    private javax.swing.JLabel txt_gun;
    private javax.swing.JLabel txt_soyad;
    private javax.swing.JLabel txt_tc;
    // End of variables declaration//GEN-END:variables
}
