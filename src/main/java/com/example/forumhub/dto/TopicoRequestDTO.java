package com.example.forumhub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRequestDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        Long cursoId

) {}