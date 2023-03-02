package br.com.kyros.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.kyros.model.Emprestimo;
import br.com.kyros.repositories.EmprestimoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmprestimoServiceTest {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Test
	public void testBuscarTodosEmprestimos() {
		Emprestimo emprestimo1 = new Emprestimo();
		emprestimo1.setId(1L);
		emprestimo1.setAtivo(true);
		emprestimo1.setCodigo(1L);
		emprestimo1.setCpf_usuario("118.834.248-79");
		emprestimo1.setDataEmprestimo(LocalDate.now());
		emprestimo1.setDataEmprestimo(LocalDate.now());
		emprestimo1.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
		emprestimo1.setId_usuario(1L);
		emprestimo1.setMulta(false);
		emprestimo1.setNome_usuario("Silva");
		emprestimo1.setTipo_usuario("professor");
		emprestimo1.setTipo("livro");
		emprestimo1.setTitulo_produto("Livro de Java");

		Emprestimo emprestimo2 = new Emprestimo();
		emprestimo2.setId(2L);
		emprestimo2.setAtivo(true);
		emprestimo2.setCodigo(2L);
		emprestimo2.setCpf_usuario("118.834.248-25");
		emprestimo2.setDataEmprestimo(LocalDate.now());
		emprestimo2.setDataEmprestimo(LocalDate.now());
		emprestimo2.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
		emprestimo2.setId_usuario(2L);
		emprestimo2.setMulta(true);
		emprestimo2.setNome_usuario("Souza");
		emprestimo2.setTipo_usuario("estudante");
		emprestimo2.setTipo("livro");
		emprestimo2.setTitulo_produto("Livro de Spring");

		emprestimoRepository.save(emprestimo1);
		emprestimoRepository.save(emprestimo2);

		List<Emprestimo> emprestimos = emprestimoRepository.findAll();

		assertNotNull(emprestimos);
		assertEquals(2, emprestimos.size());
	}

}
