package org.adligo.models.core_tests.shared.assertions;

import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreEnglishConstants;
import org.adligo.models.core.shared.Org;
import org.adligo.models.core.shared.OrgMutant;
import org.adligo.models.core.shared.SimpleStorageInfo;
import org.adligo.models.core_tests.shared.MockId;
import org.adligo.tests.shared.I_Test;

public class OrganizationAssertions {

	public static void assertMutators(I_Test test, String prefix) throws Exception {
		OrgMutant mutant = new OrgMutant();
		
		InvalidParameterException ex = null;
		try {
			mutant.setName(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setName("");
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.SET_NAME, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(null);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new MockId(null));
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.SET_TYPE, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		ex = null;
		try {
			mutant.setType(new MockId("hey"));
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNull(ex);
		
		
		mutant.setName("someName");
		test.assertIsEquals("someName", mutant.getName());
		
		mutant.setType(new MockId("hey"));
		test.assertIsEquals(new MockId("hey"), mutant.getType());
		
	}
	
	public static void assertConstructors(I_Test test, String prefix) throws Exception {
		
		OrgMutant mutant = new OrgMutant();
		
		InvalidParameterException ex = null;
		try {
			new Org(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_NAME,
				ex.getMessage());
		
		mutant.setName("someName");
		ex = null;
		try {
			new Org(mutant);
		} catch (Exception e) {
			ex = IPEExceptionAsserter.isIPE(e, test);
		}
		test.assertIsNotNull(ex);
		test.assertIsEquals(OrgMutant.ORGANIZAITION, ex.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ORG_EMPTY_TYPE,
				ex.getMessage());
		
		mutant.setType(new MockId("hey"));
		Org org = new Org(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new MockId("hey"), org.getType());
		test.assertIsNull(org.getId());
		
		mutant.setId(new MockId("sid"));
		mutant.setStorageInfo(new SimpleStorageInfo("bar"));
		
		org = new Org(mutant);
		test.assertIsEquals("someName", org.getName());
		test.assertIsEquals(new MockId("hey"), org.getType());
		test.assertIsEquals(new MockId("sid") , org.getId());
		
		test.assertIsEquals(mutant, org);
		test.assertIsEquals("Organization [name=someName,type=MockId [id=hey]" +
				",id=MockId [id=sid],customInfo=null,storageInfo=SimpleStorageInfo[bar]]", org.toString());
		test.assertIsEquals("OrganizationMutant [name=someName,type=MockId [id=hey]" +
				",id=MockId [id=sid],customInfo=null,storageInfo=SimpleStorageInfo[bar]]", mutant.toString());
	}
}
