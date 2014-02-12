package org.adligo.models.core_tests;

import org.adligo.models.core.shared.DomainName;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core_tests.shared.assertions.DomainNameAssertions;
import org.adligo.models.core_tests.shared.assertions.IPEExceptionAsserter;
import org.adligo.tests.ATest;
import org.adligo.tests.I_Test;
import org.adligo.xml_io.tests.client.IsXmlIoSerializable;

public class DomainTests extends ATest {

	
	public void testDomainToDC() throws Exception {
		String result = DomainName.toDn("adligo.com");
		assertEquals("dc=adligo,dc=com", result);
		
		result = DomainName.toDn("foo.bar.adligo.com");
		assertEquals("dc=foo,dc=bar,dc=adligo,dc=com", result);
	}
	
	public void testDomainFromDC() throws Exception {
		String result = DomainName.fromDn("dc=adligo,dc=com");
		assertEquals("adligo.com", result);
		
		result = DomainName.fromDn("dc=foo,dc=bar,dc=adligo,dc=com");
		assertEquals("foo.bar.adligo.com", result);
	}
	
	public void testValidate() throws Exception {
		DomainNameAssertions.assertInvalidParameterExceptions("", this);
		
		DomainName.validate("adligo.com");
		DomainName.validate("adligo.org");
		
		
		InvalidParameterException x = null;
		try {
			new DomainName("");
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, this);
		}
		assertIsNotNull(x);
		assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		assertIsEquals(ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, x.getMessage());
	
	}
	
	public void testStringConstructor() throws Exception {
		
		assertStringConstructorParamterException(null,
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, this);
		assertStringConstructorParamterException("",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, this);
		assertStringConstructorParamterException("a.b",
				ModelsCoreEnglishConstants.DOMAIN_TO_SHORT, this);
		assertStringConstructorParamterException(".abc",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER, this);
		assertStringConstructorParamterException("abc.",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER, this);
		assertStringConstructorParamterException("ab .",
				ModelsCoreEnglishConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE, this);
		assertStringConstructorParamterException("a..b",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS, this);
		assertStringConstructorParamterException("a.b..com",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS, this);
		
		new DomainName("adligo.com");
		new DomainName("adligo.org");
	}

	public void testDomainNameConstructorAndEquals() throws Exception {
		DomainName com = new DomainName("adligo.com");
		DomainName org = new DomainName("adligo.org");
		DomainName com2 = new DomainName("adligo.com");
		
		assertEquals(com, com);
		DomainName com3 = new DomainName(com.getName());
		assertEquals(com, com2);
		assertEquals(com, com3);
		
		//assert to strings
		assertEquals("adligo.com", com.toString());
		assertEquals("adligo.org", org.toString());
		
		assertNotSame(com, org);
		assertNotSame(com2, org);
		assertNotSame(com3, org);
	}
	public static void assertStringConstructorParamterException(
			String domain, String expectedError, I_Test test) throws Exception {
		
		InvalidParameterException x = null;
		
		try {
			new DomainName(domain);
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(DomainName.DOMAIN_NAME, x.getMethodName());
		test.assertIsEquals(expectedError, x.getMessage());
	}
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(DomainName.class);
	}
}
