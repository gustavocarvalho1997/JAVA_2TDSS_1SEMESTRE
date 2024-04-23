package br.com.fiap.exercicio.dto;

import br.com.fiap.exercicio.model.Post;

import java.time.LocalDateTime;

public record ListagemPostDTO(Long codigo, String titulo, String conteudo, String nomeAutor, LocalDateTime dataCriacao, LocalDateTime dataPublicacao) {
    public ListagemPostDTO(Post post){
        this(post.getCodigo(), post.getTitulo(), post.getConteudo(), post.getDetalhesPost().getNomeAutor(), post.getDetalhesPost().getDataCriacao(), post.getDetalhesPost().getDataPublicacao());
    }
}
