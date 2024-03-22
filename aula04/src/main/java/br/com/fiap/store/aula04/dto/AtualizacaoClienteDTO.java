package br.com.fiap.store.aula04.dto;

import br.com.fiap.store.aula04.model.CategoriaCliente;

public record AtualizacaoClienteDTO(String nome, CategoriaCliente categoria) {
}
