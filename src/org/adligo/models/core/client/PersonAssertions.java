package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;
import org.adligo.tests.client.I_Test;

public class PersonAssertions {

	public void setUp() {
		Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
				new DefaultStorageIdentifierFactory());
	}
	public static void assertMutators(I_Test test, String prefix) throws Exception {
		PersonMutant mutant = new PersonMutant();
		test.assertIsFalse(mutant.isValid());
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ex = null;
		try {
			mutant.setLast_name(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Person.SET_LAST_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PERSON_A_NAME_LAST_NAME_IS_REQUIRED,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setLast_name("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Person.SET_LAST_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PERSON_A_NAME_LAST_NAME_IS_REQUIRED,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				CommonModel.ID_NULL,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(new StringIdentifier());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				CommonModel.ID_EMPTY,
				ex.getMessage());
		
		
		
		mutant.setFirst_name("someFirstName");
		test.assertIsEquals("someFirstName", mutant.getFirst_name());
		test.assertIsFalse(mutant.isValid());
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
		
		mutant.setMiddle_name("someMiddleName");
		test.assertIsEquals("someMiddleName", mutant.getMiddle_name());
		test.assertIsFalse(mutant.isValid());
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
		mutant.setLast_name("someName");
		test.assertIsEquals("someName", mutant.getLast_name());
		test.assertIsTrue(mutant.isValid());
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
	    mutant.setBirthday(new Long( 1));
		test.assertIsEquals(new Long(1), mutant.getBirthday());
		test.assertIsTrue(mutant.isValid());
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
	    mutant.setDeceased(new Long( 2));
		test.assertIsEquals(new Long(2), mutant.getDeceased());
		test.assertIsTrue(mutant.isValid());
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
		mutant.setId(new StringIdentifier("sid"));
		test.assertIsEquals(new StringIdentifier("sid"), mutant.getId());
		test.assertIsFalse(hashCode == mutant.hashCode());
		
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		PersonMutant mutant = new PersonMutant();
		
		InvalidParameterException ex = null;
		try {
			new Person(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Person.PERSON, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PERSON_A_NAME_LAST_NAME_IS_REQUIRED,
				ex.getMessage());
		
		
		mutant.setLast_name("someName");
		mutant.setFirst_name("someFirstName");
		mutant.setMiddle_name("someMiddleName");
		mutant.setBirthday(new Long(3));
		mutant.setDeceased(new Long(4));
		
		Person person = new Person(mutant);
		test.assertIsEquals("someName", person.getLast_name());
		test.assertIsEquals("someFirstName", person.getFirst_name());
		test.assertIsEquals("someMiddleName", person.getMiddle_name());
		test.assertIsEquals(new Long(3), person.getBirthday());
		test.assertIsEquals(new Long(4), person.getDeceased());
		
		test.assertIsEquals(person, mutant);
		
		test.assertIsEquals("Person [first_name=someFirstName,middle_name=someMiddleName,last_name=someName," +
				"id=null,birthday=12/31/69 6:00 PM 003,deceased=12/31/69 6:00 PM 004]", person.toString());
		test.assertIsEquals("PersonMutant [first_name=someFirstName,middle_name=someMiddleName," +
				"last_name=someName,id=null,birthday=12/31/69 6:00 PM 003,deceased=12/31/69 6:00 PM 004]", mutant.toString());
		
		
		mutant.setId(new StringIdentifier("sid"));
		person = new Person(mutant);
		test.assertIsEquals(person, mutant);
		test.assertIsEquals(new StringIdentifier("sid"), person.getId());
		
		mutant.setFirst_name("john");
		test.assertIsFalse(person.equals(mutant));
	}
}
