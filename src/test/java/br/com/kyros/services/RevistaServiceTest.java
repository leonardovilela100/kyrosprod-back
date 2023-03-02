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

import br.com.kyros.model.Revista;
import br.com.kyros.repositories.RevistaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RevistaServiceTest {

	@Autowired
	private RevistaService revistaService;

	@MockBean
	private RevistaRepository revistaRepository;

	@Test
	public void criarRevistaTest() {
		Revista revista = new Revista();
		revista.setCodigo(1L);
		revista.setTitulo("Revista de Teste");
		revista.setAno_edicao("2022");
		revista.setNumero((long) 500);
		revista.setEmprestado(false);
		revista.setAtivo(true);

		Mockito.when(revistaRepository.save(Mockito.any(Revista.class))).thenReturn(revista);

		Revista revistaCriado = revistaService.criarRevista(revista);

		assertNotNull(revistaCriado);
		assertEquals(revista.getCodigo(), revistaCriado.getCodigo());
		assertEquals(revista.getTitulo(), revistaCriado.getTitulo());
		assertEquals(revista.getAno_edicao(), revistaCriado.getAno_edicao());
		assertEquals(revista.getNumero(), revistaCriado.getNumero());
		assertEquals(revista.getEmprestado(), revistaCriado.getEmprestado());
		assertEquals(revista.isAtivo(), revistaCriado.isAtivo());

	}

	@Test
	public void desativarRevistaTest() {
		Long codigo = 1L;
		Revista revista = new Revista();

		revista.setAtivo(false);

		Mockito.when(revistaRepository.findById(codigo)).thenReturn(Optional.of(revista));

		revistaService.desativarRevista(codigo);

		assertFalse(revista.isAtivo());
		Mockito.verify(revistaRepository, Mockito.times(1)).save(revista);
	}

	@Test
	public void ativarRevistaTest() {
		Long codigo = 1L;
		Revista revista = new Revista();

		revista.setAtivo(true);

		Mockito.when(revistaRepository.findById(codigo)).thenReturn(Optional.of(revista));

		revistaService.ativarRevista(codigo);

		assertTrue(revista.isAtivo());
		Mockito.verify(revistaRepository, Mockito.times(1)).save(revista);
	}

	@Test
	public void buscarRevistasTest() {
		Long codigo = 1L;
		String titulo = "Revista de Teste";
		String ano_edicao = "01/02/2023";
		Boolean ativo = true;
		PageRequest pageRequest = PageRequest.of(0, 10);

		Page<Revista> pageRevistas = new PageImpl<>(Arrays.asList(new Revista()));
		Mockito.when(revistaRepository.buscarRevista(Mockito.eq(codigo), Mockito.eq(titulo), Mockito.eq(ano_edicao),
				Mockito.eq(ativo), Mockito.any(PageRequest.class))).thenReturn(pageRevistas);

		Page<Revista> pageRevistasEncontrados = revistaService.buscarRevistas(codigo, titulo, ano_edicao, ativo,
				pageRequest);

		assertNotNull(pageRevistasEncontrados);
	}

	@Test
	public void deletarRevistaTest() {
		doNothing().when(revistaRepository).deleteById(1L);

		revistaService.deletarRevista(1L);

		verify(revistaRepository, times(1)).deleteById(1L);
	}

}