package org.adligo.models.core.util;

import org.adligo.models.core.ModelsMockSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.util.DateRangeAssertions;
import org.adligo.tests.ATest;

public class DateRangeTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
		ModelsMockSetup.setUp();
	}
	
	public void testMutations() throws Exception {
		DateRangeAssertions.assertMutations("", this);
	}
	
	public void testConstructors() throws Exception {
		DateRangeAssertions.assertConstructors("", this);
	}
}
