package org.adligo.models.core.client;

import org.adligo.models.core.client.english.OrganizationsValidationConstants;
import org.adligo.tests.client.I_Test;

public class OrganizationAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		OrganizationMutant mutant = new OrganizationMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.setName(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_NAME_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setName("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_NAME_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_TYPE_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new NamedId());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_TYPE_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new NamedId(""));
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_TYPE_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setName("someName");
		test.assertIsEquals("someName", mutant.getName());
		
		mutant.setType(new NamedId("someType"));
		test.assertIsEquals(new NamedId("someType"), mutant.getType());
		
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		
		OrganizationMutant mutant = new OrganizationMutant();
		
		InvalidParameterException ex = null;
		try {
			new Organization(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_NAME_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setName("someName");
		ex = null;
		try {
			new Organization(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(Organization.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + OrganizationsValidationConstants.THE_TYPE_FIELD_CAN_NOT_BE_EMPTY,
				ex.getMessage());
		
		mutant.setType(new NamedId("someType"));
		Organization org = new Organization(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new NamedId("someType"), org.getType());
		test.assertIsNull(org.getId());
		
		mutant.setId(new StorageIdentifier((long) 99));
		
		org = new Organization(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new NamedId("someType"), org.getType());
		test.assertIsEquals(new StorageIdentifier((long) 99) , org.getId());
		
		test.assertIsEquals(mutant, org);
		test.assertIsEquals("Organization [name=someName,type=NamedId " +
				"[name=someType,id=null],id=StorageIdentifier [id=99,key=null]]", org.toString());
		test.assertIsEquals("OrganizationMutant [name=someName,type=NamedId " +
				"[name=someType,id=null],id=StorageIdentifier [id=99,key=null]]", mutant.toString());
	}
}
