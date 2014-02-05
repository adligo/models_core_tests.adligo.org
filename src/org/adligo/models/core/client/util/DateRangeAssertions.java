package org.adligo.models.core.client.util;

import java.util.Date;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ValidationException;
import org.adligo.models.core.client.assertions.IPEExceptionAsserter;
import org.adligo.tests.I_Test;

public class DateRangeAssertions {
	public static void assertMutations(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		
		mutant.setStart(null);
		test.assertIsNull(mutant.getStart());
		test.assertIsNull(mutant.getStartDate());
		mutant.setEnd(null);
		test.assertIsNull(mutant.getEnd());
		test.assertIsNull(mutant.getEndDate());
		

		mutant.setStartDate(null);
		test.assertIsNull(mutant.getStart());
		test.assertIsNull(mutant.getStartDate());
		mutant.setEndDate(null);
		test.assertIsNull(mutant.getEnd());
		test.assertIsNull(mutant.getEndDate());
		
		mutant.setStart(10L);
		test.assertIsEquals(new Long(10L), mutant.getStart());
		test.assertIsEquals(new Long(10L), mutant.getStartDate().getTime());
		mutant.setStartDate(new Date(10L));
		test.assertIsEquals(new Long(10L), mutant.getStart());
		test.assertIsEquals(new Long(10L), mutant.getStartDate().getTime());
		
		InvalidParameterException ipe = null;
		try  {
			mutant.setEnd(9L);
		} catch (Exception x) {
			ipe = IPEExceptionAsserter.isIPE(x, test);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.THE_END_OF_THE_DATE_RANGE_MUST_BE_AFTER_THE_START, 
				ipe.getMessage());
		mutant.setEnd(12L);
		test.assertIsEquals(new Long(12L), mutant.getEnd());
		test.assertIsEquals(new Long(12L), mutant.getEndDate().getTime());
		mutant.setEndDate(new Date(12L));
		test.assertIsEquals(new Long(12L), mutant.getEnd());
		test.assertIsEquals(new Long(12L), mutant.getEndDate().getTime());
		
		ipe = null;
		try  {
			mutant.setStart(13L);
		} catch (Exception x) {
			ipe = IPEExceptionAsserter.isIPE(x, test);
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
		
		test.assertIsNull(mutant.getStart());
		test.assertIsNull(mutant.getStartDate());
		mutant.setStart(1L);
		test.assertIsEquals(new Long(1L) ,mutant.getStart());
		test.assertIsEquals(new Long(1L) ,mutant.getStartDate().getTime());
		caught = null;
		try {
			mutant.isValidWithoutNulls();
		} catch (ValidationException ve) {
			caught = ve;
		}
		test.assertIsNotNull(caught);
		test.assertIsEquals(prefix + ModelsCoreEnglishConstants.A_END_VALUE_OF_THE_DATE_RANGE_IS_REQUIRED, 
				caught.getMessage());
		
		test.assertIsNull(mutant.getEnd());
		test.assertIsNull(mutant.getEndDate());
		mutant.setEnd(2L);
		test.assertIsEquals(new Long(2L) ,mutant.getEnd());
		test.assertIsEquals(new Long(2L) ,mutant.getEndDate().getTime());
		mutant.isValidWithoutNulls();
	}
	
	
	public static void assertContainsAndOverlaps(String prefix, I_Test test) throws Exception {
		DateRangeMutant mutant = new DateRangeMutant();
		mutant.setStart(0L);
		mutant.setEnd(10L);
		test.assertIsTrue(mutant.contains(0L));
		test.assertIsTrue(mutant.contains(2L));
		test.assertIsTrue(mutant.contains(10L));
		test.assertIsFalse(mutant.contains(-1L));
		test.assertIsFalse(mutant.contains(11L));
		
		DateRangeMutant other = new DateRangeMutant();
		test.assertIsFalse(mutant.contains(other));
		other.setStart(-1L);
		other.setEnd(3L);
		test.assertIsFalse(mutant.contains(other));
		other.setEnd(11L);
		other.setStart(9L);
		test.assertIsFalse(mutant.contains(other));
		test.assertIsTrue(mutant.contains(mutant));
		
		other.setEnd(10L);
		other.setStart(9L);
		test.assertIsTrue(mutant.contains(other));
		
		other = new DateRangeMutant();
		test.assertIsFalse(mutant.overlaps(other));
		other.setStart(-1L);
		other.setEnd(3L);
		test.assertIsTrue(mutant.overlaps(other));
		other.setEnd(11L);
		other.setStart(9L);
		test.assertIsTrue(mutant.overlaps(other));
		test.assertIsTrue(mutant.contains(mutant));
		
		other.setEnd(10L);
		other.setStart(9L);
		test.assertIsTrue(mutant.overlaps(other));
		
		Long dur = other.getDuration();
		test.assertIsEquals(new Long(1), dur);
		other = new DateRangeMutant();
		dur = other.getDuration();
		test.assertIsNull(dur);
	}
}
