package com.kloudspot.repository;

import java.util.List;

import com.kloudspot.exceptions.MovieNotFound;
import com.kloudspot.exceptions.MovieNotFoundByGivenID;
import com.kloudspot.exceptions.MovieNotFoundForGivenFemaleActorException;
import com.kloudspot.exceptions.MovieNotFoundForGivenMaleActorException;
import com.kloudspot.models.Movie;

public interface IMovieRepository {
	void addMovie(Movie movie);
	void updateMovie(int id,float rating);
	void deleteMovie(int id);
	
	List<Movie> findAllMovie();
	List<Movie> findMovieByMaleActorName(String name) throws MovieNotFoundForGivenMaleActorException;
	List<Movie> findMovieByFemaleActorName(String name) throws MovieNotFoundForGivenFemaleActorException;
	Movie findMovieByID(int id) throws MovieNotFoundByGivenID;
	List<Movie> findMovieWithHigherRatingThanFive() throws MovieNotFound;
	List<Movie> findMovieWithLowerRatingThanFive() throws MovieNotFound;

}
