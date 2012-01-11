package ch.i10a.media.database;

import java.io.Serializable;
import java.sql.Date;

public class EpisodeRec implements Serializable {

	String episodeTitle;
	String description;
	String year;
	String saveLocation;
	Date saveDate;
	int mId;

	public String getEpisodeTitle() {
		return episodeTitle;
	}
	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getSaveLocation() {
		return saveLocation;
	}
	public void setSaveLocation(String saveLocation) {
		this.saveLocation = saveLocation;
	}

	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}

}
