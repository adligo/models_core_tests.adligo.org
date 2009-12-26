package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.UserGroupAssertions;
import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.models.core.relations.client.UserGroupMutant;
import org.adligo.models.core.relations.client.UserRelationsMutant;
import org.adligo.tests.ATest;

public class UserGroupTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(UserGroup.class);
	}
	
	
	public void testConstructors() throws Exception {
		UserGroupAssertions.assertConstructors(this, "");
	}
	
	public void testMutators() throws Exception {
		UserGroupAssertions.assertMutators(this, "");
	}
	
	public void testMutantNOTSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(UserGroupMutant.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNotNull(ex);
		assertEquals("class org.adligo.models.core.relations.client.UserGroupMutant" +
				" with parents [] is not serlizeable see log. ", ex.getMessage());
	}
}
