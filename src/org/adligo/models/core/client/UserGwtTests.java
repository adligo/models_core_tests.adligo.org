package org.adligo.models.core.client;

import org.adligo.models.core.client.i18n.I_UserValidationConstants;

import com.google.gwt.core.client.GWT;

public class UserGwtTests extends FrModelsCoreGwtBaseTest {



	
	public void testErrorStrings() {
		System.out.println("UserGwtTests.testErrorStrings");
		
		UserMutant user = new UserMutant();
		
		assertEmailEmptyErrors(user,null);
		assertEmailEmptyErrors(user,"");
		
		assertTwoShort(user, "a");
		assertTwoShort(user, "a@a.a");
		
		
		
	}

	private void assertEmailEmptyErrors(UserMutant user, String email) {
		String errorString = null;
		try {
			user.setEmail(email);
		} catch (InvalidParameterException x) {
			errorString = x.getMessage();
		}
		assertNotNull(errorString);
		assertEquals("yea property files has getNoEmptyUserEmailMessage", errorString);
	}
	
	private void assertTwoShort(UserMutant user, String email) {
		String errorString = null;
		try {
			user.setEmail(email);
		} catch (InvalidParameterException x) {
			errorString = x.getMessage();
		}
		assertNotNull(errorString);
		assertEquals("yea property files has getUserEmailTwoShortMessage", errorString);
	}
	
}
