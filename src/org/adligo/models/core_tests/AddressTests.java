package org.adligo.models.core_tests;

import org.adligo.models.core.shared.Address;
import org.adligo.models.core.shared.AddressMutant;
import org.adligo.models.core.shared.I_Address;
import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core_tests.shared.assertions.AddressAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io.tests.client.IsXmlIoSerializable;

public class AddressTests extends ATest {

	
	
	public void testMutators() throws Exception {
		AddressAssertions.assertMutations("",  this);
		
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testCopy() throws Exception {
		AddressMutant mutant = new AddressMutant();
		
		AddressAssertions.assertConstructors("", this, mutant);
		
		I_Address addr = new AddressMutant(mutant);
		assertEquals("city A", addr.getCity());
		assertEquals("1234 test row", addr.getStreetAddress());
		assertEquals("12345A", addr.getPostalCode());
		assertEquals("US", addr.getCountryCode());
		assertEquals("IL", addr.getCountrySubCode());
		
		assertEquals(addr, mutant);
		assertEquals(mutant, addr);
	}
	
	public void testSerializable() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(AddressMutant.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsXmlIoSerializable.isXmlIoSerializable(Address.class);
		} catch (IllegalStateException x) {
			ex = x;
		}
		assertNull(ex);
	}
}
