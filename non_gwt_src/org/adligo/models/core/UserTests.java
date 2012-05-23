package org.adligo.models.core;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.UserAssertions;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.tests.ATest;

public class UserTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
		ModelsMockSetup.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testgetDC() throws Exception {
		UserMutant mutant = new UserMutant();
		
		String dn = mutant.getDn();
		assertEquals("uid=null,dc=unknown", dn);
		
		InvalidParameterException x = null;
		try {
			mutant.setName("");
		} catch (InvalidParameterException y) {
			x = y;
		}
		assertNotNull(x);
		
		x = null;
		try {
			mutant.setDomain("");
		} catch (InvalidParameterException y) {
			x = y;
		}
		assertNotNull(x);
		
		mutant.setName("scott");
		mutant.setDomain("adligo.com");
		String result = mutant.getDn();
		assertEquals("uid=scott,dc=adligo,dc=com", result);
	}
	
	public void testMutators() throws Exception {
		UserMutant mutant = new UserMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setName");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, UserMutant.SET_DOMAIN);
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setPassword");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, UserMutant.SET_EMAIL);
		ParamterExceptionAsserter.assertInvalidParamterExceptionStorageIdentifierMutator(mutant, "setId");
		
		mutant.setDomain("adligo.com");
		DomainName name = new DomainName("adligo.com");
		boolean equal = name.equals(mutant.getDomain());
		assertTrue(equal);
		
		mutant.setPassword("pswd");
		assertEquals("pswd", mutant.getPassword());
		
		mutant.setName("george");
		assertEquals("george", mutant.getName());
		
		StringIdentifier id = new StringIdentifier("sid");
		mutant.setId(id);
		
		assertEquals(id, mutant.getId());
		
		UserAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		UserMutant mutant = new UserMutant();
		mutant.setDomain("domain.com");
		mutant.setName("name");
		mutant.setPassword("password");
		mutant.setEmail("support@adligo.com");
		
		UserMutant user = new UserMutant(mutant);
		assertEquals(new DomainName("domain.com"), user.getDomain());
		assertEquals("name", user.getName());
		assertNull(user.getId());
		assertEquals("password", user.getPassword());
		assertEquals(new EMailAddress("support@adligo.com"), user.getEmail());
		
		StringIdentifier id = new StringIdentifier("sid");
		mutant.setId(id);
		
		user = new UserMutant(mutant);
		assertEquals(new DomainName("domain.com"), user.getDomain());
		assertEquals("name", user.getName());
		assertEquals("password", user.getPassword());
		assertEquals(new EMailAddress("support@adligo.com"), user.getEmail());
		assertEquals(id, user.getId());
		
		UserAssertions.assertConstructors(this, "");
	}

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(UserMutant.class);
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(User.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}
}
