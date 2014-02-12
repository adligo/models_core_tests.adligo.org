package org.adligo.models.core_tests;

import org.adligo.models.core.shared.DomainName;
import org.adligo.models.core.shared.EMailAddress;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core_tests.shared.assertions.EmailAddressAssertions;
import org.adligo.models.core_tests.shared.assertions.IPEExceptionAsserter;
import org.adligo.tests.ATest;
import org.adligo.xml_io.tests.client.IsXmlIoSerializable;

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
			x = IPEExceptionAsserter.isIPE(g, this);
		}
		assertIsNotNull(x);
		assertIsEquals(EMailAddress.EMAIL, x.getMethodName());
		assertIsEquals(ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY, x.getMessage());
	}

	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(EMailAddress.class);
	}
}
