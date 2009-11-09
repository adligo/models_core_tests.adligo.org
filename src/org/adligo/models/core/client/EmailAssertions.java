package org.adligo.models.core.client;

import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.models.core.client.english.EmailValidationConstants;
import org.adligo.tests.client.I_Test;

public class EmailAssertions {

	public static void assertInvalidParameterExceptions(String pre, I_Test test) throws Exception {
		
		assertInvalidEmailParamterException(test,
				null, pre+EmailValidationConstants.E_MAIL_CAN_NOT_BE_EMPTY, null);
		assertInvalidEmailParamterException(test,
				"", pre+EmailValidationConstants.E_MAIL_CAN_NOT_BE_EMPTY, null);
		assertInvalidEmailParamterException(test,
				"a@l.j", pre+EmailValidationConstants.TWO_SHORT, null);
		assertInvalidEmailParamterException(test,
				"a@o", pre+EmailValidationConstants.TWO_SHORT, null);
		assertInvalidEmailParamterException(test,
				"a@ou. io", pre+EmailValidationConstants.SPACE_CHARACTER, null);
		
		assertInvalidEmailParamterException(test,
				"asou.as.io",pre+ EmailValidationConstants.NO_AT_SYMBOL, null);
		
		
		assertInvalidEmailParamterException(test, "yohan@", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidEmailParamterException(test, "yohan@a.b", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_TO_SHORT);
		assertInvalidEmailParamterException(test, "yohan@.abc", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidEmailParamterException(test, "yohan@abc.", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidEmailParamterException(test, "yohan@ab .", pre+ EmailValidationConstants.SPACE_CHARACTER,
				null);
		assertInvalidEmailParamterException(test, "yohan@a..b", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidEmailParamterException(test, "yohan@a.b..com", pre+ EmailValidationConstants.DOMAIN_ERROR,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		assertInvalidEmailParamterException(test,
				"@asou.as.io",pre+ EmailValidationConstants.NO_USER, null);
			
	}
	
	@SuppressWarnings("static-access")
	public static void assertInvalidEmailParamterException(I_Test test,
			String email, String expectedError, String expectedNestedError) throws Exception {
		
		InvalidParameterException x = null;
	
		try {
			EMail.validate(email);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.EMAIL, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
		
		if (expectedNestedError != null) {
			Exception cause = (Exception) x.getCause();
			InvalidParameterException root = GwtParameterExceptionAsserter.isIPE(cause);
			test.assertIsEquals(DomainName.DOMAIN_NAME, root.getMethodName());
			test.assertIsEquals(expectedNestedError, root.getMessage());
		}
		
		x = null;
		
		try {
			new EMail(email);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.EMAIL, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
		
		if (expectedNestedError != null) {
			Exception cause = (Exception) x.getCause();
			InvalidParameterException root = GwtParameterExceptionAsserter.isIPE(cause);
			test.assertIsEquals(DomainName.DOMAIN_NAME, root.getMethodName());
			test.assertIsEquals(expectedNestedError, root.getMessage());
		}
	}
}
