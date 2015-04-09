package br.com.cespec.infrastructure.repository.mongodb;

import java.util.List;

import br.com.cespec.model.Produto;

public interface ProdutoRepositorio {

	void inserir(Produto produto);

	void atualizar(Produto produto);

	void remover(Produto produto);

	List<Produto> buscaComIntervaloDePrecoVarejo(double precoInicial, double precoFinal);

	<T> List<Produto> buscaPorIntervaloDePrecoVarejoECapitulos(double precoInicial, double precoFinal, T... capitulos);

	List<Produto> searchByProduto(Produto produto);


	List<Produto> buscaTodos();
}
