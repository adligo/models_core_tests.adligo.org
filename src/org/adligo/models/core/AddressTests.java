package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.I_Address;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.ModelsMockSetup;
import org.adligo.models.core.client.StringIdentifierMutant;
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
		
		I_Address addr = new Address(mutant);
		assertEquals("city A", addr.getCity());
		assertEquals("1234 test row", addr.getStreet_address());
		assertEquals("12345A", addr.getPostal_code());
		assertEquals("US", addr.getCountry_code());
		assertEquals("IL", addr.getCountry_sub_code());
		
		assertEquals(addr, mutant);
		assertEquals(mutant, addr);
	}
	
	public void testSerializable() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(Address.class);
	}
	
	public void testMutantNOTSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(AddressMutant.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNotNull(ex);
		assertEquals("class org.adligo.models.core.client.AddressMutant" +
				" with parents [] is not serlizeable see log. ", ex.getMessage());
	}
}
