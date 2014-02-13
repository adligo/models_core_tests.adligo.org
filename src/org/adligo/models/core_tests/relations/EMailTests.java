package org.adligo.models.core_tests.relations;

import org.adligo.models.core.relations.shared.EMail;
import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core_tests.shared.assertions.EMailAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io_tests.shared.IsXmlIoSerializable;

public class EMailTests extends ATest {

	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ModelsCoreRegistry.setup();
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
	
	public void testSerialization() throws IllegalStateException {
		IsXmlIoSerializable.isXmlIoSerializable(EMail.class);
	}
}
