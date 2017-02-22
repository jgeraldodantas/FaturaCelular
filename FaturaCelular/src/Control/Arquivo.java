/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Objeto.Conta;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**
 *
 * @author geraldo.dantas
 */


public class Arquivo {
    

    public void importaDados(String caminho) throws ParseException{
        
        try{
            int cont = 0;
            String[] vetor = new String[20]; 
            String linha = new String();
            Conta conta = new Conta();    
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho),"ISO-8859-1"));              
                     
            arq.readLine();
            while(arq.ready()){         
                conta = new Conta(); 
                vetor = new String[20];
                
                linha = arq.readLine();
                linha = linha+";";           
                vetor = linha.split(";",-1);   
                                               
                conta.setNumConta(Long.parseLong(vetor[0]));
                conta.setTelefoneOrigem(Long.parseLong(vetor[1]));
                conta.setDetalheServico(vetor[2]);
                conta.setDescricaoServico(vetor[3]);
                conta.setDestinoServico(vetor[4]);     
                conta.setDataLigacao(vetor[5]);  
                conta.setHoraInicio(trataTempo(vetor[6]));   
                conta.setDestino(vetor[7]);
                conta.setTelefoneChamado(vetor[8]);
                conta.setTarifa(vetor[9]);
                conta.setDuracao(trataTempo(vetor[10]));
                conta.setOperadoraDestino(vetor[11]);                    
                conta.setOrigem(vetor[12]);
                conta.setTipoChamada(vetor[13]);
                conta.setServico(vetor[14]);
                conta.setUnidade(vetor[15]);
                conta.setReferencia(vetor[16]);                             
                conta.setValor(trataValor(vetor[17]));
                
            /*  
                System.out.println(" ------------------- \n");
                System.out.println(conta.getNumConta());
                System.out.println(conta.getTelefoneOrigem());
                System.out.println(conta.getDetalheServico());
                System.out.println(conta.getDescricaoServico());
                System.out.println(conta.getDestinoServico());                    
                System.out.println(conta.getDataLigacao()); 
                System.out.println(conta.getHoraInicio());                    
                System.out.println(conta.getDestino());
                System.out.println(conta.getTelefoneChamado());
                System.out.println(conta.getTarifa());
                System.out.println(conta.getDuracao());
                System.out.println(conta.getOperadoraDestino());                    
                System.out.println(conta.getOrigem());
                System.out.println(conta.getTipoChamada());
                System.out.println(conta.getServico());
                System.out.println(conta.getUnidade());
                System.out.println(conta.getReferencia());
                System.out.println(conta.getValor());
                
                cont++;
            */    
            }
            arq.close();
        //    System.out.println("Contador: "+ cont + " linhas");
        }catch(IOException ioe){
                ioe.printStackTrace();
        } 
               
    };
    
    public String localizaArquivo(){
        int escolha = 0;
        String arquivo = new String();        
        JFileChooser chooserArquivo = new JFileChooser();
        
        escolha = chooserArquivo.showOpenDialog(chooserArquivo);
        arquivo = chooserArquivo.getSelectedFile().getAbsolutePath();
      
        return arquivo;        
    }    
        
    public void processamento(){
        
        try {
            importaDados(localizaArquivo());
        } catch (ParseException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Date trataTempo(String tempo) throws ParseException{
        SimpleDateFormat horario = new SimpleDateFormat("hh:mm:ss"); 
        Date duracao = new Date(); 
    
        if(!tempo.isEmpty()){
            tempo = tempo.replace("h", "");
            tempo = tempo.replace("m", "");
            tempo = tempo.replace("s", "");
        }
        else {tempo = "00:00:00";}
           
        duracao = horario.parse(tempo);
        return duracao;
    }
    
    public Double trataValor(String v17){
        Double valor = 0.0;         
        valor = Double.parseDouble(v17.replace(",","."));        
        return valor;
    }
    
}
