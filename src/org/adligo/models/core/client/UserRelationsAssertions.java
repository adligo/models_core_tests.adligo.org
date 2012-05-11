package org.adligo.models.core.client;

import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.relations.client.UserRelationsMutant;
import org.adligo.tests.client.I_Test;

public class UserRelationsAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		UserRelationsMutant mutant = new UserRelationsMutant();
		
		InvalidParameterException ex = null;

		
		Set<String> roles = new HashSet<String>();
		roles.add("");
		try {
			mutant.addRoles(roles);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_ROLE,
				ex.getMessage());
		
		roles = new HashSet<String>();
		roles.add(null);
		try {
			mutant.addRoles(roles);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_ROLE,
				ex.getMessage());
		
		try {
			mutant.addRole(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_ROLE,
				ex.getMessage());
		
		try {
			mutant.addRole("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_ROLE,
				ex.getMessage());
		
		mutant.addRole("admin");
		roles = new HashSet<String>();
		roles.add("bartender");
		mutant.addRoles(roles);
		
		test.assertIsFalse(mutant.isUserInRole("admin"));
		test.assertIsTrue(mutant.isUserInRole("bartender"));
		test.assertIsFalse(mutant.isUserInRole(""));
		test.assertIsFalse(mutant.isUserInRole(null));
		
		//groups
		ex = null;
		Set<String> groups = new HashSet<String>();
		groups.add("");
		try {
			mutant.addGroups(groups);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_GROUP,
				ex.getMessage());
		
		groups = new HashSet<String>();
		groups.add(null);
		try {
			mutant.addGroups(groups);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_GROUP,
				ex.getMessage());
		
		try {
			mutant.addGroup(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_GROUP,
				ex.getMessage());
		
		try {
			mutant.addGroup("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.ADD_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_RELATIONS_EMPTY_GROUP,
				ex.getMessage());
		
		
		mutant.addGroup("admins_group");
		groups = new HashSet<String>();
		groups.add("bartenders_group");
		mutant.addGroups(groups);
		
		Set<String> groupsFromMutant = mutant.getGroups();
		test.assertIsFalse(groupsFromMutant.contains("admins_group"));
		test.assertIsTrue(groupsFromMutant.contains("bartenders_group"));
		test.assertIsFalse(groupsFromMutant.contains(""));
		test.assertIsFalse(groupsFromMutant.contains(null));
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
			new UserRelationsMutant(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
		
		UserMutant user = new UserMutant();
		user.setName("bo");
		user.setEmail("bo@bo.com");
		user.setDomain("bo.com");
		user.setPassword("123");
		
		mutant = new UserRelationsMutant(user);
		UserRelationsMutant ur = new UserRelationsMutant(mutant);
		test.assertIsEquals(new DomainName("bo.com"), ur.getDomain());
		test.assertIsEquals(new EMailAddress("bo@bo.com"), ur.getEmail());
		test.assertIsEquals("bo", ur.getName());
		test.assertIsEquals("123", ur.getPassword());
		
		mutant.addGroup("somegroup");
		ur = new UserRelationsMutant(mutant);
		test.assertIsEquals(new DomainName("bo.com"), ur.getDomain());
		test.assertIsEquals(new EMailAddress("bo@bo.com"), ur.getEmail());
		test.assertIsEquals("bo", ur.getName());
		test.assertIsEquals("123", ur.getPassword());
		
		test.assertIsTrue(ur.getGroups().contains("somegroup"));
		OrganizationMutant orgMutant = new OrganizationMutant();
		orgMutant.setName("admins");
		orgMutant.setType(new NamedId("department"));
		
		mutant.setOrg(orgMutant);
		
		PersonMutant pm = new PersonMutant();
		pm.setLast_name("someLastName");
		mutant.setPerson(pm);
		
		try {
			new UserRelationsMutant(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
		
		
	}
	
	public static void assertUserOnlyConstructor(I_Test test, String prefix) throws Exception {
		UserMutant mutant = new UserMutant();
		mutant.setName("bo");
		
		InvalidParameterException ex = null;
		try {
			new UserRelationsMutant(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_DOMAIN_NAME_CANT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setEmail("bo@bo.com");
		mutant.setDomain("bo.com");
		mutant.setPassword("123");
		
		UserMutant user = new UserMutant(mutant);
		UserRelationsMutant rel = new UserRelationsMutant(user);
		
		test.assertIsEquals(new DomainName("bo.com"), rel.getDomain());
		test.assertIsEquals("bo", rel.getName());
		test.assertIsFalse(rel.isUserInRole(null));
		test.assertIsFalse(rel.isUserInRole(""));
		test.assertIsFalse(rel.isUserInRole("admin"));
	}
	
	public static void assertNameAndDomainConstructor(I_Test test, String prefix) throws Exception {
		InvalidParameterException ex = null;
		try {
			new UserRelationsMutant(null, null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			new UserRelationsMutant("", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.DOMAIN_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		
		ex = null;
		try {
			new UserRelationsMutant("bo.com", null, null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		
		ex = null;
		try {
			new UserRelationsMutant("bo.com", "", null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserRelationsMutant.CONSTRUCTOR, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_NAME_CANT_BE_SET_TO_EMPTY,
				ex.getMessage());
		
		UserRelationsMutant user = new UserRelationsMutant("bo.com", "bo", null);
		
		test.assertIsEquals(new DomainName("bo.com"), user.getDomain());
		test.assertIsEquals("bo", user.getName());
		test.assertIsFalse(user.isUserInRole(null));
		test.assertIsFalse(user.isUserInRole(""));
		test.assertIsFalse(user.isUserInRole("admin"));
		
		Set<String> roles = new HashSet<String>();
		roles.add("admin");
		user = new UserRelationsMutant("bo2.com", "bo2", roles);
		
		test.assertIsEquals(new DomainName("bo2.com"), user.getDomain());
		test.assertIsEquals("bo2", user.getName());
		test.assertIsFalse(user.isUserInRole(null));
		test.assertIsFalse(user.isUserInRole(""));
		test.assertIsTrue(user.isUserInRole("admin"));
		
		
		
	}
	
}
