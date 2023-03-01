package br.com.kyros.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kyros.model.Ebook;
import br.com.kyros.repositories.EbookRepository;

@Service
public class EbookService {

	@Autowired
	private EbookRepository ebookRepository;

	public Ebook criarEbook(Ebook ebook) {
		return ebookRepository.save(ebook);
	}

	public void desativarEbook(Long codigo) {
		Optional<Ebook> ebook = ebookRepository.findById(codigo);
		if (ebook.isPresent()) {
			Ebook ebookDesativado = ebook.get();
			ebookDesativado.setAtivo(false);
			ebookRepository.save(ebookDesativado);
		}
	}

	public void ativarEbook(Long codigo) {
		Optional<Ebook> ebook = ebookRepository.findById(codigo);
		if (ebook.isPresent()) {
			Ebook ebookAtivado = ebook.get();
			ebookAtivado.setAtivo(true);
			ebookRepository.save(ebookAtivado);
		}
	}

	public Page<Ebook> buscarEbooks(Long codigo, String titulo, String autor, Boolean ativo, PageRequest pageRequest) {
		return ebookRepository.buscarEbooks(codigo, titulo, autor, ativo, pageRequest);
	}
	
	public void deletarEbook(Long id) {
		ebookRepository.deleteById(id);
	}


}