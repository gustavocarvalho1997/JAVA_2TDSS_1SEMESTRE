package br.com.fiap.exercicio.controller;

import br.com.fiap.exercicio.dto.AtualizacaoPostDTO;
import br.com.fiap.exercicio.dto.CadastroPostDTO;
import br.com.fiap.exercicio.dto.DetalhesPostDTO;
import br.com.fiap.exercicio.dto.ListagemPostDTO;
import br.com.fiap.exercicio.model.Post;
import br.com.fiap.exercicio.repository.PostRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesPostDTO> create(@RequestBody @Valid CadastroPostDTO dto,
                                                  UriComponentsBuilder uriBuilder) {
        var post = new Post(dto);
        postRepository.save(post);
        var url = uriBuilder.path("/posts/{id}").buildAndExpand(post.getCodigo()).toUri();
        return ResponseEntity.created(url).body(new DetalhesPostDTO(post));
    }// POST

    @GetMapping
    public ResponseEntity<List<ListagemPostDTO>> listar(Pageable paginacao){
        var lista = postRepository.findAll(paginacao).stream().map(ListagemPostDTO::new).toList();
        return ResponseEntity.ok(lista);
    }// GET ALL

    @GetMapping("/{codigo}")
    public ResponseEntity<DetalhesPostDTO> pesquisar(@PathVariable("codigo") Long codigo){
        var post = postRepository.getReferenceById(codigo);
        return ResponseEntity.ok(new DetalhesPostDTO(post));
    }// GET ID

    @PutMapping("/{codigo}")
    @Transactional
    public ResponseEntity<DetalhesPostDTO> atualizar(@PathVariable("codigo") Long codigo,
                                                     @RequestBody AtualizacaoPostDTO dto){
        var post = postRepository.getReferenceById(codigo);
        post.atualizarInformacoes(dto);
        return ResponseEntity.ok(new DetalhesPostDTO(post));
    }// PUT

    @DeleteMapping("/{codigo}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("codigo") Long codigo){
        postRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }// DELETE
}// CLASS