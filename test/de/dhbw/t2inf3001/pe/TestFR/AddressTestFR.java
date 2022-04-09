package de.dhbw.t2inf3001.pe.TestFR;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.t2inf3001.pe.Interfaces.Address;
import de.dhbw.t2inf3001.pe.LangFR.FR_Address;

public class AddressTestFR {
	@Test
	public void testFormatBasic() {
		Address address = new FR_Address("Impasse Pastourelle", "65", "Bordeaux", "99518", "FR");
		String expected = "65 IMPASSE PASTOURELLE\n99518 BORDEAUX";
		assertEquals(expected, address.format());
	}
	
	@Test
	public void testFormatItemMissing() {
		Address address = new FR_Address("Passage Zadkine", "272", "", "77779", "FR");
		String expected = "272 PASSAGE ZADKINE\n77779 ";
		assertEquals(expected, address.format());
	}
	
	@Test 
	public void testFormatEmpty() {
		Address address = new FR_Address("", "", "", "", "");
		String expected = " \n ";
		assertEquals(expected, address.format());
	}
}
