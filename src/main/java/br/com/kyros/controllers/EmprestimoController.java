package br.com.kyros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kyros.model.Emprestimo;
import br.com.kyros.services.EmprestimoService;

@RestController
@RequestMapping("/locacao")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/emprestimo")
    public ResponseEntity<Emprestimo> emprestar(@RequestBody Emprestimo emprestimoRequest) throws Exception {
        Emprestimo emprestimo = emprestimoService.emprestar(emprestimoRequest.getCodigo(), emprestimoRequest.getId_usuario(), emprestimoRequest.getTipo());
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
    }
    
    @PostMapping("/devolucao/{id}")
    public ResponseEntity<Emprestimo> devolver(@PathVariable Long id) throws Exception {
        Emprestimo devolver = emprestimoService.devolver(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(devolver);
       
    }
    

    
   
/*
    @GetMapping
    public ResponseEntity<Page<Emprestimo>> buscarEmprestimos(Pageable pageable) {
        Page<Emprestimo> emprestimos = emprestimoService.buscarTodos(pageable);
        return ResponseEntity.ok(emprestimos);
    }
*/
}