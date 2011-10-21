package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class PhoneNumberAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		PhoneNumber mutant = new PhoneNumber();
		
		InvalidParameterException ex = null;
		try {
			mutant.setNumber(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumberMutant.SET_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setNumber("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumberMutant.SET_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		
		ex = null;
		try {
			mutant.setNumber("a");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumberMutant.SET_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS,
				ex.getMessage());
		
		mutant.setNumber("123456");
		test.assertIsEquals("123456", mutant.getNumber());
		

		
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		PhoneNumberMutant mutant = new PhoneNumberMutant();
		test.assertIsFalse(mutant.isValid());
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new PhoneNumberMutant(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumberMutant.PHONE_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setNumber("123456");
		I_PhoneNumber nbr = new PhoneNumberMutant(mutant);
		test.assertIsTrue(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		
		test.assertIsEquals("123456", nbr.getNumber());
		
		test.assertIsEquals(mutant, nbr);
		test.assertIsEquals(mutant.hashCode(), nbr.hashCode());
		
		test.assertIsEquals("PhoneNumber [number=123456]", new PhoneNumber(nbr).toString());
		test.assertIsEquals("PhoneNumberMutant [number=123456]", mutant.toString());
	}
}
