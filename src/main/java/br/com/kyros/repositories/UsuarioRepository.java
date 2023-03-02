package br.com.kyros.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kyros.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT l FROM Usuario l WHERE (:id is null or l.id = :id) AND "
			+ "(:nome is null or l.nome LIKE %:nome%) AND "
			+ "(:tipo_usuario is null or l.tipo_usuario LIKE %:tipo_usuario%)"
			+ "AND (:ativo is null or l.ativo = :ativo)")

	public Page<Usuario> buscarUsuarios(@Param("id") Long id, @Param("nome") String nome,
			@Param("tipo_usuario") String tipo_usuario, @Param("ativo") Boolean ativo, PageRequest pageRequest);
}
