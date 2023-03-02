package br.com.kyros.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ebook")
public class Ebook implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = true)
	private Long codigo;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private Long numero;

	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private String ano_edicao;

	@Column(nullable = false)
	private String url;

	@Column(nullable = false)
	private boolean ativo = true;

	@Column(name = "emprestado")
	private Boolean emprestado = false;

	public Ebook() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno_edicao() {
		return ano_edicao;
	}

	public void setAno_edicao(String ano_edicao) {
		this.ano_edicao = ano_edicao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(Boolean emprestado) {
		this.emprestado = emprestado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano_edicao, ativo, autor, codigo, emprestado, numero, titulo, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ebook other = (Ebook) obj;
		return Objects.equals(ano_edicao, other.ano_edicao) && ativo == other.ativo
				&& Objects.equals(autor, other.autor) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(emprestado, other.emprestado) && Objects.equals(numero, other.numero)
				&& Objects.equals(titulo, other.titulo) && Objects.equals(url, other.url);
	}

}