package org.adligo.models.core.client;

import org.adligo.models.core.client.ids.LongIdentifier;
import org.adligo.models.core.client.ids.StringIdentifier;
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
		test.assertIsEquals(OrganizationMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setName("");
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrganizationMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(null);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrganizationMutant.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new LongIdentifier());
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrganizationMutant.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new LongIdentifier(1L));
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNull(ex);
		
		
		mutant.setName("someName");
		test.assertIsEquals("someName", mutant.getName());
		
		mutant.setType(new LongIdentifier(132L));
		test.assertIsEquals(new LongIdentifier(132L), mutant.getType());
		
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
		test.assertIsEquals(OrganizationMutant.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		mutant.setName("someName");
		ex = null;
		try {
			new Organization(mutant);
		} catch (Exception e) {
			ex = GwtParameterExceptionAsserter.isIPE(e);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrganizationMutant.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		mutant.setType(new LongIdentifier(132L));
		Organization org = new Organization(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new LongIdentifier(132L), org.getType());
		test.assertIsNull(org.getId());
		
		mutant.setId(new StringIdentifier("sid"));
		
		org = new Organization(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new LongIdentifier(132L), org.getType());
		test.assertIsEquals(new StringIdentifier("sid") , org.getId());
		
		test.assertIsEquals(mutant, org);
		test.assertIsEquals("Organization [name=someName,type=LongIdentifier [id=132]" +
				",id=StringIdentifier [key=sid],customInfo=null,storageInfo=null]", org.toString());
		test.assertIsEquals("OrganizationMutant [name=someName,type=LongIdentifier [id=132]" +
				",id=StringIdentifier [key=sid],customInfo=null,storageInfo=null]", mutant.toString());
	}
}
