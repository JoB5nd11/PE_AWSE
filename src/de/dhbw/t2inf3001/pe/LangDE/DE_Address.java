package de.dhbw.t2inf3001.pe.LangDE;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

//Spezielle klasse für die Darstellung der Adressen in der DE-Darstellung, implementiert das Address-Interface 
public class DE_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	//Standardkonstruktor nimmt die Adressdaten als Übergabeparameter entgegen und setzt die Klassenvariablen
	public DE_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	//Format Methode nutzt das Builder Pattern zur Formatierung der Adressdaten im DE-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	//Source: https://www.binect.de/news-blog/adressformat-din-5008
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(street);
		builder.append(" ");
		builder.append(streetNumber);
		builder.append("\n");
		builder.append(zipCode);
		builder.append(" ");
		builder.append(city);
		return builder.toString();
	}

}
