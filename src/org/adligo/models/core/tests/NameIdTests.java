package org.adligo.models.core.tests;

import org.adligo.models.core.client.I_IdentifiableMutant;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.tests.client.assertions.IPEExceptionAsserter;
import org.adligo.tests.ATest;
import org.adligo.xml_io.client.IsXmlIoSerializable;

public class NameIdTests extends ATest {

	
	public void testSetters() throws Exception {
		NamedIdMutant mutant = new NamedIdMutant();
		InvalidParameterException ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, this);
		}
		assertNotNull(ex);
		assertEquals("NamedIdMutant" + StorageIdentifierValidator.REQUIRES_A_NON_NULL_ID_IN + 
				I_IdentifiableMutant.SET_ID, ex.getMessage());
		
		assertNull(mutant.getId());
		mutant.setName(null);
		assertNull(mutant.getName());
		
		StringIdentifier id = new StringIdentifier("some_string");
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
		
		StringIdentifier sid = new StringIdentifier("sid");
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
		assertEquals("NamedIdMutant [name=mutant name,id=StringIdentifier [key=sid]]", mutant.toString());
		assertEquals("NamedId [name=mutant name,id=StringIdentifier [key=sid]]", id.toString());
	}
	
	public void testEquals() throws Exception {
		NamedId a = new NamedId();
		NamedIdMutant b = new NamedIdMutant();
		
		assertEquals(a, b);
		b.setName("some_name");
		a = new NamedId(b);
		assertEquals(a, b);
		
		b.setId(new StringIdentifier("sid"));
		a = new NamedId(b);
		assertEquals(a, b);
		
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(NamedId.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsXmlIoSerializable.isXmlIoSerializable(NamedIdMutant.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
}
