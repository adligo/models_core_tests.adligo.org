package org.adligo.models.core.client;

import org.adligo.tests.client.AGwtTest;

public class EMailGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreTestGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	
	public void testNothing() {
		//todo
	}


	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreTestGwtSetup.init();
	}
}
