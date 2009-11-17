package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.UserGroup;
import org.adligo.tests.ATest;

public class UserGroupTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(UserGroup.class);
	}
}
