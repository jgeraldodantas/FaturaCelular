/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Banco.Banco;
import Banco.Usuario;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author geraldo.dantas
 */


public class ProcessaArq {
    
    static Banco banco = new Banco();    
      
    public ArrayList<Conta> buscaBanco() throws ParseException{
        banco.relatorioServicos();
        banco.organizaConsumoUsuarios();
        banco.criaPeriodoAnterior();
        return banco.recuperaDados();
    }
    
    public ArrayList<Conta> buscaRelatorioServicos(){         
        return banco.getRelatorioServicos();
    }
    
    public ArrayList<Usuario> buscaRelatorioUsuarios(){         
        return banco.getRelatorioConsumoUsuario();
    }
    
    public ArrayList<Conta> buscaRelatorioPeriodoAnterior(){         
        return banco.getRelatorioPeriodoAnterior();
    }
    
    public ArrayList<Conta> buscaPeriodosAnteriores(){         
        return banco.getPeriodoAnterior();
    }   
    
    
    
    
    public void gravaArquivoConsumoUnidades(ArrayList<Usuario> listaUsuario, String caminho) throws IOException, DocumentException{
        
        Document doc = null;
        OutputStream os = null;
        PdfWriter pdf = null;
        Paragraph p = new Paragraph();  
        Tratamento tempo = new Tratamento();
        PdfPTable table = new PdfPTable(5);
        DecimalFormat df = new DecimalFormat("#####.##");
        ArrayList<String> listaCidade = new ArrayList<String>();
        String local = new String();
        String informacao, tipo = new String();
        Double soma, valorTotal, diferenca = 0.0;   
        Usuario unidade = new Usuario();
        ArrayList<Usuario> listaUnidades = new ArrayList<Usuario>();
    /*    
        if(banco.getConta().get(banco.getConta().size()-1).getDiferenca() > 0){
            diferenca = banco.getConta().get(banco.getConta().size()-1).getDiferenca()/9;
        }
        else{ diferenca = 0.0; }
    */    
        for(int a=0;a<=listaUsuario.size()-1;a++){                
            if( (!listaCidade.contains(listaUsuario.get(a).getCidade())) ){
                listaCidade.add(listaUsuario.get(a).getCidade());
            }
        }       
                       
        float[] headerwidths = { 30, 80, 35, 35, 25 }; // define a largura de cada coluna       
        table.setWidths(headerwidths);
                
        caminho = localizaArquivo(false)+".pdf";        
        try {//configurações da página          
            float fntSize, lineSpacing; 
            fntSize = 8f;
            lineSpacing = 8f;
            
            doc = new Document(PageSize.A4.rotate(), 10, 10, 30, 40); 
            os = new FileOutputStream(caminho);            
            pdf.getInstance(doc, os);   
            doc.open();
            
            
            /*
                local = new String();
                local = caminho +" "+ listaCidade.get(a) + ".pdf";
                
                doc = new Document(PageSize.A4.rotate(), 10, 10, 30, 40); 
                os = new FileOutputStream(local);            
                pdf.getInstance(doc, os);   
                doc.open();
            */    
                //cabecalho da tabela
                table.getDefaultCell().setBorder(0);
                
                table.getDefaultCell().setBorder(0);
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.getDefaultCell().setColspan(5);

                table.addCell(new Paragraph("CONSUMO POR UNIDADE "+banco.periodoFatura()));

                table.getDefaultCell().setBorder(0);
                table.getDefaultCell().setColspan(0);
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                doc.add(table); 
                
            for(int a=0; a<=listaCidade.size()-1;a++){
                
                table = new PdfPTable(5);
                table.setWidths(headerwidths);
                table.getDefaultCell().setBorder(0);
                table.addCell(new Paragraph(""));
                table.addCell(new Paragraph(""));
                table.addCell(new Paragraph(""));
                table.addCell(new Paragraph(""));
                table.addCell(new Paragraph(""));
                table.getDefaultCell().setBorder(1);

                table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY); 
                table.addCell(new Paragraph("Cidade"));
                table.addCell(new Paragraph("Usuário"));
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(new Paragraph("Número"));
                table.addCell(new Paragraph("Tipo"));
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                table.addCell(new Paragraph("Valor"));
                table.getDefaultCell().setBackgroundColor(BaseColor.WHITE); 
                
                soma = 0.0; 
                for(int b=0;b<=listaUsuario.size()-1;b++){
                    
                    if(listaCidade.get(a).equals(listaUsuario.get(b).getCidade())){
                        
                        //cidade
                        informacao = new String();
                        informacao = listaUsuario.get(b).getCidade();
                        table.addCell(new Paragraph(informacao));   
                        
                        //Usuário
                        informacao = new String();
                        informacao = listaUsuario.get(b).getNome();
                        table.addCell(new Paragraph(informacao));                    

                        //Número
                        informacao = new String();                                 
                        informacao = String.valueOf(listaUsuario.get(b).getLinha());
                        table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                        table.addCell(new Paragraph(informacao)); 

                        //Tipo
                        informacao = new String();                                 
                        informacao = listaUsuario.get(b).getTipo();
                        table.addCell(new Paragraph(informacao)); 

                        //Valor
                        informacao = new String();  
                        soma += listaUsuario.get(b).getValor();
                        informacao = "R$"+ df.format(listaUsuario.get(b).getValor());
                        table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                        table.addCell(new Paragraph(informacao)); 
                    }
                }                     

                // Total
                table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
                informacao = new String();
                informacao = "Total apurado";                    
                table.addCell(informacao);

                // tempo                        
                table.addCell("");            
                table.addCell("");    
                table.addCell("");    

                // valor
                informacao = new String();
                informacao = "R$"+ df.format(soma);
                table.addCell(informacao);                                   
                table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);  
                
                if((soma-diferenca)>0){                    
                   table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
                   informacao = new String();
                   informacao = "Total a pagar";                    
                   table.addCell(informacao);

                   // tempo                        
                   table.addCell("");            
                   table.addCell("");    
                   table.addCell("");    

                   // valor
                   informacao = new String();
                   informacao = "R$"+ df.format(soma-diferenca);
                   table.addCell(informacao);                                   
                   table.getDefaultCell().setBackgroundColor(BaseColor.WHITE); 
                }
                
                table.addCell("");            
                table.addCell(""); 
                table.addCell(""); 
                table.addCell("");            
                table.addCell(""); 
                
                unidade = new Usuario();
                unidade.setCidade(listaCidade.get(a));
                unidade.setValor(soma);
                listaUnidades.add(unidade);
                
                doc.add(table);                             
            }
            
