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

import br.com.kyros.model.Usuario;
import br.com.kyros.repositories.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

	@Autowired
	private UsuarioService usuarioService;

	@MockBean
	private UsuarioRepository usuarioRepository;

	@Test
	public void criarUsuarioTest() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("Usuario de Teste");
		usuario.setTipo_usuario("professor");
		usuario.setCpf("838.478.377-29");
		usuario.setAtivo(true);

		Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

		Usuario usuarioCriado = usuarioService.criarUsuario(usuario);

		assertNotNull(usuarioCriado);
		assertEquals(usuario.getId(), usuarioCriado.getId());
		assertEquals(usuario.getNome(), usuarioCriado.getNome());
		assertEquals(usuario.getTipo_usuario(), usuarioCriado.getTipo_usuario());
		assertEquals(usuario.getCpf(), usuarioCriado.getCpf());
		assertEquals(usuario.isAtivo(), usuarioCriado.isAtivo());
	}

	@Test
	public void desativarUsuarioTest() {
		Long codigo = 1L;
		Usuario usuario = new Usuario();
		usuario.setAtivo(false);

		Mockito.when(usuarioRepository.findById(codigo)).thenReturn(Optional.of(usuario));

		usuarioService.desativarUsuario(codigo);

		assertFalse(usuario.isAtivo());
		Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuario);
	}

	@Test
	public void ativarUsuarioTest() {
		Long codigo = 1L;
		Usuario usuario = new Usuario();

		usuario.setAtivo(true);

		Mockito.when(usuarioRepository.findById(codigo)).thenReturn(Optional.of(usuario));

		usuarioService.ativarUsuario(codigo);

		assertTrue(usuario.isAtivo());
		Mockito.verify(usuarioRepository, Mockito.times(1)).save(usuario);
	}

	@Test
	public void buscarUsuariosTest() {
		Long id = 1L;
		String nome = "Usuario de Teste";
		String tipo_usuario = "professor";
		Boolean ativo = true;
		PageRequest pageRequest = PageRequest.of(0, 10);

		Page<Usuario> pageUsuarios = new PageImpl<>(Arrays.asList(new Usuario()));
		Mockito.when(usuarioRepository.buscarUsuarios(Mockito.eq(id), Mockito.eq(nome), Mockito.eq(tipo_usuario),
				Mockito.eq(ativo), Mockito.any(PageRequest.class))).thenReturn(pageUsuarios);

		Page<Usuario> pageUsuariosEncontrados = usuarioService.buscarUsuarios(id, nome, tipo_usuario, ativo,
				pageRequest);

		assertNotNull(pageUsuariosEncontrados);
	}

	@Test
	public void deletarUsuarioTest() {
		doNothing().when(usuarioRepository).deleteById(1L);

		usuarioService.deletarUsuario(1L);

		verify(usuarioRepository, times(1)).deleteById(1L);
	}

}