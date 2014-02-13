package org.adligo.models.core_tests.shared;

import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core.shared.PhoneNumber;
import org.adligo.models.core_tests.shared.assertions.PhoneNumberAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io_tests.shared.IsXmlIoSerializable;

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
