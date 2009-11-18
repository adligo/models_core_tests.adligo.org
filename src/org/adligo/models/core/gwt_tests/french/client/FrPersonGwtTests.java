package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrPersonGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	
	public void testStringConstructorAndValidateVsPropertyfile() throws Exception {
		PersonAssertions.assertConstructors(this, "fr ");
		PersonAssertions.assertMutators(this, "fr ");
	}


	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}
}
