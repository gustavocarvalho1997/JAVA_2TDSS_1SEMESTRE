package br.com.fiap.aula03.dto.produto;

import br.com.fiap.aula03.model.Produto;

public record ListagemProdutoDTO(String nome, Double valor, Integer quantidade) {
    public ListagemProdutoDTO(Produto produto){
        this(produto.getNome(), produto.getValor(), produto.getQuantidade());
    }
}
