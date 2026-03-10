package com.example.forumhub.dto;

import java.time.LocalDateTime;

public record TopicoResponseDTO(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        String curso

) {}