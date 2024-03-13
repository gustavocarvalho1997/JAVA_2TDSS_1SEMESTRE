package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaMercado;
import br.com.fiap.aula03.model.Mercado;

public record ListagemMercadoDTO(String nome, CategoriaMercado categoria) {
    public ListagemMercadoDTO(Mercado mercado){
        this(mercado.getNome(), mercado.getCategoria());
    }
}
