package br.com.cespec.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="usuario")
public class Usuario {

	@Id
	private ObjectId codigo;

	private String nome;

	private String senha;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", senha=" + senha + "]";
	}

	public ObjectId getCodigo() {
		return codigo;
	}

	public void setCodigo(ObjectId codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
