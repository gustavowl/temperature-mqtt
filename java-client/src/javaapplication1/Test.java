/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import org.eclipse.paho.client.mqttv3.MqttClient;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author koruja
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
	
	MqttPublishSample mqtt;
	
    public Test() {
        initComponents();
        mqtt = new MqttPublishSample(this);
        mqtt.doDemo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubButton = new javax.swing.JButton();
        ServerLabel = new javax.swing.JLabel();
        ServerTextField = new javax.swing.JTextField();
        SubComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        SubOutput = new javax.swing.JTextArea();
        PubTextField = new javax.swing.JTextField();
        PubComboBox = new javax.swing.JComboBox<>();
        PubButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SubButton.setText("Sub");
        SubButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubButtonMouseClicked(evt);
            }
        });

        ServerLabel.setText("Server");

        ServerTextField.setText("tcp://206.189.191.14");
        ServerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerTextFieldActionPerformed(evt);
            }
        });

        SubComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "/esp/temp", "/esp/smoke",
        		"/esp/daymsgs", "/vou/meformar" }));

        SubOutput.setColumns(20);
        SubOutput.setRows(5);
        jScrollPane1.setViewportView(SubOutput);

        PubComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "/esp/daymsgr" }));

        PubButton.setText("Pub");
        PubButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PubButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PubButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PubComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PubTextField)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ServerLabel)
                            .addComponent(SubButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ServerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(SubComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerLabel)
                    .addComponent(ServerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubButton)
                    .addComponent(SubComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PubComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PubButton))
                .addGap(18, 18, 18)
                .addComponent(PubTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        
        javax.swing.text.DefaultCaret caret = (javax.swing.text.DefaultCaret)SubOutput.getCaret();
        caret.setUpdatePolicy(javax.swing.text.DefaultCaret.ALWAYS_UPDATE);

        pack();
    }
    
    private void SubButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubButtonMouseClicked
        /*SubOutput.setText( SubOutput.getText() + '\n' +
                SubComboBox.getSelectedItem().toString() );*/
    	mqtt.subscribe(ServerTextField.getText(), "Receiving",
    			SubComboBox.getSelectedItem().toString());
        
    }//GEN-LAST:event_SubButtonMouseClicked
    
	private void PubButtonMouseClicked(java.awt.event.MouseEvent evt) {
		mqtt.publish(ServerTextField.getText(), "Sending",
				PubComboBox.getSelectedItem().toString(),
				PubTextField.getText());
		
	}

    private void ServerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServerTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        Test t = new Test();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                t.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PubButton;
    private javax.swing.JComboBox<String> PubComboBox;
    private javax.swing.JTextField PubTextField;
    private javax.swing.JLabel ServerLabel;
    private javax.swing.JTextField ServerTextField;
    private javax.swing.JButton SubButton;
    private javax.swing.JComboBox<String> SubComboBox;
    private javax.swing.JTextArea SubOutput;
    private javax.swing.JScrollPane jScrollPane1;
    private int message_count = 0;
    private final int MAX_MESSAGE_COUNT = 25;
    // End of variables declaration//GEN-END:variables
    
    public void SubOutputWrite(String text) {
    	if (message_count == MAX_MESSAGE_COUNT) {
    		SubOutputClear();
    		message_count = 0;
    	}
    	message_count++;
    	SubOutput.setText(SubOutput.getText() + '\n' + text);
    }
    
    public void SubOutputClear() {
    	SubOutput.setText("");
    }
}
