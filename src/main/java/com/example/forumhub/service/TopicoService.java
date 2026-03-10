package com.example.forumhub.service;

import com.example.forumhub.dto.TopicoResponseDTO;
import com.example.forumhub.dto.*;
import com.example.forumhub.model.*;
import com.example.forumhub.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository t,UsuarioRepository u,CursoRepository c){
        this.topicoRepository=t;
        this.usuarioRepository=u;
        this.cursoRepository=c;
    }

    public TopicoResponseDTO criar(TopicoRequestDTO dto, String email){

        com.example.forumhub.model.Usuario autor = usuarioRepository.findByEmail(email).orElseThrow();

        com.example.forumhub.model.Curso curso = cursoRepository.findById(dto.cursoId()).orElseThrow();

        Topico topico = Topico.builder()
                .titulo(dto.titulo())
                .mensagem(dto.mensagem())
                .autor(autor)
                .curso(curso)
                .build();

        topicoRepository.save(topico);

        return new TopicoResponseDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                autor.getNome(),
                curso.getNome()
        );
    }

    public List<TopicoResponseDTO> listar(){

        return topicoRepository.findAll()
                .stream()
                .map(t -> new TopicoResponseDTO(
                        t.getId(),
                        t.getTitulo(),
                        t.getMensagem(),
                        t.getDataCriacao(),
                        t.getAutor().getNome(),
                        t.getCurso().getNome()
                ))
                .toList();
    }

    public TopicoResponseDTO buscar(Long id){

        Topico t = topicoRepository.findById(id).orElseThrow();

        return new TopicoResponseDTO(
                t.getId(),
                t.getTitulo(),
                t.getMensagem(),
                t.getDataCriacao(),
                t.getAutor().getNome(),
                t.getCurso().getNome()
        );
    }

    public void deletar(Long id,String email){

        Topico t = topicoRepository.findById(id).orElseThrow();

        if(!t.getAutor().getEmail().equals(email)){
            throw new RuntimeException("Apenas o autor pode deletar");
        }

        topicoRepository.delete(t);
    }

}