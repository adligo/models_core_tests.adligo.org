package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.UserGroupAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrUserGroupGwtTests extends AGwtTest {

	public void testErrorStrings() throws Exception {
		UserGroupAssertions.assertMutators(this, "fr ");
		UserGroupAssertions.assertConstructors(this, "fr ");
	}


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
}
