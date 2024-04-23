package br.com.fiap.exercicio.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CadastroPostDTO(
        @NotBlank @Size(max = 50)
        String titulo,
        @NotBlank @Size(max = 500)
        String conteudo,
        @NotBlank @Size(max = 50)
        String nomeAutor,
        @Future @NotNull
        LocalDateTime dataPublicacao) {
}