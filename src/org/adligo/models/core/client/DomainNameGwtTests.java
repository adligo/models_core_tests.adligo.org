package org.adligo.models.core.client;

import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.tests.client.AGwtTest;


public class DomainNameGwtTests extends AGwtTest {
	
	@Override
	public String getModuleName() {
		return ModelsCoreTestGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreTestGwtSetup.init();
	}
	
	public void testValidationClassAndPropertyFileMatch() throws Exception {
		assertPropertyFile("");
	}

	public static void assertPropertyFile(String pre) throws Exception {
		assertInvalidDomainParamterException(null,
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException("",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException("a.b",
				pre+ DomainValidationConstants.DOMAIN_TO_SHORT);
		assertInvalidDomainParamterException(".abc",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidDomainParamterException("abc.",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidDomainParamterException("ab .",
				pre+ DomainValidationConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertInvalidDomainParamterException("a..b",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidDomainParamterException("a.b..com",
				pre+ DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
	}
	
	public static void assertInvalidDomainParamterException(
			String domain, String expectedError) throws Exception {
		
		InvalidParameterException x = null;
	
		try {
			DomainName.validate(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		assertEquals(expectedError, x.getMessage());
		
		x = null;
		
		try {
			DomainName.toDn(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		assertEquals(expectedError, x.getMessage());
	}
}
