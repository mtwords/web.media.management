package ch.i10a.media.database;

import java.io.Serializable;

/**
 * Class for the people records in the database 
 */
public class PersonRec implements Serializable {

	private int pId;
	private String firstName;
	private String lastName;

	/**
	 * Setter method to set the unique id for a person record
	 * @param id: id of a person record
	 */
	public void setPersonId(int id) {
		this.pId = id;
	}
	/**
	 * Getter method to retrieve the id of a person record
	 * @return id: the id of a person record
	 */
	public int getPersonId() {
		return this.pId;
	}
	/**
	 * Setter method to set the first name of a person
	 * @param fName: first name of a person
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	/**
	 * Getter method to retrieve the first name of a person
	 * @return firstname: the first name of a person
	 */
	public String getFirstName() {
		return this.firstName;
	}
	/**
	 * Setter method to set the last name of a person
	 * @param fName: last name of a person
	 */
	public void setLastName(String lName) {
		this.lastName = lName;
	}
	/**
	 * Getter method to retrieve the last name of a person
	 * @return firstname: the last name of a person
	 */
	public String getLastName() {
		return this.lastName;
	}

}
