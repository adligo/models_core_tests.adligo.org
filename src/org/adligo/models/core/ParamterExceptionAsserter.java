package org.adligo.models.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.StorageIdentifierMutant;
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
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, "");
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	
	}

	public static void assertInvalidParamterExceptionStringMutator(Object obj, String methodName, String exceptionMessage) throws Exception {
		InvalidParameterException x = null;
		Class<?> clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {String.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, "");
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		ATest.assertEquals(exceptionMessage, x.getMessage());
		
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionIntegerMutator(Object obj, String methodName) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {Integer.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}

	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionLongMutator(Object obj, String methodName) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {Long.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
	
	@SuppressWarnings("unchecked")
	public static void assertInvalidParamterExceptionStorageIdentifierMutator(Object obj, String methodName) throws Exception {
		InvalidParameterException x = null;
		Class clazz = obj.getClass();
		Method method = clazz.getDeclaredMethod(methodName,new Class[] {I_StorageIdentifier.class});
		
		try {
			method.invoke(obj, new Object[] {null});
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
		
		x = null;
		try {
			method.invoke(obj, new Object[] {new StorageIdentifierMutant()});
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		ATest.assertNotNull(x);
		ATest.assertEquals(methodName, x.getMethodName());
	}
}
