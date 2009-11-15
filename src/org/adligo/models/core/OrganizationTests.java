package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.OrganizationAssertions;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class OrganizationTests extends ATest {

	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.init();
		new EnglishConstantsFactory();
	}
	
	public void testMutators() throws Exception {
		OrganizationAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		OrganizationAssertions.assertConstructors(this, "");
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(Organization.class);
	}
}
