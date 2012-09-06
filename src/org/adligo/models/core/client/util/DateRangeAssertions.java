package org.adligo.models.core.client.util;

import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ValidationException;
import org.adligo.tests.client.I_Test;

public class DateRangeAssertions {
	public static void assertMutations(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		mutant.setStart(null);
		mutant.setEnd(null);
		
		mutant.setStart(10L);
		InvalidParameterException ipe = null;
		try  {
			mutant.setEnd(9L);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.THE_END_OF_THE_DATE_RANGE_MUST_BE_AFTER_THE_START, 
				ipe.getMessage());
		mutant.setEnd(12L);
		
		ipe = null;
		try  {
			mutant.setStart(13L);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.THE_START_OF_THE_DATE_RANGE_MUST_BE_BEFORE_THE_END,
				ipe.getMessage());
		mutant.setStart(1L);
		mutant.isValid();
	}
	
	public static void assertConstructors(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		mutant.setStart(1L);
		mutant.setEnd(1L);
		
		DateRange dr = new DateRange(mutant);
		test.assertIsEquals(1L, dr.getStart());
		test.assertIsEquals(1L, dr.getEnd());
		
		mutant.setEnd(3L);
		
		dr = new DateRange(mutant);
		test.assertIsEquals(1L, dr.getStart());
		test.assertIsEquals(3L, dr.getEnd());
		
		mutant.setStart(2L);
		
		dr = new DateRange(mutant);
		test.assertIsEquals(2L, dr.getStart());
		test.assertIsEquals(3L, dr.getEnd());
	}
	
	public static void assertIsValidWithoutNulls(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		ValidationException caught = null;
		try {
			mutant.isValidWithoutNulls();
		} catch (ValidationException ve) {
			caught = ve;
		}
		test.assertIsNotNull(caught);
		test.assertIsEquals(prefix + ModelsCoreEnglishConstants.A_START_VALUE_OF_THE_DATE_RANGE_IS_REQUIRED, 
				caught.getMessage());
		
		mutant.setStart(1L);
		caught = null;
		try {
			mutant.isValidWithoutNulls();
		} catch (ValidationException ve) {
			caught = ve;
		}
		test.assertIsNotNull(caught);
		test.assertIsEquals(prefix + ModelsCoreEnglishConstants.A_END_VALUE_OF_THE_DATE_RANGE_IS_REQUIRED, 
				caught.getMessage());
		mutant.setEnd(2L);
		mutant.isValidWithoutNulls();
	}
}
