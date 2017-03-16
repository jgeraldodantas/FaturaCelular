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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAbreConta = new javax.swing.JMenu();
        menuFatura = new javax.swing.JMenu();
        menuRelatorioServicos = new javax.swing.JMenu();
        menuPDF = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 200));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

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

        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        menuAbreConta.setText("  Abrir Fatura    ");
        menuAbreConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAbreContaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAbreConta);

        menuFatura.setText("Detalhes");
        menuFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFaturaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuFatura);

        menuRelatorioServicos.setText("Relatório de Serviços    ");
        menuRelatorioServicos.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                menuRelatorioServicosMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        menuRelatorioServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRelatorioServicosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRelatorioServicos);

        menuPDF.setText("Gerar PDF    ");
        menuPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPDFMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPDF);

        menuSair.setText("Sair    ");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void menuFaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFaturaMouseClicked
        // TODO add your handling code here:        
        ProcessaArq arq = new ProcessaArq();
        ArrayList<Conta> lista = new ArrayList<Conta>();
        
        if(arq.verificaConta()){
            lista = arq.buscaBanco();
            preencheTabelaOriginal(lista);
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_menuFaturaMouseClicked

    private void menuRelatorioServicosMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_menuRelatorioServicosMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRelatorioServicosMenuKeyPressed

    private void menuRelatorioServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRelatorioServicosMouseClicked
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        if(arq.verificaRelatorioServicos()){ preencheTabelaRelatorioServicos(arq.buscaRelatorioServicos()); }       
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_menuRelatorioServicosMouseClicked

    private void menuPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPDFMouseClicked
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        
        if(arq.verificaConta() || arq.verificaRelatorioServicos()){
            try {        
                arq.gravaArquivo(arq.buscaRelatorioServicos(), this.caminho);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_menuPDFMouseClicked

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuAbreContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAbreContaMouseClicked
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
        
    }//GEN-LAST:event_menuAbreContaMouseClicked


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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAbreConta;
    private javax.swing.JMenu menuFatura;
    private javax.swing.JMenu menuPDF;
    private javax.swing.JMenu menuRelatorioServicos;
    private javax.swing.JMenu menuSair;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
