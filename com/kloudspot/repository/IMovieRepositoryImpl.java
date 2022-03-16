package com.kloudspot.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import com.kloudspot.exceptions.MovieNotFound;
import com.kloudspot.exceptions.MovieNotFoundByGivenID;
import com.kloudspot.exceptions.MovieNotFoundForGivenFemaleActorException;
import com.kloudspot.exceptions.MovieNotFoundForGivenMaleActorException;
import com.kloudspot.models.Movie;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

public class IMovieRepositoryImpl implements IMovieRepository {
	DBManager dbmanger = new DBManager();
	
	public void addMovie(Movie movie) {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		collection.insertOne(movie);
		System.out.println("Inserted successfully");
	}

	public void updateMovie(int id, float rating) {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		Bson filter = Filters.eq("_id",id);
		Bson update = Updates.set("price", rating);
		collection.updateOne(filter,update);
		System.out.println("updated successfully");
	}

	public void deleteMovie(int id) {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		collection.deleteOne(Filters.eq("_id",id));
		System.out.println("deleted Successfully");
	}

	public List<Movie> findAllMovie() {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		return collection.find().into(new ArrayList<Movie>());
	}

	public List<Movie> findMovieByMaleActorName(String name) throws MovieNotFoundForGivenMaleActorException {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		List<Movie> movies = collection.find(Filters.eq("maleactor",name)).into(new ArrayList<Movie>());
		if(movies.isEmpty()) {
			throw new MovieNotFoundForGivenMaleActorException("Movies not found by given male actor name : ");
		}
		return movies;
	}

	public List<Movie> findMovieByFemaleActorName(String name) throws MovieNotFoundForGivenFemaleActorException {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		List<Movie> movies = collection.find(Filters.eq("femaleactor",name)).into(new ArrayList<Movie>());
		if(movies.isEmpty()) {
			throw new MovieNotFoundForGivenFemaleActorException("Movies not found by given male actor name : ");
		}
		return movies;
	}

	public Movie findMovieByID(int id) throws MovieNotFoundByGivenID {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		Movie movie = collection.find(Filters.eq("_id",id)).first();
		if(movie==null) {
			throw new MovieNotFoundByGivenID("Invalid ID");
		}
		return movie;
	}

	public List<Movie> findMovieWithHigherRatingThanFive() throws MovieNotFound {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		List<Movie> movies = collection.find(Filters.gt("rating", 5.0)).into(new ArrayList<Movie>());
		if(movies==null) {
			throw new MovieNotFound("Not have movie whoes rating greater than 5.0");
		}
		return movies;
	}

	public List<Movie> findMovieWithLowerRatingThanFive() throws MovieNotFound {
		MongoCollection<Movie> collection = dbmanger.findCollection();
		List<Movie> movies = collection.find(Filters.eq("rating", Filters.lt("rating", 5.0))).into(new ArrayList<Movie>());
		if(movies==null) {
			throw new MovieNotFound("Not have movie whoes rating less than 5.0");
		}
		return movies;
	}

}
