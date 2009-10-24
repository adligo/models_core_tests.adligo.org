package org.adligo.models.core.client;

import org.adligo.tests.ATest;

public class StorageIdentifierTests extends ATest {

	public void testStorageIdentifierConstructors() throws Exception {
		
		InvalidParameterException x = null;
		try {
			new StorageIdentifier((Integer) null);
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setId", x.getMethodName());
		
		x = null;
		try {
			new StorageIdentifier(new StorageIdentifierMutant());
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("StorageIdentifier", x.getMethodName());
		
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
			new StorageIdentifier(1, (String) null);
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
		
		x = null;
		try {
			new StorageIdentifier(null , "hey");
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setId", x.getMethodName());
		
		//sholdn't throw a exception
		StorageIdentifier id = new StorageIdentifier(1, "hey");
		assertEquals((Integer) 1, id.getId());
		assertEquals("hey", id.getKey());
		
		id = new StorageIdentifier(2);
		assertEquals((Integer) 2, id.getId());
		
		id = new StorageIdentifier("you");
		assertEquals("you", id.getKey());
		
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		mutant.setId(3);
		mutant.setKey("bar");
		
		id = new StorageIdentifier(mutant);
		assertEquals((Integer) 3, id.getId());
		assertEquals("bar", id.getKey());
	}
	
	public void testMutators() throws Exception {
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setKey");
		ParamterExceptionAsserter.assertInvalidParamterExceptionIntegerMutator(mutant, "setId");
		
		mutant.setKey("key");
		assertEquals("key", mutant.getKey());
		
		mutant.setId(5);
		assertEquals((Integer) 5, mutant.getId());
	}
	
	public void testToString() throws Exception {
		StorageIdentifierMutant mutant = new StorageIdentifierMutant();
		assertEquals("StorageIdentifierMutant [id=null,key=null]", mutant.toString());
		mutant.setKey("keyVal");
		assertEquals("StorageIdentifierMutant [id=null,key=keyVal]", mutant.toString());
		mutant.setId(12);
		assertEquals("StorageIdentifierMutant [id=12,key=keyVal]", mutant.toString());
		
		StorageIdentifier id = new StorageIdentifier(mutant);
		assertEquals("StorageIdentifier [id=12,key=keyVal]", id.toString());
	}
}
