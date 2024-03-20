package br.com.fiap.store.aula04.dto;

import br.com.fiap.store.aula04.model.CategoriaCliente;
import br.com.fiap.store.aula04.model.Cliente;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesClienteDTO(Long codigo, String nome, String cpf, LocalDate dataNascimento, LocalDateTime dataCadastro, CategoriaCliente categoria, Integer pontos) {
    public DetalhesClienteDTO(Cliente cliente) {
        this(cliente.getCodigo(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getDataCadastro(), cliente.getCategoria(), cliente.getPontos());
    }
}// RECORD