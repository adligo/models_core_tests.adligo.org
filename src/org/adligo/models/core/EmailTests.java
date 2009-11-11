package org.adligo.models.core;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
import org.adligo.models.core.client.EmailAssertions;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.english.EmailValidationConstants;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class EmailTests extends ATest {
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		new EnglishConstantsFactory();
		ModelsCoreRegistry.init();
	}
	
	public void testStringConstructorAndValidateExceptions() throws Exception {
		EmailAssertions.assertInvalidParameterExceptions("", this);
		
		EMail a = new EMail("support@adligo.org");
		assertEquals("support@adligo.org", a.toString());
		assertEquals("support", a.getUserName());
		assertEquals(new DomainName("adligo.org"), a.getDomainName());
		
		InvalidParameterException x = null;
		try {
			new EMail(new EMail());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertIsNotNull(x);
		assertIsEquals(EMail.EMAIL, x.getMethodName());
		assertIsEquals(EmailValidationConstants.E_MAIL_CAN_NOT_BE_EMPTY, x.getMessage());
	}
	
	public void testCopyConstructor() throws Exception {
		EMail a = new EMail("support@adligo.org");
		EMail b = new EMail("support@adligo.com");
		
		assertNotSame(a, b);
		EMail a1 = new EMail(a);
		assertEquals(a, a1);
		assertEquals("support@adligo.org", a1.toString());
		assertEquals("support", a1.getUserName());
		assertEquals(new DomainName("adligo.org"), a1.getDomainName());
		
		
		
	}
}
