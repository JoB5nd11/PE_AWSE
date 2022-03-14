package de.dhbw.t2inf3001.pe;

import static org.junit.Assert.*;
import org.junit.Test;
import de.dhbw.t2inf3001.pe.Student;

public class StudentTest {
	//A Student Object is created here instead of loading one of the datastore.
	//This is because it is not guaranteed that the datastore stays the same.
	//If it changes the Unit Test might fail, even though the code is working.
	//Maybe there is a better solution like making a copy of the datastore or one just
	//for testing, but I don't know ( 0 _ 0 )
	private Student createStudent() {
		Student s = new Student("11", "Johannes", "Bendler", "Regerstraﬂe 5 Heidenheim 89518 DE", "01601 682381");
		return s;
	}
	
	@Test
	public void testStudentAdressFormat() {
		Student s = createStudent();
		String expected = "Regerstraﬂe 5\n89518 Heidenheim";
		assertEquals(expected, s.getAddress());
	}
	
	//TODO with Abstract Factory Implementation?
	@Test
	public void testStudentPhoneFormat() {
		Student s = createStudent();
		String expected = "01601-682381";
		assertEquals(expected, s.getPhone());
	}
	
	@Test
	public void testStudentInternationalPhoneFormat() {
		Student s = createStudent();
		String expected = "+49-1601-682381";
		assertEquals(expected, s.getIntlPhone());
	}
	
	@Test
	public void testStudentFirstName() {
		Student s = createStudent();
		String expected = "Johannes";
		assertEquals(expected, s.getFirstName());
	}
	
	@Test
	public void testStudentLastName() {
		Student s = createStudent();
		String expected = "Bendler";
		assertEquals(expected, s.getLastName());
	}
	
	@Test
	public void testStudentInfoFormat() {
		Student s = createStudent();
		String expected = "11: Johannes Bendler";
		assertEquals(expected, s.getInfo());
	}
}
