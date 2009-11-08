package org.adligo.models.core.client;

import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtDomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtUserValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;
import org.adligo.tests.client.AGwtTest;

import com.google.gwt.core.client.GWT;

public abstract class ModelsCoreGwtBaseTest extends AGwtTest {

	@Override
	public String getModuleName() {
		return "org.adligo.models.core.ModelsCoreTests";
	}
	
	@Override
	protected void gwtSetUp() throws Exception {
		super.gwtSetUp();
		init();
	}

	public static void init() {
		ConstantsFactory.INSTANCE.put(I_DomainNameValidationConstants.class, 
				GWT.create(I_GwtDomainNameValidationConstants.class));
		//set up adi code for GWT
		I_GwtUserValidationConstants type = (I_GwtUserValidationConstants) 
			GWT.create(I_GwtUserValidationConstants.class);
		ConstantsFactory.INSTANCE.put(I_UserValidationConstants.class, type);
		ModelsCoreRegistry.init();
	}
	
}
