package br.com.kyros.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.kyros.model.Ebook;
import br.com.kyros.model.Emprestimo;
import br.com.kyros.model.Livro;
import br.com.kyros.model.Revista;
import br.com.kyros.model.Usuario;
import br.com.kyros.repositories.EbookRepository;
import br.com.kyros.repositories.EmprestimoRepository;
import br.com.kyros.repositories.LivroRepository;
import br.com.kyros.repositories.RevistaRepository;
import br.com.kyros.repositories.UsuarioRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private RevistaRepository revistaRepository;

	@Autowired
	private EbookRepository ebookRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Emprestimo emprestar(Long codigo, Long idUsuario, String tipo) throws Exception {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setDataEmprestimo(LocalDate.now());
		emprestimo.setTipo(tipo);
		emprestimo.setAtivo(true);
		emprestimo.setId_usuario(idUsuario);
		emprestimo.setCodigo(codigo);

		Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NotFoundException());
		emprestimo.setTipo_usuario(usuario.getTipo_usuario());
		emprestimo.setNome_usuario(usuario.getNome());
		emprestimo.setCpf_usuario(usuario.getCpf());

		if (usuario.getTipo_usuario().equalsIgnoreCase("professor")) {
			emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(14));
		} else {
			emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(7));
		}

		switch (tipo) {
		case "livro":
			Livro livro = livroRepository.findById(codigo).orElseThrow(() -> new NotFoundException());
			if (livro.isAtivo() == false && livro.getEmprestado() == true) {
				throw new Exception("Livro já emprestado");
			}
			livro.setAtivo(false);
			livro.setEmprestado(true);
			emprestimo.setTitulo_produto(livro.getTitulo());
			livroRepository.save(livro);
			break;
		case "revista":
			Revista revista = revistaRepository.findById(codigo).orElseThrow(() -> new NotFoundException());
			if (revista.isAtivo() == false && revista.getEmprestado() == true) {
				throw new Exception("Revista já emprestado");
			}
			revista.setAtivo(false);
			revista.setEmprestado(true);
			emprestimo.setTitulo_produto(revista.getTitulo());
			revistaRepository.save(revista);
			break;
		case "ebook":
			Ebook ebook = ebookRepository.findById(codigo).orElseThrow(() -> new NotFoundException());
			if (ebook.isAtivo() == false && ebook.getEmprestado() == true) {
				throw new Exception("Ebook já emprestado");
			}
			ebook.setEmprestado(true);
			ebook.setAtivo(false);
			emprestimo.setTitulo_produto(ebook.getTitulo());
			ebookRepository.save(ebook);
			break;
		default:
			throw new Exception("Tipo inválido");
		}

		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo devolver(Long id) throws Exception {

		Optional<Emprestimo> devolverid = emprestimoRepository.findById(id);

		Emprestimo devolver = devolverid.get();

		devolver.setAtivo(false);
		devolver.setDataDevolucao(LocalDate.now());

		if (devolver.getDataPrevistaDevolucao() != null
				&& devolver.getDataPrevistaDevolucao().isBefore(LocalDate.now())) {
			devolver.setMulta(true);

		} else {
			devolver.setMulta(false);
		}

		switch (devolver.getTipo()) {
		case "livro":
			Livro livro = livroRepository.findById(devolver.getCodigo()).orElseThrow(() -> new NotFoundException());
			if (livro.isAtivo() == false) {
				livro.setAtivo(true);
				livro.setEmprestado(false);
				livroRepository.save(livro);
			} else {
				throw new Exception("Livro não está emprestado");
			}
			break;
		case "revista":
			Revista revista = revistaRepository.findById(devolver.getCodigo())
					.orElseThrow(() -> new NotFoundException());
			if (revista.isAtivo() == false) {
				revista.setAtivo(true);
				revista.setEmprestado(false);
				revistaRepository.save(revista);
			} else {
				throw new Exception("Livro não está emprestado");
			}

			break;
		case "ebook":
			Ebook ebook = ebookRepository.findById(devolver.getCodigo()).orElseThrow(() -> new NotFoundException());
			if (ebook.isAtivo() == false) {
				ebook.setAtivo(true);
				ebook.setEmprestado(false);
				ebookRepository.save(ebook);
			} else {
				throw new Exception("Ebook não está emprestado");
			}

			break;
		default:
			throw new Exception("Tipo inválido");
		}

		return emprestimoRepository.save(devolver);
	}

	public List<Emprestimo> buscarTodosEmprestimos() {
		return emprestimoRepository.findAll();
	}

}