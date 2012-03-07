package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.I_Address;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.ids.StringIdentifierMutant;
import org.adligo.tests.ATest;

public class AddressTests extends ATest {

	
	
	public void testMutators() throws Exception {
		AddressAssertions.assertMutations("",  this);
		
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
		ModelsMockSetup.setUp();
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
		IsGwtRpcSerializable.isRpcSerializable(AddressMutant.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(Address.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}
}
