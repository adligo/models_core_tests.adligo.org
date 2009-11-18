package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.UserAssertions;
import org.adligo.models.core.client.UserRelationsAssertions;
import org.adligo.tests.client.AGwtTest;

public class UserRelationsTests extends AGwtTest {

	public void testErrorStrings() throws Exception {
		UserRelationsAssertions.assertMutators(this, "");
		UserRelationsAssertions.assertConstructors(this, "");
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
