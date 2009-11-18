package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.tests.ATest;

public class PersonTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
	}
	
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
		IsGwtRpcSerializable.isRpcSerializable(Person.class);
	}
}
