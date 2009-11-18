package org.adligo.models.core.gwt_tests.english.client;

import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.tests.client.AGwtTest;

public class AddressGwtTests extends AGwtTest {
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
	
	public void testValidationClassAndPropertyFileMatch() throws Exception {
		AddressAssertions.assertMutations("", this);
		AddressAssertions.assertConstructors("", this, new AddressMutant());
	}
}
