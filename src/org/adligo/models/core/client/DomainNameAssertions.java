package org.adligo.models.core.client;

import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.tests.client.I_Test;

public class DomainNameAssertions  {

	public static void assertPropertyFile(String pre, I_Test test) throws Exception {
		assertInvalidDomainParamterException(test, null,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException(test,"",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException(test,"a.b",
				pre+ DomainValidationConstants.DOMAIN_TO_SHORT);
		assertInvalidDomainParamterException(test,".abc",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidDomainParamterException(test,"abc.",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidDomainParamterException(test,"ab .",
				pre+ DomainValidationConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertInvalidDomainParamterException(test,"a..b",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidDomainParamterException(test,"a.b..com",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
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
