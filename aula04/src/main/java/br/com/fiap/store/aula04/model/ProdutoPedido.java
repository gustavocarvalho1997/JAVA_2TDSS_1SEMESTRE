package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "aula4_produto_pedido")
public class ProdutoPedido {
    @Id
    @GeneratedValue
    @Column(name = "cd_produto_pedido")
    private Long codigo;
    @Column(name = "vl_produto_pedido", nullable = false, precision = 9, scale = 2)
    private BigDecimal valor;
    @Column(name = "qt_produto_pedido", nullable = false)
    private Integer quantidade;
}
