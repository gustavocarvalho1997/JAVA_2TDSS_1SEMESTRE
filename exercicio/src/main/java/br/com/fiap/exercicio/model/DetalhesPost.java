package br.com.fiap.exercicio.model;

import br.com.fiap.exercicio.dto.CadastroPostDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "java_exercicio_detalhes_post")
@EntityListeners(AuditingEntityListener.class)
public class DetalhesPost {
    @Id
    @GeneratedValue
    @Column(name = "cd_detalhes_post")
    private Long codigo;

    @Column(name = "nm_autor", length = 50, nullable = false)
    private String nomeAutor;

    @Column(name = "dt_criacao", nullable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "dt_publicacao", nullable = false)
    private LocalDateTime dataPublicacao;

    // Relacionamento 1:1 com a tabela Post
    @OneToOne
    @JoinColumn(name = "cd_post", unique = true, nullable = false)
    private Post post;

    public DetalhesPost(CadastroPostDTO dto){
        nomeAutor = dto.nomeAutor();
        dataPublicacao = dto.dataPublicacao();
    }

}
