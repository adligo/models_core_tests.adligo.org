package org.adligo.models.core.client;

import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtDomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtUserValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;
import org.adligo.tests.client.AGwtTest;

import com.google.gwt.core.client.GWT;

public abstract class FrModelsCoreGwtBaseTest extends AGwtTest {

	@Override
	public String getModuleName() {
		return "org.adligo.models.core.ModelsCoreFrTests";
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		ModelsCoreGwtBaseTest.init();
	}
	
}
