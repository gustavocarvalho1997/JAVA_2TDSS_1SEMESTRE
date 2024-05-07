package br.com.fiap.exercicio.dto;

import jakarta.validation.constraints.Size;

public record AtualizacaoPostDTO(@Size(max = 50)
                                 String titulo,
                                 @Size(max = 50)
                                 String autor) {
}