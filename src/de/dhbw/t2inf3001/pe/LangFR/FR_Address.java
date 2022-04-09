package de.dhbw.t2inf3001.pe.LangFR;

import de.dhbw.t2inf3001.pe.Interfaces.Address;

public class FR_Address implements Address{
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public FR_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String format() {
		//Source: https://www.smarty.com/articles/la-poste
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
