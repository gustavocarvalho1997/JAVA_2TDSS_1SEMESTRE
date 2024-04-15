package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    // cascade - realiza as ações em cascata, ou seja, se cadastrar/alterar/excluir o pedido, a nota fiscal também  pode sofrer a mesma alteração
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private NotaFiscal notaFiscal;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_pedido")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdutoPedido> itens = new ArrayList<>();

    // Método para setar a FK  na tabela ProdutoPedido
    public void adicionarItem(ProdutoPedido item) {
        itens.add(item);
        item.setPedido(this);
    }//ADICIONAR ITEM
}
