package br.com.kyros.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.kyros.model.Livro;
import br.com.kyros.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public Livro criarLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public void desativarLivro(Long codigo) {
		Optional<Livro> livro = livroRepository.findById(codigo);
		if (livro.isPresent()) {
			Livro livroDesativado = livro.get();
			livroDesativado.setAtivo(false);
			livroRepository.save(livroDesativado);
		}
	}

	public void ativarLivro(Long codigo) {
		Optional<Livro> livro = livroRepository.findById(codigo);
		if (livro.isPresent()) {
			Livro livroAtivado = livro.get();
			livroAtivado.setAtivo(true);
			livroRepository.save(livroAtivado);
		}
	}

	public Page<Livro> buscarLivros(Long codigo, String titulo, String autor, Boolean ativo, PageRequest pageRequest) {
		return livroRepository.buscarLivros(codigo, titulo, autor, ativo, pageRequest);
	}

	public void deletarLivro(Long id) {
		livroRepository.deleteById(id);
	}

}