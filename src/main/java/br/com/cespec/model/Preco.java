package br.com.cespec.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Preco {
	@Field
	private double lista;
	@Field @Indexed
	private double varejo;

	@Override
	public String toString() {
		return "Preco [lista=" + lista + ", varejo=" + varejo + "]";
	}

	public Preco(double lista, double varejo) {
		this.lista = lista;
		this.varejo = varejo;
	}

	public double getLista() {
		return lista;
	}

	public void setLista(double lista) {
		this.lista = lista;
	}

	public double getVarejo() {
		return varejo;
	}

	public void setVarejo(double varejo) {
		this.varejo = varejo;
	}
}
