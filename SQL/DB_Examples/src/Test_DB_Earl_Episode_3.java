
import java.sql.*;
import java.io.*;

class Test_DB_Earl_Episode_3 {
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

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */

               //
               // Episoden-Einträge
               //
               //
               psmnt = connection.prepareStatement("insert into episode(episodeTitle, description, year, saveLocation, saveDate, mId) "+
			   "values(?,?,?,?,?,(Select mId from movie where title = 'My Name is Earl'))");
               
               psmnt.setString(1,"S01E03 - Randys Touchdown");
               psmnt.setString(2,"Earl decides that the next thing he needs to make right is to quit smoking. However, Randy and Catalina are of the opinion that Earl needs to face his fear of Donny Jones, even if it kills him. Coincidentally, Joy is planning to kill Earl in order to inherit his money");
               psmnt.setString(3,"2007");
               psmnt.setString(4,"O:\\vid\\Serien\\Chuck\\Season 1\\my_name_is_earl.1x03.randys_touchdown.dvdrip_xvid-fov.avi");
               psmnt.setString(5,"1330624800");
               
               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded episode successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload episode.");
               }

               
               
               //
               // Bewertungs-Einträge
               //
               //Bewertung 1
               psmnt = connection.prepareStatement("insert into rating(ratedBy, rating) "+
			   "values(?,?)");
               
               psmnt.setString(1,"AKT");
               psmnt.setString(2,"4");
               
               
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
               
               psmnt.setString(1,"BKT");
               psmnt.setString(2,"4");
               
               
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
               
               psmnt.setString(1,"CTT");
               psmnt.setString(2,"2");
               
               
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
			   "values((Select eId from episode where episodeTitle = 'S01E03 - Randys Touchdown'),(Select rId from rating where ratedBy = 'AKT' and rating = '4'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-1 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-1.");
               }
             //Bewertung 2
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'S01E03 - Randys Touchdown'),(Select rId from rating where ratedBy = 'BKT' and rating = '4'))");

               s = psmnt.executeUpdate();
               if(s>0) {
                      System.out.println("Uploaded rating1-2 successfully !");
               }
               else {
		            System.out.println("unsucessfull to upload rating1-2.");
               }
             //Bewertung 3
               psmnt = connection.prepareStatement("insert into has(eId, rId) "+
			   "values((Select eId from episode where episodeTitle = 'S01E03 - Randys Touchdown'),(Select rId from rating where ratedBy = 'CTT' and rating = '2'))");

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
