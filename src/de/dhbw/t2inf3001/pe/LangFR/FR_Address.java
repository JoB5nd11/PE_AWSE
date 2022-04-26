package de.dhbw.t2inf3001.pe.LangFR;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

//Spezielle klasse für die Darstellung der Adressen in der FR-Darstellung, implementiert das Address-Interface 
public class FR_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	//Standardkonstruktor nimmt die Adressdaten als Übergabeparameter entgegen und setzt die Klassenvariablen
	public FR_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	//Format Methode nutzt das Builder Pattern zur Formatierung der Adressdaten im FR-Format
	//Anschließend werden diese als String zurück gegeben (Getter)
	//Source: https://www.smarty.com/articles/la-poste
	public String format() {
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street.toUpperCase());
		builder.append("\n");
		builder.append(zipCode);
		builder.append(" ");
		builder.append(city.toUpperCase());
		return builder.toString();
	}
}
