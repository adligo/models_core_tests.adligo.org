package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.EmailAddressAssertions;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.tests.ATest;

public class EmailAddressTests extends ATest {
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testStringConstructorAndValidateExceptions() throws Exception {
		EmailAddressAssertions.assertInvalidParameterExceptions("", this);
		
		EMailAddress a = new EMailAddress("support@adligo.org");
		assertEquals("support@adligo.org", a.toString());
		assertEquals("support", a.getUserName());
		assertEquals(new DomainName("adligo.org"), a.getDomainName());
		
		InvalidParameterException x = null;
		try {
			new EMailAddress("");
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		assertIsNotNull(x);
		assertIsEquals(EMailAddress.EMAIL, x.getMethodName());
		assertIsEquals(ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY, x.getMessage());
	}

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(EMailAddress.class);
	}
}
