package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.client.ids.StringIdentifierMutant;
import org.adligo.tests.ATest;

public class StringIdentifierTests extends ATest {

	public void testStorageIdentifierConstructors() throws Exception {
		
		InvalidParameterException x;
		x = null;
		try {
			new StringIdentifier(new StringIdentifierMutant());
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StringIdentifier.TYPE, x.getMethodName());
		assertEquals(StringIdentifier.NO_KEY_OR_A_ID, x.getMessage());
		
	}


	public void testStringConstructor() throws Exception {
		InvalidParameterException x;
		x = null;
		try {
			new StringIdentifier((String) null);
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setKey", x.getMethodName());
		
		x = null;
		try {
			new StringIdentifier("");
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals("setKey", x.getMethodName());
		
		StringIdentifier id = new StringIdentifier("you");
		assertEquals("you", id.getKey());
	}

	
	public void testMutators() throws Exception {
		StringIdentifierMutant mutant = new StringIdentifierMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setKey");
		
		mutant.setKey("key");
		assertEquals("key", mutant.getKey());
		
	}
	
	public void testToString() throws Exception {
		StringIdentifierMutant mutant = new StringIdentifierMutant();
		assertEquals("StringIdentifierMutant [key=null]", mutant.toString());
		mutant.setKey("keyVal");
		assertEquals("StringIdentifierMutant [key=keyVal]", mutant.toString());
		
		StringIdentifier id = new StringIdentifier(mutant);
		assertEquals("StringIdentifier [key=keyVal]", id.toString());
	}
	
	public void testEquals() throws Exception {
		StringIdentifier a = new StringIdentifier();
		StringIdentifierMutant b = new StringIdentifierMutant();
		
		assertEquals(a, b);
		b = new StringIdentifierMutant();
		b.setKey("some_key");
		
		a = new StringIdentifier(b);
		assertEquals(a, b);
	}
	
	public void testIsSeralizable() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(StringIdentifier.class);
	}
	
}
