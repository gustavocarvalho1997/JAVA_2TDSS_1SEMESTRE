package br.com.fiap.store.aula04.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
@Table(name = "aula4_cliente")
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name = "cd_cliente")
    private Long codigo;
    @Column(name = "nm_cliente", nullable = false, length = 100)
    private String nome;
    @Column(name = "nr_cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "dt_cadastro")
    @CreatedDate
    private LocalDateTime dataCadastro;
    @Column(name = "ds_categoria", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private CategoriaCliente categoria;
    @Transient // Não será uma coluna no banco de dados
    private  String token;
    @Column(name = "nr_pontos", precision = 10)
    private Integer pontos;
}//CLASS