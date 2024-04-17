package br.com.fiap.exercicio.repository;

import br.com.fiap.exercicio.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}// Interface