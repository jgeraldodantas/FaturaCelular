/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

/**
 *
 * @author geraldo.dantas
 */
public class Usuario {
    
    private String cidade;
    private String siape;
    private String nome;
    private long linha;
    private String tipo;
    private Double valor;

    public Usuario(String cidade, String siape, String nome, long linha, String tipo, Double valor) {
        this.cidade = cidade;
        this.siape = siape;
        this.nome = nome;
        this.linha = linha;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Usuario() {
        this.cidade = "";
        this.siape = "";
        this.nome = "";
        this.linha = 0;
        this.tipo = "";
        this.valor = 0.0;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getLinha() {
        return linha;
    }

    public void setLinha(long linha) {
        this.linha = linha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
