package org.adligo.models.core_tests.shared.assertions;

import org.adligo.models.core.shared.DomainName;
import org.adligo.models.core.shared.EMailAddress;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.tests.I_Test;

public class EmailAddressAssertions {

	public static void assertInvalidParameterExceptions(String pre, I_Test test) throws Exception {
		
		assertInvalidEmailParamterException(test,
				null, pre+ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY, null);
		assertInvalidEmailParamterException(test,
				"", pre+ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY, null);
		assertInvalidEmailParamterException(test,
				"a@l.j", pre+ModelsCoreEnglishConstants.EMAIL_ADDRESS_TWO_SHORT, null);
		assertInvalidEmailParamterException(test,
				"a@o", pre+ModelsCoreEnglishConstants.EMAIL_ADDRESS_TWO_SHORT, null);
		assertInvalidEmailParamterException(test,
				"a@ou. io", pre+ModelsCoreEnglishConstants.EMAIL_ADDRESS_SPACE_CHARACTER, null);
		
		assertInvalidEmailParamterException(test,
				"asou.as.io",pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_NO_AT_SYMBOL, null);
		
		
		assertInvalidEmailParamterException(test, "yohan@", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidEmailParamterException(test, "yohan@a.b", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_TO_SHORT);
		assertInvalidEmailParamterException(test, "yohan@.abc", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidEmailParamterException(test, "yohan@abc.", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidEmailParamterException(test, "yohan@ab .", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_SPACE_CHARACTER,
				null);
		assertInvalidEmailParamterException(test, "yohan@a..b", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidEmailParamterException(test, "yohan@a.b..com", pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_DOMAIN_ERROR,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		assertInvalidEmailParamterException(test,
				"@asou.as.io",pre+ ModelsCoreEnglishConstants.EMAIL_ADDRESS_NO_USER, null);
			
	}
	
	@SuppressWarnings("static-access")
	public static void assertInvalidEmailParamterException(I_Test test,
			String email, String expectedError, String expectedNestedError) throws Exception {
		
		InvalidParameterException x = null;
	
		try {
			EMailAddress.validate(email);
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMailAddress.EMAIL, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
		
		if (expectedNestedError != null) {
			Exception cause = (Exception) x.getCause();
			InvalidParameterException root = IPEExceptionAsserter.isIPE(cause, test);
			test.assertIsEquals(DomainName.DOMAIN_NAME, root.getMethodName());
			test.assertIsEquals(expectedNestedError, root.getMessage());
		}
		
		x = null;
		
		try {
			new EMailAddress(email);
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMailAddress.EMAIL, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
		
		if (expectedNestedError != null) {
			Exception cause = (Exception) x.getCause();
			InvalidParameterException root = IPEExceptionAsserter.isIPE(cause, test);
			test.assertIsEquals(DomainName.DOMAIN_NAME, root.getMethodName());
			test.assertIsEquals(expectedNestedError, root.getMessage());
		}
	}
}
