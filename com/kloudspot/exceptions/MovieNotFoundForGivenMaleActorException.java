package com.kloudspot.exceptions;

import java.beans.ExceptionListener;

public class MovieNotFoundForGivenMaleActorException extends Exception {
	public MovieNotFoundForGivenMaleActorException(String ExceptionMessage) {
		super(ExceptionMessage);
	}
}
