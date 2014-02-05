package org.adligo.models.core.client.assertions;

import org.adligo.models.core.client.I_PhoneNumber;
import org.adligo.models.core.client.I_Validateable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.ValidationException;
import org.adligo.tests.I_Test;

public class PhoneNumberAssertions {

	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		PhoneNumber number = new PhoneNumber();
		ValidationException caught = null;
		try {
			number.isValid();
		} catch (ValidationException ve) {
			caught = ve;
		}
		test.assertIsNotNull(caught);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY, caught.getMessage());
		test.assertIsEquals(I_Validateable.IS_VALID, caught.getMethodName());
		
		int hashCode = number.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new PhoneNumber(number);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(PhoneNumber.PHONE_NUMBER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.PHONE_NUMBER_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		number = new PhoneNumber("123456");
		I_PhoneNumber nbr = new PhoneNumber(number);
		number.isValid();
		test.assertIsTrue(hashCode != number.hashCode());
		
		test.assertIsEquals("123456", nbr.getNumber());
		
		test.assertIsEquals(number, nbr);
		test.assertIsEquals(number.hashCode(), nbr.hashCode());
		
		test.assertIsEquals("123456", new PhoneNumber(nbr).toString());
		test.assertIsEquals("123456", number.toString());
	}
}
