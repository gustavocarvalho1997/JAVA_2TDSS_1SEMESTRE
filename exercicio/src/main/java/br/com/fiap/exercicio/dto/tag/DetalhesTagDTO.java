package br.com.fiap.exercicio.dto.tag;

import br.com.fiap.exercicio.model.Tag;

public record DetalhesTagDTO(Long id, String nome) {
    public DetalhesTagDTO(Tag tag) {
        this(tag.getCodigo(), tag.getNome());
    }
}