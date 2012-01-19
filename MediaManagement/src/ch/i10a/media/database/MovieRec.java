package ch.i10a.media.database;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class for the movie records in the database 
 *
 */
public class MovieRec implements Serializable {

	private int mId;
	private String title;
	private String originalTitle;
	private int duration;
	private byte[] icon;
	private byte[] thumbnail;
	private int type;
	private String genre;
	private String[] searchTerms;
	private String description;
	ArrayList<PersonRec> actors = new ArrayList<PersonRec>();

	/**
	 * Setter method to set the movie id
	 * @param id: id of the movie
	 */
	public void setMovieId(int id) {
		this.mId = id;
	}
	/**
	 * Getter method to retrieve the movie id
	 * @return
	 */
	public int getMovieId() {
		return this.mId;
	}
	/**
	 * Setter method to set the movie title
	 * @param s: the title of the movie
	 */
	public void setTitle(String s) {
		this.title = s;
	}
	/**
	 * Getter Method to retrieve the title of a movie (localized)
	 * @return title: the title of a movie (localized)
	 */
	public String getTitle() {
		return this.title;
	}
	/**
	 * Setter method to set the original title of a movie
	 * @param s: the title of the movie
	 */
	public void setOriginalTitle(String s) {
		this.originalTitle = s;
	}
	/**
	 * Getter Method to retrieve the original title of a movie
	 * @return title: the original title of a movie
	 */	
	public String getOriginalTitle() {
		return this.originalTitle;
	}
	/**
	 * Setter method to set the duration of a movie
	 * @param dur: duration of a movie (saved as int for easier handle)
	 */
	public void setDuration(int dur) {
		this.duration = dur;
	}
	/**
	 * Getter method to retrieve the duration of a movie
	 * @return duration: the duration of a movie
	 */
	public int getDuration() {
		return this.duration;
	}
	/**
	 * Setter method to set the path to an picture of the movie (e.g. DVD cover or theatre poster)
	 * @param path: Path to the picture
	 */
	public void setIcon(byte[] path) {
		this.icon = path;
	}
	/**
	 * Getter method to retrieve the path to an picture of the movie (e.g. DVD cover or theatre poster)
	 * @return icon: path to the picture 
	 */
	public byte[] getIcon() {
		return this.icon;
	}
	/**
	 * Setter method to set the path to an picture of the movie (e.g. DVD cover or theatre poster) shrunk to a thumbnail (preview)
	 * @param path: Path to the thumbnail
	 */
	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	/**
	 * Getter method to retrieve the path to an picture of the movie (e.g. DVD cover or theatre poster) shrunk to a thumbnail (preview)
	 * @return icon: path to the thumbnail
	 */
	public byte[] getThumbnail() {
		return thumbnail;
	}
	/**
	 * Setter method to set the type of a record
	 * @param type: type of the record 
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * Getter method to retrieve the type of a reocrd
	 * @return type: the type of a record
	 */
	public int getType() {
		return type;
	}
	/**
	 * Setter method to set the genre of a movie
	 * @param s: genre of the movie 
	 */
	public void setGenre(String s) {
		this.genre = s;
	}
	/** 
	 * Getter method to set the genre of a movie
	 * @return genre: genre of a movie 
	 */
	public String getGenre() {
		return this.genre;
	}
	/**
	 * Setter method to set the keywords the movie must be displayed upon when conducting a search
	 * @param terms: Search terms
	 */
	public void setSearchTerms(String[] terms) {
		this.searchTerms = terms;
	}
	/**
	 * Getter method to retrieve the keywords the movie must be displayed upon when conducting a search
	 * @return terms: search terms
	 */
	public String[] getSearchTerms() {
		return this.searchTerms;
	}
	/**
	 * Setter Method to set the Description of a movie
	 * @param description: Description of a movie
	 */	
	public void setDescription(String s) {
		this.description = s;
	}
	/**
	 * Getter Method for the Description of a movie
	 * @return description: Description of a movie
	 */	
	public String getDescription() {
		return this.description;
	}


}
