package org.adligo.models.core.client;

import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.relations.client.UserRelationsMutant;
import org.adligo.tests.client.I_Test;

public class UserRelationsAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		
	}
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		assertNameAndDomainConstructor(test, prefix);
		assertUserOnlyConstructor(test, prefix);
		assertUserRelationsConstructor(test, prefix);
	}
	
	public static void assertUserRelationsConstructor(I_Test test, String prefix) throws Exception {
		UserRelationsMutant mutant = new UserRelationsMutant();
		
		InvalidParameterException ex = null;
		try {
			new UserRelations(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		UserMutant user = new UserMutant();
		user.setName("bo");
		user.setEmail("bo@bo.com");
		user.setDomain("bo.com");
		user.setPassword("123");
		
		mutant = new UserRelationsMutant(user);
		new UserRelations(mutant);
		
		mutant.setOrg_mutant(new OrganizationMutant());
		
		ex = null;
		try {
			new UserRelations(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.THE_NAME_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		OrganizationMutant orgMutant = new OrganizationMutant();
		orgMutant.setName("admins");
		orgMutant.setType(new NamedId("department"));
		
		mutant.setOrg_mutant(orgMutant);
		
	}
	
	public static void assertUserOnlyConstructor(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		mutant.setName("bo");
		
		InvalidParameterException ex = null;
		try {
			new UserRelations(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setEmail("bo@bo.com");
		mutant.setDomain("bo.com");
		mutant.setPassword("123");
		
		User user = new User(mutant);
		UserRelations rel = new UserRelations(user);
		
		test.assertIsEquals(new DomainName("bo.com"), rel.getDomain());
		test.assertIsEquals("bo", rel.getName());
		test.assertIsFalse(rel.isUserInRole(null));
		test.assertIsFalse(rel.isUserInRole(""));
		test.assertIsFalse(rel.isUserInRole("admin"));
	}
	
	public static void assertNameAndDomainConstructor(I_Test test, String prefix) throws Exception {
		InvalidParameterException ex = null;
		try {
			new UserRelations(null, null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserRelations("", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		
		ex = null;
		try {
			new UserRelations("bo.com", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		
		ex = null;
		try {
			new UserRelations("bo.com", "", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelations.USER_RELATIONS, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishValidationConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		UserRelations user = new UserRelations("bo.com", "bo", null);
		
		test.assertIsEquals(new DomainName("bo.com"), user.getDomain());
		test.assertIsEquals("bo", user.getName());
		test.assertIsFalse(user.isUserInRole(null));
		test.assertIsFalse(user.isUserInRole(""));
		test.assertIsFalse(user.isUserInRole("admin"));
		
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
		user = new UserRelations("bo2.com", "bo2", roles);
		
		test.assertIsEquals(new DomainName("bo2.com"), user.getDomain());
		test.assertIsEquals("bo2", user.getName());
		test.assertIsFalse(user.isUserInRole(null));
		test.assertIsFalse(user.isUserInRole(""));
		test.assertIsTrue(user.isUserInRole("admin"));
		
		
	}
	
}
