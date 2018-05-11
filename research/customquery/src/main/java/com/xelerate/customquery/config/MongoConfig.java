package com.xelerate.customquery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@ComponentScan(basePackages = "com.xelerate")
@EnableMongoRepositories({ "com.xelerate.customquery.repository" })
public class MongoConfig {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoCredential credential = MongoCredential.createCredential("xdmf", "DEV", "xdmf".toCharArray());
		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(5).build();
		MongoClient mongoClient = new MongoClient(prepareServerAddress(), credential, options);
		return new SimpleMongoDbFactory(mongoClient, "DEV");
	}

	private ServerAddress prepareServerAddress() {
		String host = "192.168.11.34";
		Integer port = 27020;
		return new ServerAddress(host, port);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
}
