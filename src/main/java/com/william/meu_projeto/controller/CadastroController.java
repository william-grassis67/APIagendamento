package com.william.meu_projeto.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.service.CadastroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CadastroController {

    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @PostMapping("/register")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return cadastroService.registrarUsuario(usuario);
    }
}
