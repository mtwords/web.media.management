
import java.sql.*;
import java.io.*;

class Test_DB_Hot_Fuzz {
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
	            File image = new File("C:/pic/hot-fuzz-poster-2.jpg");
	            File image2 = new File("C:/pic/thumbs/hot-fuzz-poster-2.jpg");

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */
               psmnt = connection.prepareStatement("insert into movie(title, originalTitle, duration, icon, thumbnail, type, keywords, description) "+
				   "values(?,?,?,?,?,?,?,?)");
               //Titel einfügen
               psmnt.setString(1,"Hot Fuzz");
               //Originaltitel einfügen
	           psmnt.setString(2,"Hot Fuzz");
	           //Dauer einfügen
               psmnt.setString(3,"7260");
               //Dauer einfügen
               psmnt.setString(6,"0");
               //Dauer einfügen
               psmnt.setString(7,"Hot, Fuzz, England, English");
             //Dauer einfügen
               psmnt.setString(8,"Jealous colleagues conspire to get a top London cop transferred to a small town and paired with a witless new partner. On the beat, the pair stumble upon a series of suspicious accidents and events.");

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
			   "values(?,?,?,?,?,(Select mId from movie where title = 'Hot Fuzz'))");
               
               psmnt.setString(1,"Hot Fuzz");
               psmnt.setString(2,"Jealous colleagues conspire to get a top London cop transferred to a small town and paired with a witless new partner. On the beat, the pair stumble upon a series of suspicious accidents and events.");
               psmnt.setString(3,"2008");
               psmnt.setString(4,"O:\\vid\\Complete Movies\\Hot.Fuzz[2007]DvDrip[Eng]-aXXo\\Hot.Fuzz[2007]DvDrip[Eng]-aXXo.avi");
               psmnt.setString(5,"1330624840");
               
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
			   "values(?,(Select mId from movie where title = 'Hot Fuzz'))");
               
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
			   "values(?,(Select mId from movie where title = 'Hot Fuzz'))");
               
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
               //Simon Pegg
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Simon");
               psmnt.setString(2,"Pegg");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(SP) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(SP).");
               }
               
             //Simon Pegg plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Simon'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(SP) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(SP).");
               }
             //Nick Frost
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Nick");
               psmnt.setString(2,"Frost");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(NF) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(NF).");
               }
             //Nick Frost plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Nick'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(NF) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(NF).");
               }
             //Joe Cornish
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Joe");
               psmnt.setString(2,"Cornish");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JC) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JC).");
               }
             //Joe Cornish plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Joe'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(JC) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(JC).");
               }

             //Edgar Wright (Director)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Edgar");
               psmnt.setString(2,"Wright");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(EW) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(EW).");
               }
               //Edgar Wright directs
               psmnt = connection.prepareStatement("insert into directs(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Edgar'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded directs(EW) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload directs(EW).");
               }
             
               //Simon Pegg wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Simon'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(SP) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(SP).");
               }
             
             //Edgar Wright wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'Hot Fuzz'),(Select pId from person where firstName = 'Edgar'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(EW) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(EW).");
               }
               //
               // Bewertungs-Einträge
               //
               //Bewertung 1
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"BPN");
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
               
               psmnt.setString(1,"OCA");
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
               
               psmnt.setString(1,"JKP");
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
			   "values((Select eId from episode where episodeTitle = 'Hot Fuzz'),(Select rId from rating where ratedBy = 'BPN' and rating = '5'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-1 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-1.");
               }
             //Bewertung 2
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'Hot Fuzz'),(Select rId from rating where ratedBy = 'OCA' and rating = '3'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-2 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-2.");
               }
             //Bewertung 3
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'Hot Fuzz'),(Select rId from rating where ratedBy = 'JKP' and rating = '3'))");

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
