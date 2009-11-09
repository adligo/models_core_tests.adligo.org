package org.adligo.models.core.client;

import org.adligo.tests.client.AGwtTest;


public class GwtParameterExceptionAsserter extends AGwtTest {

	public static InvalidParameterException isIPE(Exception g) {
		if (g instanceof InvalidParameterException) {
			return (InvalidParameterException) g;
		} else {
			Throwable t = g.getCause();
			if (t instanceof InvalidParameterException) {
				return (InvalidParameterException) t;
			}
		}
		g.printStackTrace();
		assertTrue("Exception " + g + " is not a InvalidParameterException see log" ,false);
		return null;
	}
}
