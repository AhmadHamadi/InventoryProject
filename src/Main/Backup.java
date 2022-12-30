/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author ccs
 */
public class Backup extends javax.swing.JInternalFrame {

    /**
     * Creates new form Backup
     */
    public Backup() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));        
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    String path=null;
     Process pr=null;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnbrows = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnbackup2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtpath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(880, 510));
        setPreferredSize(new java.awt.Dimension(880, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 510));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(193, 222, 136));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Backup");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 570, 50));

        jPanel3.setBackground(new java.awt.Color(231, 255, 231));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbrows.setBackground(new java.awt.Color(193, 222, 136));
        btnbrows.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbrowsMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/star-24.png"))); // NOI18N
        jLabel1.setText("Set Path");
        btnbrows.add(jLabel1);

        jPanel3.add(btnbrows, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 90, 40));

        btnbackup2.setBackground(new java.awt.Color(193, 222, 136));
        btnbackup2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackup2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/upload-24.png"))); // NOI18N
        jLabel3.setText("Backup");
        btnbackup2.add(jLabel3);

        jPanel3.add(btnbackup2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 90, 40));
        jPanel3.add(txtpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 280, 30));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel2.setText("Path");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 410, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbrowsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbrowsMouseClicked
        JFileChooser jfc= new JFileChooser();
        jfc.showOpenDialog(this);
        
        String date=new SimpleDateFormat("yyy-MM-dd").format(new Date());

        try {
            File f= jfc.getSelectedFile();
            path=f.getAbsolutePath();
            path=path.replace('\\', '/');
            path = path + "_" + date + ".sql";
            txtpath.setText(path);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnbrowsMouseClicked

    private void btnbackup2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackup2MouseClicked
        
        int x=txtpath.getText().length();
        
        if(x>0)
        {
        try {
            Runtime run= Runtime.getRuntime();
            pr=run.exec("C://wamp64//bin//mysql//mysql5.7.21//bin//mysqldump.exe -uroot --add-drop-database -B webinventory -r"+ path);
            
            int processComplete= pr.waitFor();
            if(processComplete==0)
            {
            JOptionPane.showMessageDialog(rootPane, "Backup Success");
            }
            else
            {
            JOptionPane.showMessageDialog(rootPane, "Fail");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        }
        else
        {
                JOptionPane.showMessageDialog(rootPane, "Select Path");
        }
        
    }//GEN-LAST:event_btnbackup2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnbackup2;
    private javax.swing.JPanel btnbrows;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtpath;
    // End of variables declaration//GEN-END:variables
}