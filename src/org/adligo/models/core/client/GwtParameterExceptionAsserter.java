package org.adligo.models.core.client;

import org.adligo.models.core.client.InvalidParameterException;


public class GwtParameterExceptionAsserter {

	public static InvalidParameterException isIPE(Exception g) {
		if (g instanceof InvalidParameterException) {
			return (InvalidParameterException) g;
		} else {
			Throwable t = g.getCause();
			if (t instanceof InvalidParameterException) {
				return (InvalidParameterException) t;
			}
		}
		return null;
	}
}
