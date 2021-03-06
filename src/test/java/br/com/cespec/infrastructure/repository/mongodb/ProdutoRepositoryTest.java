package br.com.cespec.infrastructure.repository.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.cespec.infrastructure.repository.AbstracaoTesteMongoSpringData;
import br.com.cespec.model.Detalhes;
import br.com.cespec.model.Preco;
import br.com.cespec.model.Produto;

public class ProdutoRepositoryTest extends AbstracaoTesteMongoSpringData {

	@Autowired
	@Qualifier("produtoRepositorioImpl")
	ProdutoRepositorio produtoRepositorio;

	private final short TOTAL_PRODUTOS = 20;

	@Before
	public void setup() {
		carga();
	}

	@After
	public void after() {
		this.dropCollection("produtos", Produto.class);
	}

	@Test
	public void deveRecuperarUmProdutoComCodigoEspecificado() {

		Produto lProduto = new Produto();

		lProduto.setSku("000-0000-000-0"+TOTAL_PRODUTOS);

		List<Produto> lProdutos = produtoRepositorio.searchByProduto(lProduto);

		assertNotNull(lProdutos);
		assertEquals(1, lProdutos.size());
		assertEquals(lProduto.getSku(), lProdutos.get(0).getSku());
	}

	@Test
	public void deveRecuperarTodosOsProdutos() {
		List<Produto> produtos = produtoRepositorio.buscaTodos();

		assertNotNull(produtos);
		assertFalse(produtos.isEmpty());
		assertEquals(TOTAL_PRODUTOS, produtos.size());
	}

	@Test
	public void deveRecuperarProdutosComPrecoVarejoEntreIntervalo() {
		List<Produto> produtos = produtoRepositorio.buscaComIntervaloDePrecoVarejo(0, 2.0);

		assertNotNull(produtos);
	}

	@Test
	public void deveRecuperarProdutosComPrecoVarejoEntreIntervaloECapitulosEspecificado() {
		List<Produto> produtos = produtoRepositorio.buscaPorIntervaloDePrecoVarejoECapitulos(0, 2.0, "Complementar", "Outros");

		assertNotNull(produtos);
	}


	@Test
	public void deveRecuperarComTipoEspecificadoNoTexto() {

		Produto lProduto = new Produto();

		lProduto.setTipo("TENIS1");

		List<Produto> produtos = produtoRepositorio.searchByProduto(lProduto);

		assertNotNull(produtos);
		assertFalse(produtos.isEmpty());
		assertEquals(11, produtos.size());
	}

	@Test
	public void deveRecuperarComSkuEspecificadoNoTexto() {

		Produto lProduto = new Produto();

		lProduto.setSku("01");

		List<Produto> produtos = produtoRepositorio.searchByProduto(lProduto);

		assertNotNull(produtos);
		assertFalse(produtos.isEmpty());
		assertEquals(11, produtos.size());
	}

	private void carga() {
		for(int i=1; i<=TOTAL_PRODUTOS; i++) {
			Produto lProduto = newProduto(i);

			this.getMongoTemplate().save(lProduto);
		}
	}

	private Produto newProduto(int index) {
		Produto lProduto = new Produto();

		lProduto.setAutor("Teste" + index);
		lProduto.setDescricao("Produto Teste" + index);
		lProduto.setSku("000-0000-000-0" + index);
		lProduto.setTipo("TENIS" + index);
		lProduto.setTitulo("Tenis Teste" + index);

		Detalhes detalhes = new Detalhes();
		detalhes.setArtista("Artista " + index);
		detalhes.setAutor("Autor" + index);
		detalhes.setGenero("Genero " + index);
		detalhes.setTitulo("Titulo de Teste" + index);

		detalhes.setCapitulos(new ArrayList<String>());

		String lCompl = ((index % 2) == 0) ? "Complementar" : "Impar";

		if((index % 5) == 0)
			lCompl = "Outros";
		detalhes.getCapitulos().add(lCompl);
		detalhes.getCapitulos().add("Capitulo " + index*Math.ceil(Math.random()));
		detalhes.getCapitulos().add("Capitulo " + index*Math.ceil(Math.random()));

		detalhes.setPic(new ArrayList<String>());
		detalhes.getPic().add("PIC " + index*Math.random());
		detalhes.getPic().add("PIC " + index*Math.random());
		detalhes.getPic().add("PIC " + index*Math.random());

		detalhes.setTracks(new ArrayList<String>());
		detalhes.getTracks().add("Tracks " + index*Math.random());

		lProduto.setDetalhes(detalhes);
		lProduto.setPreco(new Preco(index*Math.random(), index*Math.random()));

		return lProduto;
	}
}