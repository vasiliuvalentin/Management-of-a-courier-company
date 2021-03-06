/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdproiect;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Vali
 */
public class CautareAngajati extends javax.swing.JFrame {

    /**
     * Creates new form CautareAngajati
     */
    public CautareAngajati() {
        initComponents();
        this.getContentPane().setBackground(new Color(0 , 152, 152));
        this.setTitle("Cautare Angajati");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        butonOk = new javax.swing.JButton();
        comboText = new javax.swing.JComboBox<>();
        textCautare = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setText("Cautare dupa : ");

        butonOk.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        butonOk.setText("CAUTA");
        butonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonOkActionPerformed(evt);
            }
        });

        comboText.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        comboText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cod Angajat", "Nume", "Prenume", "CNP", "Adresa", "Salariu", "Functie" }));
        comboText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel2.setText("CAUTARE ANGAJATI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCautare)
                    .addComponent(comboText, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(152, 152, 152))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(butonOk)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(textCautare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(butonOk)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTextActionPerformed

    private void butonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonOkActionPerformed
        String selectie = comboText.getSelectedItem().toString();
       
        Statement stmt;
        String query=null;
         
        try {
            Connection con = Conexiune.DBConector();
            stmt = (Statement) con.createStatement();
            switch (selectie) {
                case "Cod Angajat":
                    query = "Select * from angajati where coda=?";
                    break;
                case "Nume":
                    query = "Select * from angajati where nume=?";
                    break;
                case "Prenume":
                    query = "Select * from angajati where prenume=?";
                    break;
                case "CNP":
                    query = "Select * from angajati where cnp=?";
                    break;
                case "Adresa":
                    query = "Select * from angajati where adresa=?";
                    break;
                case "Salariu":
                    query = "Select * from angajati where salariu=?";
                    break;
                case "Functie":
                    query = "Select * from angajati where codf=?";
                    break;
            }
            
           
            
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, textCautare.getText());
            
            ResultSet rs = st.executeQuery();
            FereastraAfisare lista = new FereastraAfisare();
            lista.setVisible(true);
            
            while (rs.next()) {
                lista.afisareFereastra.append(rs.getString("coda") + "\t" + rs.getString("nume") + "\t" + rs.getString("prenume") + "\t"
                        + rs.getString("cnp") + "\t" + rs.getString("adresa") + "\t" + rs.getString("salariu") + "\t" + rs.getString("codf") + "\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
        }
    }//GEN-LAST:event_butonOkActionPerformed

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
            java.util.logging.Logger.getLogger(CautareAngajati.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CautareAngajati.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CautareAngajati.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CautareAngajati.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CautareAngajati().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonOk;
    private javax.swing.JComboBox<String> comboText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField textCautare;
    // End of variables declaration//GEN-END:variables
}
