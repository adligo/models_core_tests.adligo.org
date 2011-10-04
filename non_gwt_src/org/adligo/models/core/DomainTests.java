package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.DomainNameAssertions;
import org.adligo.models.core.client.DomainNameMutant;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.tests.ATest;

public class DomainTests extends ATest {

	
	public void testDomainToDC() throws Exception {
		String result = DomainNameMutant.toDn("adligo.com");
		assertEquals("dc=adligo,dc=com", result);
		
		result = DomainNameMutant.toDn("foo.bar.adligo.com");
		assertEquals("dc=foo,dc=bar,dc=adligo,dc=com", result);
	}
	
	public void testDomainFromDC() throws Exception {
		String result = DomainNameMutant.fromDn("dc=adligo,dc=com");
		assertEquals("adligo.com", result);
		
		result = DomainNameMutant.fromDn("dc=foo,dc=bar,dc=adligo,dc=com");
		assertEquals("foo.bar.adligo.com", result);
	}
	
	public void testValidate() throws Exception {
		DomainNameAssertions.assertInvalidParameterExceptions("", this);
		
		DomainNameMutant.validate("adligo.com");
		DomainNameMutant.validate("adligo.org");
		
		
		InvalidParameterException x = null;
		try {
			new DomainName(new DomainName());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertIsNotNull(x);
		assertIsEquals(DomainNameMutant.DOMAIN_NAME, x.getMethodName());
		assertIsEquals(ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY, x.getMessage());
	
	}
	
	public void testStringConstructor() throws Exception {
		
		assertStringConstructorParamterException(null,
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertStringConstructorParamterException("",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY);
		assertStringConstructorParamterException("a.b",
				ModelsCoreEnglishConstants.DOMAIN_TO_SHORT);
		assertStringConstructorParamterException(".abc",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_FIRST_CHARACTER);
		assertStringConstructorParamterException("abc.",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_A_DOT_AS_ITS_LAST_CHARACTER);
		assertStringConstructorParamterException("ab .",
				ModelsCoreEnglishConstants.DOMAIN_MAY_NOT_CONTAIN_A_SPACE);
		assertStringConstructorParamterException("a..b",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		assertStringConstructorParamterException("a.b..com",
				ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_HAVE_TWO_CONSECUTIVE_DOTS);
		
		new DomainName("adligo.com");
		new DomainName("adligo.org");
	}

	public void testDomainNameConstructorAndEquals() throws Exception {
		DomainName com = new DomainName("adligo.com");
		DomainName org = new DomainName("adligo.org");
		DomainName com2 = new DomainName("adligo.com");
		
		assertEquals(com, com);
		DomainNameMutant com3 = new DomainNameMutant(com.getName());
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
			String domain, String expectedError) throws Exception {
		
		InvalidParameterException x = null;
		
		try {
			new DomainName(domain);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertNotNull(x);
		assertEquals(DomainNameMutant.DOMAIN_NAME, x.getMethodName());
		assertEquals(expectedError, x.getMessage());
	}
	
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(DomainName.class);
	}
}
