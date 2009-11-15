package org.adligo.models.core.client;

import org.adligo.models.core.client.english.PersonValidationConstants;
import org.adligo.tests.client.I_Test;

public class PersonAssertions {

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
				prefix + PersonValidationConstants.A_NAME_LAST_NAME_IS_REQUIRED,
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
				prefix + PersonValidationConstants.A_NAME_LAST_NAME_IS_REQUIRED,
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
				StorageIdentifier.NO_KEY_OR_A_ID,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(new StorageIdentifier());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				StorageIdentifier.NO_KEY_OR_A_ID,
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
	    
		mutant.setId(new StorageIdentifier((long) 8));
		test.assertIsEquals(new StorageIdentifier((long) 8), mutant.getId());
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
				prefix + PersonValidationConstants.A_NAME_LAST_NAME_IS_REQUIRED,
				ex.getMessage());
		
		
		mutant.setLast_name("someName");
		mutant.setFirst_name("someFirstName");
		mutant.setMiddle_name("someMiddleName");
		
		Person person = new Person(mutant);
		test.assertIsEquals("someName", person.getLast_name());
		test.assertIsEquals("someFirstName", person.getFirst_name());
		test.assertIsEquals("someMiddleName", person.getMiddle_name());
		
		test.assertIsEquals(person, mutant);
		
		test.assertIsEquals("Person [first_name=someFirstName,middle_name=someMiddleName,last_name=someName,id=null]", person.toString());
		test.assertIsEquals("PersonMutant [first_name=someFirstName,middle_name=someMiddleName,last_name=someName,id=null]", mutant.toString());
		
		
		mutant.setId(new StorageIdentifier((long) 8));
		person = new Person(mutant);
		test.assertIsEquals(person, mutant);
		test.assertIsEquals(new StorageIdentifier((long) 8), person.getId());
		
		mutant.setFirst_name("john");
		test.assertIsFalse(person.equals(mutant));
	}
}
