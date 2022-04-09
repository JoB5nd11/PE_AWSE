package de.dhbw.t2inf3001.pe.LangUS;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

public class US_Address implements Address{
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public US_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String format() {
		//Source: https://grammar.yourdictionary.com/writing/how-to-write-an-address-correctly.html
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
