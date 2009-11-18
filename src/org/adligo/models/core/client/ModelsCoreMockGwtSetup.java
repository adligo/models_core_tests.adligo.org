package org.adligo.models.core.client;

import org.adligo.models.core.client.i18n.ModelsCoreConstantsSetup;

public class ModelsCoreMockGwtSetup {
	public static final String COMMON_MODULE_NAME = "org.adligo.models.core.ModelsCoreTests";
	public static final String ENGLISH_MODULE_NAME = "org.adligo.models.core.gwt_tests.english.EnglishModelsCoreTests";
	public static final String FRENCH_MODULE_NAME = "org.adligo.models.core.gwt_tests.french.FrenchModelsCoreTests";
	private static boolean isInit = false;
	
	public static void init() {
		if (!isInit) {
			ModelsCoreConstantsSetup.init();
			isInit = true;
		}
	}
}
