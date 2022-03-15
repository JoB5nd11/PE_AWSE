package de.dhbw.t2inf3001.pe;

public class DE_Address implements Address{
	
	private String street;
	private String streetNumber;
	private String city;
	private String zipCode;
	
	public DE_Address(String street, String streetNumber, String city, String zipCode, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public String format() {
		//String newline = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append(street);
		builder.append("-DEUTSCH-");
		builder.append(streetNumber);
		builder.append("\n");
		builder.append(zipCode);
		builder.append(" ");
		builder.append(city);
		return builder.toString();
	}

}
