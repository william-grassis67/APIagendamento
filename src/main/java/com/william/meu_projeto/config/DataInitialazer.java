package com.william.meu_projeto.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.william.meu_projeto.enums.TipoUsuario;
import com.william.meu_projeto.model.Usuario;
import com.william.meu_projeto.repository.UsuarioRepository;

@Configuration
public class DataInitialazer {
    @Bean
    CommandLineRunner criarAdmin(UsuarioRepository usuarioRepository){
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario usuario = new Usuario();
                usuario.setNome("William");
                usuario.setEmail("william@gmail.com");
                usuario.setSenha("abelhuda123");
                usuario.setTipo(TipoUsuario.ADMIN);
                usuarioRepository.save(usuario);
                System.out.print("Criando administrador");
            }
        };
    }
}
