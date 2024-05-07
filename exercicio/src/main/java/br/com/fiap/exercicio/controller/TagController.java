package br.com.fiap.exercicio.controller;
import br.com.fiap.exercicio.dto.tag.CadastroTagDTO;
import br.com.fiap.exercicio.dto.tag.DetalhesTagDTO;
import br.com.fiap.exercicio.model.Tag;
import br.com.fiap.exercicio.repository.TagRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesTagDTO> post(@RequestBody @Valid CadastroTagDTO dto, UriComponentsBuilder uriBuilder){
        var tag = new Tag(dto);
        tagRepository.save(tag);
        var uri = uriBuilder.path("tags/{id}").buildAndExpand(tag.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesTagDTO(tag));
    }

}