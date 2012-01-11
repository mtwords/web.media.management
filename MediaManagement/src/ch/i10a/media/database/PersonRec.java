package ch.i10a.media.database;

import java.io.Serializable;

public class PersonRec implements Serializable {

	private int pId;
	private String firstName;
	private String lastName;

	public void setPersonId(int id) {
		this.pId = id;
	}
	public int getPersonId() {
		return this.pId;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}
	public String getLastName() {
		return this.lastName;
	}

}
