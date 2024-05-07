package br.com.fiap.exercicio.controller;

import br.com.fiap.exercicio.dto.*;
import br.com.fiap.exercicio.model.Comentario;
import br.com.fiap.exercicio.model.Post;
import br.com.fiap.exercicio.repository.ComentarioRepository;
import br.com.fiap.exercicio.repository.PostRepository;
import br.com.fiap.exercicio.repository.TagRepository;
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

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private TagRepository tagRepository;

    @DeleteMapping("{idPost}/tags")
    @Transactional
    public ResponseEntity<Void> deleteTags(@PathVariable("idPost") Long idPost){
        var post = postRepository.getReferenceById(idPost);
        post.getTags().clear();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idPost}/tags/{idTag}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("idPost") Long idPost,
                                       @PathVariable("idTag") Long idTag) {
        var post = postRepository.getReferenceById(idPost);
        var tag = tagRepository.getReferenceById(idTag);
        post.getTags().remove(tag);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{idPost}/tags/{idTag}")
    @Transactional
    public ResponseEntity<DetalhesPostDTO> put(@PathVariable("idPost") Long idPost,
                                               @PathVariable("idTag") Long idTag) {
        var post = postRepository.getReferenceById(idPost);
        var tag = tagRepository.getReferenceById(idTag);
        post.getTags().add(tag); //Acessa a lista de tags do post e adiciona a nova tag
        return ResponseEntity.ok(new DetalhesPostDTO(post));
    }

    @PostMapping("{id}/comentarios")
    @Transactional
    public ResponseEntity<DetalhesComentarioDTO> post(@PathVariable("id") Long id,
                                                      @RequestBody @Valid CadastroComentarioDTO dto,
                                                      UriComponentsBuilder uriBuilder){
        //chamar o repository post para pesquisar o post pelo codigo
        var post = postRepository.getReferenceById(id);
        //instanciar o comentário com o dto
        var comentario = new Comentario(dto, post);
        comentarioRepository.save(comentario);
        var uri = uriBuilder.path("comentarios/{id}").buildAndExpand(comentario.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesComentarioDTO(comentario));
    }


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

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesPostDTO> put(@PathVariable("id") Long id, @RequestBody AtualizacaoPostDTO dto){
        var post = postRepository.getReferenceById(id);
        post.atualizar(dto);
        return ResponseEntity.ok(new DetalhesPostDTO(post));
    }

    @DeleteMapping("/{codigo}")
    @Transactional
    public ResponseEntity<Void> remover(@PathVariable("codigo") Long codigo){
        postRepository.deleteById(codigo);
        return ResponseEntity.noContent().build();
    }// DELETE
}// CLASS