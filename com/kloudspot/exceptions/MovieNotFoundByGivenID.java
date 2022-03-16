package com.kloudspot.exceptions;

public class MovieNotFoundByGivenID extends Exception {
	public MovieNotFoundByGivenID(String ExceptionMessage) {
		super(ExceptionMessage);
	}
}
