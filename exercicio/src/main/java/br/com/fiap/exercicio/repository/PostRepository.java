package br.com.fiap.exercicio.repository;

import br.com.fiap.exercicio.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}// Interface