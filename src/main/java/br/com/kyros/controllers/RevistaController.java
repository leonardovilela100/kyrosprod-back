package br.com.kyros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.model.Revista;
import br.com.kyros.services.RevistaService;

@RestController
@RequestMapping("/api/revistas")
public class RevistaController {

	@Autowired
	private RevistaService revistaService;

	@GetMapping
	public Page<Revista> buscarRevistas(@RequestParam(required = false) Boolean ativo,
			@RequestParam(required = false) Long codigo, @RequestParam(required = false) String titulo,
			@RequestParam(required = false) String ano_edicao, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "codigo") String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		return revistaService.buscarRevistas(codigo, titulo, ano_edicao, ativo, pageRequest);
	}

	@PostMapping
	public ResponseEntity<Revista> criarRevista(@RequestBody Revista revista) {
		Revista revistaCriada = revistaService.criarRevista(revista);
		return ResponseEntity.status(HttpStatus.CREATED).body(revistaCriada);

	}

	@PatchMapping("/desativar/{codigo}")
	public ResponseEntity<Void> desativarRevista(@PathVariable Long codigo) {
		revistaService.desativarRevista(codigo);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/ativar/{codigo}")
	public ResponseEntity<Void> ativarRevista(@PathVariable Long codigo) {
		revistaService.ativarRevista(codigo);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public void deletarRevista(@PathVariable Long id) {
		revistaService.deletarRevista(id);
	}

}