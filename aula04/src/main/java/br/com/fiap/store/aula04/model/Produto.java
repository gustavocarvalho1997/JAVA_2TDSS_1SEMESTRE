package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Double valor;
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
    @Transient
    private Double precoComDesconto;
}// CLASS