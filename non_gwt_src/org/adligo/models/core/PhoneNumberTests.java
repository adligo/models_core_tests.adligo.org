package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.tests.ATest;

public class PhoneNumberTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
		ModelsMockSetup.setUp();
	}
	public void testConstructors() throws Exception {
		PhoneNumberAssertions.assertConstructors(this, "");
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(PhoneNumber.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(PhoneNumber.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}
}
