package br.com.fiap.exercicio.controller;

import br.com.fiap.exercicio.dto.CadastroComentarioDTO;
import br.com.fiap.exercicio.dto.DetalhesComentarioDTO;
import br.com.fiap.exercicio.dto.DetalhesPostDTO;
import br.com.fiap.exercicio.model.Comentario;
import br.com.fiap.exercicio.repository.ComentarioRepository;
import br.com.fiap.exercicio.repository.PostRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping
public class ComentarioController {
    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private PostRepository postRepository;

    //POST
    @PostMapping("/posts/{codigo}/comentarios")
    @Transactional
    public ResponseEntity<DetalhesComentarioDTO> create(@RequestBody @Valid @PathVariable("codigo") Long codigo, CadastroComentarioDTO dto, UriComponentsBuilder url){
        var post = postRepository.getReferenceById(codigo);
        var comentario = new Comentario(dto, post);
        comentarioRepository.save(comentario);
        var uri = url.path("/posts/{codigo}/comentarios/{id}").buildAndExpand(post.getCodigo(), comentario.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesComentarioDTO(comentario,new DetalhesPostDTO(post)));
    }
}
