package br.com.fiap.store.aula04.dto;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import br.com.fiap.store.aula04.model.Cliente;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record DetalhesClienteDTO(Long codigo, String nome, String cpf, LocalDate dataNascimento, LocalDate dataCadastro, CategoriaCliente categoria, Integer pontos) {
    public DetalhesClienteDTO(Cliente cliente) {
        this(cliente.getCodigo(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getDataCadastro().toLocalDate(), cliente.getCategoria(), cliente.getPontos());
    }
}// RECORD