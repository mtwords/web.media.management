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

}


					
							
Folgen							
F-ID	Folge	Beschreibung	Jahr	Speicherort	Aufnahme-Datum	M-ID	
ID (auto Increment)	Text	Text	Year	Text	Date	ID	
							
hat							
F-ID	Bewertungs-ID						
ID	ID						
							
Bewertungen							
Bewertungs-ID	Bewertung	Bewerter					
ID (auto Increment)	SmallInt	Text					
							
Kategorien							
Kategorie	M-ID						
Text	ID						
							
Sprachen	M-ID						
Sprache	ID						
