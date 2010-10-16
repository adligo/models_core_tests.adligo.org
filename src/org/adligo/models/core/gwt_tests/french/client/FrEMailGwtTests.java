package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.EMailAssertions;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.tests.client.AGwtTest;

public class FrEMailGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	
	public void testStringConstructorAndValidateVsPropertyfile() throws Exception {
		EMailAssertions.assertConstructorInvalidParameterExceptions("fr ", this);
	}
	
	public void testSetterValidateVsPropertyfile() throws Exception {
		EMailAssertions.assertSetterInvalidParameterExceptions("fr ", this);
	}

	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}

}
