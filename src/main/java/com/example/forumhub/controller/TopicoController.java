package com.example.forumhub.controller;

import com.example.forumhub.dto.*;
import com.example.forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService service;

    public TopicoController(TopicoService service){
        this.service=service;
    }

    @PostMapping
    public TopicoResponseDTO criar(
            @RequestBody @Valid TopicoRequestDTO dto,
            Authentication auth){

        return service.criar(dto,auth.getName());
    }

    @GetMapping
    public List<TopicoResponseDTO> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public TopicoResponseDTO detalhar(@PathVariable Long id){
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id,Authentication auth){
        service.deletar(id,auth.getName());
    }

}