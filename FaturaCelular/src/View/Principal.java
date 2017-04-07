/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Banco.Banco;
import Banco.Usuario;
import Control.Conta;
import Control.ProcessaArq;
import Control.Tratamento;
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

        jMenu2 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAbreConta = new javax.swing.JMenu();
        detalhes = new javax.swing.JMenu();
        detalheFatura = new javax.swing.JMenu();
        detPeriodoAnterior = new javax.swing.JMenuItem();
        relatorios = new javax.swing.JMenu();
        relConsumoLinha = new javax.swing.JMenuItem();
        relPeriodoAnterior = new javax.swing.JMenuItem();
        relRelatorioServicos = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        consumoLinhaPDF = new javax.swing.JMenuItem();
        servicoUtilizadoPDF = new javax.swing.JMenu();
        consumoPeriodoAnteriorPDF = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        jMenu2.setText("jMenu2");

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
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        menuAbreConta.setText("  Abrir Fatura    *");
        menuAbreConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAbreContaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAbreConta);

        detalhes.setText("Detalhes    *");

        detalheFatura.setText("Fatura completa");
        detalheFatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detalheFaturaMouseClicked(evt);
            }
        });
        detalhes.add(detalheFatura);

        detPeriodoAnterior.setText("Período anterior");
        detPeriodoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detPeriodoAnteriorActionPerformed(evt);
            }
        });
        detalhes.add(detPeriodoAnterior);

        jMenuBar1.add(detalhes);

        relatorios.setText("Relatório    *");

        relConsumoLinha.setText("Consumo por linha");
        relConsumoLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relConsumoLinhaActionPerformed(evt);
            }
        });
        relatorios.add(relConsumoLinha);

        relPeriodoAnterior.setText("Período anterior");
        relPeriodoAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relPeriodoAnteriorActionPerformed(evt);
            }
        });
        relatorios.add(relPeriodoAnterior);

        relRelatorioServicos.setText("Serviços utilizados    ");
        relRelatorioServicos.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                relRelatorioServicosMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        relRelatorioServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relRelatorioServicosMouseClicked(evt);
            }
        });
        relatorios.add(relRelatorioServicos);

        jMenuBar1.add(relatorios);

        jMenu1.setText("Salvar em PDF    *");

        consumoLinhaPDF.setText("Consumo por linhas");
        consumoLinhaPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumoLinhaPDFActionPerformed(evt);
            }
        });
        jMenu1.add(consumoLinhaPDF);

        servicoUtilizadoPDF.setText("Consumo por serviços utilizados");
        servicoUtilizadoPDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicoUtilizadoPDFMouseClicked(evt);
            }
        });
        jMenu1.add(servicoUtilizadoPDF);

        consumoPeriodoAnteriorPDF.setText("Consumo em período anterior");
        consumoPeriodoAnteriorPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumoPeriodoAnteriorPDFActionPerformed(evt);
            }
        });
        jMenu1.add(consumoPeriodoAnteriorPDF);

        jMenuBar1.add(jMenu1);

        menuSair.setText("Sair    *");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
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

    private void detalheFaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detalheFaturaMouseClicked
        // TODO add your handling code here:        
        ProcessaArq arq = new ProcessaArq();
        ArrayList<Conta> lista = new ArrayList<Conta>();
        
        if(arq.verificaConta()){
            try {
                lista = arq.buscaBanco();
            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            preencheTabelaOriginal(lista);
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_detalheFaturaMouseClicked

    private void relRelatorioServicosMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_relRelatorioServicosMenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_relRelatorioServicosMenuKeyPressed

    private void relRelatorioServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relRelatorioServicosMouseClicked
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        if(arq.verificaRelatorioServicos()){ preencheTabelaRelatorioServicos(arq.buscaRelatorioServicos()); }       
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_relRelatorioServicosMouseClicked

    private void servicoUtilizadoPDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicoUtilizadoPDFMouseClicked
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        
        if(arq.verificaConta() || arq.verificaRelatorioServicos()){
            try {     
                arq.gravaArquivoServicos(arq.buscaRelatorioServicos(), this.caminho);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
    }//GEN-LAST:event_servicoUtilizadoPDFMouseClicked

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuAbreContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAbreContaMouseClicked
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        ArrayList<Conta> lista = new ArrayList<Conta>();
                
        caminho = arq.localizaArquivo(true);
        if(caminho.isEmpty()){}
        else{
            try {
                arq.importaDadosFatura(caminho);                
                if(!arq.verificaRelatorioConsumoUsuarios()){arq.importaDadosUsuarios();}
                
                lista = arq.buscaBanco();
                preencheTabelaOriginal(lista);

            } catch (ParseException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo.\nCertifique-se que o arquivo está no formato correto");
            }
        }
        
    }//GEN-LAST:event_menuAbreContaMouseClicked

    private void consumoLinhaPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumoLinhaPDFActionPerformed
        // TODO add your handling code here: 
        ProcessaArq arq = new ProcessaArq();
        
        if(arq.verificaConta() || arq.verificaRelatorioConsumoUsuarios()){
            try {     
                arq.gravaArquivoConsumoUsuarios(arq.buscaRelatorioUsuarios(), this.caminho);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }
        
    }//GEN-LAST:event_consumoLinhaPDFActionPerformed

    private void relConsumoLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relConsumoLinhaActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        if(arq.verificaRelatorioConsumoUsuarios()){ preencheTabelaRelatorioUsuarios(arq.buscaRelatorioUsuarios()); }       
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }      
        
    }//GEN-LAST:event_relConsumoLinhaActionPerformed

    private void detPeriodoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detPeriodoAnteriorActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        if(arq.verificaRelatorioServicos()){ preencheTabelaPeriodoAnterior(arq.buscaPeriodosAnteriores()); }       
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }              
    }//GEN-LAST:event_detPeriodoAnteriorActionPerformed

    private void relPeriodoAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relPeriodoAnteriorActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        if(arq.verificaRelatorioPeriodoAnterior()){ preencheTabelaPeriodoAnterior(arq.buscaRelatorioPeriodoAnterior()); }       
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }   
    }//GEN-LAST:event_relPeriodoAnteriorActionPerformed

    private void consumoPeriodoAnteriorPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumoPeriodoAnteriorPDFActionPerformed
        // TODO add your handling code here:
        ProcessaArq arq = new ProcessaArq();
        
        if(arq.verificaConta() || arq.verificaRelatorioPeriodoAnterior()){
            try {     
                arq.gravaArquivoServicos(arq.buscaRelatorioPeriodoAnterior(), this.caminho);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{ JOptionPane.showMessageDialog(null,"Nenhuma conta selecionada"); }        
    }//GEN-LAST:event_consumoPeriodoAnteriorPDFActionPerformed


    private void preencheTabelaOriginal(ArrayList<Conta> conta){
        double soma = 0.0;
        String tempo = "00:00:00";
        Tratamento t = new Tratamento();
        DecimalFormat df = new DecimalFormat("#,####.##"); 
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
            soma += conta.get(a).getValor();
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
            tempo = t.somaTempo(tempo,conta.get(a).getDuracao());
        }           
        dm.addRow(new Object[]{null, null, null, null, null, null});
        dm.addRow(new Object[]{null, null, null, null, null, null});
        tabela.setValueAt("Total", conta.size()+1, 0);
        tabela.setValueAt(tempo, conta.size()+1, 11);
        tabela.setValueAt(t.conversaoHoraMinuto(tempo), conta.size()+1, 12);
        tabela.setValueAt("R$"+df.format(soma), conta.size()+1, 18);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.revalidate();  
    } 
    
    private void preencheTabelaRelatorioServicos(ArrayList<Conta> conta){
        String tempo = "00:00:00";
        Tratamento t = new Tratamento();
        DecimalFormat df = new DecimalFormat("#,####.##"); 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");               
        tabela.getTableHeader().setReorderingAllowed(false);          
        final DefaultTableModel dm = new DefaultTableModel(); 
        tabela.setModel(dm);
        double soma = 0.0;
        
        dm.addColumn("Item");
        dm.addColumn("Tipo");
        dm.addColumn("Descrição do Serviço");
        dm.addColumn("Duração");
        dm.addColumn("Duração (minutos)");
        dm.addColumn("Valor");
        dm.addColumn("");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(400); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(4).setPreferredWidth(100); 
        tabela.getColumnModel().getColumn(5).setPreferredWidth(90); 
        tabela.getColumnModel().getColumn(6).setPreferredWidth(0); 
        
        for(int a=0;a < conta.size();a++){   
            dm.addRow(new Object[]{null, null, null});
            soma += conta.get(a).getValor();
            tabela.setValueAt(a+1, a, 0);                                       
            tabela.setValueAt(conta.get(a).getTipo(), a, 1);                   
            tabela.setValueAt(conta.get(a).getDescricaoServico(), a, 2);        
            tabela.setValueAt(conta.get(a).getDuracao(), a, 3);       
            tabela.setValueAt(t.conversaoHoraMinuto(conta.get(a).getDuracao()), a, 4);       
            tabela.setValueAt("R$"+df.format(conta.get(a).getValor()), a, 5);  
            tabela.setValueAt("", a, 6);  
            tempo = t.somaTempo(tempo,conta.get(a).getDuracao());
        }           
        
        dm.addRow(new Object[]{null, null, null, null, null, null});
        dm.addRow(new Object[]{null, null, null, null, null, null});
        tabela.setValueAt("Total", conta.size()+1, 0);
        tabela.setValueAt(tempo, conta.size()+1, 3);
        tabela.setValueAt(t.conversaoHoraMinuto(tempo), conta.size()+1, 4);
        tabela.setValueAt("R$"+df.format(soma), conta.size()+1, 5);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.revalidate();  
    } 
    
    
    private void preencheTabelaPeriodoAnterior(ArrayList<Conta> periodo){
        String tempo = "00:00:00";
        Tratamento t = new Tratamento();
        DecimalFormat df = new DecimalFormat("#,####.##"); 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");               
        tabela.getTableHeader().setReorderingAllowed(false);          
        final DefaultTableModel dm = new DefaultTableModel(); 
        tabela.setModel(dm);
        double soma = 0.0;
        
        dm.addColumn("Item");
        dm.addColumn("Tipo");
        dm.addColumn("Descrição do Serviço");
        dm.addColumn("Data da Ligação");
        dm.addColumn("Duração");
        dm.addColumn("Duração (minutos)");
        dm.addColumn("Valor");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(400); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(105); 
        tabela.getColumnModel().getColumn(4).setPreferredWidth(65); 
        tabela.getColumnModel().getColumn(5).setPreferredWidth(115); 
        tabela.getColumnModel().getColumn(6).setPreferredWidth(100); 
        
        for(int a=0;a < periodo.size();a++){   
            dm.addRow(new Object[]{null, null, null});
            soma += periodo.get(a).getValor();
            tabela.setValueAt(a+1, a, 0);                                       
            tabela.setValueAt(periodo.get(a).getTipo(), a, 1);                   
            tabela.setValueAt(periodo.get(a).getDescricaoServico(), a, 2);        
            tabela.setValueAt(periodo.get(a).getDataLigacao(), a, 3);        
            tabela.setValueAt(periodo.get(a).getDuracao(), a, 4);       
            tabela.setValueAt(t.conversaoHoraMinuto(periodo.get(a).getDuracao()), a, 5);       
            tabela.setValueAt("R$"+df.format(periodo.get(a).getValor()), a, 6);  
            tempo = t.somaTempo(tempo,periodo.get(a).getDuracao()); 
        }           
        
        dm.addRow(new Object[]{null, null, null, null, null, null});
        dm.addRow(new Object[]{null, null, null, null, null, null});
        tabela.setValueAt("Total", periodo.size()+1, 0);
        tabela.setValueAt(tempo, periodo.size()+1, 4);
        tabela.setValueAt(t.conversaoHoraMinuto(tempo), periodo.size()+1, 5);
        tabela.setValueAt("R$"+df.format(soma), periodo.size()+1, 6);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.revalidate();  
    } 
    
    private void preencheTabelaRelatorioUsuarios(ArrayList<Usuario> usuario){
        DecimalFormat df = new DecimalFormat("#,####.##"); 
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");               
        tabela.getTableHeader().setReorderingAllowed(false);          
        final DefaultTableModel dm = new DefaultTableModel(); 
        tabela.setModel(dm);
        double soma = 0.0;
        
        dm.addColumn("Item");
        dm.addColumn("Lotação");
        dm.addColumn("SIAPE/CPF");
        dm.addColumn("Usuário");
        dm.addColumn("Número");
        dm.addColumn("Tipo");
        dm.addColumn("Valor");
        
        tabela.getColumnModel().getColumn(0).setPreferredWidth(45);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(110); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(80); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(290); 
        tabela.getColumnModel().getColumn(4).setPreferredWidth(115); 
        tabela.getColumnModel().getColumn(5).setPreferredWidth(45); 
        tabela.getColumnModel().getColumn(6).setPreferredWidth(90); 
        
        for(int a=0;a < usuario.size();a++){   
            dm.addRow(new Object[]{null, null, null});
            soma += usuario.get(a).getValor();
            tabela.setValueAt(a+1, a, 0);                                       
            tabela.setValueAt(usuario.get(a).getCidade(), a, 1);                   
            tabela.setValueAt(usuario.get(a).getSiape(), a, 2);        
            tabela.setValueAt(usuario.get(a).getNome(), a, 3);         
            tabela.setValueAt(usuario.get(a).getLinha(), a, 4);    
            tabela.setValueAt(usuario.get(a).getTipo(), a, 5);       
            tabela.setValueAt("R$"+df.format(usuario.get(a).getValor()), a, 6);  
        }           
        
        dm.addRow(new Object[]{null, null, null, null, null, null});
        dm.addRow(new Object[]{null, null, null, null, null, null});
        tabela.setValueAt("Total", usuario.size(), 0);
        tabela.setValueAt("R$"+df.format(soma), usuario.size(), 6);
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
    private javax.swing.JMenuItem consumoLinhaPDF;
    private javax.swing.JMenuItem consumoPeriodoAnteriorPDF;
    private javax.swing.JMenuItem detPeriodoAnterior;
    private javax.swing.JMenu detalheFatura;
    private javax.swing.JMenu detalhes;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAbreConta;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenuItem relConsumoLinha;
    private javax.swing.JMenuItem relPeriodoAnterior;
    private javax.swing.JMenu relRelatorioServicos;
    private javax.swing.JMenu relatorios;
    private javax.swing.JMenu servicoUtilizadoPDF;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
