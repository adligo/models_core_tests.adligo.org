package org.adligo.models.core;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.tests.ATest;

public class NameIdTests extends ATest {

	public void testSetters() throws Exception {
		NamedIdMutant mutant = new NamedIdMutant();
		
		mutant.setId(null);
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
		
	}
	
	public void testSubClass() throws Exception {
			@SuppressWarnings("unused")
			NameIdSubclass subclass = null;
			NamedIdMutant mutant = new NamedIdMutant();
			
			InvalidParameterException exception = null;
			try {
				subclass = new NameIdSubclass(mutant);
			} catch (InvalidParameterException x) {
				exception = x;
			}
			assertNotNull(exception);
			assertEquals(NamedId.SET_ID, exception.getMethodName());
			assertEquals(NameIdSubclass.ID_ERROR, exception.getMessage());
			
			StorageIdentifier sid = new StorageIdentifier((long) 1);
			mutant.setId(sid);
			NameIdSubclass.setThrow_id_error(false);
			exception = null;
			try {
				subclass = new NameIdSubclass(mutant);
			} catch (InvalidParameterException x) {
				exception = x;
			}
			assertNotNull(exception);
			assertEquals(NamedId.SET_NAME, exception.getMethodName());
			assertEquals(NameIdSubclass.NAME_ERROR, exception.getMessage());
			
			
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
}
