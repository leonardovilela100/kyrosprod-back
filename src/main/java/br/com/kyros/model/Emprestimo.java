package br.com.kyros.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "data_emprestimo")
	private LocalDate dataEmprestimo;

	@Column(name = "data_prevista_devolucao", nullable = false)
	private LocalDate dataPrevistaDevolucao;
	
	@Column(name = "data_devolucao")
	private LocalDate dataDevolucao;
	
	@Column(name = "multa")
	private Boolean multa;

	@Column(name = "tipo_produto", nullable = false, length = 10)
	private String tipo;

	@Column(name = "ativo", nullable = false)
	private Boolean ativo;

	@Column(name = "codigo_produto", nullable = false)
	private Long codigo;

	@Column(name = "id_usuario", nullable = false)
	private Long id_usuario;
	
	@Column(name = "cpf_usuario", nullable = false)
	private String cpf_usuario;

	@Column(name = "tipo_usuario", nullable = false)
	private String tipo_usuario;

	@Column(name = "titulo_produto", nullable = false)
	private String titulo_produto;
	
	

	@Column(name = "nome_usuario", nullable = false)
	private String nome_usuario;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_livro", insertable = false, updatable = false)
	private Livro livro;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_revista", insertable = false, updatable = false)
	private Revista revista;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_ebook", insertable = false, updatable = false)
	private Ebook ebook;

	@Transient
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario", insertable = false, updatable = false)
	private Usuario usuario;

	public Emprestimo() {
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}



	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}



	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}



	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}



	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}



	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}



	public Boolean getMulta() {
		return multa;
	}



	public void setMulta(Boolean multa) {
		this.multa = multa;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public Long getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getCpf_usuario() {
		return cpf_usuario;
	}



	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}



	public String getTipo_usuario() {
		return tipo_usuario;
	}



	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}



	public String getTitulo_produto() {
		return titulo_produto;
	}



	public void setTitulo_produto(String titulo_produto) {
		this.titulo_produto = titulo_produto;
	}



	public String getNome_usuario() {
		return nome_usuario;
	}



	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}



	public Livro getLivro() {
		return livro;
	}



	public void setLivro(Livro livro) {
		this.livro = livro;
	}



	public Revista getRevista() {
		return revista;
	}



	public void setRevista(Revista revista) {
		this.revista = revista;
	}



	public Ebook getEbook() {
		return ebook;
	}



	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public int hashCode() {
		return Objects.hash(ativo, codigo, cpf_usuario, dataDevolucao, dataEmprestimo, dataPrevistaDevolucao, ebook, id,
				id_usuario, livro, multa, nome_usuario, revista, tipo, tipo_usuario, titulo_produto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(cpf_usuario, other.cpf_usuario) && Objects.equals(dataDevolucao, other.dataDevolucao)
				&& Objects.equals(dataEmprestimo, other.dataEmprestimo)
				&& Objects.equals(dataPrevistaDevolucao, other.dataPrevistaDevolucao)
				&& Objects.equals(ebook, other.ebook) && Objects.equals(id, other.id)
				&& Objects.equals(id_usuario, other.id_usuario) && Objects.equals(livro, other.livro)
				&& Objects.equals(multa, other.multa) && Objects.equals(nome_usuario, other.nome_usuario)
				&& Objects.equals(revista, other.revista) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(tipo_usuario, other.tipo_usuario)
				&& Objects.equals(titulo_produto, other.titulo_produto) && Objects.equals(usuario, other.usuario);
	}



	
	

}