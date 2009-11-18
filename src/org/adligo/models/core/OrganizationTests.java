package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.OrganizationAssertions;
import org.adligo.tests.ATest;

public class OrganizationTests extends ATest {

	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
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
