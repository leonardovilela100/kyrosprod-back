package br.com.kyros.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kyros.model.Revista;

public interface RevistaRepository extends JpaRepository<Revista, Long> {

	@Query("SELECT l FROM Revista l WHERE (:codigo is null or l.codigo = :codigo) AND "
			+ "(:titulo is null or l.titulo LIKE %:titulo%) AND "
			+ "(:ano_edicao is null or l.ano_edicao LIKE %:ano_edicao%) " + "AND (:ativo is null or l.ativo = :ativo)")

	public Page<Revista> buscarRevista(@Param("codigo") Long codigo, @Param("titulo") String titulo,
			@Param("ano_edicao") String ano_edicao, @Param("ativo") Boolean ativo, PageRequest pageRequest);
}
