
import java.sql.*;
import java.io.*;

class Test_DB_Empty_Cleanup {
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

                //�Load JDBC driver "com.mysql.jdbc.Driver"
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                /* Create a connection by using getConnection() method that takes 
				parameters of string type connection url, user name and password to 
				connect to database. */
                connection = DriverManager.getConnection(connectionURL, "webmedia", "web.media");

	           /* prepareStatement() is used for create statement object that is 
	           used for sending sql statements to the specified database. */


               //leeren von wrotescreenplay
               //
               psmnt = connection.prepareStatement("truncate wrotescreenplay");
               s = psmnt.executeUpdate();
               //leeren von has
               //
               psmnt = connection.prepareStatement("truncate has");
               s = psmnt.executeUpdate();
               //leeren von language
               //
               psmnt = connection.prepareStatement("truncate language");
               s = psmnt.executeUpdate();
               //leeren von directs
               //
               psmnt = connection.prepareStatement("truncate directs");
               s = psmnt.executeUpdate();
               //leeren von actsin
               //
               psmnt = connection.prepareStatement("truncate actsin");
               s = psmnt.executeUpdate();
               //leeren von category
               //
               psmnt = connection.prepareStatement("truncate category");
               s = psmnt.executeUpdate();
               //leeren von rating
               //
               psmnt = connection.prepareStatement("delete from rating where rating > 0");
               s = psmnt.executeUpdate();
               if(s>0) {
                   System.out.println("loeschen von rating erfolgreich");
               }
               else {
		            System.out.println("loeschen von rating fehlgeschlagen oder Tabelle war leer.");
               }
               //leeren von person
               //
               psmnt = connection.prepareStatement("delete from person where pID > 0");
               s = psmnt.executeUpdate();
               if(s>0) {
                   System.out.println("loeschen von person erfolgreich");
               }
               else {
		            System.out.println("loeschen von person fehlgeschlagen oder Tabelle war leer.");
               }
               //leeren von episode
               //
               psmnt = connection.prepareStatement("delete from episode where eID > 0");
               s = psmnt.executeUpdate();
               if(s>0) {
                   System.out.println("loeschen von episode erfolgreich");
               }
               else {
		            System.out.println("loeschen von episode fehlgeschlagen oder Tabelle war leer.");
               }
               //leeren von movie
               //
               psmnt = connection.prepareStatement("delete from movie where mID > 0");
               s = psmnt.executeUpdate();
               if(s>0) {
                   System.out.println("loeschen von movie erfolgreich");
               }
               else {
		            System.out.println("loeschen von movie fehlgeschlagen oder Tabelle war leer.");
               }
               
               
               
               //
               //Pr�fen, ob die entsprechenden Tabellen leer sind
               //
               
               //Test f�r actsin
               rs = psmnt.executeQuery("select * from actsin");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle actsin enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("actsin ist leer");
               }
             //Test f�r category
               rs = psmnt.executeQuery("select * from category");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle category enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("category ist leer");
               }
             //Test f�r directs
               rs = psmnt.executeQuery("select * from directs");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle directs enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("directs ist leer");
               }
             //Test f�r episode
               rs = psmnt.executeQuery("select * from episode");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle episode enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("episode ist leer");
               }
             //Test f�r has
               rs = psmnt.executeQuery("select * from has");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle has enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("has ist leer");
               }
             //Test f�r language
               rs = psmnt.executeQuery("select * from language");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle language enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("language ist leer");
               }
             //Test f�r movie
               rs = psmnt.executeQuery("select * from movie");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle movie enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("movie ist leer");
               }
             //Test f�r person
               rs = psmnt.executeQuery("select * from person");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle person enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("person ist leer");
               }
             //Test f�r rating
               rs = psmnt.executeQuery("select * from rating");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle rating enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("rating ist leer");
               }
             //Test f�r wrotescreenplay
               rs = psmnt.executeQuery("select * from wrotescreenplay");
                
               if(rs.next()) {
                   System.out.println("ERROR: Tabelle wrotescreenplay enth�lt noch Eintr�ge");
               }
               else {
		            System.out.println("wrotescreenplay ist leer");
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
