package br.com.fiap.exercicio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroPostDTO(
        @NotBlank
        @Size(max = 50, message = "O tamanho máximo do titulo deve ser 50 caracteres")
        String titulo,
        @NotBlank
        @Size(max = 500, message = "O conteudo deve conter no máximo 500 caracteres")
        String conteudo
) {
}// RECORD