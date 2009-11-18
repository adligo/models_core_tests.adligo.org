package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.OrganizationAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrOrganizationGwtTests extends AGwtTest {
	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}
	
	public void testValidationClassAndPropertyFileMatch() throws Exception {
		OrganizationAssertions.assertMutators(this, "fr ");
		OrganizationAssertions.assertConstructors(this, "fr ");
	}
}
