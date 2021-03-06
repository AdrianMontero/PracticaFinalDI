package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * JFrame principal de la aplicación en que se mostraran tanto los formulario de 
 * marcas como los de modelos.
 * 
 * @author GreenMonster
 */
public class JFInterfaz extends javax.swing.JFrame {

    JPMarca jpma = new JPMarca();
    JPModelo jpmo = new JPModelo();

    /**
     * Creates new form JFInterfaz
     */
    public JFInterfaz() {

        initComponents();
        this.getContentPane().add(jpma);//Marca
//        this.getContentPane().add(jpmo);//Modelo
        this.setVisible(true);
        this.setBounds(0, 0, 700, 400);

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMarcas = new javax.swing.JMenu();
        jModelos = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMarcas.setText("Marcas");
        jMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMarcasMouseClicked(evt);
            }
        });
        jMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMarcasActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMarcas);

        jModelos.setText("Modelos");
        jModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModelosMouseClicked(evt);
            }
        });
        jModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModelosActionPerformed(evt);
            }
        });
        jMenuBar1.add(jModelos);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarcasActionPerformed

    }//GEN-LAST:event_jMarcasActionPerformed

    private void jModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModelosActionPerformed

    }//GEN-LAST:event_jModelosActionPerformed

    private void jMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMarcasMouseClicked
        this.getContentPane().add(jpma);//Marca
        jpmo.setVisible(false);
        jpma.setVisible(true);
    }//GEN-LAST:event_jMarcasMouseClicked

    private void jModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModelosMouseClicked
        this.getContentPane().add(jpmo);//Modelo
        jpma.setVisible(false);
        jpmo.setVisible(true);
    }//GEN-LAST:event_jModelosMouseClicked

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
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
            Logger.getLogger(JFInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFInterfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMarcas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jModelos;
    // End of variables declaration//GEN-END:variables
}
