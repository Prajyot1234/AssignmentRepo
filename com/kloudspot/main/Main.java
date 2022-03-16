package com.kloudspot.main;

import com.kloudspot.exceptions.MovieNotFound;
import com.kloudspot.exceptions.MovieNotFoundByGivenID;
import com.kloudspot.exceptions.MovieNotFoundForGivenFemaleActorException;
import com.kloudspot.exceptions.MovieNotFoundForGivenMaleActorException;
import com.kloudspot.models.Movie;
import com.kloudspot.service.IMovieService;
import com.kloudspot.service.IMovieServiceImpl;

public class Main {
	public static void main(String[] args) {
		IMovieService movieService = new IMovieServiceImpl();
		
		Movie m1 = new Movie("Avengers EndGame", "Chris Evans", "Scarlett Johnsons", "Joe Russo", 8.9f, 1);
		Movie m2 = new Movie("No Time to die", "Daniel", "Ana", "Cary", 7.3f, 2);
		Movie m3 = new Movie("Dune", "Timothee", "Zendaya", "Denis", 8.1f, 3);
		Movie m4 = new Movie("Don't Look Up","Leonardo","Jennifer Lawrence","Adam",7.8f,4);
		Movie m5 = new Movie("Titanic", "Leonardo", "Kate winslet", "James", 8.1f, 5);
		
		System.out.println("Adding Books");
		movieService.addMovie(m1);
		movieService.addMovie(m2);
		movieService.addMovie(m3);
		movieService.addMovie(m4);
		movieService.addMovie(m5);
		
		System.out.println();
		System.out.println("Printing All Movies");
		movieService.getAllMovie().stream().forEach(System.out::println);
		
		System.out.println();
		try {
			System.out.println("Movies list with lenoardo as male actor");
			movieService.getMovieByMaleActorName("Leonardo").stream().forEach(System.out::println);
		} catch (MovieNotFoundForGivenMaleActorException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		try {
			System.out.println("Movies list with Zendaya as female actor");
			movieService.getMovieByFemaleActorName("Zendaya").stream().forEach(System.out::println);
		} catch (MovieNotFoundForGivenFemaleActorException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		try {
			System.out.println("Movie with id 1");
			Movie m = movieService.getMovieByID(1);
			System.out.println(m);
		} catch (MovieNotFoundByGivenID e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		try {
			System.out.println("Rating greater than five");
			movieService.getMovieWithHigherRatingThanFive().stream().forEach(System.out::println);
		} catch (MovieNotFound e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		try {
			System.out.println("Rating less than five");
			movieService.getMovieWithLowerRatingThanFive().stream().forEach(System.out::println);
		} catch (MovieNotFound e) {
			System.out.println(e.getMessage());
		}
		
	}
}
