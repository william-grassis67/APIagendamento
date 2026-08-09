package com.william.meu_projeto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.meu_projeto.dto.UsuarioDTO;
import com.william.meu_projeto.model.SolicitacaoAgendamento;
import com.william.meu_projeto.service.AdminService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/users")
    public List<UsuarioDTO> login() {
        return adminService.listarUsuario();
    }

    @GetMapping("/agendamentos")
    public List<SolicitacaoAgendamento> listarAgendamentos() {
        return adminService.listarTodosAgendamentos();
    }
}
