package com.kloudspot.repository;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.kloudspot.models.Movie;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static org.bson.codecs.configuration.CodecRegistries.*;

public class DBManager {
	static MongoClient mongoInstance;
	static MongoDatabase database = null;

	public static void openDatabase() {

		String connectionString = "mongodb://localhost:27017";
		ConnectionString connection = new ConnectionString(connectionString);

		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		
		// set the codecregistry and the connection string
		MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connection)
				.codecRegistry(codecRegistry).build(); // configuration for mongodb connection

		mongoInstance = MongoClients.create(clientSettings);
	}

	public static void closeConnection() {
		mongoInstance.close();
	}

	public MongoDatabase findDatabase() {
		openDatabase();
		database = mongoInstance.getDatabase("kloudb");
		return database;
	}

	public MongoCollection<Movie> findCollection() {
		if(database == null)
			database = findDatabase();
//		database.createCollection("movie");
		MongoCollection<Movie> collection = database.getCollection("movie", Movie.class);
		return collection;
	}
	
}  	
