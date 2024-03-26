package br.com.fiap.store.aula04.dto.produto;

import br.com.fiap.store.aula04.model.EstadoProduto;
import br.com.fiap.store.aula04.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesProdutoDTO(Long codigo, String nome, BigDecimal valor, Integer estoque, Boolean freteGratis, LocalDate fabricacao, LocalDateTime dataCadastro, EstadoProduto estado) {
    public DetalhesProdutoDTO(Produto produto){
        this(produto.getCodigo(), produto.getNome(), produto.getValor(), produto.getEstoque(), produto.getFreteGratis(), produto.getFabricacao(), produto.getDataCadastro(), produto.getEstado());
    }
}// RECORD
