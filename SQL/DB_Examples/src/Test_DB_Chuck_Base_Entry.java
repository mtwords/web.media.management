
import java.sql.*;
import java.io.*;

class Test_DB_Chuck_Base_Entry {
      public static void main(String[] args) throws SQLException {

    	  
    	  int s;
            // declare a connection by using Connection interface 
            Connection connection = null;

            /* Create string of connection url within specified format with machine 
			name, port number and database name. Here machine name id localhost 
			and database name is mahendra. */

            String connectionURL = "jdbc:mysql://db4free.net:3306/mmanagement";

            /*declare a resultSet that works as a table resulted by execute a specified 
			sql query. */
            ResultSet rs = null;

            // Declare statement.
            PreparedStatement psmnt = null;
           
		    // declare FileInputStream object to store binary stream of given image.
			FileInputStream fis;
			FileInputStream fis2;

            try {

                // Load JDBC driver "com.mysql.jdbc.Driver"
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                /* Create a connection by using getConnection() method that takes 
				parameters of string type connection url, user name and password to 
				connect to database. */
                connection = DriverManager.getConnection(connectionURL, "webmedia", "web.media");

                // create a file object for image by specifying full path of image as parameter.
	            File image = new File("C:/pic/chuck0_1.jpg");
	            File image2 = new File("C:/pic/thumbs/chuck0_1.jpg");

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */
               psmnt = connection.prepareStatement("insert into movie(title, originalTitle, duration, icon, thumbnail, type, keywords, description) "+
				   "values(?,?,?,?,?,?,?,?)");
               //Titel einfügen
               psmnt.setString(1,"Chuck");
               //Originaltitel einfügen
	           psmnt.setString(2,"Chuck");
	           //Dauer einfügen
               psmnt.setString(3,"1800");
               //Dauer einfügen
               psmnt.setString(6,"1");
               //Dauer einfügen
               psmnt.setString(7,"Chuck, Bartowski, Spy");
             //Dauer einfügen
               psmnt.setString(8,"When a twenty-something computer geek inadvertently downloads critical government secrets into his brain, CIA and NSA assign two agents to protect him and exploit such knowledge, turning his life upside down. ");

               fis = new FileInputStream(image);
               fis2 = new FileInputStream(image2);
	 
               psmnt.setBinaryStream(4, (InputStream)fis, (int)(image.length()));
               psmnt.setBinaryStream(5, (InputStream)fis2, (int)(image2.length()));

	           /* executeUpdate() method execute specified sql query. Here this query 
	           insert data and image from specified address. */ 
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded movie successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload movie.");
               }
               //
               // Episoden-Einträge
               //
               //
               psmnt = connection.prepareStatement("insert into episode(episodeTitle, description, year, saveLocation, saveDate, mId) "+
			   "values(?,?,?,?,?,(Select mId from movie where title = 'Chuck'))");
               
               psmnt.setString(1,"S01E01 - Pilot");
               psmnt.setString(2,"Chuck is a computer geek who gets a computer full of information zapped into his brain...information that contains secrets that the federal government desperately needs to keep in Chuck's head...and keep Chuck, himself, intact. In the opener Chuck meets a woman who agrees to go on a date with him, but she's one of the government agents who's interested more in his head than his body.");
               psmnt.setString(3,"2007");
               psmnt.setString(4,"O:\\vid\\Serien\\Chuck\\Season 1\\Chuck 01x01 - Pilot.avi");
               psmnt.setString(5,"1330624800");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded episode successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload episode.");
               }
               
               //
               // Kategorie-Einträge
               //
               //
               psmnt = connection.prepareStatement("insert into category(category, mId) "+
			   "values(?,(Select mId from movie where title = 'Chuck'))");
               
               psmnt.setString(1,"Comedy");
               
               
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded category successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload category.");
               }
               
               //
               // Language-Einträge
               //
               //
               psmnt = connection.prepareStatement("insert into language(lang, mId) "+
			   "values(?,(Select mId from movie where title = 'Chuck'))");
               
               psmnt.setString(1,"E");
               
               
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded language successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload language.");
               }
               
               //
               // Personen-Einträge und actsin, directs and wrotescreenplay
               //
               //
               //Zachary Levy
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Zachary");
               psmnt.setString(2,"Levi");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(ZL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(ZL).");
               }
               
             //Zachary Levy plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Zachary'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(ZL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(ZL).");
               }
             //Yvonne Strahovski
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Yvonne");
               psmnt.setString(2,"Strahovski");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(YS) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(YS).");
               }
             //Yvonne Strahovski plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Yvonne'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(YS) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(YS).");
               }
             //Adam Baldwin
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Adam");
               psmnt.setString(2,"Baldwin");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(AB) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(AB).");
               }
             //Adam Baldwin plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Adam'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(AB) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(AB).");
               }
             //Joshua Gomez
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Joshua");
               psmnt.setString(2,"Gomez");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JG) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JG).");
               }
             //Joshua Gomez plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Joshua'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(JG) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(JG).");
               }
             //Joseph McGinty (Director)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Joseph");
               psmnt.setString(2,"McGinty");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JM) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JM).");
               }
               //Joseph McGinty directs
               psmnt = connection.prepareStatement("insert into directs(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Joseph'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded directs(JM) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload directs(JM).");
               }
             //Josh Schwartz (Writer)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Josh");
               psmnt.setString(2,"Schwartz");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JS) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JS).");
               }
               //Josh Schwartz wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Josh'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(JS) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(JS).");
               }
             //Chris Fedak (Writer)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Chris");
               psmnt.setString(2,"Fedak");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(CF) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(CF).");
               }
             //Chris Fedak wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'Chuck'),(Select pId from person where firstName = 'Chris'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(CF) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(CF).");
               }
               //
               // Bewertungs-Einträge
               //
               //Bewertung 1
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"RKA");
               psmnt.setString(2,"5");
               
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1.");
               }
             //Bewertung 2
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"OA");
               psmnt.setString(2,"3");
               
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating2 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating2.");
               }
             //Bewertung 3
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"PKE");
               psmnt.setString(2,"3");
               
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating3 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating3.");
               }
               
               //
               // Bewertungs-Zwischentabelle
               //
               //Bewertung 1
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'S01E01 - Pilot'),(Select rId from rating where ratedBy = 'RKA' and rating = '5'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-1 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-1.");
               }
             //Bewertung 2
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'S01E01 - Pilot'),(Select rId from rating where ratedBy = 'OA' and rating = '3'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-2 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-2.");
               }
             //Bewertung 3
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'S01E01 - Pilot'),(Select rId from rating where ratedBy = 'PKE' and rating = '3'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-3 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-3.");
               }
               
             
               
           }

           // catch if found any exception during rum time.
           catch (Exception ex) {
	              System.out.println("Found some error : "+ex);
           }

           finally {
	            // close all the connections.
	            connection.close();
                psmnt.close();
           }
	  }
}
