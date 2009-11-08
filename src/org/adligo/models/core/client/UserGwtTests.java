package org.adligo.models.core.client;

import org.adligo.tests.client.AGwtTest;

public class UserGwtTests extends AGwtTest {



	
	public void testErrorStrings() {
		System.out.println("UserGwtTests.testErrorStrings");
		
		UserMutant user = new UserMutant();
		
		
		
		
	}


	@Override
	public String getModuleName() {
		return ModelsCoreTestGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreTestGwtSetup.init();
	}
}
