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
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author geraldo.dantas
 */
public class Tratamento {

    public String conversaoHoraMinuto(String tempo){
        String str,m,s = new String();
        int hora,minuto,segundo,calc=0;
                
        hora = Integer.parseInt(tempo.split(":")[0]);
        minuto = Integer.parseInt(tempo.split(":")[1]);
        segundo = Integer.parseInt(tempo.split(":")[2]);
        calc = minuto + (hora * 60);
        
        // tartamento para garantir a entrega do tempo no formato 00m 00s
        if(calc<10){m = "0" + Integer.toString(calc) + "m "; }
        else{m = Integer.toString(calc) + "m "; }
        
        if(segundo<10){s = "0" + Integer.toString(segundo) + "s"; }
        else{s = Integer.toString(segundo) + "s"; }
        
        return m + s;
    }
    
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
   
    public String retornaTipo(int t, String origem, String destino){
        String tipo = new String();
        
        switch(t){
            case 0:  case 1:  case 2:  case 3:  {                 
              
            if(origem.isEmpty() || destino.isEmpty()){ tipo = "Roaming Indeterminado"; break; }
            else{
                if( origem.equals(destino) && (!origem.equals("DDD 35")) ){ tipo = "Roaming VC1"; break; }
                else{                   
                     if((origem.startsWith("DDD 03")) && (destino.startsWith("DDD 03")) &&
                        (!origem.equals("DDD 35"))  && (!destino.equals("DDD 35"))){ 
                         tipo = "Roaming VC2"; break; 
                     }
                     else{ 
                         if((origem.startsWith("DDD 03")) && (!origem.equals("DDD 35")) && 
                           (!destino.startsWith("DDD 03"))){
                            tipo = "Roaming VC3"; break;
                         }
                         else{ tipo = "Roaming Desconhecido"; break; }                        
                     }
                }
            }    
                
                
            /*    
                if(destino.equals("DDD 035")){ tipo = "Roaming VC1"; break; }
                else{                   
                     if(destino.contains("DDD 03")){ tipo = "Roaming VC2"; break; }
                     else{ tipo = "Roaming VC3"; break; }               
                }
            */    
            }
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

    
    public String somaTempo(String t1, String t2){            
      
        String[] tempo1, tempo2;
        String total = new String();
        int hora,minuto,segundo,h,m,s,resto = 0;
        
        tempo1 = t1.split(":");
        tempo2 = t2.split(":");
                
        hora  = Integer.parseInt(tempo1[0]) + Integer.parseInt(tempo2[0]);
        minuto = Integer.parseInt(tempo1[1]) + Integer.parseInt(tempo2[1]);
        segundo = Integer.parseInt(tempo1[2]) + Integer.parseInt(tempo2[2]);
        
        s = segundo % 60;
        resto = Math.abs(segundo/60);
        
        m = Math.abs((resto + minuto)%60);
        resto = Math.abs((resto + minuto)/60);
        
        h = resto + hora;
        
        // tartamento para garantir a entrega do tempo no formato 00:00:00
        tempo1 = new String[3];
        if(h<10){tempo1[0] = "0" + Integer.toString(h); }
        else{tempo1[0] = Integer.toString(h); }
        
        if(m<10){tempo1[1] = "0" + Integer.toString(m); }
        else{tempo1[1] = Integer.toString(m); }
        
        if(s<10){tempo1[2] = "0" + Integer.toString(s); }
        else{tempo1[2] = Integer.toString(s); }
        
        total = tempo1[0]+":"+tempo1[1]+":"+tempo1[2];  
        
        System.out.println(s+" - "+m+" = "+h);
        
        return total;   
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
    
    public String verificaNomeServico(ArrayList<Conta> lista){
        String servico = new String();
        
        for(int a=0; a<lista.size(); a++){
            if(!(lista.get(a).getDetalheServico().equals(""))){
                servico = lista.get(a).getDetalheServico();
                break;
            }
        }
        return servico;
    }
    
    
    public String verificaRoaming(){
        String tipo = new String();
        
        
        
        return tipo;
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
