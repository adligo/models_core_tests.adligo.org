package org.adligo.models.core.client;

import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.UserGroupMutant;
import org.adligo.tests.client.I_Test;

public class UserGroupAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		UserGroupMutant mutant = new UserGroupMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.addRole(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_GROUP_EMPTY_ROLE_TO_USER_GROUP,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.addRole("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.ADD_ROLE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_GROUP_EMPTY_ROLE_TO_USER_GROUP,
				ex.getMessage());
		mutant.addRole("viewer");
		test.assertIsTrue(mutant.getRoles().contains("viewer"));
		
		Set<String> roles = new HashSet<String>();
		roles.add(null);
		
		ex = null;
		try {
			mutant.setRoles(roles);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.ADD_ALL_ROLES, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_GROUP_EMPTY_ROLE_TO_USER_GROUP,
				ex.getMessage());
		
		roles = new HashSet<String>();
		roles.add("");
		
		ex = null;
		try {
			mutant.setRoles(roles);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.ADD_ALL_ROLES, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.USER_GROUP_EMPTY_ROLE_TO_USER_GROUP,
				ex.getMessage());
		
		roles = new HashSet<String>();
		roles.add("savers");
		mutant.setRoles(roles);
		
		test.assertIsTrue(mutant.getRoles().contains("savers"));
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		UserGroupMutant mutant = new UserGroupMutant();
		
		InvalidParameterException ex = null;
		try {
			new UserGroup(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.USER_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		
		ex = null;
		try {
			new UserGroup(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.USER_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		new UserGroup(mutant);
		Organization org = new Organization();
		mutant.setOrg(org);
		
		mutant.addRole("admin");
		new UserGroup(mutant);
	}
}
