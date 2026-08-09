package com.william.meu_projeto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.meu_projeto.model.SolicitacaoAgendamento;
import com.william.meu_projeto.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/agendamentos/{id}")
    public ResponseEntity<?> listarAgendamento(@PathVariable Long id) {
        List<SolicitacaoAgendamento> agendamento = usuarioService.listarAgendamentos(id);

        if (agendamento == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Nenhum agendamento encontrado"));
        }

        return ResponseEntity.ok(agendamento);
    }

    @PostMapping("/register/agendamento/{id}")
    public SolicitacaoAgendamento registrarAgendamento(@RequestBody SolicitacaoAgendamento agendamento,
            @PathVariable Long id) {
        return usuarioService.registrarAgendamento(agendamento, id);
    }

    @PutMapping("/cancel/{id}")
    public SolicitacaoAgendamento cancelarAgendamento(@PathVariable Long id){
        return usuarioService.cancelarAgendamento(id);
    }

}
