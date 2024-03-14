package br.com.fiap.aula03.model;

import br.com.fiap.aula03.dto.AtualizacaoMercadoDTO;
import br.com.fiap.aula03.dto.CadastroMercadoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
@Table(name = "JAVA_TB_MERCADO")
public class Mercado {

    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
    private CategoriaMercado categoria;
    private String cnpj;
    private Double faturamento;

    //Cria um construtor que recebe o dto para cadastro
    public Mercado(CadastroMercadoDto mercadoDto) {
        nome = mercadoDto.nome();
        categoria = mercadoDto.categoria();
        cnpj = mercadoDto.cnpj();
        faturamento = mercadoDto.faturamento();
    }
    //Atualiza as informações do mercado
    public void atualizarInformacoes(AtualizacaoMercadoDTO dto) {
        if(dto.nome() != null) {
            nome = dto.nome();
        }
        if(dto.cnpj() != null) {
            cnpj = dto.cnpj();
        }
        if(dto.faturamento() != null) {
            faturamento = dto.faturamento();
        }
    }
}