package br.com.fiap.exercicio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroComentarioDTO(
        @NotBlank @Size(max = 100)
        String conteudo,
        @Size(max = 50)
        String autor
) {
}
