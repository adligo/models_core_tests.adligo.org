package org.adligo.models.core_tests.shared;

import java.lang.reflect.Method;

import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ids.I_StorageIdentifier;
import org.adligo.models.core.shared.ids.StringIdentifier;
import org.adligo.models.core_tests.shared.assertions.IPEExceptionAsserter;
import org.adligo.tests.ATest;
import org.adligo.tests.I_Test;

public class ParamterExceptionAsserter {


	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionStringMutator(Object obj, String methodName, I_Test test) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {String.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, "");
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	
	}

	public static void assertInvalidParamterExceptionStringMutator(Object obj, String methodName, String exceptionMessage, I_Test test) throws Exception {
		InvalidParameterException x = null;
		Class<?> clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {String.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, "");
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		ATest.assertEquals(exceptionMessage, x.getMessage());
		
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionIntegerMutator(Object obj, String methodName, I_Test test) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {Integer.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}

	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionLongMutator(Object obj, String methodName, I_Test test) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {Long.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionStorageIdentifierMutator(Object obj, String methodName, I_Test test) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {I_StorageIdentifier.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, new Object[] {new StringIdentifier()});
		} catch (Exception g) {
			x = IPEExceptionAsserter.isIPE(g, test);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
}
