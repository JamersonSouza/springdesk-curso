package tech.jamersondev.springdesk.model;

import java.time.LocalDate;

import tech.jamersondev.springdesk.Enums.Prioridade;
import tech.jamersondev.springdesk.Enums.Status;

public class Chamado {

    private Integer id;
    private String titulo;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataFechamento;
    private String observacao;
    private Status status;
    private Prioridade prioridade;

    public Chamado(){}
    
    public Chamado(Integer id, String titulo, LocalDate dataAbertura, LocalDate dataFechamento, String observacao,
            Status status, Prioridade prioridade) {
        this.id = id;
        this.titulo = titulo;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.observacao = observacao;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public LocalDate getDataFechamento() {
        return dataFechamento;
    }
    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    
    
}
