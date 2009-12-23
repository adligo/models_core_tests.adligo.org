package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.StringIdentifier;
import org.adligo.models.core.client.StringIdentifierMutant;
import org.adligo.models.core.client.VersionedIdentifier;
import org.adligo.models.core.client.VersionedIdentifierMutant;
import org.adligo.tests.ATest;

public class VersionedIdentifierTests extends ATest {

	public void testConstructors() throws Exception {
		
		
		
		
	}

	public void testCopy() throws InvalidParameterException {
		InvalidParameterException x;
		x = null;
		try {
			new VersionedIdentifier(new VersionedIdentifierMutant());
		} catch (InvalidParameterException g) {
			x = g;
		}
		assertNotNull(x);
		assertEquals(VersionedIdentifier.CLAZZ_SIMPLE_NAME, x.getMethodName());
		assertEquals(VersionedIdentifier.NO_VERSION_OR_A_ID, x.getMessage());
		
	}


	public void testMutators() throws Exception {
		VersionedIdentifierMutant mutant = new VersionedIdentifierMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionLongMutator(mutant, "setId");
		
		mutant.setId((long) 5);
		assertEquals(new Long(5), mutant.getId());
	}
	
	public void testToString() throws Exception {
		VersionedIdentifierMutant mutant = new VersionedIdentifierMutant();
		assertEquals("VersionedIdentifierMutant [id=null,version=null]", mutant.toString());
		mutant.setVersion(3);
		assertEquals("VersionedIdentifierMutant [id=null,version=3]", mutant.toString());
		mutant.setId((long) 12);
		assertEquals("VersionedIdentifierMutant [id=12,version=3]", mutant.toString());
		
		VersionedIdentifier id = new VersionedIdentifier(mutant);
		assertEquals("VersionedIdentifier [id=12,version=3]", id.toString());
	}
	
	public void testEquals() throws Exception {
		VersionedIdentifier a = new VersionedIdentifier();
		VersionedIdentifierMutant b = new VersionedIdentifierMutant();
		
		assertEquals(a, b);
		b.setId(1);
		b.setVersion(2);
		a = new VersionedIdentifier(b);
		assertNotSame(a, b);
		
		a = new VersionedIdentifier(b);
		assertEquals(a, b);
	}
	
	public void testIsSeralizable() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(StringIdentifier.class);
	}
	
}
