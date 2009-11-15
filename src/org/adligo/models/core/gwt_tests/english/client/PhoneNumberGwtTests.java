package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.tests.client.AGwtTest;

public class PhoneNumberGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.ENGLISH_MODULE_NAME;
	}
	
	
	public void testStringConstructorAndValidateVsPropertyfile() throws Exception {
		PhoneNumberAssertions.assertConstructors(this, "");
		PhoneNumberAssertions.assertMutators(this, "");
	}


	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreRegistry.init();
		ModelsCoreMockGwtSetup.init();
	}
}
