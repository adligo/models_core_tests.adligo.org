package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.rpc.transfer.ResetPasswordResponse;
import org.adligo.tests.ATest;

public class ResetPasswordResponseTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(ResetPasswordResponse.class);
	}

}
