package br.com.kyros.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kyros.model.Usuario;
import br.com.kyros.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void desativarUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			Usuario usuarioDesativado = usuario.get();
			usuarioDesativado.setAtivo(false);
			usuarioRepository.save(usuarioDesativado);
		}
	}

	public void ativarUsuario(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			Usuario usuarioAtivado = usuario.get();
			usuarioAtivado.setAtivo(true);
			usuarioRepository.save(usuarioAtivado);
		}
	}

	public Page<Usuario> buscarUsuarios(Long id, String nome, String tipo_usuario, Boolean ativo,
			PageRequest pageRequest) {
		return usuarioRepository.buscarUsuarios(id, nome, tipo_usuario, ativo, pageRequest);
	}

	public void deletarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}
