package org.adligo.models.core.client;

import org.adligo.tests.client.I_Test;

public class AddressAssertions {

	public static void assertMutations(String prefix, I_Test test) throws Exception {
		AddressMutant mutant = new AddressMutant();
		
		InvalidParameterException ipe = null;
		try  {
			mutant.setCity(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCity("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		mutant.setCity("city A");
		test.assertIsEquals("city A", mutant.getCity());
		
		ipe = null;
		try  {
			mutant.setPostalCode(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setPostalCode("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		mutant.setPostalCode("12345");
		test.assertIsEquals("12345", mutant.getPostalCode());
		
		ipe = null;
		try  {
			mutant.setStreetAddress(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setStreetAddress("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		mutant.setStreetAddress("1234 long row");
		test.assertIsEquals("1234 long row", mutant.getStreetAddress());
		
		mutant.setCountryCode("US");
		test.assertIsEquals("US", mutant.getCountryCode());
		
		ipe = null;
		try  {
			mutant.setCountryCode(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountryCode("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountryCode("X");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MUST_BE_2_DIGITS, 
				ipe.getMessage());
		
		mutant.setCountrySubCode("IL");
		test.assertIsEquals("IL", mutant.getCountrySubCode());
		
		ipe = null;
		try  {
			mutant.setCountrySubCode(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountrySubCode("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountrySubCode("XXYY1");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MUST_BE_4_DIGITS_OR_LESS, 
				ipe.getMessage());
	}
	
	public static void assertConstructors(String prefix, I_Test test, AddressMutant mutant) throws Exception {
		InvalidParameterException ipe = null;
		try  {
			new AddressMutant(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(AddressMutant.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setStreetAddress("1234 test row");
		
		ipe = null;
		try  {
			new AddressMutant(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(AddressMutant.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		mutant.setCity("city A");
		ipe = null;
		try  {
			new AddressMutant(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(AddressMutant.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setCountryCode("US");
		ipe = null;
		try  {
			new AddressMutant(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(AddressMutant.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setCountrySubCode("IL");
		ipe = null;
		try  {
			new AddressMutant(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(AddressMutant.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setPostalCode("12345A");
	}
}
