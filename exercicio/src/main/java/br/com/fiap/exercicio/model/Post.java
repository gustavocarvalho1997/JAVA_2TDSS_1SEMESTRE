package br.com.fiap.exercicio.model;

import br.com.fiap.exercicio.dto.AtualizacaoPostDTO;
import br.com.fiap.exercicio.dto.CadastroPostDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "java_exercicio_post")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "cd_post")
    private Long codigo;

    @Column(name = "ds_titulo", length = 50, nullable = false)
    private String titulo;

    @Column(name = "ds_conteudo", length = 500, nullable = false)
    private String conteudo;

    // Relacionamento 1:1 com a tabela DetalhesPost
    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL)
    private DetalhesPost detalhesPost;

    // Relacionamento N:M com a tabela Tag
    @ManyToMany
    @JoinTable(
        name = "java_exercicio_post_tag",
        joinColumns = @JoinColumn(name = "cd_post"),
        inverseJoinColumns = @JoinColumn(name = "cd_tag"))
    private List<Tag> tags;

    // Relacionamento 1:N com a tabela Comentario
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    // Criação
    public Post(CadastroPostDTO dto){
        titulo = dto.titulo();
        conteudo = dto.conteudo();
        detalhesPost = new DetalhesPost(dto);
        detalhesPost.setPost(this); //seta a FK da relação
    }

    // Atualizar
    public void atualizarInformacoes(AtualizacaoPostDTO dto){
        if(dto.titulo() != null){
            this.titulo = dto.titulo();
        }
        if(dto.nomeAutor() != null){
            this.detalhesPost.setNomeAutor(dto.nomeAutor());
        }
    }

}
