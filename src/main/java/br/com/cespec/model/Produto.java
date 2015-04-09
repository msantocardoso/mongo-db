package br.com.cespec.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="produtos")
public class Produto {

	@Id
	private String id;
	@Field @Indexed
	private String sku;
	@Field @Indexed
	private String tipo;
	@Field
	private String titulo;
	@Field
	private String descricao;
	@Field
	private String autor;
	@Field
	private Preco preco;
	@Field
	private Detalhes detalhes;

	@Override
	public String toString() {
		return "Produto [id=" + id + ", sku=" + sku + ", tipo=" + tipo + ", titulo=" + titulo + ", descricao=" + descricao + ", autor=" + autor + ", preco=" + preco
				+ ", detalhes=" + detalhes + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public Detalhes getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(Detalhes detalhes) {
		this.detalhes = detalhes;
	}

	public String getTrack() {
		return (this.getDetalhes() != null && this.getDetalhes().getTracks() != null) ? this.getDetalhes().getTracks().toString() : "";
	}

	public String getCapitulos() {
		return (this.getDetalhes() != null && this.getDetalhes().getCapitulos() != null) ? this.getDetalhes().getCapitulos().toString() : "";
	}
}
