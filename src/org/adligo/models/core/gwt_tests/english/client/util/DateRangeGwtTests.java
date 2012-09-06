package org.adligo.models.core.gwt_tests.english.client.util;

import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.util.DateRangeAssertions;
import org.adligo.tests.client.AGwtTest;

public class DateRangeGwtTests extends AGwtTest {
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
		DateRangeAssertions.assertMutations("", this);
		DateRangeAssertions.assertConstructors("", this);
	}
}
