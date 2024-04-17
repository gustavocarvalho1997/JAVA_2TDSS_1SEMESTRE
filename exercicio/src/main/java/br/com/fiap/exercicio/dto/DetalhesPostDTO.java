package br.com.fiap.exercicio.dto;

import br.com.fiap.exercicio.model.Post;

public record DetalhesPostDTO(Long codigo, String titulo, String conteudo) {
    public DetalhesPostDTO(Post post){
        this(post.getCodigo(), post.getTitulo(), post.getConteudo());
    }
}// RECORD