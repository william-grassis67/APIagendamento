package com.william.meu_projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.william.meu_projeto.dto.UsuarioDTO;
import com.william.meu_projeto.enums.StatusAgendamento;
import com.william.meu_projeto.exceptions.AgendamentoExistenteException;
import com.william.meu_projeto.model.SolicitacaoAgendamento;
import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.repository.AgendamentoRepository;
import com.william.meu_projeto.repository.UsuarioRepository;

@Service
public class AdminService {
    private final UsuarioRepository usuarioRepository;
    private final AgendamentoRepository agendamentoRepository;

    public AdminService(UsuarioRepository usuarioRepository, AgendamentoRepository agendamentoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public List<UsuarioDTO> listarUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioDTO> usuario = usuarios.stream()
                .map(u -> new UsuarioDTO(u.getNome(), u.getEmail(), u.getSolicitacaoAgendamentos()))
                .collect(Collectors.toList());

        for (Usuario u : usuarioRepository.findAll()) {
            System.out.println("=====================");
            System.out.println("Nome: " + u.getNome());
            System.out.println("Email: " + u.getEmail());
            System.out.println("======================");
        }

        return usuario;
    }

    //LISTAR AGENDAMENTOS DO SALÃO

    public List<SolicitacaoAgendamento> listarTodosAgendamentos(){
        return agendamentoRepository.findAll();
    }

    //ALTERAR status

    public SolicitacaoAgendamento mudarStatus(StatusAgendamento status, Long id){
        SolicitacaoAgendamento agendamento = agendamentoRepository.findById(id)
            .orElseThrow(() -> new AgendamentoExistenteException("Agendamento inexistente"));

        agendamento.setStatus(status);
        agendamentoRepository.save(agendamento);

        return agendamento;
    }





}
