package br.com.kyros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.kyros.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}