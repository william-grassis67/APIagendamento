package com.william.meu_projeto.service;

//import java.util.List;

import org.springframework.stereotype.Service;

//import java.util.List;
//import java.util.stream.Collector;

import com.william.meu_projeto.dto.UsuarioDTO;
import com.william.meu_projeto.enums.TipoUsuario;
import com.william.meu_projeto.exceptions.CampoInvalidoException;
import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.repository.UsuarioRepository;

@Service
public class CadastroService {
    private final UsuarioRepository usuarioRepository;

    public CadastroService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // REGISTRAR USUARIO
    public Usuario registrarUsuario(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();

        if (usuario.getEmail() == null) {
            throw new CampoInvalidoException("O campo de email esta incorreto");
        } else {
            // System.out.println("O usuario " + usuario.getNome() + " foi cadastrado");
            System.out.println("Email recebido: " + usuario.getEmail());
            System.out.println("Usuario recebido: " + usuario.getNome());
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new CampoInvalidoException("Não foi possivel se cadastrar nesse email!");
        }

        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setAgendamentos(usuario.getSolicitacaoAgendamentos());
        usuario.setTipo(TipoUsuario.USUARIO);
        usuarioRepository.save(usuario);
        return usuario;
    }

}
