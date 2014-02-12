package org.adligo.models.core_tests.shared.assertions;

import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.relations.shared.UserGroup;
import org.adligo.models.core.relations.shared.UserGroupMutant;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.models.core.shared.OrganizationMutant;
import org.adligo.models.core.shared.ids.LongIdentifier;
import org.adligo.tests.I_Test;

public class UserGroupAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		UserGroupMutant mutant = new UserGroupMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.addRole(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
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
			ex = IPEExceptionAsserter.isIPE(e, test);
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
			ex = IPEExceptionAsserter.isIPE(e, test);
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
			ex = IPEExceptionAsserter.isIPE(e, test);
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
			ex = IPEExceptionAsserter.isIPE(e, test);
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
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(UserGroupMutant.USER_GROUP, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		OrganizationMutant org = new OrganizationMutant();
		org.setName("funPeople");
		
		org.setType(new LongIdentifier(321L));
		mutant.setOrg(org);		
		new UserGroup(mutant);

		
		mutant.addRole("admin");
		new UserGroup(mutant);
	}
}
