package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.ModelsMockSetup;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.UserRelationsAssertions;
import org.adligo.models.core.relations.client.UserRelationsMutant;
import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.tests.ATest;

public class UserRelationsTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
		ModelsMockSetup.setUp();
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(UserRelationsMutant.class);
	}
	
	public void testConstructors() throws Exception {
		UserRelationsAssertions.assertConstructors(this, "");
	}
	
	public void testMutators() throws Exception {
		UserRelationsAssertions.assertMutators(this, "");
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsGwtRpcSerializable.isRpcSerializable(UserRelations.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}
}
