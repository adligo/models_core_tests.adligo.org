package org.adligo.models.core;

import java.io.IOException;
import java.sql.SQLException;

import org.adligo.i.adi.client.Registry;
import org.adligo.models.core.client.DefaultStorageIdentifierFactory;
import org.adligo.models.core.client.ModelsCoreCheckedInvokerNames;
import org.adligo.tests.xml.parsers.template.jdbc.MockDatabase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
* may NOT contain GWT.creates
* @author scott
*
*/
public class ModelsMockSetup {

	public static void setUp() throws SQLException, IOException {
		Registry.addCheckedInvoker(ModelsCoreCheckedInvokerNames.STORAGE_IDENTIFIER_FACTORY, 
				new DefaultStorageIdentifierFactory());
		MockDatabase.createTestDb();
	}
	
	public static Session createSession() {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory factory = config.buildSessionFactory();  
		return factory.openSession();
	}
}
