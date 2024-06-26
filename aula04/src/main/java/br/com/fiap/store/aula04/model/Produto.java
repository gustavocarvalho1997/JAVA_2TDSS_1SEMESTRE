package br.com.fiap.store.aula04.model;

import br.com.fiap.store.aula04.dto.produto.AtualizacaoProdutoDTO;
import br.com.fiap.store.aula04.dto.produto.CadastroProdutoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "aula4_produto")
public class Produto {
    @Id
    @GeneratedValue
    @Column(name = "cd_produto")
    private Long codigo;
    @Column(name = "nm_produto", nullable = false, length = 50)
    private String nome;
    @Column(name = "vl_produto", nullable = false, precision = 9, scale = 2)
    private BigDecimal valor;
    @Column(name = "nr_estoque", precision = 9)
    private Integer estoque;
    @Column(name = "st_frete_gratis")
    private Boolean freteGratis;
    @Column(name = "dt_fabricacao")
    private LocalDate fabricacao;
    @Column(name = "dt_cadastro")
    @CreatedDate
    private LocalDateTime dataCadastro;
    @Column(name = "ds_estado", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private EstadoProduto estado;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoPedido> pedidos;

    @ManyToMany
    @JoinTable(name = "aula4_produto_fornecedor",
            joinColumns = @JoinColumn(name = "cd_produto"),
            inverseJoinColumns = @JoinColumn(name = "cd_fornecedor"))
    private List<Fornecedor> fornecedores;

    public Produto(CadastroProdutoDTO dto){
        this.nome = dto.nome();
        this.valor = dto.valor();
        this.estoque = dto.estoque();
        this.freteGratis = dto.freteGratis();
        this.fabricacao = dto.fabricacao();
        this.estado = dto.estado();
    }// CONSTRUTOR

    public void atualizarInformacoes(AtualizacaoProdutoDTO dto ){
        if(dto.valor() != null){
            this.valor = dto.valor();
        }
        if(dto.estoque() != null){
            this.estoque = dto.estoque();
        }
        if(dto.estado() != null){
            this.estado = dto.estado();
        }
    }
}// CLASS