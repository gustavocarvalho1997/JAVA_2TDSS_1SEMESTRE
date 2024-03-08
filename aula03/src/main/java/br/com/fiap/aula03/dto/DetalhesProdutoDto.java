package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.Produto;

public record DetalhesProdutoDto(Integer id, String nome, Double valor, Integer quantidade) {
    public DetalhesProdutoDto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getQuantidade());
    }
}
