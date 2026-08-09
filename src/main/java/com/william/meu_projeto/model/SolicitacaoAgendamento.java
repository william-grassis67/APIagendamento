package com.william.meu_projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.william.meu_projeto.enums.StatusAgendamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamentos")
public class SolicitacaoAgendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario cliente;
    private String servico;
    private String profissional;
    private String data;
    private String horario;
    private StatusAgendamento status;

    public SolicitacaoAgendamento(Long id, Usuario cliente, String servico, String profissional, String data,
            String horario, StatusAgendamento status) {
        this.id = id;
        this.cliente = cliente;
        this.servico = servico;
        this.profissional = profissional;
        this.data = data;
        this.horario = horario;
        this.status = status;
    }

    public SolicitacaoAgendamento() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return this.cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getServico() {
        return this.servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getProfissional() {
        return this.profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public StatusAgendamento getStatus() {
        return this.status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}
