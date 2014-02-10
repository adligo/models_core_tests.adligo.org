package org.adligo.models.core.tests.relations;

import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.relations.client.UserRelations;
import org.adligo.models.core.tests.client.assertions.UserRelationsAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io.tests.client.IsXmlIoSerializable;

public class UserRelationsTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
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
			IsXmlIoSerializable.isXmlIoSerializable(UserRelations.class);
		} catch (Exception x) {
			ex = x;
		}
		assertNull(ex);
	}
}
