package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.rpc.transfer.SaveRequest;
import org.adligo.tests.ATest;

public class AuthenticationReqestTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(SaveRequest.class);
	}

}
