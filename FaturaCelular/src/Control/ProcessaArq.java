/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Banco.Banco;
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
      
    public ArrayList<Conta> buscaBanco(){
        banco.relatorioServicos();
        return banco.recuperaDados();
    }
    
    public ArrayList<Conta> buscaRelatorioServicos(){         
        return banco.getRelatorioServicos();
    }

    public void gravaArquivo(ArrayList<Conta> lista, String caminho) throws IOException, DocumentException{
        ArrayList<String> listaTipos;
        String local[];        
        Document doc = null;
        OutputStream os = null;
        Paragraph p = new Paragraph();  
        Tratamento tempo = new Tratamento();
        DecimalFormat df = new DecimalFormat("#,####.##");
        String informacao, tempoServico, tempoSubTotal, tempoTotal, tipo = new String();
        Double soma, valorTotal = 0.0;      
        
        
        local = caminho.split(".CSV");         
        caminho = local[0]+".pdf";        
        try {//configurações da página
          
            float fntSize, lineSpacing;
            fntSize = 10f;
            lineSpacing = 10f;
            doc = new Document(PageSize.A4.rotate(), 50, 50, 50, 50);
            
            os = new FileOutputStream(caminho);            
            PdfWriter.getInstance(doc, os);            
            doc.open();
                                    
            tempoTotal = "00:00:00";  
            tempoServico = "00:00:00";    
            tempoSubTotal = "00:00:00";  
            listaTipos = new ArrayList<String>();
            for(int a=0;a<lista.size()-1;a++){
                
                if(!listaTipos.contains(lista.get(a).getTipo())){
                    
                    listaTipos.add(lista.get(a).getTipo());                                            
                    soma = 0.0;          
                    tipo = new String();
                    informacao = new String();  
                    
                    informacao = "**** "+listaTipos.get(listaTipos.size()-1)+" ****";
                    p = new Paragraph(new Phrase(lineSpacing,informacao,FontFactory.getFont(FontFactory.COURIER, fntSize)));
                    doc.add(p);  
                    
                    for(int b=0;b<=lista.size()-1;b++){
                        if( lista.get(b).getTipo().equals(listaTipos.get(listaTipos.size()-1)) ){
                    
                            soma += lista.get(b).getValor();
                            tempoServico = tempo.somaTempo(lista.get(b).getDuracao(),tempoServico);
                            tempoSubTotal = tempo.somaTempo(tempoServico,tempoSubTotal);
                            tempoTotal = tempo.somaTempo(tempoServico,tempoTotal);
                            tipo = listaTipos.get(listaTipos.size()-1);  
                            
                            informacao = new String();
                            informacao = lista.get(b).getDescricaoServico() +"      "+ tempoServico +" = "+  tempo.conversaoHoraMinuto(tempoServico) +"      R$"+ df.format(lista.get(b).getValor());
                            tempoServico = "00:00:00";     
                            
                            System.out.println(informacao);                
                            p = new Paragraph(new Phrase(lineSpacing,informacao,FontFactory.getFont(FontFactory.COURIER, fntSize)));
                            doc.add(p);
                        }
                    }                     
                    
                    listaTipos.add(tipo);                    
                    valorTotal += soma;   
                    
                    informacao = new String();
                    informacao = "Sub Total:      "+  tempoSubTotal +" = "+ tempo.conversaoHoraMinuto(tempoSubTotal)  +"      R$"+ df.format(soma) +"\n\n\n";
                    tempoSubTotal = "00:00:00";
                    
                    System.out.println(informacao);                
                    p = new Paragraph(new Phrase(lineSpacing,informacao,FontFactory.getFont(FontFactory.COURIER, fntSize)));
                    doc.add(p);   
                }       
            }
            
            informacao = new String();
            informacao = "Total Geral:  "+ tempoTotal +" = "+ tempo.conversaoHoraMinuto(tempoTotal) +"  R$"+df.format(valorTotal);
            p = new Paragraph(new Phrase(lineSpacing,informacao,FontFactory.getFont(FontFactory.COURIER, fntSize)));
            doc.add(p);
            System.out.println(informacao);
         
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

    
    
    
    public void importaDados(String caminho) throws ParseException{
        Tratamento item = new Tratamento();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
                
        try{
            int cont = 0;
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
                banco.cadastro(dados);
                 
                valor += dados.getValor();                
                cont++;
            }
            arq.close();
                        
        }catch(IOException ioe){
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo.\nCertifique-se que o arquivo está no formato correto");
        } 
               
    };
    
    public String localizaArquivo(){
        int escolha = 0;
        String arquivo = new String();        
        JFileChooser chooserArquivo = new JFileChooser();
                
        escolha = chooserArquivo.showOpenDialog(chooserArquivo);
        if ( escolha == JFileChooser.CANCEL_OPTION ){ arquivo = ""; }
        else{ arquivo = chooserArquivo.getSelectedFile().getAbsolutePath(); }   
        return arquivo;        
    }    
        
    public void processamento(){
        try {
            importaDados(localizaArquivo());
        } catch (ParseException ex) {
            Logger.getLogger(ProcessaArq.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public boolean verificaConta(){
        boolean ok = false;
        if(banco.getConta().size() > 1){ ok = true; }
        return ok;
    }
    
    public boolean verificaRelatorioServicos(){
        boolean ok = false;
        if(banco.getRelatorioServicos().size() > 1){ ok = true; }
        return ok;
    }

}
