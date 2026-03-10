package com.example.forumhub.model;

import jakarta.persistence.*;
import lombok.*;
import com.example.forumhub.model.Curso;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensagem;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    @PrePersist
    public void prePersist(){
        dataCriacao = LocalDateTime.now();
        status = StatusTopico.NAO_RESPONDIDO;
    }

}