/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Banco.Banco;
import Control.Conta;
import Control.ProcessaArq;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author geraldo.dantas
 */
public class Principal extends javax.swing.JFrame {

    static String caminho = new String();
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jButton1.setText("Abrir Conta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item", "Número da Conta", "Telefone Origem", "Detalhe Serviço", "Descrição Serviço", "Destino Serviço", "Data Ligação", "Hora Início", "Destino", "Telefone Chamado", "Tarifa", "Duração", "Operadora Destino", "Origem", "Tipo da Chamada", "Serviço", "Unidade", "Referência", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setDropMode(javax.swing.DropMode.ON);
        tabela.setEnabled(false);
        tabela.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(tabela);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sistema de Processamento de Conta Telefônica");

        jButton3.setText("Relatório de Serviços");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Gerar PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 593, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        ProcessaArq arq = new ProcessaArq();
        ArrayList<Conta> lista = new ArrayList<Conta>();
        
        caminho = arq.localizaArquivo();
        try {
            arq.importaDados(caminho);
                  
            lista = arq.buscaBanco();
            preencheTabelaOriginal(lista);

        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo.\nCertifique-se que o arquivo está no formato correto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();        
        preencheTabelaRelatorioServicos(arq.buscaRelatorioServicos());        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        
        try {        
            arq.gravaArquivo(arq.buscaRelatorioServicos(), this.caminho);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed


    private void preencheTabelaOriginal(ArrayList<Conta> conta){
       
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
                
        tabela.getTableHeader().setReorderingAllowed(false);          
        final DefaultTableModel dm = new DefaultTableModel(); 
        tabela.setModel(dm);
        
        dm.addColumn("Item");
        dm.addColumn("Num. Conta");
        dm.addColumn("Tel. Origem");
        dm.addColumn("Detalhe do Serviço");
        dm.addColumn("Descrição do Serviço");
        dm.addColumn("Destino do Serviço");
        dm.addColumn("Data da Ligação");
        dm.addColumn("Hora Início");
        dm.addColumn("Destino");
        dm.addColumn("Telefone Chamado");
        dm.addColumn("Tarifa");
        dm.addColumn("Duração");
        dm.addColumn("Operadora Destino");        
        dm.addColumn("Origem");
        dm.addColumn("Tipo da Chamada");
        dm.addColumn("Serviço");
        dm.addColumn("Unidade");
        dm.addColumn("Referência");
        dm.addColumn("Valor");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(90); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(225); 
        tabela.getColumnModel().getColumn(4).setPreferredWidth(210); 
        tabela.getColumnModel().getColumn(5).setPreferredWidth(220); 
        tabela.getColumnModel().getColumn(6).setPreferredWidth(105); 
        tabela.getColumnModel().getColumn(7).setPreferredWidth(70); 
        tabela.getColumnModel().getColumn(8).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(9).setPreferredWidth(120); 
        tabela.getColumnModel().getColumn(10).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(11).setPreferredWidth(70); 
        tabela.getColumnModel().getColumn(12).setPreferredWidth(120); 
        tabela.getColumnModel().getColumn(13).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(14).setPreferredWidth(160); 
        tabela.getColumnModel().getColumn(15).setPreferredWidth(160); 
        tabela.getColumnModel().getColumn(16).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(17).setPreferredWidth(75); 
        tabela.getColumnModel().getColumn(18).setPreferredWidth(60); 
        
        for(int a=0;a < conta.size();a++){   
            dm.addRow(new Object[]{null, null, null, null, null, null});
            tabela.setValueAt(a+1, a, 0);  
            tabela.setValueAt(conta.get(a).getNumConta(), a, 1);  
            tabela.setValueAt(conta.get(a).getTelefoneOrigem(), a, 2);       
            tabela.setValueAt(conta.get(a).getDetalheServico(), a, 3);     
            tabela.setValueAt(conta.get(a).getDescricaoServico(), a, 4);  
            tabela.setValueAt(conta.get(a).getDestinoServico(), a, 5);       
            tabela.setValueAt(conta.get(a).getDataLigacao(), a, 6);              
            tabela.setValueAt(formato.format(conta.get(a).getHoraInicio()), a, 7);               
            tabela.setValueAt(conta.get(a).getDestino(), a, 8);    
            tabela.setValueAt(conta.get(a).getTelefoneChamado(), a, 9);    
            tabela.setValueAt(conta.get(a).getTarifa(), a, 10);    
            tabela.setValueAt(conta.get(a).getDuracao(), a, 11);    
            tabela.setValueAt(conta.get(a).getOperadoraDestino(), a, 12);    
            tabela.setValueAt(conta.get(a).getOrigem(), a, 13);    
            tabela.setValueAt(conta.get(a).getTipoChamada(), a, 14);    
            tabela.setValueAt(conta.get(a).getServico(), a, 15);    
            tabela.setValueAt(conta.get(a).getUnidade(), a, 16);    
            tabela.setValueAt(conta.get(a).getReferencia(), a, 17);    
            tabela.setValueAt("R$"+conta.get(a).getValor(), a, 18);  
        }           
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.revalidate();  
    } 
    
        private void preencheTabelaRelatorioServicos(ArrayList<Conta> conta){
        DecimalFormat df = new DecimalFormat("#,####.##"); 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");               
        tabela.getTableHeader().setReorderingAllowed(false);          
        final DefaultTableModel dm = new DefaultTableModel(); 
        tabela.setModel(dm);
        
        dm.addColumn("Item");
        dm.addColumn("Tipo");
        dm.addColumn("Descrição do Serviço");
        dm.addColumn("Duração");
        dm.addColumn("Valor");
        dm.addColumn("");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(400); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(90); 
        tabela.getColumnModel().getColumn(4).setPreferredWidth(90); 
        tabela.getColumnModel().getColumn(5).setPreferredWidth(150); 
        
        for(int a=0;a < conta.size();a++){   
            dm.addRow(new Object[]{null, null, null});
            tabela.setValueAt(a+1, a, 0);                                       
            tabela.setValueAt(conta.get(a).getTipo(), a, 1);                   
            tabela.setValueAt(conta.get(a).getDescricaoServico(), a, 2);        
            tabela.setValueAt(conta.get(a).getDuracao(), a, 3);       
            tabela.setValueAt("R$"+df.format(conta.get(a).getValor()), a, 4);  
            tabela.setValueAt("", a, 5);  
        }           
        
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.revalidate();  
    } 
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
                    
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
