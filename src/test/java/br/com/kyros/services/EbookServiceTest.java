package br.com.kyros.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

import br.com.kyros.model.Ebook;
import br.com.kyros.repositories.EbookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EbookServiceTest {

	@Autowired
	private EbookService ebookService;

	@MockBean
	private EbookRepository ebookRepository;

	@Test
	public void criarEbookTest() {
		Ebook ebook = new Ebook();
		ebook.setCodigo(1L);
		ebook.setTitulo("Ebook de Teste");
		ebook.setAno_edicao("2022");
		ebook.setAutor("Autor de Teste");
		ebook.setAtivo(true);
		ebook.setEmprestado(false);
		ebook.setUrl("www.google.com.br");

		Mockito.when(ebookRepository.save(Mockito.any(Ebook.class))).thenReturn(ebook);

		Ebook ebookCriado = ebookService.criarEbook(ebook);

		assertNotNull(ebookCriado);
		assertEquals(ebook.getCodigo(), ebookCriado.getCodigo());
		assertEquals(ebook.getTitulo(), ebookCriado.getTitulo());
		assertEquals(ebook.getAno_edicao(), ebookCriado.getAno_edicao());
		assertEquals(ebook.getAutor(), ebookCriado.getAutor());
		assertEquals(ebook.isAtivo(), ebookCriado.isAtivo());
		assertEquals(ebook.getEmprestado(), ebookCriado.getEmprestado());
		assertEquals(ebook.getUrl(), ebookCriado.getUrl());

	}

	@Test
	public void desativarEbookTest() {
		Long codigo = 1L;
		Ebook ebook = new Ebook();

		ebook.setAtivo(false);

		Mockito.when(ebookRepository.findById(codigo)).thenReturn(Optional.of(ebook));

		ebookService.desativarEbook(codigo);

		assertFalse(ebook.isAtivo());
		Mockito.verify(ebookRepository, Mockito.times(1)).save(ebook);
	}

	@Test
	public void ativarEbookTest() {
		Long codigo = 1L;
		Ebook ebook = new Ebook();

		ebook.setAtivo(true);

		Mockito.when(ebookRepository.findById(codigo)).thenReturn(Optional.of(ebook));

		ebookService.ativarEbook(codigo);

		assertTrue(ebook.isAtivo());
		Mockito.verify(ebookRepository, Mockito.times(1)).save(ebook);
	}

	@Test
	public void buscarEbooksTest() {
		Long codigo = 1L;
		String titulo = "Ebook de Teste";
		String autor = "Autor de Teste";
		Boolean ativo = true;
		PageRequest pageRequest = PageRequest.of(0, 10);

		Page<Ebook> pageEbooks = new PageImpl<>(Arrays.asList(new Ebook()));
		Mockito.when(ebookRepository.buscarEbooks(Mockito.eq(codigo), Mockito.eq(titulo), Mockito.eq(autor),
				Mockito.eq(ativo), Mockito.any(PageRequest.class))).thenReturn(pageEbooks);

		Page<Ebook> pageEbooksEncontrados = ebookService.buscarEbooks(codigo, titulo, autor, ativo, pageRequest);

		assertNotNull(pageEbooksEncontrados);
	}

	@Test
	public void deletarEbookTest() {
		doNothing().when(ebookRepository).deleteById(1L);

		ebookService.deletarEbook(1L);

		verify(ebookRepository, times(1)).deleteById(1L);
	}

}