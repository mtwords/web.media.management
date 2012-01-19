package ch.i10a.media.database;

import java.io.Serializable;

/**
 * Class foe the rating's records on the database
 */
public class RatingRec implements Serializable {

	private int rId;
	private String rateName;
	private int rating;
	private String ratingText;
	public int getrId() {
		return rId;
	}
	/** 
	 * Setter method to the unique id of a rating record
	 * @param rId: id of a rating record
	 */
	public void setrId(int rId) {
		this.rId = rId;
	}
	/**
	 * Getter method to retrieve the name of the rating person
	 * @return rateName: the rater's name
	 */
	public String getRateName() {
		return rateName;
	}
	/**
	 * Setter method to set the name of the rating person
	 * @param rateName: the rater's name
	 */	
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
	/**
	 * Getter method to retrieve the rating of a movie
	 * @return rating: the rating value of a movie
	 */
	public int getRating() {
		return rating;
	}
	/**
	 * Setter method to set the rating of a movie
	 * @param rating: the rating value of a movie
	 */	
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * Getter method to retrieve the comment to a rating
	 * @return ratingText: the comment to a rating
	 */
	public String getRatingText() {
		return ratingText;
	}
	/**
	 * Setter method to set the comment to a rating
	 * @param ratingText: the comment to a rating
	 */	
	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}

}
