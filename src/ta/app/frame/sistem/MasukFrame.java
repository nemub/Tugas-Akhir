/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasukFrame.java
 *
 * Created on Oct 5, 2013, 8:42:40 PM
 */
package ta.app.frame.sistem;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import ta.app.Master;
import ta.util.orm.mapping.Pengguna;
import ta.util.orm.query.LoginQuery;

/**
 *
 * @author Sahal
 */
public class MasukFrame extends javax.swing.JInternalFrame {

    private Master master;

    /**
     * Creates new form MasukFrame
     */
    public MasukFrame() {
        initComponents();
    }

    public MasukFrame(Master master) {
        this();
        this.master = master;

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
        namaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        namaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("NIK");

        passwordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTxtKeyPressed(evt);
            }
        });

        jLabel3.setText("Password");

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loginBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(loginBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        validation();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void namaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            namaTxt.transferFocus();
        }
    }//GEN-LAST:event_namaTxtKeyPressed

    private void passwordTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validation();
        }
    }//GEN-LAST:event_passwordTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JPasswordField passwordTxt;
    // End of variables declaration//GEN-END:variables

    public void defaultView() {
        loginBtn.setText("Login");
        namaTxt.setText("");
        passwordTxt.setText("");
        passwordTxt.transferFocusBackward();
    }

    private void validation() {
        if (namaTxt.getText().isEmpty() || String.valueOf(passwordTxt.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mohon isikan terlebih dahulu NIK dan Password", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            if (namaTxt.getText().length() <= 5 && String.valueOf(passwordTxt.getPassword()).length() <= 12) {
                LoginQuery loginQuery = new LoginQuery();

                if (loginQuery.isRegistered(namaTxt.getText(), String.valueOf(passwordTxt.getPassword()))) {
                    Pengguna user = loginQuery.getUser();
                    master.authorized(user, loginQuery.getAuthorized());
                    JOptionPane.showMessageDialog(this, "Hallo '" + user.getNama() + "'", "Salam", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Pengguna tidak terdaftar !!!", "Validasi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Jumlah huruf untuk NIK atau Password melebihi batas ketentuan", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        }

        defaultView();
    }

}
