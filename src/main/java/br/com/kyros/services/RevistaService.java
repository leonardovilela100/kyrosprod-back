package br.com.kyros.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kyros.model.Revista;
import br.com.kyros.repositories.RevistaRepository;

@Service
public class RevistaService {
    
    @Autowired
    private RevistaRepository revistaRepository;
    
    public Revista criarRevista(Revista revista) {
        return revistaRepository.save(revista);
    }
    
    public void desativarRevista(Long codigo) {
        Optional<Revista> revista = revistaRepository.findById(codigo);
        if (revista.isPresent()) {
        	Revista revistaDesativado = revista.get();
        	revistaDesativado.setAtivo(false);
            revistaRepository.save(revistaDesativado);
        } 
    }
    
    
    public void ativarRevista(Long codigo) {
        Optional<Revista> revista = revistaRepository.findById(codigo);
        if (revista.isPresent()) {
        	Revista revistaAtivar = revista.get();
        	revistaAtivar.setAtivo(true);
            revistaRepository.save(revistaAtivar);
        } 
    }
    
    public Page<Revista> buscarRevistas(Long codigo, String titulo, String ano_edicao, PageRequest pageRequest) {
        return revistaRepository.buscarRevista(codigo, titulo, ano_edicao, pageRequest);
    }
    
    
    
    /*
    public List<Livro>  buscaTodosLivros() {
    	return (List<Livro>) livroRepository.findAll();	
    }
    */
    
}