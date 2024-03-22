package br.com.fiap.store.aula04.dto;

import br.com.fiap.store.aula04.model.CategoriaCliente;

import java.time.LocalDate;

public record CadastroClienteDTO(String nome, String cpf, LocalDate dataNascimento, CategoriaCliente categoria) {
}
