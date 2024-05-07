package br.com.fiap.exercicio.dto.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroTagDTO(@NotBlank @Size(max = 20)String nome) {
}