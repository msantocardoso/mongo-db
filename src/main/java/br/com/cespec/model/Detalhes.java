package br.com.cespec.model;

import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Detalhes {

	@Field
	private String titulo;
	@Field
	private String autor;
	@Field
	private String artista;
	@Field
	private String genero;
	@Field
	private List<String> pic;
	@Field @Indexed
	private List<String> capitulos;
	@Field
	private List<String> tracks;

	@Override
	public String toString() {
		return "Detalhes [titulo=" + titulo + ", autor=" + autor + ", artista=" + artista + ", genero=" + genero + ", pic=" + pic + ", capitulos=" + capitulos
				+ ", tracks=" + tracks + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<String> getPic() {
		return pic;
	}

	public void setPic(List<String> pic) {
		this.pic = pic;
	}

	public List<String> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<String> capitulos) {
		this.capitulos = capitulos;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

}
