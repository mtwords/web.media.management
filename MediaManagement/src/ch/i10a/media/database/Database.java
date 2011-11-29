package ch.i10a.media.database;

public class Database {
	
	private class Movie { 
		private int mId;
		private String title;
		private String originalTitle;
		private String duration;
		private String picString;
		private String genre;
		private String[] searchTerms;
		private String description;
	}
	
	private class Person {
		private int pId;
		private String firstName;
		private String lastName;
	}
	
	private class Rating {
		private int rId;
		private String rateName;
		private int rating;
		private String ratingText;
	}
	

}