            doc.newPage();
            table.getDefaultCell().setBorder(0);
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.getDefaultCell().setBorder(1);

            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY); 
            table.addCell(new Paragraph("Cidade"));
            table.addCell(new Paragraph(""));
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            table.addCell(new Paragraph("Valor"));
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE); 
          
            
            
            soma = 0.0;
            for(int a=0; a<= listaUnidades.size()-1; a++){
                //cidade
                informacao = new String();
                informacao = listaUnidades.get(a).getCidade();
                table.addCell(new Paragraph(informacao));  
                
                table.addCell(""); 
                table.addCell("");            
                table.addCell("");    
                
                //Valor
                informacao = new String();  
                soma += listaUnidades.get(a).getValor();
                informacao = "R$"+ df.format(listaUnidades.get(a).getValor());
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                table.addCell(new Paragraph(informacao));              
            }
            
            // Total
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
            informacao = new String();
            informacao = "Total apurado";                    
            table.addCell(informacao);

            // tempo                        
            table.addCell("");            
            table.addCell("");    
            table.addCell("");    

            // valor
            informacao = new String();
            informacao = "R$"+ df.format(soma);
            table.addCell(informacao);                                   
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);  
            
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
            informacao = new String();
            informacao = "Total a pagar";                    
            table.addCell(informacao);

            // tempo                        
            table.addCell("");            
            table.addCell("");    
            table.addCell("");    

            // valor
            informacao = new String();
            informacao = "R$"+ df.format(soma);
        //    informacao = "R$"+ df.format(soma-banco.getConta().get(banco.getConta().size()-1).getDiferenca());
            table.addCell(informacao);                                   
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);  
            
            
            
            
            doc.add(table); 
            doc.close();
            os.close(); 
            
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }     
    }

        
    
    
    public void gravaArquivoConsumoUsuarios(ArrayList<Usuario> lista, String caminho) throws IOException, DocumentException{
             
        Document doc = null;
        OutputStream os = null;
        Paragraph p = new Paragraph();  
        Tratamento tempo = new Tratamento();
        DecimalFormat df = new DecimalFormat("#####.##");
        String informacao, tipo = new String();
        Double soma, valorTotal = 0.0;      
        
        PdfPTable table = new PdfPTable(5); //tabela com 5 colunas
        float[] headerwidths = { 30, 80, 35, 35, 25 }; // define a largura de cada coluna  
        table.setWidths(headerwidths);
                
        caminho = localizaArquivo(false)+".pdf";        
        try {//configurações da página          
            float fntSize, lineSpacing;
            fntSize = 8f;
            lineSpacing = 8f;
            doc = new Document(PageSize.A4.rotate(), 10, 10, 30, 40);
            
            os = new FileOutputStream(caminho);            
            PdfWriter.getInstance(doc, os);            
            doc.open();
                                                
            //cabecalho da tabela
            table.getDefaultCell().setBorder(0);
            table.getWidthPercentage();
                      
            table.getDefaultCell().setBorder(0);
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table.getDefaultCell().setColspan(5);

            table.addCell(new Paragraph("CONSUMO POR USUÁRIOS ")+banco.periodoFatura());

            table.getDefaultCell().setBorder(1);
            table.getDefaultCell().setColspan(0);
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.addCell(new Paragraph(""));
            table.getDefaultCell().setBorder(1);
            
            
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY); 
            table.addCell(new Paragraph("Cidade"));
            table.addCell(new Paragraph("Usuário"));
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table.addCell(new Paragraph("Número"));
            table.addCell(new Paragraph("Tipo"));
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            table.addCell(new Paragraph("Valor"));
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE); 
            
            soma = 0.0; 
            for(int a=0;a<=lista.size()-1;a++){

                //cidade
                informacao = new String();
                informacao = lista.get(a).getCidade();
            //    table.setTotalWidth(80);
                table.addCell(new Paragraph(informacao));        
                
                //Usuário
                informacao = new String();
                informacao = lista.get(a).getNome();
            //    table.setTotalWidth(200);
                table.addCell(new Paragraph(informacao));                    

                //Número
                informacao = new String();                                 
                informacao = String.valueOf(lista.get(a).getLinha());
            //    table.setTotalWidth(10);
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                table.addCell(new Paragraph(informacao)); 

                //Tipo
                informacao = new String();                                 
                informacao = lista.get(a).getTipo();
            //    table.setTotalWidth(10);
                table.addCell(new Paragraph(informacao)); 
                
                //Valor
                informacao = new String();  
                soma += lista.get(a).getValor();
                informacao = "R$"+ df.format(lista.get(a).getValor());
            //    table.setTotalWidth(10);
                table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                table.addCell(new Paragraph(informacao)); 
            }                     
            
            // Total
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
            informacao = new String();
            informacao = "Total";                    
            table.addCell(informacao);

            // tempo                               
            table.addCell("");            
            table.addCell("");            
            table.addCell("");    

            // valor
            informacao = new String();
            informacao = "R$"+ df.format(soma);
            table.addCell(informacao);                                   
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);  
                                        
            doc.add(table);
            // fim da página
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }     
    }

    
    
    
    
    
    
    public void gravaArquivoServicos(ArrayList<Conta> lista, String caminho) throws IOException, DocumentException{
        ArrayList<String> listaTipos;
        String local[];        
        Document doc = null;
        OutputStream os = null;
        Paragraph p = new Paragraph();  
        Tratamento tempo = new Tratamento();
        DecimalFormat df = new DecimalFormat("#####.##");
        String informacao, tempoServico, tempoSubTotal, tempoTotal, tipo = new String();
        Double soma, valorTotal = 0.0;      
        
        PdfPTable table = new PdfPTable(3); //tabela com 3 colunas
        float[] headerwidths = { 85, 35, 25 }; // define a largura de cada coluna
        table.setWidths(headerwidths);
               
        caminho = localizaArquivo(false)+".pdf";        
        try {//configurações da página          
            float fntSize, lineSpacing;
            fntSize = 10f;
            lineSpacing = 10f;
            doc = new Document(PageSize.A4.rotate(), 10, 10, 20, 10);
            
            os = new FileOutputStream(caminho);            
            PdfWriter.getInstance(doc, os);            
            doc.open();
                                    
            tempoTotal = "00:00:00";  
            tempoServico = "00:00:00";    
            tempoSubTotal = "00:00:00";  
            listaTipos = new ArrayList<String>();
            
            //cabecalho da tabela
            table.getDefaultCell().setBorder(0);
            table.getWidthPercentage();
                      
            table.getDefaultCell().setBorder(0);
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table.getDefaultCell().setColspan(3);

            table.addCell(new Paragraph(tempo.verificaNomeServico(lista)+" "+banco.periodoFatura()));

            table.getDefaultCell().setBorder(1);
            table.getDefaultCell().setColspan(0);
            table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            
            for(int a=0;a<lista.size()-1;a++){
                System.out.println(a+" - "+lista.get(a).getTipo());
                                
                if(!listaTipos.contains(lista.get(a).getTipo())){
                    
                    listaTipos.add(lista.get(a).getTipo());                                            
                    soma = 0.0;          
                    tipo = new String();
                    informacao = new String();  
                                        
                    informacao = ""+listaTipos.get(listaTipos.size()-1)+"";                     
                    table.getDefaultCell().setBorder(1);
                    table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    table.getDefaultCell().setColspan(3);
                    table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
               
                    table.addCell(new Paragraph(informacao));
                    
                    table.getDefaultCell().setBorder(1);
                    table.getDefaultCell().setColspan(0);
                    table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                    table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                                                         
                    // conteúdo da tabela
                    for(int b=0;b<=lista.size()-1;b++){
                        if( lista.get(b).getTipo().equals(listaTipos.get(listaTipos.size()-1)) ){
                    
                            soma += lista.get(b).getValor();
                            tempoServico = tempo.somaTempo(lista.get(b).getDuracao(),tempoServico);
                            tempoSubTotal = tempo.somaTempo(tempoServico,tempoSubTotal);
                            tempoTotal = tempo.somaTempo(tempoServico,tempoTotal);
                            tipo = listaTipos.get(listaTipos.size()-1);  
                     
                            informacao = new String();
                            informacao = lista.get(b).getDescricaoServico();
                            table.setTotalWidth(80);
                            table.addCell(new Paragraph(informacao));        
                                    
                            informacao = new String();
                            informacao = tempoServico +" ("+  tempo.conversaoHoraMinuto(tempoServico)+")"; 
                            table.setTotalWidth(30);
                            table.addCell(new Paragraph(informacao));                    
                                                   
                            informacao = new String();                                 
                            informacao = "R$"+ df.format(lista.get(b).getValor());
                            table.setTotalWidth(20);
                            table.addCell(new Paragraph(informacao)); 
                            
                            tempoServico = "00:00:00";                                 
                        //    System.out.println(informacao);                                 
                        }
                    }                     
                    //rodapé da tabela
                    listaTipos.add(tipo);                    
                    valorTotal += soma;   
                    
                    
                    // subtotal
                    table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
                    informacao = new String();
                    informacao = "Sub Total:";                    
                    table.addCell(informacao);
                    
                    // tempo
                    informacao = new String();
                    informacao = tempoSubTotal +" ("+ tempo.conversaoHoraMinuto(tempoSubTotal)+")";                 
                    table.addCell(informacao);
                    
                    // valor
                    informacao = new String();
                    informacao = "R$"+ df.format(soma);
                    table.addCell(informacao);
                    table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
                    
                    
                    // espaço entre tabelas
                    
                    table.getDefaultCell().setBorder(1);
                    table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                    table.getDefaultCell().setColspan(3);
                    table.addCell(new Paragraph("* * * * *"));
                    table.getDefaultCell().setColspan(0);
                    table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_LEFT);                    
                    table.getDefaultCell().setBorder(0);
                                    
                    tempoSubTotal = "00:00:00";                    
                //    System.out.println(informacao);   
                }       
            }
            // fim da página
            
            // valor total
            informacao = new String();
            informacao = "Total Geral:  ";            
            table.getDefaultCell().setBorder(1);
            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);  
            table.addCell(informacao);
            table.getDefaultCell().setBorder(1);
            
            // tempo
            informacao = new String();
            informacao = tempoTotal +" ("+ tempo.conversaoHoraMinuto(tempoTotal) +")";            
            table.addCell(informacao);
            
            //valor
            informacao = new String();
            informacao = "R$"+df.format(valorTotal);
            table.addCell(informacao);
            
            doc.add(table);
        //    System.out.println(informacao);
         
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }     
    }

    
    
    
    public void importaDadosFatura(String caminho) throws ParseException{
        Tratamento item = new Tratamento();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
        Double diferenca = 0.0;
        Boolean ok = false;        
    /*    
        while (!ok){
            try{
                diferenca = Double.parseDouble(JOptionPane.showInputDialog("Valor da diferença"));
                if(diferenca >= 0.0){ ok = true; }
            }
            catch(Exception e){
                diferenca = Double.parseDouble(JOptionPane.showInputDialog("Valor da diferença"));
                if(diferenca >= 0.0){ ok = true; }
            }
        }        
    */    
        try{
            Double valor = 0.0;
            String[] vetor = new String[20];
            String separador = new String();
            String linha = new String();
            Conta dados = new Conta(); 
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho),"ISO-8859-1")); 
            
            separador = item.verificaSeparador(arq.readLine());
            while(arq.ready()){         
                dados = new Conta(); 
                vetor = new String[20];
                
                linha = item.removeCaracteres(arq.readLine());
                linha = linha+separador;           
                vetor = linha.split(separador,-1);   
                 
                dados.setNumConta(Long.parseLong(vetor[0]));
                dados.setTelefoneOrigem(Long.parseLong(vetor[1]));
                dados.setDetalheServico(vetor[2]);
                dados.setDescricaoServico(item.removeEspaco(vetor[3])+" ");
                dados.setDestinoServico(item.removeEspaco(vetor[4]));     
                dados.setDataLigacao(vetor[5]);  
                dados.setHoraInicio(sdf.parse(item.trataTempo(vetor[6])));   
                dados.setDestino(vetor[7]);
                dados.setTelefoneChamado(vetor[8]);
                dados.setTarifa(vetor[9]);
                dados.setDuracao(item.trataTempo(vetor[10]));
                dados.setOperadoraDestino(vetor[11]);                    
                dados.setOrigem(vetor[12]);
                dados.setTipoChamada(vetor[13]);
                dados.setServico(vetor[14]);
                dados.setUnidade(vetor[15]);
                dados.setReferencia(vetor[16]);                             
                dados.setValor(item.trataValor(vetor[17]));
                dados.setDiferenca(diferenca);
                dados.setPeriodo(banco.periodoFatura());
                banco.cadastro(dados);
                 
            //    valor += dados.getValor();     
            }
            arq.close();
                        
        }catch(IOException ioe){
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo da fatura.\nCertifique-se que o arquivo está no formato correto");
        } 
               
    };
    
    
    public void importaDadosUsuarios(){
        Tratamento item = new Tratamento();
        String caminho = "src\\Banco\\usuarios.csv";
            
        try{
            Double valor = 0.0;
            String[] vetor = new String[20];
            String separador = new String();
            String linha = new String();
            Usuario user = new Usuario();  
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho),"ISO-8859-1")); 
                                                   
            separador = ",";
            while(arq.ready()){         
                user = new Usuario(); 
                vetor = new String[20];
                
                linha = item.removeCaracteres(arq.readLine());
                linha = linha+separador;           
                vetor = linha.split(separador,-1);   
                 
                user.setCidade(vetor[0]);
                user.setSiape(vetor[1]);
                user.setNome(vetor[2]);
                user.setLinha(Long.parseLong(vetor[3]));
                user.setTipo(vetor[4]);
                user.setValor(valor);
               
                banco.cadastroUsuario(user);             
            }
            arq.close();
                        
        }catch(IOException ioe){
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo de usuarios.\nCertifique-se que o arquivo está no formato correto");
        } 
    }
    
    
    
    
    
    
    
    
    public String localizaArquivo(boolean opc){
        int escolha = 0;
        String arquivo = new String();        
        JFileChooser chooserArquivo = new JFileChooser();
        
        // TRUE = Abrir arquivo / FALSE = salvar arquivo
        if(opc){ escolha = chooserArquivo.showOpenDialog(chooserArquivo); }
        else{ escolha = chooserArquivo.showSaveDialog(chooserArquivo); }
        
        if ( escolha == JFileChooser.CANCEL_OPTION ){ arquivo = ""; }
        else{ arquivo = chooserArquivo.getSelectedFile().getAbsolutePath(); }   
        
        return arquivo;        
    }    
        
    public void processamento(){
        try { importaDadosFatura(localizaArquivo(true)); } 
        catch (ParseException ex) { Logger.getLogger(ProcessaArq.class.getName()).log(Level.SEVERE, null, ex); }        
    }
    
    public boolean verificaConta(){
        boolean ok = false;
        if(banco.getConta().size() > 1){ ok = true; }
        return ok;
    }

    public boolean verificaRelatorioPeriodoAnterior(){
        boolean ok = false;
        if(banco.getRelatorioPeriodoAnterior().size() > 1){ ok = true; }
        return ok;
    }
   
    public boolean verificaRelatorioConsumoUsuarios(){
        boolean ok = false;
        if(banco.getRelatorioConsumoUsuario().size() > 1){ ok = true; }
        return ok;
    }
    
    public boolean verificaRelatorioServicos(){
        boolean ok = false;
        if(banco.getRelatorioServicos().size() > 1){ ok = true; }
        return ok;
    }

}
