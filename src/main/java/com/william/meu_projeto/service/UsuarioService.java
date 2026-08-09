package com.william.meu_projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.william.meu_projeto.enums.StatusAgendamento;
import com.william.meu_projeto.exceptions.AgendamentoExistenteException;
import com.william.meu_projeto.exceptions.CampoInvalidoException;
import com.william.meu_projeto.model.SolicitacaoAgendamento;
import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.repository.AgendamentoRepository;
import com.william.meu_projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final AgendamentoRepository agendamentoRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(AgendamentoRepository agendamentoRepository, UsuarioRepository usuarioRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // REGISTRAR AGENDAMENTO
    public SolicitacaoAgendamento registrarAgendamento(SolicitacaoAgendamento agendamento, Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CampoInvalidoException("Não foi possivel encontrar o usuario"));

        boolean existe = agendamentoRepository.existsByDataAndHorarioAndProfissional(agendamento.getData(),
                agendamento.getHorario(),
                agendamento.getProfissional());

        if (existe) {
            throw new AgendamentoExistenteException("Agendamento ja existente");
        }

        if (agendamento.getData() == null || agendamento.getData().trim().isEmpty()
                || agendamento.getHorario() == null || agendamento.getHorario().trim().isEmpty()
                || agendamento.getProfissional() == null
                || agendamento.getServico() == null || agendamento.getServico().trim().isEmpty()) {

            throw new CampoInvalidoException("Os campos não podem ser vazios");
        }

        agendamento.setStatus(StatusAgendamento.SOLICITADO);
        agendamento.setCliente(usuario);
        agendamentoRepository.save(agendamento);

        return agendamento;
    }

    // LISTAR AGENDAMENTOS
    public List<SolicitacaoAgendamento> listarAgendamentos(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CampoInvalidoException("Usuario não encontrado"));

        // agendamentoRepository.findAll();
        return usuario.getSolicitacaoAgendamentos();
    }

    // CANCELAR AGENDAMENTO
    public SolicitacaoAgendamento cancelarAgendamento(Long id) {
        SolicitacaoAgendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new CampoInvalidoException("Agendamento inexistente"));

        agendamento.setStatus(StatusAgendamento.CANCELADO);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }
}
