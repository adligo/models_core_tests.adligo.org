package org.adligo.models.core;

import java.lang.reflect.Method;

import org.adligo.models.core.client.Domain;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class DomainTests extends ATest {

	
	public void testUserDomainToDC() throws Exception {
		String result = Domain.toDn("adligo.com");
		assertEquals("dc=adligo,dc=com", result);
		
		result = Domain.toDn("foo.bar.adligo.com");
		assertEquals("dc=foo,dc=bar,dc=adligo,dc=com", result);
	}
	
	public void testValidate() throws Exception {
		
		assertInvalidDomainParamterException(null,
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException("",
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertInvalidDomainParamterException("a.b",
				DomainValidationConstants.DOMAIN_TO_SHORT);
		assertInvalidDomainParamterException(".abc",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertInvalidDomainParamterException("abc.",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertInvalidDomainParamterException("ab .",
				DomainValidationConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertInvalidDomainParamterException("a..b",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertInvalidDomainParamterException("a.b..com",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidDomainParamterException(
			String domain, String expectedError) throws Exception {
		
		InvalidParameterException x = null;
	
		try {
			Domain.validate(domain);
		} catch (Exception g) {
			x = ParamterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(Domain.VALIDATE, x.getMethodName());
		assertEquals(expectedError, x.getMessage());
		
		x = null;
		
		try {
			Domain.toDn(domain);
		} catch (Exception g) {
			x = ParamterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(Domain.VALIDATE, x.getMethodName());
		assertEquals(expectedError, x.getMessage());
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		new EnglishConstantsFactory();
		ModelsCoreRegistry.init();
	}
}
