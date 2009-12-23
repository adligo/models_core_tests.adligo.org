package org.adligo.models.core.client;

import org.adligo.i.adi.client.Registry;

/**
* may NOT contain GWT.creates
* @author scott
*
*/
public class ModelsMockSetup {

	public static void setUp() {
		Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
				new DefaultStorageIdentifierFactory());
	}
}
