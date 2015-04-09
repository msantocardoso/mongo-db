package br.com.cespec.infrastructure.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfiguracao extends AbstractMongoConfiguration{

	@Override
	protected String getDatabaseName() {
		return "dbtest";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("localhost");
	}
}