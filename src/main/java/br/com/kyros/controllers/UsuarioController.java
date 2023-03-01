package br.com.kyros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.model.Usuario;
import br.com.kyros.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public Page<Usuario> buscarUsuarios(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String nome, @RequestParam(required = false) String tipo_usuario,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "id") String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		return usuarioService.buscarUsuarios(id, nome, tipo_usuario, pageRequest);
	}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);

	}

	@PatchMapping("/desativar/{id}")
	public ResponseEntity<Void> desativarUsuario(@PathVariable Long id) {
		usuarioService.desativarUsuario(id);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/ativar/{id}")
	public ResponseEntity<Void> ativarUsuario(@PathVariable Long id) {
		usuarioService.ativarUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
