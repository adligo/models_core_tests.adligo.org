package org.adligo.models.core.client;

import java.lang.reflect.Method;
import org.adligo.tests.ATest;

public class ParamterExceptionAsserter {

	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionStringMutator(Object obj, String methodName) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {String.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			if (g instanceof InvalidParameterException) {
				x = (InvalidParameterException) g;
			}
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, "");
		} catch (Exception g) {
			if (g instanceof InvalidParameterException) {
				x = (InvalidParameterException) g;
			}
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionIntegerMutator(Object obj, String methodName) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {Integer.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			if (g instanceof InvalidParameterException) {
				x = (InvalidParameterException) g;
			}
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
	
}
