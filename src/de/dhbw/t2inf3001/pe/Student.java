package de.dhbw.t2inf3001.pe;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.Interfaces.LanguageFactory;
import de.dhbw.t2inf3001.pe.Interfaces.PhoneNumber;
import de.dhbw.t2inf3001.pe.exceptions.StudentNotFoundException;


//Die Klasse Student implementiert die Kernfunktionalit�t der Anwendung
public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private PhoneNumber phone;
	private LanguageFactory factory;

	//Standard Konstruktor, erh�lt als Parameter die Studenten ID und die Factory (z. B. DE_Factory)
	public Student(String id, LanguageFactory factory) throws Exception {
		
		this.factory = factory;		//Setzen der factory / Landeseinstellung
		try {
			readDataFromStore(id);		//Einlesen der Studenten Informationen aus dem Datastore, �bergabeparameter ist die Studenten ID
		} catch (StudentNotFoundException e) {
			throw new StudentNotFoundException();
		}
	}
	
	//Zus�tzlicher Konstruktor, er wird lediglich f�r das Debugging und Unit-Testing verwendet
	//Er wird durch die Tests aufgerufen, und erh�lt alle notwendigen Daten als �bergabeparameter
	public Student(String id, String firstName, String lastName, String address, String phone, LanguageFactory factory) {
		this.factory = factory;
		
		List<String> data = new ArrayList<String>();		//Erstellen einer ArrayList, in welcher anschlie�end die �bergebenen Daten abgespeichert werden
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
		
		createStudentFromStringsList(data);		//Legt den Student an, bzw. schreibt die �bergebenen Daten in die Klassenvariablen
	}
	
	//Getter f�r die Adresse im konfigurierten Format
	public String getAddress() {
		return address.format();
	}

	//Getter f�r die Telefonnummer im konfigurierten Format
	public String getPhone() {
		return phone.format();
	}
	
	//Getter f�r die internationale Telefonnumer im konfigurierten Format
	public String getIntlPhone() {
		return phone.formatInternational();
	}
	
	//Getter f�r den Vornamen
	public String getFirstName() {
		return firstName;
	}

	//Getter f�r den Nachnamen
	public String getLastName() {
		return lastName;
	}
	
	//Getter f�r die zusammengesetzte Information
	public String getInfo() {
		return id + ": " + firstName + " " + lastName;
	}

	//Methode erh�lt als �bergabeparameter die ID eines Studenten
	//Hierf�r l�d die Methode alle Informationen des Studenten aus dem Datastore und speichert diese in eine Liste
	//Anschlie�end ruft sie die Funktion createStudentFromStringsList auf und �bergibt die Liste
	private void readDataFromStore(String id) throws Exception {
		try {
			List<String> data = DataStore.read(id);	
			createStudentFromStringsList(data);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	//Erh�lt als �bergabeparameter eine Liste mit den Studenten-Daten
	//Und schreibt diese anschlie�end in die Klassenvariablen
	private void createStudentFromStringsList(List<String> data) {
		this.id = data.get(0);
		this.firstName = data.get(1);
		this.lastName = data.get(2);
		
		//Die Adresse und Telefonnumer werden �ber die Factory gesetzt
		//Die Factory entscheidet, welche Address und Telefon Klassen verwendet werden
		this.address = factory.createAddress(data.get(3), data.get(4), data.get(5), data.get(6), data.get(7));
		this.phone = factory.createPhoneNumber(data.get(8), data.get(9), data.get(7));
	}
}
