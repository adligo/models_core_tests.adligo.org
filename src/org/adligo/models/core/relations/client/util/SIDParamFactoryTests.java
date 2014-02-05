package org.adligo.models.core.relations.client.util;

import org.adligo.models.core.client.ids.LongIdentifier;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.client.ids.VersionedLongIdentifier;
import org.adligo.models.core.client.ids.VersionedLongIdentifierMutant;
import org.adligo.models.core.relations.client.util.SIDParamFactory;
import org.adligo.models.params.client.I_Operators;
import org.adligo.models.params.client.I_TemplateParams;
import org.adligo.models.params.client.ParamsFactory;
import org.adligo.models.params.client.SqlOperators;
import org.adligo.tests.ATest;

public class SIDParamFactoryTests extends ATest {

	
	public void testLongIdentifier() throws Exception {
		I_TemplateParams params =  SIDParamFactory.byId(new LongIdentifier(123L));
		assertTrue(params.getNextParam(ParamsFactory.DEFAULT));
		assertTrue(params.getNextParam(ParamsFactory.WHERE));
		
		I_TemplateParams whereParams = params.getNestedParams();
		
		assertTrue(whereParams.getNextParam(ParamsFactory.ID));
		Object [] vals = whereParams.getValues();
		assertEquals(1, vals.length);
		assertEquals(new Long(123L), vals[0]);
		
		I_Operators ops =  whereParams.getOperators();
		assertEquals(SqlOperators.EQUALS, ops);
	}
	
	public void testStringIdentifier() throws Exception {
		I_TemplateParams params =  SIDParamFactory.byId(new StringIdentifier("123L"));
		assertTrue(params.getNextParam(ParamsFactory.DEFAULT));
		assertTrue(params.getNextParam(ParamsFactory.WHERE));
		
		I_TemplateParams whereParams = params.getNestedParams();
		
		assertTrue(whereParams.getNextParam(ParamsFactory.ID));
		Object [] vals = whereParams.getValues();
		assertEquals(1, vals.length);
		assertEquals("123L", vals[0]);
		
		I_Operators ops =  whereParams.getOperators();
		assertEquals(SqlOperators.EQUALS, ops);
	}
	
	public void testVersionedIdentifier() throws Exception {
		VersionedLongIdentifierMutant vli = new VersionedLongIdentifierMutant();
		
		vli.setId(123L);
		vli.setVersion(987);
		
		I_TemplateParams params =  SIDParamFactory.byId(new VersionedLongIdentifier(vli));
		assertTrue(params.getNextParam(ParamsFactory.DEFAULT));
		assertTrue(params.getNextParam(ParamsFactory.WHERE));
		
		I_TemplateParams whereParams = params.getNestedParams();
		
		assertTrue(whereParams.getNextParam(ParamsFactory.ID));
		Object [] vals = whereParams.getValues();
		assertEquals(1, vals.length);
		assertEquals(123L, vals[0]);
		
		I_Operators ops =  whereParams.getOperators();
		assertEquals(SqlOperators.EQUALS, ops);
		
		assertTrue(whereParams.getNextParam(SIDParamFactory.VERSION));
		vals = whereParams.getValues();
		assertEquals(1, vals.length);
		assertEquals(987, vals[0]);
		
		ops =  whereParams.getOperators();
		assertEquals(SqlOperators.EQUALS, ops);
	}
}
