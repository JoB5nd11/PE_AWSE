package de.dhbw.t2inf3001.pe.TestDE;

import static org.junit.Assert.*;
import org.junit.Test;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.LangDE.DE_Address;

public class AddressTestDE {
	@Test
	public void testFormatBasic() {
		Address address = new DE_Address("Finkenweg", "1", "Berlin", "12345", "DE");
		String expected = "Finkenweg 1\n12345 Berlin";
		assertEquals(expected, address.format());
	}
	
	@Test
	public void testFormatUmlaut() {
		Address address = new DE_Address("K�nigsstra�e", "10", "K�ln", "50669", "DE");
		String expected = "K�nigsstra�e 10\n50669 K�ln";
		assertEquals(expected, address.format());
	}
	
	@Test
	public void testFormatItemMissing() {
		Address address = new DE_Address("Budapester Stra�e", "38", "", "35239", "DE");
		String expected = "Budapester Stra�e 38\n35239 ";
		assertEquals(expected, address.format());
	}
	
	@Test 
	public void testFormatEmpty() {
		Address address = new DE_Address("", "", "", "", "");
		String expected = " \n ";
		assertEquals(expected, address.format());
	}
}
