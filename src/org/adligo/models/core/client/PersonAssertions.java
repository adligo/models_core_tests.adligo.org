package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.tests.client.I_Test;

public class PersonAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		PersonMutant mutant = new PersonMutant();
		ValidationException vx = null;
		try {
			mutant.isValid();
		} catch (Exception x) {
			test.assertIsTrue(x instanceof ValidationException);
			vx = (ValidationException) x;
		}
		test.assertIsNotNull(vx);
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ipx = null;
		try {
			mutant.setLast_name(null);
		} catch (Exception x) {
			test.assertIsTrue(x instanceof InvalidParameterException);
			ipx  = (InvalidParameterException) x;
		}
		test.assertIsEquals(prefix + ModelsCoreEnglishConstants.PERSON_A_LAST_NAME_IS_REQUIRED,
				ipx.getMessage());
		test.assertIsEquals(PersonMutant.SET_LAST_NAME,
				ipx.getMethodName());
		test.assertIsNull(mutant.getLast_name());
		
		mutant.setLast_name("");
		test.assertIsEquals("", mutant.getLast_name());
		
		InvalidParameterException ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				"PersonMutant" + StorageIdentifierValidator.REQUIRES_A_NON_NULL_ID_IN + 
				I_IdentifiableMutant.SET_ID,
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
				"PersonMutant" + StorageIdentifierValidator.REQUIRES_A_ID_WITH_A_VALUE_IN + 
				I_IdentifiableMutant.SET_ID,
				ex.getMessage());
		
		
		
		mutant.setFirst_name("someFirstName");
		test.assertIsEquals("someFirstName", mutant.getFirst_name());
		mutant.isValid();
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
		
		mutant.setMiddle_name("someMiddleName");
		test.assertIsEquals("someMiddleName", mutant.getMiddle_name());
		mutant.isValid();
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
	    mutant.setNickname("someNickName");
		test.assertIsEquals("someNickName", mutant.getNickname());
		mutant.isValid();
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
		mutant.setLast_name("someName");
		test.assertIsEquals("someName", mutant.getLast_name());
		mutant.isValid();
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
	    mutant.setBirthday(new Long( 1));
		test.assertIsEquals(new Long(1), mutant.getBirthday());
		mutant.isValid();
		test.assertIsFalse(hashCode == mutant.hashCode());
	    hashCode = mutant.hashCode();
	    
	    mutant.setDeceased(new Long( 2));
		test.assertIsEquals(new Long(2), mutant.getDeceased());
		mutant.isValid();
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
		test.assertIsEquals(PersonMutant.PERSON, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PERSON_A_NAME_IS_REQUIRED,
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
				"nick_name=null,id=null,version=null,birthday=12/31/1969 06:00 PM 003,deceased=12/31/1969 06:00 PM 004," +
				"gender=null,height=null,weight=null,customInfo=null,storageInfo=null]", person.toString());
		test.assertIsEquals("PersonMutant [first_name=someFirstName,middle_name=someMiddleName,last_name=someName," +
				"nick_name=null,id=null,version=null,birthday=12/31/1969 06:00 PM 003,deceased=12/31/1969 06:00 PM 004," +
				"gender=null,height=null,weight=null,customInfo=null,storageInfo=null]", mutant.toString());
		
		
		mutant.setId(new StringIdentifier("sid"));
		person = new Person(mutant);
		test.assertIsEquals(person, mutant);
		test.assertIsEquals(new StringIdentifier("sid"), person.getId());
		
		mutant.setFirst_name("john");
		test.assertIsFalse(person.equals(mutant));
	}
}
