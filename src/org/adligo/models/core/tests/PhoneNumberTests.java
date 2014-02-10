package org.adligo.models.core.tests;

import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.tests.client.assertions.PhoneNumberAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io.client.IsXmlIoSerializable;

public class PhoneNumberTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	public void testConstructors() throws Exception {
		PhoneNumberAssertions.assertConstructors(this, "");
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(PhoneNumber.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsXmlIoSerializable.isXmlIoSerializable(PhoneNumber.class);
		} catch (IllegalStateException x) {
			ex = x;
		}
		assertNull(ex);
	}
}
