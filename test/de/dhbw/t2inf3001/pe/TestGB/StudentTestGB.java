package de.dhbw.t2inf3001.pe.TestGB;

import static org.junit.Assert.*;
import org.junit.Test;

import de.dhbw.t2inf3001.pe.Student;
import de.dhbw.t2inf3001.pe.LangGB.GB_Factory;

public class StudentTestGB {
	private Student createStudent() {
		return new Student("222", "Jonathan", "Weston", "Hudson 173 York 1667 GB", "01652 758146", new GB_Factory());
	}
	
	@Test
	public void testStudentAdressFormat() {
		Student s = createStudent();
		String expected = "173 Hudson\nYORK\n1667";
		assertEquals(expected, s.getAddress());
	}
	
	@Test
	public void testStudentPhoneFormat() {
		Student s = createStudent();
		String expected = "01652 758146";
		assertEquals(expected, s.getPhone());
	}
	
	@Test
	public void testStudentInternationalPhoneFormat() {
		Student s = createStudent();
		String expected = "+44-1652-758146";
		assertEquals(expected, s.getIntlPhone());
	}
}
