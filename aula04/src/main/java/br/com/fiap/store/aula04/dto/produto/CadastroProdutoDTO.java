package br.com.fiap.store.aula04.dto.produto;

import br.com.fiap.store.aula04.model.EstadoProduto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroProdutoDTO(String nome, BigDecimal valor, Integer estoque, Boolean freteGratis, LocalDate fabricacao, EstadoProduto estado) {
}
