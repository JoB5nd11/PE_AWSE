package de.dhbw.t2inf3001.pe.LangUS;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

//Spezielle klasse für die Darstellung der Adressen in der DE-Darstellung, implementiert das Address-Interface 
public class US_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;

	//Standardkonstruktor nimmt die Adressdaten als Übergabeparameter entgegen und setzt die Klassenvariablen
	public US_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	//Format Methode nutzt das Builder Pattern zur Formatierung der Adressdaten im US-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	//Source: https://grammar.yourdictionary.com/writing/how-to-write-an-address-correctly.html
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append("\n");
		builder.append(city);
		builder.append(", ");
		builder.append(zipCode);
		return builder.toString();
	}
}
