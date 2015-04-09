package br.com.cespec.infrastructure.repository.mongodb.impl;


import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.cespec.infrastructure.repository.mongodb.ProdutoRepositorio;
import br.com.cespec.model.Produto;

@Component
public class ProdutoRepositorioImpl implements ProdutoRepositorio {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void inserir(Produto produto) {
		mongoTemplate.insert(produto);
	}

	public void atualizar(Produto produto) {
		mongoTemplate.save(produto);
	}

	public void remover(Produto produto) {
		mongoTemplate.remove(produto);
	}

	@SuppressWarnings("unchecked")
	public <T> List<Produto> buscaPorIntervaloDePrecoVarejoECapitulos(double precoInicial, double precoFinal, T... capitulos) {

		Query query = new Query();

		query.addCriteria(where("preco.varejo").gte(precoInicial).lte(precoFinal));
		query.addCriteria(where("detalhes.capitulos").in(capitulos));

		return mongoTemplate.find(query, Produto.class);
	}

	public List<Produto> buscaComIntervaloDePrecoVarejo(double precoInicial, double precoFinal) {

		Query query = new Query(where("preco.varejo").gte(precoInicial).lte(precoFinal));

		return mongoTemplate.find(query, Produto.class);
	}

	public List<Produto> buscaTodos() {

		return mongoTemplate.findAll(Produto.class);
	}

	public List<Produto> searchByProduto(Produto produto) {

		Query lQuery = new Query();

		if (StringUtils.hasText(produto.getSku())) {
			Criteria lCriteria = where("sku").regex(".*" + produto.getSku() + ".*", "i");

			lQuery.addCriteria(lCriteria);
		}

		if (StringUtils.hasText(produto.getTipo())) {
			Criteria lCriteria = where("tipo").regex(".*" + produto.getTipo() + ".*", "i");

			lQuery.addCriteria(lCriteria);
		}

		return mongoTemplate.find(lQuery, Produto.class);
	}
}
