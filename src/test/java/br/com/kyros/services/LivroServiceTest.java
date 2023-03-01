package br.com.kyros.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.kyros.model.Livro;
import br.com.kyros.repositories.LivroRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LivroServiceTest {

	@Autowired
	private LivroService livroService;

	@MockBean
	private LivroRepository livroRepository;

	@Test
	public void criarLivroTest() {
		Livro livro = new Livro();
		livro.setTitulo("Livro de Teste");
		livro.setAutor("Autor de Teste");
		livro.setEditora("Editora de Teste");
		livro.setAno_edicao("2022");

		Mockito.when(livroRepository.save(Mockito.any(Livro.class))).thenReturn(livro);

		Livro livroCriado = livroService.criarLivro(livro);

		assertNotNull(livroCriado);
		assertEquals(livro.getTitulo(), livroCriado.getTitulo());
		assertEquals(livro.getAutor(), livroCriado.getAutor());
		assertEquals(livro.getEditora(), livroCriado.getEditora());
		assertEquals(livro.getAno_edicao(), livroCriado.getAno_edicao());
	}

	@Test
	public void desativarLivroTest() {
		Long codigo = 1L;
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		livro.setTitulo("Livro de Teste");
		livro.setAutor("Autor de Teste");
		livro.setEditora("Editora de Teste");
		livro.setAno_edicao("2022");
		livro.setAtivo(true);

		Mockito.when(livroRepository.findById(codigo)).thenReturn(Optional.of(livro));

		livroService.desativarLivro(codigo);

		assertFalse(livro.isAtivo());
		Mockito.verify(livroRepository, Mockito.times(1)).save(livro);
	}

	@Test
	public void ativarLivroTest() {
		Long codigo = 1L;
		Livro livro = new Livro();
		livro.setCodigo(codigo);
		livro.setTitulo("Livro de Teste");
		livro.setAutor("Autor de Teste");
		livro.setEditora("Editora de Teste");
		livro.setAno_edicao("2022");
		livro.setAtivo(false);

		Mockito.when(livroRepository.findById(codigo)).thenReturn(Optional.of(livro));

		livroService.ativarLivro(codigo);

		assertTrue(livro.isAtivo());
		Mockito.verify(livroRepository, Mockito.times(1)).save(livro);
	}

	@Test
	public void buscarLivrosTest() {
		Long codigo = 1L;
		String titulo = "Livro de Teste";
		String autor = "Autor de Teste";
		Boolean ativo = true;
		PageRequest pageRequest = PageRequest.of(0, 10);

		Page<Livro> pageLivros = new PageImpl<>(Arrays.asList(new Livro()));
		Mockito.when(livroRepository.buscarLivros(Mockito.eq(codigo), Mockito.eq(titulo), Mockito.eq(autor), Mockito.eq(ativo), Mockito.any(PageRequest.class))).thenReturn(pageLivros);

		Page<Livro> pageLivrosEncontrados = livroService.buscarLivros(codigo, titulo, autor, ativo, pageRequest);

		assertNotNull(pageLivrosEncontrados);
	}
}