package org.adligo.models.core.gwt_tests.french.client.util;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.util.DateRangeAssertions;
import org.adligo.tests.client.AGwtTest;

public class FrDateRangeGwtTests extends AGwtTest {
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
		DateRangeAssertions.assertMutations("fr ", this);
		DateRangeAssertions.assertConstructors("fr ", this);
	}
	
	public void testIsValidWithoutNulls() throws Exception {
		DateRangeAssertions.assertIsValidWithoutNulls("fr ", this);
	}
}
