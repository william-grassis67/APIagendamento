package com.william.meu_projeto.service;

import org.springframework.stereotype.Service;

//import java.util.List;

//import com.william.meu_projeto.dto.LoginResponseDTO;
import com.william.meu_projeto.exceptions.CampoInvalidoException;
import com.william.meu_projeto.exceptions.UsuarioNaoEncontradoException;
import com.william.meu_projeto.model.Login;
import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.repository.UsuarioRepository;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
        return usuario;
    }

    public Login newLogin(Login login) {
        if (login.getEmail().trim().isEmpty() || login.getSenha().trim().isEmpty()) {
            System.out.println("===================================");
            System.out.println("senha e email não pode ser vazios!");
            System.out.println("====================================");
        }

        Usuario usuario = usuarioRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Não foi possivel encontrar o usuario"));

        if (login.getEmail().equals(usuario.getEmail()) && login.getSenha().equals(usuario.getSenha())) {
            System.out.println("====================================");
            System.out.println("O login foi efetudo com sucesso");
            System.out.println("Email recebido: " + login.getEmail());
            System.out.println("usuario recebdio: " + usuario.getNome());
            System.out.println("tipo de usuario: " + usuario.getTipo());
            System.out.println("====================================");
        } else {
            throw new CampoInvalidoException("senha ou email incorretos!");
        }
        return login;
    }
}
