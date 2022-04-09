package de.dhbw.t2inf3001.pe.TestUS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.LangUS.US_Address;

public class AddressTestUS {
	@Test
	public void testFormatBasic() {
		Address address = new US_Address("Abbott Passage", "867", "North Blanca, MA", "82051", "US");
		String expected = "867 Abbott Passage\nNorth Blanca, MA, 82051";
		assertEquals(expected, address.format());
	}
	
	@Test
	public void testFormatItemMissing() {
		Address address = new US_Address("Lebsack Manor", "703", "", "87521", "US");
		String expected = "703 Lebsack Manor\n, 87521";
		assertEquals(expected, address.format());
	}
	
	@Test 
	public void testFormatEmpty() {
		Address address = new US_Address("", "", "", "", "");
		String expected = " \n, ";
		assertEquals(expected, address.format());
	}
}
