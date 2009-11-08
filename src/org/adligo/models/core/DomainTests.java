package org.adligo.models.core;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.DomainNameGwtTests;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class DomainTests extends ATest {

	
	public void testUserDomainToDC() throws Exception {
		String result = DomainName.toDn("adligo.com");
		assertEquals("dc=adligo,dc=com", result);
		
		result = DomainName.toDn("foo.bar.adligo.com");
		assertEquals("dc=foo,dc=bar,dc=adligo,dc=com", result);
	}
	
	public void testValidate() throws Exception {
		
		DomainNameGwtTests.assertInvalidDomainParamterException(null,
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		DomainNameGwtTests.assertInvalidDomainParamterException("",
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		DomainNameGwtTests.assertInvalidDomainParamterException("a.b",
				DomainValidationConstants.DOMAIN_TO_SHORT);
		DomainNameGwtTests.assertInvalidDomainParamterException(".abc",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		DomainNameGwtTests.assertInvalidDomainParamterException("abc.",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		DomainNameGwtTests.assertInvalidDomainParamterException("ab .",
				DomainValidationConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		DomainNameGwtTests.assertInvalidDomainParamterException("a..b",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		DomainNameGwtTests.assertInvalidDomainParamterException("a.b..com",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		DomainName.validate("adligo.com");
		DomainName.validate("adligo.org");
	}
	
	public void testStringConstructor() throws Exception {
		
		assertStringConstructorParamterException(null,
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertStringConstructorParamterException("",
				DomainValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertStringConstructorParamterException("a.b",
				DomainValidationConstants.DOMAIN_TO_SHORT);
		assertStringConstructorParamterException(".abc",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertStringConstructorParamterException("abc.",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertStringConstructorParamterException("ab .",
				DomainValidationConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertStringConstructorParamterException("a..b",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertStringConstructorParamterException("a.b..com",
				DomainValidationConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		new DomainName("adligo.com");
		new DomainName("adligo.org");
	}

	public void testDomainNameConstructorAndEquals() throws Exception {
		DomainName com = new DomainName("adligo.com");
		DomainName org = new DomainName("adligo.org");
		DomainName com2 = new DomainName("adligo.com");
		
		assertEquals(com, com);
		DomainName com3 = new DomainName(com);
		assertEquals(com, com2);
		assertEquals(com, com3);
		
		assertNotSame(com, org);
		assertNotSame(com2, org);
		assertNotSame(com3, org);
	}
	public static void assertStringConstructorParamterException(
			String domain, String expectedError) throws Exception {
		
		InvalidParameterException x = null;
		
		try {
			new DomainName(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(DomainName.DOMAIN_NAME, x.getMethodName());
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
