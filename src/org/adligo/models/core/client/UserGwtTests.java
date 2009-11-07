package org.adligo.models.core.client;

import org.adligo.models.core.client.ConstantsFactory;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;
import org.adligo.tests.client.AGwtTest;

import com.google.gwt.core.client.GWT;

public class UserGwtTests extends AGwtTest {

	@Override
	public String getModuleName() {
		return "org.adligo.models.core.ModelsCoreTests";
	}

	@Override
	protected void gwtSetUp() throws Exception {
		System.out.println("UserGwtTests.gwtSetUp ");
		// TODO Auto-generated method stub
		super.gwtSetUp();
		
		I_GwtUserValidationConstants type = (I_GwtUserValidationConstants) 
			GWT.create(I_GwtUserValidationConstants.class);
		System.out.println("type is " + type);
		ConstantsFactory.INSTANCE.put(I_UserValidationConstants.class, type);
		ModelsCoreRegistry.init();
	}

	
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
