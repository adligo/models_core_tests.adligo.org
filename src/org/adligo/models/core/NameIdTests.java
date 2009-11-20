package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.StorageIdentifierMutant;
import org.adligo.tests.ATest;

public class NameIdTests extends ATest {

	public void testSetters() throws Exception {
		NamedIdMutant mutant = new NamedIdMutant();
		InvalidParameterException ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		assertNotNull(ex);
		assertEquals("You set the id to null?", ex.getMessage());
		
		assertNull(mutant.getId());
		mutant.setName(null);
		assertNull(mutant.getName());
		
		StorageIdentifier id = new StorageIdentifier((long) 1);
		mutant.setId(id);
		assertEquals(id, mutant.getId());
		mutant.setName("name");
		assertEquals("name", mutant.getName());
		
	}
	
	public void testCopy() throws Exception {
		NamedIdMutant mutant = new NamedIdMutant();
		NamedId id = new NamedId(mutant);
		
		assertNull(id.getName());
		assertNull(id.getId());
		
		StorageIdentifier sid = new StorageIdentifier((long) 1);
		mutant.setId(sid);
		id = new NamedId(mutant);
		assertNull(id.getName());
		assertEquals(sid, id.getId());
		
		mutant = new NamedIdMutant();
		mutant.setName("mutant name");
		id = new NamedId(mutant);
		assertEquals("mutant name", id.getName());
		assertNull(id.getId());
		
		mutant.setId(sid);
		id = new NamedId(mutant);
		assertEquals("mutant name", id.getName());
		assertEquals(sid, id.getId());
		
		assertEquals(id, mutant);
		assertEquals("NamedIdMutant [name=mutant name,id=StorageIdentifier [id=1,key=null]]", mutant.toString());
		assertEquals("NamedId [name=mutant name,id=StorageIdentifier [id=1,key=null]]", id.toString());
	}
	
	public void testEquals() throws Exception {
		NamedId a = new NamedId();
		NamedIdMutant b = new NamedIdMutant();
		
		assertEquals(a, b);
		b.setName("some_name");
		a = new NamedId(b);
		assertEquals(a, b);
		
		b.setId(new StorageIdentifier((long) 1));
		a = new NamedId(a);
		assertEquals(a, b);
		
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(NamedId.class);
	}
	
	public void testMutantNOTSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(NamedIdMutant.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNotNull(ex);
		assertEquals("class org.adligo.models.core.client.NamedIdMutant" +
				" with parents [] is not serlizeable see log. ", ex.getMessage());
	}
}
