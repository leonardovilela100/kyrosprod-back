package br.com.kyros.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kyros.model.Ebook;

public interface EbookRepository extends JpaRepository<Ebook, Long> {
	Boolean ativo = false;

	@Query("SELECT l FROM Ebook l WHERE (:codigo is null or l.codigo = :codigo) AND "
			+ "(:titulo is null or l.titulo LIKE %:titulo%) AND " + "(:autor is null or l.autor LIKE %:autor%) "
			+ "AND (:ativo is null or l.ativo = :ativo)")

	public Page<Ebook> buscarEbooks(@Param("codigo") Long codigo, @Param("titulo") String titulo,
			@Param("autor") String autor, @Param("ativo") Boolean ativo, PageRequest pageRequest);
}
