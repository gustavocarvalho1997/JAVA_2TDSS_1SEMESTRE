package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "aula4_nota_fiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue
    @Column(name = "cd_nota_fiscal")
    private Long codigo;
    @Column(name = "vl_nota_fiscal", nullable = false, precision = 9, scale = 2)
    private BigDecimal valor;
    @Column(name = "dt_nota_fiscal")
    @CreatedDate
    private LocalDateTime data;
    @OneToOne
    @JoinColumn(name = "cd_pedido")
    private Pedido pedido;
}
