package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrPhoneNumberGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	
	public void testStringConstructorAndValidateVsPropertyfile() throws Exception {
		PhoneNumberAssertions.assertConstructors(this, "fr ");
		PhoneNumberAssertions.assertMutators(this, "fr ");
	}


	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}
}
