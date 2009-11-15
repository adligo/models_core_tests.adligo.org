package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.UserAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrUserGwtTests extends AGwtTest {

	public void testErrorStrings() throws Exception {
		UserAssertions.assertMutators(this, "fr ");
		UserAssertions.assertConstructors(this, "fr ");
	}


	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreRegistry.init();
		ModelsCoreMockGwtSetup.init();
	}
}
