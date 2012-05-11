package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class DomainNameAssertions  {

	public static void assertInvalidParameterExceptions(String pre, I_Test test) throws Exception {
		assertInvalidDomainParamterException(test, null,
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException(test,"",
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException(test,"a.b",
				pre+ ModelsCoreEnglishConstants.DOMAIN_TO_SHORT);
		assertInvalidDomainParamterException(test,".abc",
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidDomainParamterException(test,"abc.",
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidDomainParamterException(test,"ab .",
				pre+ ModelsCoreEnglishConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertInvalidDomainParamterException(test,"a..b",
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidDomainParamterException(test,"a.b..com",
				pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		
		InvalidParameterException x = null;
		
		try {
			new DomainName(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		test.assertIsEquals( pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, x.getMessage());
		
		x = null;
		try {
			new DomainName((String) null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		test.assertIsEquals(pre+ ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, x.getMessage());
	}
	
	@SuppressWarnings("static-access")
	public static void assertInvalidDomainParamterException(I_Test test,
			String domain, String expectedError) throws Exception {
		
		InvalidParameterException x = null;
	
		try {
			DomainName.validate(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
		
		x = null;
		
		try {
			DomainName.toDn(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
	}

}
