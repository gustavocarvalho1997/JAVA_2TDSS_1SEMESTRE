package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.produto.CadastroProdutoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "JAVA_TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private LocalDate dataCadastro = LocalDate.now();

    // Cria um construtor que recebe o dto para cadastro
    public Produto(CadastroProdutoDto produtoDto) {
        this.nome = produtoDto.nome();
        this.valor = produtoDto.valor();
        this.quantidade = produtoDto.quantidade();
    }

}