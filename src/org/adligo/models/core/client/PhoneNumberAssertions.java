package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class PhoneNumberAssertions {

	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		PhoneNumber number = new PhoneNumber();
		test.assertIsFalse(number.isValid());
		int hashCode = number.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new PhoneNumber(number);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumber.PHONE_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		number = new PhoneNumber("123456");
		I_PhoneNumber nbr = new PhoneNumber(number);
		test.assertIsTrue(number.isValid());
		test.assertIsTrue(hashCode != number.hashCode());
		
		test.assertIsEquals("123456", nbr.getNumber());
		
		test.assertIsEquals(number, nbr);
		test.assertIsEquals(number.hashCode(), nbr.hashCode());
		
		test.assertIsEquals("123456", new PhoneNumber(nbr).toString());
		test.assertIsEquals("123456", number.toString());
	}
}
