package org.adligo.models.core_tests.relations;

import org.adligo.models.core.relations.shared.UserGroup;
import org.adligo.models.core.relations.shared.UserGroupMutant;
import org.adligo.models.core.shared.ModelsCoreRegistry;
import org.adligo.models.core_tests.shared.assertions.UserGroupAssertions;
import org.adligo.tests.ATest;
import org.adligo.xml_io_tests.shared.IsXmlIoSerializable;

public class UserGroupTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testSerialization() throws Exception {
		IsXmlIoSerializable.isXmlIoSerializable(UserGroup.class);
	}
	
	
	public void testConstructors() throws Exception {
		UserGroupAssertions.assertConstructors(this, "");
	}
	
	public void testMutators() throws Exception {
		UserGroupAssertions.assertMutators(this, "");
	}
	
	public void testMutantSeralizable() {
		Exception ex = null;
		try {
			IsXmlIoSerializable.isXmlIoSerializable(UserGroupMutant.class);
		} catch (IllegalStateException x) {
			ex = x;
		}
		assertNull(ex);
	}
}
