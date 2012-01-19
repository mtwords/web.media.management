package ch.i10a.media.database;

import java.io.Serializable;
import java.sql.Date;

/**
 * Class for the Episode Records in the database
 * Implemente serializable for serialization. 
 */
public class EpisodeRec implements Serializable {

	String episodeTitle;
	String description;
	String year;
	String saveLocation;
	Date saveDate;
	int mId;

	/**
	 * Getter Method for the Episode title
	 * @return episodeTitle: The Title of the Episode
	 */
	public String getEpisodeTitle() {
		return episodeTitle;
	}
	/**
	 * Setter Method to an episode title
	 * @param episodeTitle: The Title of the episode
	 */
	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}
	/**
	 * Getter Method for the Description of a episode
	 * @return description: Description of the episode
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter Method to set the description of a episode
	 * @param description: The desciption of a episode
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter Method to retrieve the production year of the episode 
 * 	@return: the production year of a episode
 	*/
	public String getYear() {
		return year;
	}
	/**
	 * Setter Method to set the production year of a episode
	 * @param year: the production year of a episode
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * Getter method to retrieve the location where a episode has been saved to
	 * @return saveLocation: The location of the episode file
	 */
	public String getSaveLocation() {
		return saveLocation;
	}
	/**
	 * Setter Method to set a save location for a episode
	 * @param saveLocation: The location the episode has to be stored to.  
	 */
	public void setSaveLocation(String saveLocation) {
		this.saveLocation = saveLocation;
	}
	/**
	 * Getter method to retrieve the date a episode has been saved 
	 * @return saveDate: Date the episode has been saved on. 
	 */
	public Date getSaveDate() {
		return saveDate;
	}
	/**
	 * Setter method to set the date a episode has been saved on
	 * @param saveDate: The date a episode has been saved on. 
	 */
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	/**
	 * Getter Method to retrieve the record id (primary index on database) of a movie. 
	 * @return: mId: the (unique) id of a episode record. 
	 */
	public int getmId() {
		return mId;
	}
	/** 
	 * Setter Method to set the movie id for an episode (each episode is linked to a movie record id)
	 * @param mId: unique id of a movie record. 
	 */
	public void setmId(int mId) {
		this.mId = mId;
	}

}
