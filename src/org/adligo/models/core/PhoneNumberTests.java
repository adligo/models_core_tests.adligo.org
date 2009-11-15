package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class PhoneNumberTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.init();
		new EnglishConstantsFactory();
	}
	
	public void testMutators() throws Exception {
		PhoneNumberAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		PhoneNumberAssertions.assertConstructors(this, "");
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(PhoneNumber.class);
	}
}
