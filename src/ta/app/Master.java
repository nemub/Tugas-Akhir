/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Master.java
 *
 * Created on Oct 5, 2013, 7:48:16 PM
 */
package ta.app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ta.app.frame.alat.InputFrame;
import ta.app.frame.sistem.MasukFrame;
import ta.app.frame.sistem.OtorisasiFrame;
import ta.app.frame.sistem.PenggunaFrame;
import ta.app.frame.sistem.VendorFrame;
import ta.util.orm.mapping.Akses;
import ta.util.orm.mapping.Pengguna;

/**
 *
 * @author Sahal
 */
public class Master extends javax.swing.JFrame {

    // Menu Sistem
    private final JInternalFrame[] frames = new JInternalFrame[5];
    // Menu Keys
    private static final int LOGIN = 0, ACCOUNT = 1, USER = 2, VENDOR = 3,
            ITEM = 4;

    /**
     * Creates new form Master
     */
    public Master() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masterPane = new javax.swing.JDesktopPane();
        Transaksi = new javax.swing.JMenuBar();
        sistemMenu = new javax.swing.JMenu();
        masukItem = new javax.swing.JMenuItem();
        keluarItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        vendorItem = new javax.swing.JMenuItem();
        penggunaItem = new javax.swing.JMenuItem();
        otorisasiItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        tutupItem = new javax.swing.JMenuItem();
        alatMenu = new javax.swing.JMenu();
        inputItem = new javax.swing.JMenuItem();
        lihatItem = new javax.swing.JMenuItem();
        kalibrasiMenu = new javax.swing.JMenu();
        kalibrasiItem = new javax.swing.JMenu();
        jBulanItem = new javax.swing.JMenuItem();
        jTahunItem = new javax.swing.JMenuItem();
        hasilItem = new javax.swing.JMenuItem();
        orderMenu = new javax.swing.JMenu();
        permohonanItem = new javax.swing.JMenuItem();
        prosesItem = new javax.swing.JMenuItem();
        setujuItem = new javax.swing.JMenuItem();
        daftarItem = new javax.swing.JMenuItem();
        laporanMenu = new javax.swing.JMenu();
        lapStokItem = new javax.swing.JMenuItem();
        lapKalibrasiItem = new javax.swing.JMenu();
        lapMingguItem = new javax.swing.JMenuItem();
        lapBulanItem = new javax.swing.JMenuItem();
        lapOrderItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Sistem Informasi Alat Ukur");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        sistemMenu.setText("Sistem");

