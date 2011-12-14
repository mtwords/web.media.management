package ch.i10a.media.database;

import java.util.ArrayList;

public class Database {
	
	public Database() {
		Movie movie = new Movie();
		Rating rating = new Rating();
		Person person = new Person();

	}
	
	private class Movie { 
		private int mId;
		private String title;
		private String originalTitle;
		private int duration;
		private String picString;
		private String genre;
		private String[] searchTerms;
		private String description;
		ArrayList<Person> actors;
		
		public Movie() {
			actors = new ArrayList<Person>();
			
		}
		
		/* Setter methods for the inner class Movie */
		public void setMovieId(int id) {
			this.mId = id;
		}
		public void setTitle(String s) {
			this.title = s;
		}
		public void setOriginalTitle(String s) {
			this.originalTitle = s;
		}
		public void setDuration(int dur) {
			this.duration = dur;
		}
		public void setPicString(String path) {
			this.picString = path;
		}
		public void setGenre(String s) {
			this.genre = s;
		}
		public void setSearchTerms(String[] terms) {
			this.searchTerms = terms;
		}
		public void setDescription(String s) {
			this.description = s;
		}
		/* Getter methods for the inner class Movie */
		public int getMovieId() {
			return this.mId;
		}
		public String getTitle() {
			return this.title;
		}
		public String getOriginalTitle() {
			return this.originalTitle;
		}
		public int getDuration() {
			return this.duration;
		}
		public String getPicString() {
			return this.picString;
		}
		public String getGenre() {
			return this.genre;
		}
		public String[] getSearchTerms() {
			return this.searchTerms;
		}
		public String getDescription() {
			return this.description;
		}
	}
	
	private class Person {
		private int pId;
		private String firstName;
		private String lastName;
		/* setter methods for the inner class Person */
		public void setPersonId(int id) {
			this.pId = id;
		}
		public void setFirstName(String fName) {
			this.firstName = fName;
		}
		public void setLastName(String lName) {
			this.lastName = lName;
		}
		/* getter methods for the inner class Person */
		public int getPersonId() {
			return this.pId;
		}
		public String getFirstName() {
			return this.firstName;
		}
		public String getLastName() {
			return this.lastName;
		}
		
	}
	
	private class Rating {
		private int rId;
		private String rateName;
		private int rating;
		private String ratingText;
	}

}
