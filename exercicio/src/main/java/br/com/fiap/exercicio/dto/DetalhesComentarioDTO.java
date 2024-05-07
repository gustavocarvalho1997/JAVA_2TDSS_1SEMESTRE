package br.com.fiap.exercicio.dto;


import br.com.fiap.exercicio.model.Comentario;

import java.time.LocalDateTime;

public record DetalhesComentarioDTO(Long id, String conteudo, String autor,
                                    LocalDateTime dataCriacao, DetalhesPostDTO detalhesPost) {

    public DetalhesComentarioDTO(Comentario comentario){
        this(comentario.getCodigo(), comentario.getComentario(), comentario.getAutor(),
                comentario.getDataCriacao(), new DetalhesPostDTO(comentario.getPost()));
    }

}
