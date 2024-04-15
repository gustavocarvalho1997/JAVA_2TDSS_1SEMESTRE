package br.com.fiap.exercicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "java_exercicio_tag")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "cd_tag")
    private Long codigo;

    @Column(name = "nm_tag", length = 20, nullable = false)
    private String nome;

    // Relacionamento N:M com a tabela Post
    @ManyToMany(mappedBy = "tags")
    private List<Post> posts;
}
