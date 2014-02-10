package org.adligo.models.core.tests;

import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.tests.client.assertions.OrganizationAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io.client.IsXmlIoSerializable;

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
		IsXmlIoSerializable.isXmlIoSerializable(Organization.class);
	}
}
