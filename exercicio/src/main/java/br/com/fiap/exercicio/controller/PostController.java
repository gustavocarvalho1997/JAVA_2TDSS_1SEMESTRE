package br.com.fiap.exercicio.controller;

import br.com.fiap.exercicio.dto.CadastroPostDTO;
import br.com.fiap.exercicio.dto.DetalhesPostDTO;
import br.com.fiap.exercicio.model.Post;
import br.com.fiap.exercicio.repository.PostRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPostDTO> cadastrar(@RequestBody @Valid CadastroPostDTO dto, UriComponentsBuilder uri){
        var post = new Post(dto);
        postRepository.save(post);
        var url = uri.path("/posts/{id}").buildAndExpand(post.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPostDTO(post));
    }// POST
}// CLASS