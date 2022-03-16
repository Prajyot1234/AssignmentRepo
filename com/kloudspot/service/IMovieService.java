package com.kloudspot.service;

import java.util.List;

import com.kloudspot.exceptions.MovieNotFound;
import com.kloudspot.exceptions.MovieNotFoundByGivenID;
import com.kloudspot.exceptions.MovieNotFoundForGivenFemaleActorException;
import com.kloudspot.exceptions.MovieNotFoundForGivenMaleActorException;
import com.kloudspot.models.Movie;

public interface IMovieService {
	void addMovie(Movie movie);
	void updateMovie(int id,float rating);
	void deleteMovie(int id);
	List<Movie> getAllMovie();
	List<Movie> getMovieByMaleActorName(String name) throws MovieNotFoundForGivenMaleActorException;
	List<Movie> getMovieByFemaleActorName(String name) throws MovieNotFoundForGivenFemaleActorException;
	Movie getMovieByID(int id) throws MovieNotFoundByGivenID;
	List<Movie> getMovieWithHigherRatingThanFive() throws MovieNotFound;
	List<Movie> getMovieWithLowerRatingThanFive() throws MovieNotFound;
}
