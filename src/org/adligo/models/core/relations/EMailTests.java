package org.adligo.models.core.relations;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.EMailAssertions;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.relations.client.EMail;
import org.adligo.tests.ATest;

public class EMailTests extends ATest {

	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
	}
	
	public void testSetterInvalidParameterSetters() throws Exception {
		EMailAssertions.assertSetterInvalidParameterExceptions("", this);
	}
	
	public void testConstructorInvalidParameterSetters() throws Exception {
		EMailAssertions.assertConstructorInvalidParameterExceptions("", this);
	}
	
	public void testSetters() throws Exception {
		EMailAssertions.assertMutators(this);
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(EMail.class);
	}
}
