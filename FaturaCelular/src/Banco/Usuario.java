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
    private long numero;
    private String siape;
    private String tipo;
    private String usuario;

    public Usuario(String cidade, long numero, String siape, String tipo, String usuario) {
        this.cidade = cidade;
        this.numero = numero;
        this.siape = siape;
        this.tipo = tipo;
        this.usuario = usuario;
    }
    
    public Usuario() {
        this.cidade = "";
        this.numero = 0;
        this.siape = "";
        this.tipo = "";
        this.usuario = "";
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
     
}
