package br.com.cespec.infrastructure.repository.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cespec.infrastructure.repository.AbstracaoTesteMongoSpringData;
import br.com.cespec.model.Usuario;

public class UsuarioRepositorioTest extends AbstracaoTesteMongoSpringData {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;

	@After
	public void after() {
		this.dropCollection("usuario", Usuario.class);
	}

	@Test
	public void salvaUsuarioERecuperaUsandoRecursoRepository() {

		Usuario lUsuario = new Usuario("Murilo Cardoso", "passw");

		usuarioRepositorio.save(lUsuario);

		Usuario usuario = usuarioRepositorio.findByNome("Murilo Cardoso");

		assertNotNull(usuario);
		assertEquals(usuario.getNome(), lUsuario.getNome());
		assertEquals(usuario.getSenha(), lUsuario.getSenha());
	}
}
