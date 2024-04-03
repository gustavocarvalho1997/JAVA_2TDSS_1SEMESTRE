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
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "aula4_pedido")
public class Pedido {
    @Id
    @GeneratedValue
    @Column(name = "cd_pedido")
    private Long codigo;
    @Column(name = "vl_pedido", precision = 9, scale = 2)
    private BigDecimal valor;
    @Column(name = "dt_pedido")
    @CreatedDate
    private LocalDateTime data;
    @OneToOne(mappedBy = "pedido")
    private NotaFiscal nf;
    @ManyToOne
    @JoinColumn(name = "cd_pedido")
    private Cliente cliente;
}
