/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author geraldo.dantas
 */
public class Tratamento {
    
    public String converteCodificacaoArq(String caminho) throws FileNotFoundException, UnsupportedEncodingException, IOException{ 
        String dados = new String();
        String linha = new String();
        String file = new String();
        String separador = new String();
        String[] vetor;
        vetor = caminho.split(".CSV");
        file = vetor[0]+".txt";
                
        BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho),"ISO-8859-1"));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        
        while(arq.ready()){         
            vetor = new String[20];
            separador = verificaSeparador(arq.readLine());
            linha = arq.readLine();
            linha = linha+separador;           
            saida.append(linha+"\n");
        } 
        saida.close();
        arq.close();
        return file;
    }
    
        
    public String removeCaracteres(String texto){
        
        texto = texto.replaceAll("Á","A");   texto = texto.replaceAll("Â","A");   texto = texto.replaceAll("Ã","A");   texto = texto.replaceAll("À","A");
        texto = texto.replaceAll("É","E");   texto = texto.replaceAll("Ê","E");   
        texto = texto.replaceAll("Í","I");   
        texto = texto.replaceAll("Ó","O");   texto = texto.replaceAll("Ô","O");   texto = texto.replaceAll("Õ","O");
        texto = texto.replaceAll("Ú","U");      
        texto = texto.replaceAll("Ç","C");        
        
        texto = texto.replaceAll("á","a");   texto = texto.replaceAll("â","a");   texto = texto.replaceAll("ã","a");   texto = texto.replaceAll("à","a");
        texto = texto.replaceAll("é","e");   texto = texto.replaceAll("ê","e");   
        texto = texto.replaceAll("í","i");   
        texto = texto.replaceAll("ó","o");   texto = texto.replaceAll("ô","o");   texto = texto.replaceAll("õ","o");
        texto = texto.replaceAll("ú","u");      
        texto = texto.replaceAll("ç","c");
        
        texto = texto.replace("Acesso a Caixa Postal", "Acesso Caixa Postal");
        texto = texto.replace("Torpedo SMS para Outros Servicos", "Torpedo SMS");
        
        return texto;
    }
    
    public String removeEspaco(String texto){ 
        //verifica se termina com espaço e remove 
        while(texto.endsWith(" ")){ texto = texto.trim(); }
        return texto;
    }
   
    public String retornaTipo(int t){
        String tipo = new String();
        
        switch(t){
            case 0:  case 1:  case 2:  case 3:  { tipo = "Roaming"; break; }
            case 4:  case 5:  case 6:  case 7:  { tipo = "VC1"; break; }
            case 8:  case 9:  case 10: case 11: { tipo = "VC2"; break; }
            case 12: case 13: case 14: case 15: { tipo = "VC3"; break; }
            case 16: case 17: { tipo = "SMS"; break; }
            case 18: { tipo = "Serviço Não Contratado"; break; }
            case 19: case 20:{ tipo = "Assinatura"; break; }
            case 21: case 22: case 23: case 24:{ tipo = "Não Específico"; break; }
            case 25: case 26: { tipo = "Ligações Recebidas à Cobrar"; break; }
            case 27: case 28: { tipo = "Indeterminado na fatura"; break; }
        }        
        return tipo;
    }
  
    public String somaTempo(String v, String v2){
        GregorianCalendar gc = new GregorianCalendar();   
  
        int hora = Integer.parseInt(v.substring(0,2));
        int min = Integer.parseInt(v.substring(3,5));
        int seg = Integer.parseInt(v.substring(6,8));
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");   
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");   
        Time time = new Time(hora, min, seg);           
        gc.setTimeInMillis(time.getTime());   
        
        hora = Integer.parseInt(v2.substring(0,2));
        min = Integer.parseInt(v2.substring(3,5));
        seg = Integer.parseInt(v2.substring(6,8));
        
        gc.add(Calendar.HOUR,hora);
        gc.add(Calendar.MINUTE,min);
        gc.add(Calendar.SECOND,seg);  
        
        return sdf2.format(gc.getTime());
    }
    
    public String trataTempo(String tempo) throws ParseException{
        SimpleDateFormat horario = new SimpleDateFormat("hh:mm:ss"); 
        Date duracao = new Date(); 
    
        if(!tempo.isEmpty()){
            tempo = tempo.replace("h", "");
            tempo = tempo.replace("m", "");
            tempo = tempo.replace("s", "");
        }
        else {tempo = "00:00:00";}
           
    //    duracao = horario.parse(tempo);
        return tempo;
    }
            
    public Double trataValor(String v17){
        Double valor = 0.0;         
        valor = Double.parseDouble(v17.replace(",","."));        
        return valor;
    }
    
    public String verificaSeparador(String linha){
        String separador = new String();
        
        if(linha.contains(";")){
            separador = ";";
        }
        else{separador = ",";}
        
        return separador;
    }
    
    
}
