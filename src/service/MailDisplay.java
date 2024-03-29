/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.File;
import javax.swing.JFileChooser;
import library.Mail;
import static library.Mail_Library.DownloadAttachement;
import static library.Mail_Library.getInfosMails;

/**
 *
 * @author fredm
 */
public class MailDisplay extends javax.swing.JFrame {

    /**
     * Creates new form MailDisplay
     */
    public MailDisplay() {
        initComponents();
    }
    public MailDisplay(Mail mailOpen)
    {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println(mailOpen.toString());
        if(mailOpen.getFrom() != null)
        {
           System.out.println(mailOpen.getFrom());
           TFFrom.setText(mailOpen.getFrom()); 
        }
            
        if(mailOpen.getSubject() != null)
        {
            TFSujet.setText(mailOpen.getSubject());
        }
        if(mailOpen.getText() != null)
            TAMsg.setText(mailOpen.getText());
        if(mailOpen.getFileName() != null)
            TFFile.setText(mailOpen.getFileName());
    }
    public MailDisplay(String mailOpen) {
        initComponents();
        String[] infos = getInfosMails("localhost", "info@test.com", "user",  mailOpen);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFFrom = new javax.swing.JTextField();
        TFSujet = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TAMsg = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        Ltitre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFFile = new javax.swing.JTextField();
        BEnvoyer = new javax.swing.JButton();
        BDownload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Sujet :");

        jLabel6.setText("Message :");

        TFFrom.setEditable(false);

        TFSujet.setEditable(false);

        TAMsg.setEditable(false);
        TAMsg.setColumns(20);
        TAMsg.setRows(5);
        jScrollPane2.setViewportView(TAMsg);

        jLabel7.setText("Fichier :");

        Ltitre.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        Ltitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Ltitre.setText("Mail");

        jLabel4.setText("From :");

        TFFile.setEditable(false);

        BEnvoyer.setText("Fermer");
        BEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnvoyerActionPerformed(evt);
            }
        });

        BDownload.setText("Télécharger fichier");
        BDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(19, 19, 19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BDownload)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BEnvoyer))
                                    .addComponent(jScrollPane2)
                                    .addComponent(TFFile, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(Ltitre)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Ltitre)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BEnvoyer)
                    .addComponent(BDownload))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnvoyerActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BEnvoyerActionPerformed

    private void BDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDownloadActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setSelectedFile(new File(TFFile.getText()));
        int retour = file.showSaveDialog(this.getParent());
        if(retour==JFileChooser.APPROVE_OPTION)
        {
            if(TFFile.getText() != null)
                DownloadAttachement("localhost", "info@test.com", "user", TFFile.getText(), file.getSelectedFile().getAbsolutePath());
            TFFile.setText(file.getSelectedFile().getAbsolutePath());
        }
        
    }//GEN-LAST:event_BDownloadActionPerformed

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
            java.util.logging.Logger.getLogger(MailDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MailDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MailDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MailDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDownload;
    private javax.swing.JButton BEnvoyer;
    private javax.swing.JLabel Ltitre;
    private javax.swing.JTextArea TAMsg;
    private javax.swing.JTextField TFFile;
    private javax.swing.JTextField TFFrom;
    private javax.swing.JTextField TFSujet;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
