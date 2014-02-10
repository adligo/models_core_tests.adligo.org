package org.adligo.models.core.tests;

import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.tests.client.assertions.PersonAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io.tests.client.IsXmlIoSerializable;

public class PersonTests extends ATest {
	
	
	public void testMutators() throws Exception {
		PersonAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		PersonAssertions.assertConstructors(this, "");
	}
	
	public void testGetName() throws Exception {
		PersonMutant mutant = new PersonMutant();
		assertEquals("", mutant.getName());
		mutant.setLast_name("lname");
		assertEquals("lname", mutant.getName());
		
		mutant.setMiddle_name("mname");
		assertEquals("mname lname", mutant.getName());
		
		mutant.setFirst_name("fname");
		assertEquals("fname mname lname", mutant.getName());
		
		mutant = new PersonMutant();
		mutant.setFirst_name("fname");
		assertEquals("fname", mutant.getName());
		
		mutant = new PersonMutant();
		mutant.setMiddle_name("mname");
		assertEquals("mname", mutant.getName());
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(Person.class);
	}
}
