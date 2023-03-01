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

import br.com.kyros.model.Ebook;
import br.com.kyros.services.EbookService;

@RestController
@RequestMapping("/ebooks")
public class EbookController {

	@Autowired
	private EbookService ebookService;

	@GetMapping
	public Page<Ebook> buscarEbooks(@RequestParam(required = false) Boolean ativo,@RequestParam(required = false) Long codigo,
			@RequestParam(required = false) String titulo, @RequestParam(required = false) String autor,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "codigo") String sort) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
		return ebookService.buscarEbooks(codigo, titulo, autor,ativo, pageRequest);
	}

	@PostMapping
	public ResponseEntity<Ebook> criarEbook(@RequestBody Ebook ebook) {
		Ebook ebookCriado = ebookService.criarEbook(ebook);
		return ResponseEntity.status(HttpStatus.CREATED).body(ebookCriado);

	}

	@PatchMapping("/desativar/{codigo}")
	public ResponseEntity<Void> desativarEbook(@PathVariable Long codigo) {
		ebookService.desativarEbook(codigo);
		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/ativar/{codigo}")
	public ResponseEntity<Void> ativarEbook(@PathVariable Long codigo) {
		ebookService.ativarEbook(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public void deletarEbook(@PathVariable Long id) {
		ebookService.deletarEbook(id);
	}

}