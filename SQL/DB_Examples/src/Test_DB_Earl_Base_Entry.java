
import java.sql.*;
import java.io.*;

class Test_DB_Earl_Base_Entry {
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
	            File image = new File("C:/pic/MyNameIsEarl.jpg");
	            File image2 = new File("C:/pic/thumbs/MyNameIsEarl.jpg");

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */
               psmnt = connection.prepareStatement("insert into movie(title, originalTitle, duration, icon, thumbnail, type, keywords, description) "+
				   "values(?,?,?,?,?,?,?,?)");
               //Titel einfügen
               psmnt.setString(1,"My Name is Earl");
               //Originaltitel einfügen
	           psmnt.setString(2,"My Name is Earl");
	           //Dauer einfügen
               psmnt.setString(3,"1800");
               //Dauer einfügen
               psmnt.setString(6,"1");
               //Dauer einfügen
               psmnt.setString(7,"Earl, Hickey, trailer, park");
             //Dauer einfügen
               psmnt.setString(8,"Earl is a low-life who buys a winning lottery ticket, only to get hit by a car, losing the ticket in the process. He then realizes in the hospital that his bad luck is the result of karma in which fate punishes him for all the rotten things he's ever done in his life; therefore, he then decides to dedicate his life to making amends to all the people he has hurt in his life.");

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
			   "values(?,?,?,?,?,(Select mId from movie where title = 'My Name is Earl'))");
               
               psmnt.setString(1,"S01E01 - Pilot");
               psmnt.setString(2,"Earl wins the lottery, but loses the ticket. He discovers that it could be because he has bad karma. So he makes a list and begins fixing the bad things he has done. And once he begins working on his list, the ticket finds its way back to him.");
               psmnt.setString(3,"2005");
               psmnt.setString(4,"O:\\vid\\Serien\\earl\\My Name Is Earl - Season 1\\My.Name.Is.Earl.S01E01.Pilot.DVDRip.XviD-FoV.ShareVirus.avi");
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
			   "values(?,(Select mId from movie where title = 'My Name is Earl'))");
               
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
			   "values(?,(Select mId from movie where title = 'My Name is Earl'))");
               
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
               //Jason Lee
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Jason");
               psmnt.setString(2,"Lee");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JL).");
               }
               
             //Jason Lee plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Jason'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(ZL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(ZL).");
               }
             //Ethan Suplee
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Ethan");
               psmnt.setString(2,"Suplee");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(ES) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(ES).");
               }
             //Ethan Suplee plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Ethan'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(ES) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(ES).");
               }
             //Jaime Pressly
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Jaime");
               psmnt.setString(2,"Pressly");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(JP) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(JP).");
               }
             //Jaime Pressly plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Jaime'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(JP) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(JP).");
               }
             //Nadine Velazquez
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Nadine");
               psmnt.setString(2,"Velazquez");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(NV) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(NV).");
               }
             //Nadine Velazquez plays
               psmnt = connection.prepareStatement("insert into actsin(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Nadine'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded plays(NV) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload plays(NV).");
               }
             //Marc Buckland (Director)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Marc");
               psmnt.setString(2,"Buckland");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(MB) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(MB).");
               }
               //Marc Buckland directs
               psmnt = connection.prepareStatement("insert into directs(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Marc'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded directs(MB) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload directs(MB).");
               }
             //Gregory Thomas Garcia  (Writer)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Gregory Thomas");
               psmnt.setString(2,"Garcia");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(GG) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(GG).");
               }
               //Gregory Thomas Garcia  wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Gregory Thomas'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(GG) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(GG).");
               }
             //Kat Likkel (Writer)
               psmnt = connection.prepareStatement("insert into person(firstName, lastName) "+
			   "values(?,?)");
               
               psmnt.setString(1,"Kat");
               psmnt.setString(2,"Likkel");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded Person(KL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload Person(KL).");
               }
             //Kat Likkel wrote
               psmnt = connection.prepareStatement("insert into wrotescreenplay(mId, pId) "+
			   "values((Select mId from movie where title = 'My Name is Earl'),(Select pId from person where firstName = 'Kat'))");
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded wrote(KL) successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload wrote(KL).");
               }
               //
               // Bewertungs-Einträge
               //
               //Bewertung 1
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"BPT");
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
               
               psmnt.setString(1,"CTC");
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
               
               psmnt.setString(1,"HKA");
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
			   "values((Select eId from episode where year = '2005'),(Select rId from rating where ratedBy = 'BPT' and rating = '5'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-1 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-1.");
               }
             //Bewertung 2
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where year = '2005'),(Select rId from rating where ratedBy = 'CTC' and rating = '3'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-2 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-2.");
               }
             //Bewertung 3
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where year = '2005'),(Select rId from rating where ratedBy = 'HKA' and rating = '3'))");

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
