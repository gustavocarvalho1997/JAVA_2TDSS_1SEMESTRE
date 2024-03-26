package br.com.fiap.store.aula04.dto.produto;

import br.com.fiap.store.aula04.model.EstadoProduto;
import br.com.fiap.store.aula04.model.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ListagemProdutoDTO(String nome, BigDecimal valor, Integer estoque, LocalDate fabricacao, EstadoProduto estado) {
    public ListagemProdutoDTO(Produto produto){
        this(produto.getNome(), produto.getValor(), produto.getEstoque(), produto.getFabricacao(), produto.getEstado());
    }
}
