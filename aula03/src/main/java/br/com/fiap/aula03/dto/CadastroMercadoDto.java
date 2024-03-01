package br.com.fiap.aula03.dto;

import br.com.fiap.aula03.model.CategoriaMercado;
public record CadastroMercadoDto(Integer id, String nome, CategoriaMercado categoria) {
}//RECORD