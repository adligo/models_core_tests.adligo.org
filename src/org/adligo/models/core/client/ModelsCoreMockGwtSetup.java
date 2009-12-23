package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;
import org.adligo.models.core.client.i18n.ModelsCoreConstantsSetup;

/**
 * may contain GWT.creates
 * @author scott
 *
 */
public class ModelsCoreMockGwtSetup {
	public static final String COMMON_MODULE_NAME = "org.adligo.models.core.ModelsCoreTests";
	public static final String ENGLISH_MODULE_NAME = "org.adligo.models.core.gwt_tests.english.EnglishModelsCoreTests";
	public static final String FRENCH_MODULE_NAME = "org.adligo.models.core.gwt_tests.french.FrenchModelsCoreTests";
	private static boolean isInit = false;
	
	public static void init() {
		if (!isInit) {
			ModelsCoreConstantsSetup.init();
			isInit = true;
			Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
					new DefaultStorageIdentifierFactory());
		}
	}
}
