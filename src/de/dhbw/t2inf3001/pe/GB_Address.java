package de.dhbw.t2inf3001.pe;

public class GB_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public GB_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String format() {
		//String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(streetNumber);
		builder.append(" ");
		builder.append(street);
		builder.append("\n");
		builder.append(city.toUpperCase());
		builder.append("\n");
		builder.append(zipCode.toUpperCase());
		return builder.toString();
	}

}
