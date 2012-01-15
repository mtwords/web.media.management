package ch.i10a.media.database;

import java.io.Serializable;
import java.util.ArrayList;

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

	public void setMovieId(int id) {
		this.mId = id;
	}
	public int getMovieId() {
		return this.mId;
	}

	public void setTitle(String s) {
		this.title = s;
	}
	public String getTitle() {
		return this.title;
	}

	public void setOriginalTitle(String s) {
		this.originalTitle = s;
	}
	public String getOriginalTitle() {
		return this.originalTitle;
	}

	public void setDuration(int dur) {
		this.duration = dur;
	}
	public int getDuration() {
		return this.duration;
	}

	public void setIcon(byte[] path) {
		this.icon = path;
	}
	public byte[] getIcon() {
		return this.icon;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}

	public void setGenre(String s) {
		this.genre = s;
	}
	public String getGenre() {
		return this.genre;
	}

	public void setSearchTerms(String[] terms) {
		this.searchTerms = terms;
	}
	public String[] getSearchTerms() {
		return this.searchTerms;
	}

	public void setDescription(String s) {
		this.description = s;
	}
	public String getDescription() {
		return this.description;
	}


}
