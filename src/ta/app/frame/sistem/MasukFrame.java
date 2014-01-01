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
import ta.util.orm.mapping.HakAkses;
import ta.util.orm.query.LoginQuery;

/**
 *
 * @author Sahal
 */
public class MasukFrame extends javax.swing.JInternalFrame {
    private Master master;
    /** Creates new form MasukFrame */
    public MasukFrame() {
        initComponents();
    }

    public MasukFrame(Master master) {
        this();
        this.master = master ;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namaTxt = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        passwordTxt = new javax.swing.JPasswordField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Login");

        LoginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));

        jLabel2.setText("Nama");

        jLabel3.setText("Password");

        namaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                namaTxtKeyPressed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        passwordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginBtn)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTxt)
                            .addComponent(namaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                .addContainerGap())
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
       validation();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void namaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            namaTxt.transferFocus();
    }//GEN-LAST:event_namaTxtKeyPressed

    private void passwordTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            validation();
    }//GEN-LAST:event_passwordTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginBtn;
    private javax.swing.JTextField namaTxt;
    private javax.swing.JPasswordField passwordTxt;
    // End of variables declaration//GEN-END:variables

    public void clear() {
        namaTxt.setText("");
        passwordTxt.setText("");
        passwordTxt.transferFocusBackward();
    }

    private void validation() {
    if (namaTxt.getText().isEmpty() || String.valueOf(passwordTxt.getPassword()).isEmpty())
            JOptionPane.showMessageDialog(this, "Mohon isikan terlebih dahulu nama dan password", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        else {
            if (namaTxt.getText().length() <= 30 && String.valueOf(passwordTxt.getPassword()).length() <= 20) {
                LoginQuery loginQuery = new LoginQuery();
                if (loginQuery.isRegistered(namaTxt.getText(), String.valueOf(passwordTxt.getPassword()))) {
                    HakAkses user = loginQuery.getUser();
                    master.otorisasi(user);
                    setVisible(false);
                } else
                    JOptionPane.showMessageDialog(this, "Pengguna tidak terdaftar !!!", "Validasi", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(this, "Jumlah huruf untuk nama atau password melebihi batas ketentuan", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        }

        clear();
    }

}