package br.com.kyros.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ebook")
public class Ebook extends Produto {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Long numero;

	@Column(nullable = false)
	private String autor;

	@Column(nullable = false)
	private String url;

	public Ebook() {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, numero, url);
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
		return Objects.equals(autor, other.autor) && Objects.equals(numero, other.numero)
				&& Objects.equals(url, other.url);
	}

}