package br.com.kyros.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kyros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT l FROM Livro l WHERE (:codigo is null or l.codigo = :codigo) AND "
			+ "(:titulo is null or l.titulo LIKE %:titulo%) AND " + "(:autor is null or l.autor LIKE %:autor%) "
			+ "AND (:ativo is null or l.ativo = :ativo)")

	public Page<Livro> buscarLivros(@Param("codigo") Long codigo, @Param("titulo") String titulo,
			@Param("autor") String autor, @Param("ativo") Boolean ativo, PageRequest pageRequest);
}