        masukItem.setText("Masuk");
        masukItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukItemActionPerformed(evt);
            }
        });
        sistemMenu.add(masukItem);

        keluarItem.setText("Keluar");
        keluarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarItemActionPerformed(evt);
            }
        });
        sistemMenu.add(keluarItem);
        sistemMenu.add(jSeparator1);

        vendorItem.setText("Data Vendor");
        vendorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorItemActionPerformed(evt);
            }
        });
        sistemMenu.add(vendorItem);

        penggunaItem.setText("Data Pengguna");
        penggunaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penggunaItemActionPerformed(evt);
            }
        });
        sistemMenu.add(penggunaItem);

        otorisasiItem.setText("Otorisasi");
        otorisasiItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otorisasiItemActionPerformed(evt);
            }
        });
        sistemMenu.add(otorisasiItem);
        sistemMenu.add(jSeparator2);

        tutupItem.setText("Tutup");
        tutupItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutupItemActionPerformed(evt);
            }
        });
        sistemMenu.add(tutupItem);

        Transaksi.add(sistemMenu);

        alatMenu.setText("Alat");

        inputItem.setText("Input Data");
        inputItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputItemActionPerformed(evt);
            }
        });
        alatMenu.add(inputItem);

        lihatItem.setText("Lihat Data");
        alatMenu.add(lihatItem);

        Transaksi.add(alatMenu);

        kalibrasiMenu.setText("Kalibrasi");

        kalibrasiItem.setText("Jadwal Kalibrasi");

        jBulanItem.setText("Jadwal  Bulanan");
        kalibrasiItem.add(jBulanItem);

        jTahunItem.setText("Jadwal Tahunan");
        kalibrasiItem.add(jTahunItem);

        kalibrasiMenu.add(kalibrasiItem);

        hasilItem.setText("Hasil Kalibrasi");
        kalibrasiMenu.add(hasilItem);

        Transaksi.add(kalibrasiMenu);

        orderMenu.setText("Order");

        permohonanItem.setText("Permohonan");
        orderMenu.add(permohonanItem);

        prosesItem.setText("Proses");
        orderMenu.add(prosesItem);

        setujuItem.setText("Persetujuan");
        orderMenu.add(setujuItem);

        daftarItem.setText("Daftar Order");
        orderMenu.add(daftarItem);

        Transaksi.add(orderMenu);

        laporanMenu.setText("Laporan");

        lapStokItem.setText("Laporan Stok");
        laporanMenu.add(lapStokItem);

        lapKalibrasiItem.setText("Laporan Kalibrasi");

        lapMingguItem.setText("Laporan Mingguan");
        lapKalibrasiItem.add(lapMingguItem);

        lapBulanItem.setText("Laporan Bulanan");
        lapKalibrasiItem.add(lapBulanItem);

        laporanMenu.add(lapKalibrasiItem);

        lapOrderItem.setText("Laporan Order");
        laporanMenu.add(lapOrderItem);

        Transaksi.add(laporanMenu);

        setJMenuBar(Transaksi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masterPane, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void masukItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukItemActionPerformed
        MasukFrame masukFrame = (MasukFrame) frames[LOGIN];
        closeAllFrame();
        defaultView();
        masukFrame.defaultView();
    }//GEN-LAST:event_masukItemActionPerformed

    private void keluarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarItemActionPerformed
        masukItemActionPerformed(evt);
    }//GEN-LAST:event_keluarItemActionPerformed

    private void vendorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorItemActionPerformed
        VendorFrame vendorFrame = (VendorFrame) frames[VENDOR];
        closeAllFrame();
        frames[VENDOR].show();
        vendorFrame.fill();
    }//GEN-LAST:event_vendorItemActionPerformed

    private void penggunaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penggunaItemActionPerformed
        PenggunaFrame penggunaFrame = (PenggunaFrame) frames[ACCOUNT];
        closeAllFrame();
        frames[ACCOUNT].show();
        penggunaFrame.fill();
    }//GEN-LAST:event_penggunaItemActionPerformed

    private void otorisasiItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otorisasiItemActionPerformed
        OtorisasiFrame otorisasiFrame = (OtorisasiFrame) frames[USER];
        closeAllFrame();
        frames[USER].show();
        otorisasiFrame.fill();
    }//GEN-LAST:event_otorisasiItemActionPerformed

    private void tutupItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutupItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_tutupItemActionPerformed

    private void inputItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputItemActionPerformed
        InputFrame inputFrame = (InputFrame) frames[ITEM];
        closeAllFrame();
        frames[ITEM].show();
        inputFrame.fill();
    }//GEN-LAST:event_inputItemActionPerformed

    /*
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Master().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Transaksi;
    private javax.swing.JMenu alatMenu;
    private javax.swing.JMenuItem daftarItem;
    private javax.swing.JMenuItem hasilItem;
    private javax.swing.JMenuItem inputItem;
    private javax.swing.JMenuItem jBulanItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jTahunItem;
    private javax.swing.JMenu kalibrasiItem;
    private javax.swing.JMenu kalibrasiMenu;
    private javax.swing.JMenuItem keluarItem;
    private javax.swing.JMenuItem lapBulanItem;
    private javax.swing.JMenu lapKalibrasiItem;
    private javax.swing.JMenuItem lapMingguItem;
    private javax.swing.JMenuItem lapOrderItem;
    private javax.swing.JMenuItem lapStokItem;
    private javax.swing.JMenu laporanMenu;
    private javax.swing.JMenuItem lihatItem;
    private javax.swing.JDesktopPane masterPane;
    private javax.swing.JMenuItem masukItem;
    private javax.swing.JMenu orderMenu;
    private javax.swing.JMenuItem otorisasiItem;
    private javax.swing.JMenuItem penggunaItem;
    private javax.swing.JMenuItem permohonanItem;
    private javax.swing.JMenuItem prosesItem;
    private javax.swing.JMenuItem setujuItem;
    private javax.swing.JMenu sistemMenu;
    private javax.swing.JMenuItem tutupItem;
    private javax.swing.JMenuItem vendorItem;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setAppTheme();
        setFrames();
        defaultView();
    }

    private void setAppTheme() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setFrames() {
        // Menu Sistem
        frames[LOGIN] = new MasukFrame(this);
        frames[ACCOUNT] = new PenggunaFrame();
        frames[USER] = new OtorisasiFrame();
        frames[VENDOR] = new VendorFrame();
        frames[ITEM] = new InputFrame();
        // Register MDI to Master
        for (JInternalFrame frame : frames) {
            if (frame != null) {
                masterPane.add(frame);
            }
        }
    }

    private void defaultView() {
        frames[LOGIN].show();
        // disable all unnecessary menu
        alatMenu.setEnabled(false);
        kalibrasiMenu.setEnabled(false);
        orderMenu.setEnabled(false);
        laporanMenu.setEnabled(false);
        // disable all unnecessary menu item
        keluarItem.setEnabled(false);
        vendorItem.setEnabled(false);
        penggunaItem.setEnabled(false);
        otorisasiItem.setEnabled(false);
    }

    private void closeAllFrame() {
        for (JInternalFrame frame : frames) {
            if (frame != null) {
                frame.setVisible(false);
            }
        }
    }

    public void authorized(Pengguna user, Akses authorized) {
        defaultView();
        masukItem.setEnabled(false);
        keluarItem.setEnabled(true);

        if (authorized.getHak().equals("Admin")) {
            penggunaItem.setEnabled(true);
            otorisasiItem.setEnabled(true);
        } else if (authorized.getHak().equals("Inspector")) {
        } else if (authorized.getHak().equals("Pengguna")) {
            vendorItem.setEnabled(true);
            alatMenu.setEnabled(true);
        } else if (authorized.getHak().equals("Pimpinan")) {
        }
    }
}
