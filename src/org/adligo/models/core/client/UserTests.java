package org.adligo.models.core.client;

import org.adligo.tests.ATest;

public class UserTests extends ATest {

	
	public void testUserDomainToDC() {
		String result = User.toDn("adligo.com");
		assertEquals("dc=adligo,dc=com", result);
		
		result = User.toDn(null);
		assertNull(result);
		
		result = User.toDn("");
		assertEquals("dc=", result);
		
		result = User.toDn("foo");
		assertEquals("dc=foo",result);
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
	
	public void copyExceptions() throws Exception {
		UserMutant mutant = new UserMutant();
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setName");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setDomain");
		ParamterExceptionAsserter.assertInvalidParamterExceptionStringMutator(mutant, "setPassword");
		ParamterExceptionAsserter.assertInvalidParamterExceptionIntegerMutator(mutant, "setId");
	}
	
	public void copyTest() throws Exception {
		UserMutant mutant = new UserMutant();
		mutant.setDomain("domain");
		mutant.setName("name");
		mutant.setId(1);
		mutant.setPassword("password");
		
		User user = new User(mutant);
		assertEquals("domain", user.getDomain());
		assertEquals("name", user.getName());
		assertEquals(new Integer(1), user.getId());
		assertEquals("password", user.getPassword());
	}
}
