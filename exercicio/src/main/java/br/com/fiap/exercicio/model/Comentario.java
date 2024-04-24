package br.com.fiap.exercicio.model;

import br.com.fiap.exercicio.dto.CadastroComentarioDTO;
import br.com.fiap.exercicio.dto.CadastroPostDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "java_exercicio_comentario")
@EntityListeners(AuditingEntityListener.class)
public class Comentario {
    @Id
    @GeneratedValue
    @Column(name = "cd_comentario")
    private Long codigo;

    @Column(name = "ds_comentario", length = 100, nullable = false)
    private String comentario;

    @Column(name = "dt_criacao", nullable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "nm_autor", length = 50, nullable = true)
    private String autor;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_post", nullable = false)
    private Post post;

    //Criação
    public Comentario(CadastroComentarioDTO dto, Post post){
        comentario = dto.conteudo();
        autor = dto.autor();
        this.post = post;
    }

}
