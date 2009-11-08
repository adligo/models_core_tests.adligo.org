package org.adligo.models.core.client;

import org.adligo.models.core.client.ConstantsFactory;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtDomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtUserValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

import com.google.gwt.core.client.GWT;

public class ModelsCoreMockGwtSetup {
	public static final String COMMON_MODULE_NAME = "org.adligo.models.core.ModelsCoreTests";
	public static final String ENGLISH_MODULE_NAME = "org.adligo.models.core.gwt_tests.english.EnglishModelsCoreTests";
	public static final String FRENCH_MODULE_NAME = "org.adligo.models.core.gwt_tests.french.FrenchModelsCoreTests";
	private static boolean isInit = false;
	
	public static void init() {
		if (!isInit) {
			isInit = true;
			ConstantsFactory.INSTANCE.put(I_DomainNameValidationConstants.class, 
					GWT.create(I_GwtDomainNameValidationConstants.class));
			//set up adi code for GWT
			I_GwtUserValidationConstants type = (I_GwtUserValidationConstants) 
				GWT.create(I_GwtUserValidationConstants.class);
			ConstantsFactory.INSTANCE.put(I_UserValidationConstants.class, type);
			ModelsCoreRegistry.init();
		}
	}
}
