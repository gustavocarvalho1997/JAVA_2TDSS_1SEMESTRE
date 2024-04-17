package br.com.fiap.exercicio.repository;

import br.com.fiap.exercicio.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}// Interface