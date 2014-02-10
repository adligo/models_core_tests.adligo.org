package org.adligo.models.core.tests.util;

import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.tests.client.util.DateRangeAssertions;
import org.adligo.tests.ATest;

public class DateRangeTests extends ATest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ModelsCoreRegistry.setup();
	}
	
	public void testMutations() throws Exception {
		DateRangeAssertions.assertMutations("", this);
	}
	
	public void testConstructors() throws Exception {
		DateRangeAssertions.assertConstructors("", this);
	}
	
	public void testIsValidWithoutNulls() throws Exception {
		DateRangeAssertions.assertIsValidWithoutNulls("", this);
	}
	
	public void testContainsAndOverlaps() throws Exception {
		DateRangeAssertions.assertContainsAndOverlaps("", this);
	}
}
