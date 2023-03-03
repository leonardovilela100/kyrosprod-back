package br.com.kyros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kyros.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

	@Query(value = "SELECT * FROM emprestimo WHERE id_usuario = :id_usuario and ativo = true LIMIT 1", nativeQuery = true)
	public Emprestimo buscarId(@Param("id_usuario") Long id);

}