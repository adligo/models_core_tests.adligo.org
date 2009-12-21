package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class UserAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.setName(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setName("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		assertEmails(test, prefix, mutant);
		assertDomains(test, prefix, mutant);
		
		ex = null;
		try {
			mutant.setName("a b");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_CONTAIN_A_SPACE,
				ex.getMessage());
		
		assertEmails(test, prefix, mutant);
		assertDomains(test, prefix, mutant);
		
		ex = null;
		try {
			mutant.setPassword(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_PASSWORD, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setPassword("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_PASSWORD, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				User.USER_ID_NULL,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(new StorageIdentifier());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				User.USER_ID_EMPTY,
				ex.getMessage());
		
		mutant.setName("userName");
		test.assertIsEquals("userName", mutant.getName());
		mutant.setPassword("passwd");
		test.assertIsEquals("passwd", mutant.getPassword());
		
		mutant.setDomain("adligo.com");
		test.assertIsEquals(new DomainName("adligo.com"), mutant.getDomain());
		mutant.setDomain(new DomainName("google.com"));
		test.assertIsEquals(new DomainName("google.com"), mutant.getDomain());
		
		mutant.setEmail("support@adligo.com");
		test.assertIsEquals(new EMailAddress("support@adligo.com"), mutant.getEmail());
		mutant.setEmail(new EMailAddress("support@google.com"));
		test.assertIsEquals(new EMailAddress("support@google.com"), mutant.getEmail());
	}

	private static void assertDomains(I_Test test, String prefix,
			UserMutant mutant) {
		InvalidParameterException ex;
		ex = null;
		try {
			mutant.setDomain((String) null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		ex = null;
		try {
			mutant.setDomain("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setDomain((DomainName) null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setDomain(new DomainName());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
	}

	private static void assertEmails(I_Test test, String prefix,
			UserMutant mutant) {
		InvalidParameterException ex;
		ex = null;
		try {
			mutant.setEmail((String) null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail((EMailAddress) null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail(new EMailAddress());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
	}
	
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		test.assertIsFalse(mutant.isValid());
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new User(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setDomain("adligo.org");
		test.assertIsFalse(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new User(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		mutant.setPassword("password");
		test.assertIsFalse(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new User(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		mutant.setName("userName");
		test.assertIsFalse(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new User(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setEmail("support@adligo.com");
		test.assertIsTrue(mutant.isValid());
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		User user = new User(mutant);
		test.assertIsEquals("userName", user.getName());
		test.assertIsEquals(new DomainName("adligo.org"), user.getDomain());
		test.assertIsEquals("password", user.getPassword());
		test.assertIsEquals(new EMailAddress("support@adligo.com"), user.getEmail());
		test.assertIsNull(user.getId());
		test.assertIsTrue(user.isValid());
		test.assertIsEquals(mutant, user);
		test.assertIsEquals(mutant.hashCode(), user.hashCode());
		
		mutant.setId(new StorageIdentifier((long) 201));
		user = new User(mutant);
		test.assertIsEquals(new StorageIdentifier((long) 201), user.getId());
		test.assertIsTrue(user.isValid());
		test.assertIsEquals(mutant, user);
		test.assertIsEquals(mutant.hashCode(), user.hashCode());
		
		test.assertIsEquals("User [name=userName,id=StorageIdentifier [id=201,key=null],email=support@adligo.com,domain=adligo.org]",
				user.toString());
		test.assertIsEquals("UserMutant [name=userName,id=StorageIdentifier [id=201,key=null],email=support@adligo.com,domain=adligo.org]",
				mutant.toString());
		
		 assertNameEmailDomainConstructors(test, prefix);
	}
	
	/**
	 * tests 
	 * User(String p_domain, String p_name)
	 * User(String p_domain, String p_name, String p_email)
	 * 
	 * @param test
	 * @param prefix
	 * @throws Exception
	 */
	public static void assertNameEmailDomainConstructors(I_Test test, String prefix) throws Exception {
		
		InvalidParameterException ex = null;
		try {
			new User(null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", "");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		User user = new User("unknown.org", "joe");
		
		test.assertIsEquals(new DomainName("unknown.org"), user.getDomain());
		test.assertIsEquals("joe", user.getName());
		
		
		//and email
		
		ex = null;
		try {
			new User(null, null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", "", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", "jon", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new User("unknown.org", "jon", "");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(User.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		user = new User("unknown.org", "joe", "joe@kingstable.org");
		
		test.assertIsEquals(new DomainName("unknown.org"), user.getDomain());
		test.assertIsEquals("joe", user.getName());
		test.assertIsEquals(new EMailAddress("joe@kingstable.org"), user.getEmail());
		
	}
}
