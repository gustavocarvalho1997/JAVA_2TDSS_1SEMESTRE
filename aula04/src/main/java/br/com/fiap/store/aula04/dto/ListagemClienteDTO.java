package br.com.fiap.store.aula04.dto;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import br.com.fiap.store.aula04.model.Cliente;

import java.time.LocalDate;

public record ListagemClienteDTO(String nome, LocalDate dataNascimento, CategoriaCliente categoria, Integer pontos) {
    public ListagemClienteDTO(Cliente cliente){
        this(cliente.getNome(), cliente.getDataNascimento(), cliente.getCategoria(), cliente.getPontos());
    }// CONSTRUTOR
}// RECORD