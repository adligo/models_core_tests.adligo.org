package org.adligo.models.core;

import java.util.List;

import org.adligo.i.util.IsGwtRpcSerializable;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.params.client.Params;
import org.adligo.tests.ATest;
import org.adligo.xml.parsers.template.Template;
import org.adligo.xml.parsers.template.Templates;
import org.adligo.xml.parsers.template.hibernate.HibernateEngineInput;
import org.adligo.xml.parsers.template.hibernate.HibernateTemplateParserEngine;
import org.adligo.xml.parsers.template.jdbc.BaseSqlOperators;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class PersonTests extends ATest {
	Templates templates = new Templates();
		
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new ModelsCoreEnglishConstantsFactory();
		ModelsMockSetup.setUp();
		templates.parseResource("/org/adligo/tests/xml/parsers/template/jdbc/Persons2_0_SQL.xml");
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
		Session session = ModelsMockSetup.createSession();
		
		Template temp = templates.getTemplate("persons");

		Params params = new Params();
		params.addParam("default");
		
		HibernateEngineInput input = new HibernateEngineInput();
		input.setTemplate(temp);
		input.setSession(session);
		input.setAllowedOperators(BaseSqlOperators.OPERATORS);
		input.setParams(params);
		
		SQLQuery query = HibernateTemplateParserEngine.parse(input);
		query.addEntity(PersonMutant.class);
		List<PersonMutant> persons = (List<PersonMutant>) query.list();
		
		assertEquals(3, persons.size());
		
		
		
	}
}
