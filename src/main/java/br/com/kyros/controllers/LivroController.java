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

import br.com.kyros.model.Livro;
import br.com.kyros.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroService livroService;
    
    @GetMapping
    public Page<Livro> buscarLivros(
            @RequestParam(required = false) Long codigo,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "codigo") String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));
        return livroService.buscarLivros(codigo, titulo, autor, pageRequest);
    }
    
    
    
    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro livroCriado = livroService.criarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCriado);
        
    }

    
    @PatchMapping("/desativar/{codigo}")
    public ResponseEntity<Void> desativarLivro(@PathVariable Long codigo) {
        livroService.desativarLivro(codigo);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/ativar/{codigo}")
    public ResponseEntity<Void> ativarLivro(@PathVariable Long codigo) {
        livroService.ativarLivro(codigo);
        return ResponseEntity.noContent().build();
    }
    
    
    

    
    
    
}