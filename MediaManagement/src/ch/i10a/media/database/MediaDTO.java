package ch.i10a.media.database;

import java.io.Serializable;

public class MediaDTO implements Serializable {

	private MovieRec movieRec = new MovieRec();
	private EpisodeRec episodeRec = new EpisodeRec();

	public MovieRec getMovieRec() {
		return movieRec;
	}
	public void setMovieRec(MovieRec movieRec) {
		this.movieRec = movieRec;
	}

	public EpisodeRec getEpisodeRec() {
		return episodeRec;
	}
	public void setEpisodeRec(EpisodeRec episodeRec) {
		this.episodeRec = episodeRec;
	}

}
