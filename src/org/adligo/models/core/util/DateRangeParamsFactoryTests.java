package org.adligo.models.core.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.adligo.i.util.client.DateTime;
import org.adligo.models.core.client.util.DateRangeMutant;
import org.adligo.models.core.relations.client.util.DateRangeParamsFactory;
import org.adligo.models.params.client.I_Operators;
import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.models.params.client.Params;
import org.adligo.models.params.client.SqlOperators;
import org.adligo.tests.ATest;

public class DateRangeParamsFactoryTests extends ATest {

	public void testDateTimeMethods() throws Exception {
		DateRangeMutant drm = new DateRangeMutant();
		drm.setStart(1L);
		drm.setEnd(DateTime.ONE_DAY);
		
		Params params = new Params();
		DateRangeParamsFactory.addDateTimeRangeParams(params, drm, "muddie");
		assertTrue(params.getNextParam("muddie_ranges"));
		I_TemplateParams rangeParams = assertDateTimeRangeParams(params, 1L, DateTime.ONE_DAY);
		assertFalse(rangeParams.getNextParam("muddie_range"));
		assertFalse(params.getNextParam("muddie_ranges"));
		
		List<DateRangeMutant> drms = new ArrayList<DateRangeMutant>();
		drms.add(drm);
		
		DateRangeMutant drm2 = new DateRangeMutant();
		drm2.setStart(new DateTime("12/01/1928 12:00 AM 001").getTime());
		drm2.setEnd(new DateTime("09/11/2007 11:29 PM 003").getTime());
		drms.add(drm2);
		
		params = new Params();
		DateRangeParamsFactory.addDateTimeRangeParams(params, drms, "muddie");
		assertTrue(params.getNextParam("muddie_ranges"));
		rangeParams = assertDateTimeRangeParams(params, 1L, DateTime.ONE_DAY);
		rangeParams = assertDateTimeRangeParams(params, new DateTime("12/01/1928 12:00 AM 001").getTime(),
				new DateTime("09/11/2007 11:29 PM 003").getTime());
		assertFalse(rangeParams.getNextParam("muddie_range"));
		assertFalse(params.getNextParam("muddie_ranges"));
	}

	
	protected I_TemplateParams assertDateTimeRangeParams(Params params, long start, long end) {
		I_TemplateParams rangeParams = params.getNestedParams();
		assertNotNull(rangeParams);
		assertTrue(rangeParams.getNextParam("muddie_range"));
		
		I_TemplateParams tps = rangeParams.getNestedParams();
		assertNotNull(tps);
		assertTrue(tps.getNextParam("muddie"));
		I_Operators ops = tps.getOperators();
		assertEquals(SqlOperators.GREATER_THAN_EQUALS, ops);
		Object [] values = tps.getValues();
		assertEquals(1, values.length);
		assertEquals(start, ((Date) values[0]).getTime());
		
		assertTrue(tps.getNextParam("muddie"));
		ops = tps.getOperators();
		assertEquals(SqlOperators.LESS_THAN_EQUALS, ops);
		values = tps.getValues();
		assertEquals(1, values.length);
		assertEquals(end, ((Date) values[0]).getTime());
		assertFalse(tps.getNextParam("muddie"));
		
		return rangeParams;
	}
	

	public void testDateMethods() throws Exception {
		DateRangeMutant drm = new DateRangeMutant();
		drm.setStart(1L);
		drm.setEnd(DateTime.ONE_DAY);
		
		Params params = new Params();
		DateRangeParamsFactory.addDateRangeParams(params, drm, "muddie");
		assertTrue(params.getNextParam("muddie_ranges"));
		I_TemplateParams rangeParams = assertDateRangeParams(params, 
				new DateTime("12/30/1969 11:59 PM 999").getTime(), 
				new DateTime("01/02/1970 12:00 AM 000").getTime());
		assertFalse(rangeParams.getNextParam("muddie_range"));
		assertFalse(params.getNextParam("muddie_ranges"));
		
		List<DateRangeMutant> drms = new ArrayList<DateRangeMutant>();
		drms.add(drm);
		
		DateRangeMutant drm2 = new DateRangeMutant();
		drm2.setStart(new DateTime("12/01/1928 12:00 AM 001").getTime());
		drm2.setEnd(new DateTime("09/11/2007 11:29 PM 003").getTime());
		drms.add(drm2);
		
		params = new Params();
		DateRangeParamsFactory.addDateRangeParams(params, drms, "muddie");
		assertTrue(params.getNextParam("muddie_ranges"));
		rangeParams = assertDateRangeParams(params, 
				new DateTime("12/30/1969 11:59 PM 999").getTime(), 
				new DateTime("01/02/1970 12:00 AM 000").getTime());
		rangeParams = assertDateRangeParams(params, 
				new DateTime("11/30/1928 11:59 PM 999").getTime(), 
				new DateTime("09/12/2007 12:00 AM 000").getTime());
		assertFalse(rangeParams.getNextParam("muddie_range"));
		assertFalse(params.getNextParam("muddie_ranges"));
	}

	
	protected I_TemplateParams assertDateRangeParams(Params params, long start, long end) {
		I_TemplateParams rangeParams = params.getNestedParams();
		assertNotNull(rangeParams);
		assertTrue(rangeParams.getNextParam("muddie_range"));
		
		I_TemplateParams tps = rangeParams.getNestedParams();
		assertNotNull(tps);
		assertTrue(tps.getNextParam("muddie"));
		I_Operators ops = tps.getOperators();
		assertEquals(SqlOperators.GREATER_THAN, ops);
		Object [] values = tps.getValues();
		assertEquals(1, values.length);
		SimpleDateFormat sdf = new SimpleDateFormat(DateTime.DEFAULT_DATE_TIME_FORMAT);
		assertEquals(new DateTime(start).toString(), sdf.format((Date) values[0]));
		
		assertTrue(tps.getNextParam("muddie"));
		ops = tps.getOperators();
		assertEquals(SqlOperators.LESS_THAN, ops);
		values = tps.getValues();
		assertEquals(1, values.length);
		assertEquals(new DateTime(end).toString(),new DateTime( ((Date) values[0]).getTime()).toString());
		assertFalse(tps.getNextParam("muddie"));
		
		return rangeParams;
	}
}
