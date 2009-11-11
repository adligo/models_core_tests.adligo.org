package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.DomainNameAssertions;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.tests.client.AGwtTest;


public class DomainNameGwtTests extends AGwtTest {
	
	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreRegistry.init();
		ModelsCoreMockGwtSetup.init();
	}
	
	public void testValidationClassAndPropertyFileMatch() throws Exception {
		DomainNameAssertions.assertInvalidParameterExceptions("", this);
	}


}