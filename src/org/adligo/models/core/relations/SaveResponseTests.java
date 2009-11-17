package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.relations.client.rpc.transfer.SaveResponse;
import org.adligo.tests.ATest;

public class SaveResponseTests extends ATest {

	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(SaveResponse.class);
	}

}
