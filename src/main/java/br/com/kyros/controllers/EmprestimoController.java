package br.com.kyros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.model.Emprestimo;
import br.com.kyros.services.EmprestimoService;

@RestController
@RequestMapping("/api/locacao")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping("/emprestimo")
	public ResponseEntity<Emprestimo> emprestar(@RequestBody Emprestimo emprestimoRequest) throws Exception {
		Emprestimo emprestimo = emprestimoService.emprestar(emprestimoRequest.getCodigo(),
				emprestimoRequest.getId_usuario(), emprestimoRequest.getTipo());
		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
	}

	@PostMapping("/devolucao/{id}")
	public ResponseEntity<Emprestimo> devolver(@PathVariable Long id) throws Exception {
		Emprestimo devolver = emprestimoService.devolver(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(devolver);

	}

	@GetMapping("/emprestimos")
	public ResponseEntity<List<Emprestimo>> buscarTodosEmprestimos() {
		List<Emprestimo> emprestimos = emprestimoService.buscarTodosEmprestimos();
		if (emprestimos.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(emprestimos);
		}
	}

}