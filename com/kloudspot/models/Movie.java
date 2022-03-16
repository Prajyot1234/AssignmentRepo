package com.kloudspot.models;

import org.bson.codecs.pojo.annotations.*;

public class Movie {

	private String moviename,maleactor,femaleactor,director;
	private float rating;
	@BsonProperty("_id")
	private int _id;
	
	public Movie() {
		super();
	}
	
	public Movie(String moviename, String maleactor, String femaleactor, String director, float rating, int _id) {
		super();
		this.moviename = moviename;
		this.maleactor = maleactor;
		this.femaleactor = femaleactor;
		this.director = director;
		this.rating = rating;
		this._id = _id;
	}
	
	public String getMoviename() {
		return moviename;
	}
	
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	
	public String getMaleactor() {
		return maleactor;
	}
	
	public void setMaleactor(String maleactor) {
		this.maleactor = maleactor;
	}
	
	public String getFemaleactor() {
		return femaleactor;
	}
	
	public void setFemaleactor(String femaleactor) {
		this.femaleactor = femaleactor;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public int get_id() {
		return _id;
	}
	
	public void set_id(int _id) {
		this._id = _id;
	}
	
	@Override
	public String toString() {
		return "Movie [moviename=" + moviename + ", maleactor=" + maleactor + ", femaleactor=" + femaleactor
				+ ", director=" + director + ", rating=" + rating + ", _id=" + _id + "]";
	}
	
	
}
