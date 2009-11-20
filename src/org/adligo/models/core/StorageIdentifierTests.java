package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.StorageIdentifierMutant;
import org.adligo.tests.ATest;

public class StorageIdentifierTests extends ATest {

	public void testStorageIdentifierConstructors() throws Exception {
		
		InvalidParameterException x;
		x = null;
		try {
			new StorageIdentifier(new StorageIdentifierMutant());
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StorageIdentifier.CLAZZ_SIMPLE_NAME, x.getMethodName());
		assertEquals(StorageIdentifier.NO_KEY_OR_A_ID, x.getMessage());
		
	}

	public void testCopy() throws InvalidParameterException {
		InvalidParameterException x;
		x = null;
		try {
			new StorageIdentifier((long) 1, (String) null);
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StorageIdentifier.SET_KEY, x.getMethodName());
		assertEquals(StorageIdentifier.KEY_CANT_BE_SET_TO_EMPTY, x.getMessage());
		
		x = null;
		try {
			new StorageIdentifier(null , "hey");
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StorageIdentifier.SET_ID, x.getMethodName());
		assertEquals(StorageIdentifier.ID_CANT_BE_SET_TO_NULL, x.getMessage());
		
		//sholdn't throw a exception
		StorageIdentifier id = new StorageIdentifier((long) 1, "hey");
		assertEquals(new Long(1), id.getId());
		assertEquals("hey", id.getKey());
		
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		mutant.setId((long) 3);
		mutant.setKey("bar");
		id = new StorageIdentifier(mutant);
		assertEquals(new Long(3), id.getId());
		assertEquals("bar", id.getKey());
		
		mutant = new StorageIdentifierMutant();
		mutant.setKey("bar");
		id = new StorageIdentifier(mutant);
		assertNull(id.getId());
		assertEquals("bar", id.getKey());
		
		
		mutant = new StorageIdentifierMutant();
		mutant.setId((long) 3);
		id = new StorageIdentifier(mutant);
		assertEquals(new Long(3), id.getId());
		assertNull(id.getKey());
		
		assertEquals(mutant, id);
	}

	public void testStringConstructor() throws Exception {
		InvalidParameterException x;
		x = null;
		try {
			new StorageIdentifier((String) null);
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setKey", x.getMethodName());
		
		x = null;
		try {
			new StorageIdentifier("");
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setKey", x.getMethodName());
		
		StorageIdentifier id = new StorageIdentifier("you");
		assertEquals("you", id.getKey());
	}

	public void testLongConstructor() throws Exception {
		InvalidParameterException x = null;
		try {
			new StorageIdentifier((Long) null);
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StorageIdentifier.SET_ID, x.getMethodName());
		assertEquals(StorageIdentifier.ID_CANT_BE_SET_TO_NULL, x.getMessage());
		
		StorageIdentifier id = new StorageIdentifier((long) 2);
		assertEquals(new Long(2), id.getId());
	}
	
	public void testMutators() throws Exception {
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setKey");
		ParamterExceptionAsserter.assertInvalidParamterExceptionLongMutator(mutant, "setId");
		
		mutant.setKey("key");
		assertEquals("key", mutant.getKey());
		
		mutant.setId((long) 5);
		assertEquals(new Long(5), mutant.getId());
	}
	
	public void testToString() throws Exception {
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		assertEquals("StorageIdentifierMutant [id=null,key=null]", mutant.toString());
		mutant.setKey("keyVal");
		assertEquals("StorageIdentifierMutant [id=null,key=keyVal]", mutant.toString());
		mutant.setId((long) 12);
		assertEquals("StorageIdentifierMutant [id=12,key=keyVal]", mutant.toString());
		
		StorageIdentifier id = new StorageIdentifier(mutant);
		assertEquals("StorageIdentifier [id=12,key=keyVal]", id.toString());
	}
	
	public void testEquals() throws Exception {
		StorageIdentifier a = new StorageIdentifier();
		StorageIdentifierMutant b = new StorageIdentifierMutant();
		
		assertEquals(a, b);
		b.setId((long) 1);
		a = new StorageIdentifier(b);
		assertEquals(a, b);
		
		b = new StorageIdentifierMutant();
		b.setKey("some_key");
		
		a = new StorageIdentifier(b);
		assertEquals(a, b);
	}
	
	public void testIsSeralizable() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(StorageIdentifier.class);
	}
	
	public void testMutantNOTSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(StorageIdentifierMutant.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNotNull(ex);
		assertEquals("class org.adligo.models.core.client.StorageIdentifierMutant" +
				" with parents [] is not serlizeable see log. ", ex.getMessage());
	}
}
