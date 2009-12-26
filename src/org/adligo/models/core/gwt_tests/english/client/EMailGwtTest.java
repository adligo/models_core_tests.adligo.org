package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.EMailAssertions;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.tests.client.AGwtTest;

public class EMailGwtTest extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	
	public void testStringConstructorAndValidateVsPropertyfile() throws Exception {
		EMailAssertions.assertConstructorInvalidParameterExceptions("", this);
	}
	
	public void testSetterValidateVsPropertyfile() throws Exception {
		EMailAssertions.assertSetterInvalidParameterExceptions("", this);
	}

	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}

}
