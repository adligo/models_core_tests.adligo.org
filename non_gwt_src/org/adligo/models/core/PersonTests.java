package org.adligo.models.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.adligo.i.db.entities.MockJpaDb;
import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.mappings.MockHibernateModelsCoreMappings;
import org.adligo.models.params.client.Params;
import org.adligo.tests.ATest;
import org.adligo.xml.parsers.template.Template;
import org.adligo.xml.parsers.template.Templates;
import org.adligo.xml.parsers.template.jdbc.BaseSqlOperators;
import org.adligo.xml.parsers.template.jpa.JpaEngineInput;
import org.adligo.xml.parsers.template.jpa.JpaTemplateParserEngine;

public class PersonTests extends ATest {
	Templates templates = new Templates();
		
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MockJpaDb.commonSetup(new MockHibernateModelsCoreMappings());
		ModelsMockSetup.setUp();
		ModelsCoreRegistry.setup();
		
		templates.parseResource("/org/adligo/tests/xml/parsers/template/jdbc/Persons2_0_SQL.xml");
	}
	
	@Override
	protected void tearDown() throws Exception {
		MockJpaDb.commonTearDown();
	}
	
	public void testMutators() throws Exception {
		PersonAssertions.assertMutators(this, "");
	}
	
	public void testConstructors() throws Exception {
		PersonAssertions.assertConstructors(this, "");
	}
	
	public void testGetName() throws Exception {
		PersonMutant mutant = new PersonMutant();
		assertEquals("", mutant.getName());
		mutant.setLast_name("lname");
		assertEquals("lname", mutant.getName());
		
		mutant.setMiddle_name("mname");
		assertEquals("mname lname", mutant.getName());
		
		mutant.setFirst_name("fname");
		assertEquals("fname mname lname", mutant.getName());
		
		mutant = new PersonMutant();
		mutant.setFirst_name("fname");
		assertEquals("fname", mutant.getName());
		
		mutant = new PersonMutant();
		mutant.setMiddle_name("mname");
		assertEquals("mname", mutant.getName());
	}
	
	public void testSerialization() throws Exception {
		IsGwtRpcSerializable.isRpcSerializable(Person.class);
	}
	
	public void testHibernateRead() throws Exception {
		
		Template temp = templates.getTemplate("persons");

		Params params = new Params();
		params.addParam("default");
		
		JpaEngineInput input = new JpaEngineInput();
		input.setTemplate(temp);
		EntityManager em = MockJpaDb.getReadWriteEntityManagerFactory().createEntityManager();
		input.setEntityManager(em);
		
		input.setAllowedOperators(BaseSqlOperators.OPERATORS);
		input.setParams(params);
		
		Query query = JpaTemplateParserEngine.parseNative(input, PersonMutant.class);
		List<PersonMutant> persons = (List<PersonMutant>) query.getResultList();
		
		assertEquals(3, persons.size());
	}
}
