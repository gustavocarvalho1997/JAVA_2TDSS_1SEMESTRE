package br.com.fiap.store.aula04.dto.cliente;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CadastroClienteDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
        String cpf,
        @NotNull(message = "Data de nascimento é obrigatória") @Past(message = "Data de nascimento deve ser no passado")
        LocalDate dataNascimento,
        @NotNull(message = "Categoria é obrigatória")
        CategoriaCliente categoria) {
}
