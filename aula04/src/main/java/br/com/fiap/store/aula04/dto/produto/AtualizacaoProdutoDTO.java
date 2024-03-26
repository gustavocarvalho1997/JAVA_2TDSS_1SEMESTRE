package br.com.fiap.store.aula04.dto.produto;

import br.com.fiap.store.aula04.model.EstadoProduto;

import java.math.BigDecimal;

public record AtualizacaoProdutoDTO(BigDecimal valor, Integer estoque, EstadoProduto estado) {
}
