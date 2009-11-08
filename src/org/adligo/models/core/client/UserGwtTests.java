package org.adligo.models.core.client;

import org.adligo.tests.client.AGwtTest;

public class UserGwtTests extends AGwtTest {



	
	public void testErrorStrings() {
		System.out.println("UserGwtTests.testErrorStrings");
		
		UserMutant user = new UserMutant();
		
		
		
		
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
