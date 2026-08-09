package com.william.meu_projeto.model;

import java.util.List;

import com.william.meu_projeto.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<SolicitacaoAgendamento> solicitacaoAgendamentos;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario(String nome, String email, String senha, Long id, TipoUsuario tipo,
            List<SolicitacaoAgendamento> solicitacaoAgendamentos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.id = id;
        this.tipo = tipo;
        this.solicitacaoAgendamentos = solicitacaoAgendamentos;
    }

    public Usuario() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return this.id;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public List<SolicitacaoAgendamento> getSolicitacaoAgendamentos() {
        return this.solicitacaoAgendamentos;
    }

    public void setSolicitacaoAgendamento(List<SolicitacaoAgendamento> solicitacaoAgendamentos) {
        this.solicitacaoAgendamentos = solicitacaoAgendamentos;
    }
}
