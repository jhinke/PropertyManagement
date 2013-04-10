/**
 * This class creates the reservations
 */
package pms;

import java.io.Serializable;
import java.util.ArrayList;

public class reservation implements Serializable{

  private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private int roomNumber;
	private boolean isVacant;
	
	public reservation() {
		firstName = " ";
		lastName = " ";
		email = " ";
		roomNumber = 0;
		isVacant = true;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isVacant() {
		return isVacant;
	}

	public void setVacant(boolean isVacant) {
		this.isVacant = isVacant;
	}
	
	public Object getValue(String fieldName) {
		if(fieldName == "firstName") {
			return firstName;
		} else if (fieldName == "lastName") {
			return lastName;
		} else if (fieldName == "email") {
			return email;
		} else if (fieldName == "roomNumber") {
			return roomNumber;
		} else if (fieldName == "isVacant") {
			return isVacant;
		} else
			return null;
	}
	
	public static ArrayList<String> getFieldNames() {
		ArrayList<String> fields = new ArrayList<String>();
		fields.add("firstName");
		fields.add("lastName");
		fields.add("email");
		fields.add("roomNumber");
		fields.add("isVacant");
		return fields;
	}
	
	public void print() {
		System.out.println("Reservation for: " + firstName + " " + lastName + ", " + email + " in room " + roomNumber);
	}
	
}
