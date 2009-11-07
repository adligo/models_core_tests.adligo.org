package org.adligo.models.core;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
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
	
	public void testSubClass() throws Exception {
		StorageIdentifierSubclass subclass = null;
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		
		InvalidParameterException exception = null;
		try {
			subclass = new StorageIdentifierSubclass(mutant);
		} catch (InvalidParameterException x) {
			exception = x;
		}
		assertNotNull(exception);
		assertEquals(StorageIdentifier.CLAZZ_SIMPLE_NAME, exception.getMethodName());
		assertEquals(StorageIdentifier.NO_KEY_OR_A_ID, exception.getMessage());
		
		exception = null;
		mutant.setId((long) 4);
		try {
			subclass = new StorageIdentifierSubclass(mutant);
		} catch (InvalidParameterException x) {
			exception = x;
		}
		assertNotNull(exception);
		assertEquals(StorageIdentifier.SET_ID, exception.getMethodName());
		assertEquals(StorageIdentifierSubclass.ID_ERROR, exception.getMessage());
		
		exception = null;
		mutant = new StorageIdentifierMutant();
		mutant.setKey("mydn");
		try {
			subclass = new StorageIdentifierSubclass(mutant);
		} catch (InvalidParameterException x) {
			exception = x;
		}
		assertNotNull(exception);
		assertEquals(StorageIdentifier.SET_KEY, exception.getMethodName());
		assertEquals(StorageIdentifierSubclass.KEY_ERROR, exception.getMessage());
		
		StorageIdentifier id = new StorageIdentifier(mutant);
		id = new StorageIdentifierSubclass(id);
	}
}
