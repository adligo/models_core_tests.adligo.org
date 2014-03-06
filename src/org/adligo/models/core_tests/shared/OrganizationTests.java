package org.adligo.models.core_tests.shared;

import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core.shared.Org;
import org.adligo.models.core_tests.shared.assertions.OrganizationAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io_tests.shared.IsXmlIoSerializable;

public class OrganizationTests extends ATest {

	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testMutators() throws Exception {
		OrganizationAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		OrganizationAssertions.assertConstructors(this, "");
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(Org.class);
	}
}
