package com.example.forumhub.controller;

import com.example.forumhub.dto.LoginDTO;
import com.example.forumhub.dto.TokenDTO;
import com.example.forumhub.security.JwtTokenService;

import com.example.forumhub.model.Usuario;

import com.example.forumhub.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenService tokenService;

    public AuthController(AuthService authService, JwtTokenService tokenService){
        this.authService=authService;
        this.tokenService=tokenService;
    }

    @PostMapping
    public TokenDTO login(@RequestBody LoginDTO dto){

        Usuario usuario = authService.autenticar(dto.email(),dto.senha());

        String token = tokenService.generateToken(usuario);

        return new TokenDTO(token);
    }

}