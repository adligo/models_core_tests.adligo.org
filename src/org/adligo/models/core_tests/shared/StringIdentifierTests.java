package org.adligo.models.core_tests.shared;

import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ids.StringIdentifier;
import org.adligo.tests.ATest;
import org.adligo.xml_io_tests.shared.IsXmlIoSerializable;

public class StringIdentifierTests extends ATest {

	public void testStorageIdentifierConstructors() throws Exception {
		
		InvalidParameterException x;
		x = null;
		try {
			new StringIdentifier(new StringIdentifier());
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StringIdentifier.CONSTRUCTOR, x.getMethodName());
		assertEquals(StringIdentifier.KEY_CANT_BE_SET_TO_EMPTY, x.getMessage());
		
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
		assertEquals(StringIdentifier.CONSTRUCTOR, x.getMethodName());
		
		x = null;
		try {
			new StringIdentifier("");
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(StringIdentifier.CONSTRUCTOR, x.getMethodName());
		
		StringIdentifier id = new StringIdentifier("you");
		assertEquals("you", id.getKey());
	}
	
	public void testToString() throws Exception {
		StringIdentifier mutant = new StringIdentifier();
		assertEquals("StringIdentifier [key=null]", mutant.toString());
		mutant = new StringIdentifier("keyVal");
		assertEquals("StringIdentifier [key=keyVal]", mutant.toString());
		
		StringIdentifier id = new StringIdentifier(mutant);
		assertEquals("StringIdentifier [key=keyVal]", id.toString());
	}
	
	public void testEquals() throws Exception {
		StringIdentifier a = new StringIdentifier();
		StringIdentifier b = new StringIdentifier();
		
		assertEquals(a, b);
		b = new StringIdentifier("some_key");
		
		a = new StringIdentifier(b);
		assertEquals(a, b);
	}
	
	public void testIsSeralizable() throws IllegalStateException {
		IsXmlIoSerializable.isXmlIoSerializable(StringIdentifier.class);
	}
	
}
