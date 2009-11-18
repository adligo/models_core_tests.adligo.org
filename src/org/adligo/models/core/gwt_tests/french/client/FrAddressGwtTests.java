package org.adligo.models.core.gwt_tests.french.client;

import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.tests.client.AGwtTest;

public class FrAddressGwtTests extends AGwtTest {
	@Override
	public String getModuleName() {
		return ModelsCoreMockGwtSetup.FRENCH_MODULE_NAME;
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		ModelsCoreMockGwtSetup.init();
	}
	
	public void testValidationClassAndPropertyFileMatch() throws Exception {
		AddressAssertions.assertMutations("fr ", this);
		AddressAssertions.assertConstructors("fr ", this, new AddressMutant());
	}
}
