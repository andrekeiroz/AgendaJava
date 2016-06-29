/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Modelo.noTabModel;
import dao.ContatoDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andre
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        adicionarButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        textBusca = new javax.swing.JTextField();
        pesquisarButton = new javax.swing.JButton();
        listarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda");

        table.setModel(new noTabModel(cab, new ContatoDAO().tabList("contato")));
        scroll.setViewportView(table);

        adicionarButton.setText("Adicionar Contato");
        adicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Deletar Contato");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editarButton.setText("Editar Contato");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        pesquisarButton.setText("Pesquisar Contato");
        pesquisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarButtonActionPerformed(evt);
            }
        });

        listarButton.setText("Listar Contatos");
        listarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(editarButton)
                        .addGap(18, 18, 18)
                        .addComponent(listarButton)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisarButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarButton)
                    .addComponent(deleteButton)
                    .addComponent(editarButton)
                    .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarButton)
                    .addComponent(listarButton))
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarButtonActionPerformed
        addContato ac = new addContato(this, true);
        ac.setLocationRelativeTo(this);
        ac.setVisible(true);        
            
        noTabModel model = (noTabModel) table.getModel();
        List<List<String>> ll = new ContatoDAO().tabList("contato");	
        if(table.getRowCount() < ll.size()){
            table.setModel(new noTabModel(cab, new ContatoDAO().tabList("contato")));            
        }            
       
    }//GEN-LAST:event_adicionarButtonActionPerformed

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed
       int row = table.getSelectedRow();
        List<List<String>> ll = new ContatoDAO().delList("contato");
        if(row != -1){
            editContato ec = new editContato(this, true, Integer.parseInt(ll.get(row).get(0)));
            ec.setLocationRelativeTo(this);
            ec.setVisible(true);
            noTabModel model = (noTabModel) table.getModel();            
            model.removeItem(row);
            ll = new ContatoDAO().tabList("contato");
            model.addItem(row, ll.get(row));
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar.");
        }
    }//GEN-LAST:event_editarButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = table.getSelectedRow();
        if(row != -1){
            if (new JOptionPane().showConfirmDialog(null, "Tem certeza que deseja excluir o contato?", "Alerta!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                List<List<String>> ll = new ContatoDAO().delList("contato");
                new ContatoDAO().delete(Integer.parseInt(ll.get(row).get(0)));
                noTabModel model = (noTabModel) table.getModel();
                model.removeItem(row);
            }
        }else{
            new JOptionPane().showMessageDialog(null, "Selecione um cliente para remover.");
        }       
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void pesquisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarButtonActionPerformed
        noTabModel model = (noTabModel) table.getModel(); 
        model.deleteAllRows(model);
        
        if(!textBusca.getText().isEmpty()){
            List<List<String>> ll = new ContatoDAO().busca("contato", textBusca.getText());
            model.addItens(ll.size(), ll);
        }else{
            new JOptionPane().showMessageDialog(null, "Selecione um cliente para remover.");
        }   
    }//GEN-LAST:event_pesquisarButtonActionPerformed

    private void listarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarButtonActionPerformed
        noTabModel model = (noTabModel) table.getModel(); 
        model.deleteAllRows(model);
        List<List<String>> ll = new ContatoDAO().tabList("contato");
        model.addItens(ll.size(), ll);
    }//GEN-LAST:event_listarButtonActionPerformed
    
    private void atualizaTabela(){
        
    }
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal tp = new TelaPrincipal();
                tp.setLocationRelativeTo(null);
                tp.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editarButton;
    private javax.swing.JButton listarButton;
    private javax.swing.JButton pesquisarButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    private javax.swing.JTextField textBusca;
    // End of variables declaration//GEN-END:variables
    String cab[] = {"Nome", "Endereço", "Telefone", "Email"};
    private List<List<String>> listaTabela;
}