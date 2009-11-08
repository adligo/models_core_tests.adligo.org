package org.adligo.models.core;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.StorageIdentifierMutant;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.tests.ATest;

public class UserTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.init();
		new EnglishConstantsFactory();
	}
	

	
	public void testgetDC() throws Exception {
		UserMutant mutant = new UserMutant();
		
		String result = mutant.getDn();
		assertNull(result);
		
		InvalidParameterException x = null;
		try {
			mutant.setName("");
		} catch (InvalidParameterException y) {
			x = y;
		}
		assertNotNull(x);
		result = mutant.getDn();
		assertNull(result);
		
		x = null;
		try {
			mutant.setDomain("");
		} catch (InvalidParameterException y) {
			x = y;
		}
		assertNotNull(x);
		result = mutant.getDn();
		assertNull(result);
		
		mutant.setName("scott");
		mutant.setDomain("adligo.com");
		result = mutant.getDn();
		assertEquals("uid=scott,dc=adligo,dc=com", result);
	}
	
	public void testMutators() throws Exception {
		UserMutant mutant = new UserMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setName");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setDomain");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setPassword");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setEmail");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStorageIdentifierMutator(mutant, "setId");
		
		mutant.setDomain("adligo.com");
		assertEquals("adligo.com", mutant.getDomain());
		
		mutant.setPassword("pswd");
		assertEquals("pswd", mutant.getPassword());
		
		mutant.setName("george");
		assertEquals("george", mutant.getName());
		
		StorageIdentifierMutant id = new StorageIdentifierMutant();
		id.setId((long) 12);
		mutant.setId(id);
		assertEquals(id, mutant.getId());
	}
	
	public void testCopy() throws Exception {
		UserMutant mutant = new UserMutant();
		mutant.setDomain("domain");
		mutant.setName("name");
		mutant.setPassword("password");
		mutant.setEmail("support@adligo.com");
		
		User user = new User(mutant);
		assertEquals("domain", user.getDomain());
		assertEquals("name", user.getName());
		assertNull(user.getId());
		assertEquals("password", user.getPassword());
		assertEquals("support@adligo.com", user.getEmail());
		
		StorageIdentifier id = new StorageIdentifier((long) 1);
		mutant.setId(id);
		
		user = new User(mutant);
		assertEquals("domain", user.getDomain());
		assertEquals("name", user.getName());
		assertEquals("password", user.getPassword());
		assertEquals("support@adligo.com", user.getEmail());
		assertEquals(id, user.getId());
	}

	
}
