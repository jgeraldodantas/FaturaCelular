/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Control.Conta;
import Control.Tratamento;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author geraldo.dantas
 */
public class Banco {
    
    private ArrayList<Conta> conta;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Conta> relatorioServicos;
    private ArrayList<Usuario> relatorioConsumoUsuario;

    public Banco() {
        this.conta = new ArrayList<Conta>();
        this.usuarios = new ArrayList<Usuario>();
        this.relatorioServicos = new ArrayList<Conta>();
        this.relatorioConsumoUsuario = new ArrayList<Usuario>();
    }
        
    public Banco(ArrayList<Conta> conta, ArrayList<Conta> relatorioServicos, ArrayList<Usuario> usuario, ArrayList<Usuario> relatorioConsumoUsuario) {
        this.conta = conta;
        this.relatorioServicos = relatorioServicos;
        this.usuarios = usuario;
        this.relatorioConsumoUsuario = relatorioConsumoUsuario;
    }
                    
    public void cadastro(Conta dados){
        this.conta.add(dados);
    }
    
    public void cadastroUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }
    
    public void organizaConsumoUsuarios(){
        ArrayList listaUsuario = new ArrayList<Usuario>();
        Usuario user;
        Double soma;
        
        // numero(linha) - plano(V/VD/M) - valor
        for(int a=0;a<this.usuarios.size();a++){
            soma = 0.0;
            user = new Usuario();
            
            for(int b=0;b<this.conta.size();b++){                
                if(String.valueOf(this.conta.get(b).getTelefoneOrigem()).equals(String.valueOf(this.usuarios.get(a).getLinha()))){                    
                    soma += this.conta.get(b).getValor();                    
                }                
            }
            user.setCidade(usuarios.get(a).getCidade());
            user.setSiape(usuarios.get(a).getSiape());
            user.setNome(usuarios.get(a).getNome());
            user.setLinha(usuarios.get(a).getLinha());
            user.setTipo(usuarios.get(a).getTipo());
            user.setValor(soma);
            listaUsuario.add(user);
        }
        this.setRelatorioConsumoUsuario(listaUsuario);
    }
    
    
    
    
    public ArrayList<Conta> organizaFatura(int indexConta, String descricao, String tipo, ArrayList<Conta> lista){ 
        Conta resumo;
        boolean ok = false;
        Tratamento tempo = new Tratamento();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                
        for(int a=0; a < lista.size();a++){
            if(lista.get(a).getDescricaoServico().equals(descricao) && lista.get(a).getTipo().equals(tipo)){   
               resumo = new Conta();
               resumo.setDuracao(tempo.somaTempo(this.conta.get(indexConta).getDuracao(), lista.get(a).getDuracao()));
               resumo.setValor(this.conta.get(indexConta).getValor() + lista.get(a).getValor());
               resumo.setDetalheServico(this.conta.get(indexConta).getDetalheServico());
               resumo.setDescricaoServico(descricao);
               
               resumo.setTipo(tipo);
               lista.set(a,resumo); 
               ok = true;
               break;
            }         
        }
        
        if(!ok){
            resumo = new Conta();
            resumo.setDuracao(tempo.somaTempo(this.conta.get(indexConta).getDuracao(), lista.get(0).getDuracao()));
            resumo.setDetalheServico(this.conta.get(indexConta).getDetalheServico());
            resumo.setValor(this.conta.get(indexConta).getValor());          
            resumo.setDescricaoServico(descricao);   
               
            resumo.setTipo(tipo);
            lista.add(resumo);                    
        }          
        
        return lista;
    }
      
    public ArrayList<Conta> recuperaDados(){
       return this.conta;
    }
        
    public void relatorioServicos(){
        String descricao;
        String tipo;
        String areaDestino;
        Conta servico = new Conta();
        Tratamento item = new Tratamento(); 
        ArrayList<Conta> listaFatura = new ArrayList<Conta>();
        listaFatura.add(servico);
        
    /*    
        ArrayList<String> lista = new ArrayList<String>();
        for(int indiceConta=0; indiceConta<=conta.size()-1;indiceConta++){
            descricao = this.conta.get(indiceConta).getDescricaoServico() + this.conta.get(indiceConta).getDestinoServico();
            if(!lista.contains(descricao)){
                lista.add(descricao);
                System.out.println(descricao);
            }
        }
    */
    
        for(int indiceConta=0; indiceConta <= this.conta.size()-1;indiceConta++){
            int indiceRelatorio = 0;
            tipo = new String();
            descricao = new String();
            areaDestino = new String();
            
            areaDestino = this.conta.get(indiceConta).getDestino();
            descricao = this.conta.get(indiceConta).getDescricaoServico() + this.conta.get(indiceConta).getDestinoServico();
            descricao.trim();
            
            switch(descricao){
                // ****************************** Cobrança tipo Roaming ******************************
                case "Ligacoes de Longa Distancia Para Celulares Vivo":{  
                    indiceRelatorio = 0;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);                    
                    break;
                }
                
                case "Ligacoes de Longa Distancia Para Celulares de Outras Operadoras":{   
                    indiceRelatorio = 1;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Ligacoes de Longa Distancia Para Fixo Vivo":{     
                    indiceRelatorio = 2;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Ligacoes de Longa Distancia Para Fixo de Outras Operadoras":{ 
                    indiceRelatorio = 3;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                                
                // ****************************** Cobrança tipo VC1 ******************************
                case "Ligacoes Locais Para Celulares Vivo":{   
                    indiceRelatorio = 4;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Ligacoes Locais Para Celulares de Outras Operadoras":{ 
                    indiceRelatorio = 5;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Ligacoes Locais Para Fixo Vivo":{       
                    indiceRelatorio = 6;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Ligacoes Locais Para Fixo de Outras Operadoras":{  
                    indiceRelatorio = 7;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                
                // ****************************** Cobrança tipo VC2 ******************************
                case "Para Dentro do Estado Para Celulares Vivo":{ 
                    indiceRelatorio = 8;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Dentro do Estado Para Celulares de Outras Operadoras":{
                    indiceRelatorio = 9; 
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Dentro do Estado Para Fixo Vivo":{     
                    indiceRelatorio = 10;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Dentro do Estado Para Fixo de Outras Operadoras":{  
                    indiceRelatorio = 11;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                
                // ****************************** Cobrança tipo VC3 ******************************
                case "Para Outros Estados Para Celulares Vivo":{         
                    indiceRelatorio = 12;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Outros Estados Para Celulares de Outras Operadoras":{  
                    indiceRelatorio = 13;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Outros Estados Para Fixo Vivo":{            
                    indiceRelatorio = 14;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Para Outros Estados Para Fixo de Outras Operadoras":{     
                    indiceRelatorio = 15; 
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                // ****************************** Cobrança tipo SMS ******************************
                case "Torpedo SMS":{              
                    indiceRelatorio = 16;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Torpedo SMS para Outros Servicos":{             
                    indiceRelatorio = 17;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                // ****************************** Cobrança Não Assinado ******************************
                              
                case "Internet Movel - Vivo Wap":{      
                    indiceRelatorio = 18;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                     
                // ****************************** Cobrança Assinatura Intragrupo ******************************
                  
                case "Ligacoes Locais Para Grupo":{      
                    indiceRelatorio = 19;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Internet Movel":{              
                    indiceRelatorio = 20; 
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                      
                // ****************************** Cobrança Utilização Acima do Contratado ******************************
               
                case "Acesso Caixa Postal":{         
                    indiceRelatorio = 21;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                
                case "Adicional por Ligacoes Realizadas":{          
                    indiceRelatorio = 22;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                case "Adicional por Ligacoes Recebidas":{      
                    indiceRelatorio = 23;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                                                       
                case "Ligacoes Recebidas em Roaming":{            
                    indiceRelatorio = 24;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }
                
                // ****************************** Cobrança tipo "A Cobrar" ******************************
                
                case "Ligacoes Recebidas a Cobrar De Celulares Vivo":{   
                    indiceRelatorio = 25;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }  
                
                case "Recebidas a Cobrar de Outro DDD De Celulares Vivo":{   
                    indiceRelatorio = 26;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }  
                
                // ****************************** Cobrança Não Específica (Em branco)" ******************************
              
                case "": case " ":{      
                    indiceRelatorio = 27;
                    listaFatura = organizaFatura(indiceConta, descricao, item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);
                    break;
                }  
                                
                default:{                 
                    indiceRelatorio = 28;
                    listaFatura = organizaFatura(indiceConta, descricao ,item.retornaTipo(indiceRelatorio,areaDestino),listaFatura);}
            }// switch        
        
        }// for
        this.setRelatorioServicos(listaFatura);
    }

    public Double somaValor(String descricao, int indexFatura, int indexConta){
        Double valor = 0.0;        
        valor = this.conta.get(indexConta).getValor() + this.relatorioServicos.get(indexFatura).getValor();
        return valor;
    }
        
    public ArrayList<Conta> getConta() {
        return this.conta;
    }

    public void setConta(ArrayList<Conta> conta) {
        this.conta = conta;
    }

    public ArrayList<Conta> getRelatorioServicos() {
        return this.relatorioServicos;
    }

    public void setRelatorioServicos(ArrayList<Conta> relatorioServicos) {
        this.relatorioServicos = relatorioServicos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Usuario> getRelatorioConsumoUsuario() {
        return this.relatorioConsumoUsuario;
    }

    public void setRelatorioConsumoUsuario(ArrayList<Usuario> relatorioConsumoUsuario) {
        this.relatorioConsumoUsuario = relatorioConsumoUsuario;
    }
    
    
    
}
