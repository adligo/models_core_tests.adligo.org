package org.adligo.models.core.client.assertions;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.tests.I_Test;



public class IPEExceptionAsserter {

	public static InvalidParameterException isIPE(Exception g, I_Test test) {
		if (g instanceof InvalidParameterException) {
			return (InvalidParameterException) g;
		} else {
			Throwable t = g.getCause();
			if (t instanceof InvalidParameterException) {
				return (InvalidParameterException) t;
			}
		}
		g.printStackTrace();
		test.assertIsTrue("Exception " + g + " is not a InvalidParameterException see log" ,false);
		return null;
	}
}
