package org.adligo.models.core.client;

import org.adligo.tests.client.AGwtTest;



public class FrDomainNameGwtTests extends AGwtTest {
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreTestGwtSetup.init();
	}
	
	@Override
	public String getModuleName() {
		return ModelsCoreTestGwtSetup.FRENCH_MODULE_NAME;
	}
	
	public void testFrenchProperyFile() throws Exception {
		DomainNameGwtTests.assertPropertyFile("fr ");
	}
}
