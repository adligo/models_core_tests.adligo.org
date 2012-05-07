package org.adligo.models.core;

import java.io.IOException;
import java.sql.SQLException;

import org.adligo.tests.xml.parsers.template.jdbc.MockDatabase;

/**
* may NOT contain GWT.creates
* @author scott
*
*/
public class ModelsMockSetup {

	public static void setUp() throws SQLException, IOException {
		MockDatabase.createTestDb();
	}

}
