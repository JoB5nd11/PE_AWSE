package de.dhbw.t2inf3001.pe;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.Interfaces.LanguageFactory;
import de.dhbw.t2inf3001.pe.exceptions.StudentNotFoundException;

public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private PhoneNumber phone;
	private LanguageFactory factory;

	public Student(String id, LanguageFactory factory) throws Exception {
		
		this.factory = factory;
		try {
			readDataFromStore(id);
		} catch (StudentNotFoundException e) {
			throw new StudentNotFoundException();
		}
	}
	
	//for debug/unit testing purposes only
	public Student(String id, String firstName, String lastName, String address, String phone, LanguageFactory factory) {
		this.factory = factory;
		
		List<String> data = new ArrayList<String>();
		data.add(id);
		data.add(firstName);
		data.add(lastName);
		
		if(address.split(" ").length != 5) {
			throw new IllegalArgumentException("The Student address has the wrong format");
		}
		for (String string : address.split(" ")) {
			data.add(string);
		}
		
		if(phone.split(" ").length != 2) {
			throw new IllegalArgumentException("The Student phone hast the wrong format");
		}
		for (String string : phone.split(" ")) {
			data.add(string);
		}
		
		createStudentFromStringsList(data);
	}

	public String getAddress() {
		return address.format();
	}

	public String getPhone() {
		return phone.format();
	}
	
	public String getIntlPhone() {
		return phone.formatInternational();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getInfo() {
		return id + ": " + firstName + " " + lastName;
	}

	private void readDataFromStore(String id) throws Exception {
		try {
			List<String> data = DataStore.read(id);	
			createStudentFromStringsList(data);
		} catch (Exception e) {
			throw new Exception();
			//System.out.println("Error: No student with ID: " + id + " was found in the database! \n");
		}
	}
	
	//Is used just for Unit Test
	private void createStudentFromStringsList(List<String> data) {
		this.id = data.get(0);
		this.firstName = data.get(1);
		this.lastName = data.get(2);
		this.address = factory.createAddress(data.get(3), data.get(4), data.get(5), data.get(6), data.get(7));
		this.phone = factory.createPhoneNumber(data.get(8), data.get(9), data.get(7));
	}
}
