package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.rpc.transfer.AuthenticationResponse;
import org.adligo.models.core.relations.client.rpc.transfer.SaveRequest;
import org.adligo.tests.ATest;

public class AuthenticationResponseTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(AuthenticationResponse.class);
	}

}
