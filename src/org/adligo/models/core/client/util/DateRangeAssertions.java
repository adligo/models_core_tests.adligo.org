package org.adligo.models.core.client.util;

import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.tests.client.I_Test;

public class DateRangeAssertions {
	public static void assertMutations(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		mutant.setStarted(null);
		mutant.setEnded(null);
		
		mutant.setStarted(10L);
		InvalidParameterException ipe = null;
		try  {
			mutant.setEnded(9L);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.THE_END_OF_THE_DATE_RANGE_MUST_BE_AFTER_THE_START, 
				ipe.getMessage());
		mutant.setEnded(12L);
		
		ipe = null;
		try  {
			mutant.setStarted(13L);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.THE_START_OF_THE_DATE_RANGE_MUST_BE_BEFORE_THE_END,
				ipe.getMessage());
		mutant.setStarted(1L);
		mutant.isValid();
	}
	
	public static void assertConstructors(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		mutant.setStarted(1L);
		mutant.setEnded(1L);
		
		DateRange dr = new DateRange(mutant);
		test.assertIsEquals(1L, dr.getStarted());
		test.assertIsEquals(1L, dr.getEnded());
		
		mutant.setEnded(3L);
		
		dr = new DateRange(mutant);
		test.assertIsEquals(1L, dr.getStarted());
		test.assertIsEquals(3L, dr.getEnded());
		
		mutant.setStarted(2L);
		
		dr = new DateRange(mutant);
		test.assertIsEquals(2L, dr.getStarted());
		test.assertIsEquals(3L, dr.getEnded());
	}
}
