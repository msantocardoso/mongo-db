package br.com.cespec.infrastructure.repository.mongodb;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cespec.model.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, ObjectId> {

	Usuario findByNome(String nome);
}
