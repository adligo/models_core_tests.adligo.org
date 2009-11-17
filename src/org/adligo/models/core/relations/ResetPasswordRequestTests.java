package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordRequest;
import org.adligo.tests.ATest;

public class ResetPasswordRequestTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(ResetPasswordRequest.class);
	}

}
