package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class PhoneNumberAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		PhoneNumberMutant mutant = new PhoneNumberMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.setNumber(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumber.SET_NUMBER, ex.getMethodName());
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
		test.assertIsEquals(PhoneNumber.SET_NUMBER, ex.getMethodName());
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
		test.assertIsEquals(PhoneNumber.SET_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_MAY_ONLY_HAVE_ARABIC_NUMERALS,
				ex.getMessage());
		
		mutant.setNumber("123456");
		test.assertIsEquals("123456", mutant.getNumber());
		

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
		
		mutant.setId(new StringIdentifier("key"));
		test.assertIsEquals(new StringIdentifier("key"), mutant.getId());
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		PhoneNumberMutant mutant = new PhoneNumberMutant();
		test.assertIsFalse(mutant.isValid());
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new PhoneNumber(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumber.PHONE_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setNumber("123456");
		I_PhoneNumber nbr = new PhoneNumber(mutant);
		test.assertIsTrue(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		
		test.assertIsEquals("123456", nbr.getNumber());
		
		test.assertIsEquals(mutant, nbr);
		test.assertIsEquals(mutant.hashCode(), nbr.hashCode());
		
		test.assertIsEquals("PhoneNumber [number=123456,id=null]", nbr.toString());
		test.assertIsEquals("PhoneNumberMutant [number=123456,id=null]", mutant.toString());
	}
}
