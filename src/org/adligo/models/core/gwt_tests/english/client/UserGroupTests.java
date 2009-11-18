package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.UserGroupAssertions;
import org.adligo.tests.client.AGwtTest;

public class UserGroupTests extends AGwtTest {

	public void testErrorStrings() throws Exception {
		UserGroupAssertions.assertMutators(this, "");
		UserGroupAssertions.assertConstructors(this, "");
	}


	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}
}
