package com.william.meu_projeto.dto;

import java.util.List;

import com.william.meu_projeto.model.SolicitacaoAgendamento;

public class UsuarioDTO {
    private String nome;
    private String email;
    private List<SolicitacaoAgendamento> agendamentos;

    public UsuarioDTO(String nome, String email, List<SolicitacaoAgendamento> agendamentos) {
        this.email = email;
        this.nome = nome;
        this.agendamentos = agendamentos;
    }

    public UsuarioDTO() {

    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<SolicitacaoAgendamento> getAgendamentos() {
        return this.agendamentos;
    }

    public void setAgendamentos(List<SolicitacaoAgendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
