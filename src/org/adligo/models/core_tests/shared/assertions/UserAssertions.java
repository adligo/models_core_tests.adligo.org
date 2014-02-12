package org.adligo.models.core_tests.shared.assertions;

import org.adligo.models.core.shared.DomainName;
import org.adligo.models.core.shared.EMailAddress;
import org.adligo.models.core.shared.I_IdentifiableMutant;
import org.adligo.models.core.shared.I_StorageMutant;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.models.core.shared.User;
import org.adligo.models.core.shared.UserMutant;
import org.adligo.models.core.shared.ids.StorageIdentifierValidator;
import org.adligo.models.core.shared.ids.StringIdentifier;
import org.adligo.tests.I_Test;

public class UserAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.setName(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setName("");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		assertEmails(test, prefix, mutant);
		assertDomains(test, prefix, mutant);
		
		ex = null;
		try {
			mutant.setName("a b");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_CONTAIN_A_SPACE,
				ex.getMessage());
		
		assertEmails(test, prefix, mutant);
		assertDomains(test, prefix, mutant);
		
		ex = null;
		try {
			mutant.setPassword(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_PASSWORD, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setPassword("");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_PASSWORD, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				"UserMutant" + StorageIdentifierValidator.REQUIRES_A_NON_NULL_ID_IN +
				I_IdentifiableMutant.SET_ID,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setId(new StringIdentifier());
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(I_StorageMutant.SET_ID, ex.getMethodName());
		test.assertIsEquals(
				"UserMutant" + StorageIdentifierValidator.REQUIRES_A_ID_WITH_A_VALUE_IN +
				I_IdentifiableMutant.SET_ID,
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
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		ex = null;
		try {
			mutant.setDomain("");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setDomain((DomainName) null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setDomain(new DomainName());
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_DOMAIN, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
	}

	private static void assertEmails(I_Test test, String prefix,
			UserMutant mutant) {
		InvalidParameterException ex;
		ex = null;
		try {
			mutant.setEmail((String) null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail("");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail((EMailAddress) null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setEmail(new EMailAddress());
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.SET_EMAIL, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
	}
	
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		
		
		int hashCode = mutant.hashCode();
		
		InvalidParameterException ex = null;
		try {
			new UserMutant(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setDomain("adligo.org");
		
		
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new UserMutant(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_PASSWORD_CAN_T_BE_EMPTY,
				ex.getMessage());
		
		mutant.setPassword("password");
		
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new UserMutant(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		mutant.setName("userName");
		
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		ex = null;
		try {
			new UserMutant(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setEmail("support@adligo.com");
		mutant.isValid();
		test.assertIsTrue(hashCode != mutant.hashCode());
		hashCode = mutant.hashCode();
		
		User user = new User(mutant);
		test.assertIsEquals("userName", user.getName());
		test.assertIsEquals(new DomainName("adligo.org"), user.getDomain());
		test.assertIsEquals("password", user.getPassword());
		test.assertIsEquals(new EMailAddress("support@adligo.com"), user.getEmail());
		test.assertIsNull(user.getId());
		user.isValid();
		test.assertIsEquals(mutant, user);
		test.assertIsEquals(mutant.hashCode(), user.hashCode());
		
		mutant.setId(new StringIdentifier("sid"));
		user = new User(mutant);
		test.assertIsEquals(new StringIdentifier("sid"), user.getId());
		test.assertIsEquals(mutant, user);
		test.assertIsEquals(mutant.hashCode(), user.hashCode());
		
		test.assertIsEquals("User [name=userName,id=StringIdentifier [key=sid],email=support@adligo.com,domain=adligo.org,storageInfo=null]",
				user.toString());
		test.assertIsEquals("UserMutant [name=userName,id=StringIdentifier [key=sid],email=support@adligo.com,domain=adligo.org,storageInfo=null]",
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
			new UserMutant(null, null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("", null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", "");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		UserMutant user = new UserMutant("unknown.org", "joe");
		
		test.assertIsEquals(new DomainName("unknown.org"), user.getDomain());
		test.assertIsEquals("joe", user.getName());
		
		
		//and email
		
		ex = null;
		try {
			new UserMutant(null, null, null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("", null, null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", null, null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", "", null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", "jon", null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserMutant("unknown.org", "jon", "");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserMutant.USER, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.EMAIL_ADDRESS_E_MAIL_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		user = new UserMutant("unknown.org", "joe", "joe@kingstable.org");
		
		test.assertIsEquals(new DomainName("unknown.org"), user.getDomain());
		test.assertIsEquals("joe", user.getName());
		test.assertIsEquals(new EMailAddress("joe@kingstable.org"), user.getEmail());
		
	}
}
