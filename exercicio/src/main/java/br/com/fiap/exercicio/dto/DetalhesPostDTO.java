package br.com.fiap.exercicio.dto;

import br.com.fiap.exercicio.dto.tag.DetalhesTagDTO;
import br.com.fiap.exercicio.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhesPostDTO(Long codigo, String titulo, String conteudo,
                              String autor, LocalDateTime dataCriacao, LocalDateTime dataPublicacao,
                              List<DetalhesTagDTO> tags) {

    public DetalhesPostDTO(Post post){
        this(post.getCodigo(), post.getTitulo(), post.getConteudo(), post.getDetalhesPost().getNomeAutor(),
                post.getDetalhesPost().getDataCriacao(), post.getDetalhesPost().getDataPublicacao(),
                post.getTags().stream().map(DetalhesTagDTO::new).toList());
    }

}