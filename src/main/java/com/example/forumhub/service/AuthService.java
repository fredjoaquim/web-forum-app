package com.example.forumhub.service;

import com.example.forumhub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public com.example.forumhub.model.Usuario autenticar(String email, String senha){

        com.example.forumhub.model.Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow();

        if(!usuario.getSenha().equals(senha)){
            throw new RuntimeException("Senha inválida");
        }

        return usuario;
    }

}