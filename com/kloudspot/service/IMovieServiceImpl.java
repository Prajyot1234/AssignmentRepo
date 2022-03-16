package com.kloudspot.service;

import java.util.List;
import java.util.stream.Collectors;

import com.kloudspot.exceptions.MovieNotFound;
import com.kloudspot.exceptions.MovieNotFoundByGivenID;
import com.kloudspot.exceptions.MovieNotFoundForGivenFemaleActorException;
import com.kloudspot.exceptions.MovieNotFoundForGivenMaleActorException;
import com.kloudspot.models.Movie;
import com.kloudspot.repository.IMovieRepository;
import com.kloudspot.repository.IMovieRepositoryImpl;

public class IMovieServiceImpl implements IMovieService {

	IMovieRepository movieService = new IMovieRepositoryImpl();
	
	public void addMovie(Movie movie) {
		movieService.addMovie(movie);
	}

	public void updateMovie(int id, float rating) {
		movieService.updateMovie(id, rating);
	}

	public void deleteMovie(int id) {
		movieService.deleteMovie(id);
	}

	public List<Movie> getAllMovie() {
		return movieService.findAllMovie();
	}

	public List<Movie> getMovieByMaleActorName(String name) throws MovieNotFoundForGivenMaleActorException {
		return movieService.findMovieByMaleActorName(name).stream().sorted((m1,m2)-> m1.getMaleactor().compareTo(m2.getMaleactor())).collect(Collectors.toList());
	}

	public List<Movie> getMovieByFemaleActorName(String name) throws MovieNotFoundForGivenFemaleActorException {
		return movieService.findMovieByFemaleActorName(name).stream().sorted((m1,m2) -> m1.getFemaleactor().compareTo(m2.getFemaleactor())).collect(Collectors.toList());
	}

	public Movie getMovieByID(int id) throws MovieNotFoundByGivenID {
		return movieService.findMovieByID(id);
	}

	public List<Movie> getMovieWithHigherRatingThanFive() throws MovieNotFound {
		return movieService.findMovieWithHigherRatingThanFive().stream().sorted((m1,m2) -> m1.getMoviename().compareTo(m2.getMoviename())).collect(Collectors.toList());
	}

	public List<Movie> getMovieWithLowerRatingThanFive() throws MovieNotFound {
		return movieService.findMovieWithHigherRatingThanFive().stream().sorted((m1,m2) -> m1.getMoviename().compareTo(m2.getMoviename())).collect(Collectors.toList());
	}

}
