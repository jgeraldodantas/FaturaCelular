/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Date;

/**
 *
 * @author geraldo.dantas
 */
public class Conta {
    
    private long numConta;
    private long telefoneOrigem;
    private String detalheServico;    
    private String descricaoServico;
    private String destinoServico;
    private String dataLigacao;
    private Date horaInicio;
    private String destino;
    private String telefoneChamado;
    private String tarifa;
    private String duracao;
    private String operadoraDestino;
    private String origem;
    private String tipoChamada;
    private String servico;
    private String unidade;
    private String referencia;
    private Double valor;
    private String tipo; // variavel extra, não consta na fatura. Utilizada para agrupar os serviços em comum para medição 
    private Double diferenca;

    public Conta(long numConta, long telefoneOrigem, String detalheServico, String descricaoServico, String destinoServico, String dataLigacao, Date horaInicio, String destino, String telefoneChamado, String tarifa, String duracao, String operadoraDestino, String origem, String tipoChamada, String servico, String unidade, String referencia, Double valor, String tipo, Double diferenca) {
        this.numConta = numConta;
        this.telefoneOrigem = telefoneOrigem;
        this.detalheServico = detalheServico;
        this.descricaoServico = descricaoServico;
        this.destinoServico = destinoServico;
        this.dataLigacao = dataLigacao;
        this.horaInicio = horaInicio;
        this.destino = destino;
        this.telefoneChamado = telefoneChamado;
        this.tarifa = tarifa;
        this.duracao = duracao;
        this.operadoraDestino = operadoraDestino;
        this.origem = origem;
        this.tipoChamada = tipoChamada;
        this.servico = servico;
        this.unidade = unidade;
        this.referencia = referencia;
        this.valor = valor;
        this.tipo = tipo;
        this.diferenca = diferenca;
    }

    public Conta() {
        this.numConta = 0;
        this.telefoneOrigem = 0;
        this.detalheServico = "";
        this.descricaoServico = "";
        this.destinoServico = "";
        this.dataLigacao = "";
        this.horaInicio = new Date();
        this.destino = "";
        this.telefoneChamado = "";
        this.tarifa = "";
        this.duracao = "00:00:00";
        this.operadoraDestino = "";
        this.origem = "";
        this.tipoChamada = "";
        this.servico = "";
        this.unidade = "";
        this.referencia = "";
        this.valor = 0.0;
        this.tipo = "";
        this.diferenca = 0.0;
    }

    public long getNumConta() {
        return numConta;
    }

    public void setNumConta(long numConta) {
        this.numConta = numConta;
    }

    public long getTelefoneOrigem() {
        return telefoneOrigem;
    }

    public void setTelefoneOrigem(long telefoneOrigem) {
        this.telefoneOrigem = telefoneOrigem;
    }

    public String getDetalheServico() {
        return detalheServico;
    }

    public void setDetalheServico(String detalheServico) {
        this.detalheServico = detalheServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getDestinoServico() {
        return destinoServico;
    }

    public void setDestinoServico(String destinoServico) {
        this.destinoServico = destinoServico;
    }

    public String getDataLigacao() {
        return dataLigacao;
    }

    public void setDataLigacao(String dataLigacao) {
        this.dataLigacao = dataLigacao;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTelefoneChamado() {
        return telefoneChamado;
    }

    public void setTelefoneChamado(String telefoneChamado) {
        this.telefoneChamado = telefoneChamado;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getOperadoraDestino() {
        return operadoraDestino;
    }

    public void setOperadoraDestino(String operadoraDestino) {
        this.operadoraDestino = operadoraDestino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTipoChamada() {
        return tipoChamada;
    }

    public void setTipoChamada(String tipoChamada) {
        this.tipoChamada = tipoChamada;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getDiferenca() {
        return diferenca;
    }

    public void setDiferenca(Double diferenca) {
        this.diferenca = diferenca;
    }
    
    
}
