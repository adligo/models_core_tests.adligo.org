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
			mutant.setPostal_code(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setPostal_code("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		mutant.setPostal_code("12345");
		test.assertIsEquals("12345", mutant.getPostal_code());
		
		ipe = null;
		try  {
			mutant.setStreet_address(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setStreet_address("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		mutant.setStreet_address("1234 long row");
		test.assertIsEquals("1234 long row", mutant.getStreet_address());
		
		mutant.setCountry_code("US");
		test.assertIsEquals("US", mutant.getCountry_code());
		
		ipe = null;
		try  {
			mutant.setCountry_code(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountry_code("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountry_code("X");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MUST_BE_2_DIGITS, 
				ipe.getMessage());
		
		mutant.setCountry_sub_code("IL");
		test.assertIsEquals("IL", mutant.getCountry_sub_code());
		
		ipe = null;
		try  {
			mutant.setCountry_sub_code(null);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountry_sub_code("");
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		ipe = null;
		try  {
			mutant.setCountry_sub_code("XXYY1");
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
			new Address(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(Address.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_STREET_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setStreet_address("1234 test row");
		
		ipe = null;
		try  {
			new Address(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(Address.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_CITY_FIELD_MAY_NOT_BE_EMPTY,
				ipe.getMessage());
		
		mutant.setCity("city A");
		ipe = null;
		try  {
			new Address(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(Address.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setCountry_code("US");
		ipe = null;
		try  {
			new Address(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(Address.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_COUNTRY_SUBDIVISION_CODE_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setCountry_sub_code("IL");
		ipe = null;
		try  {
			new Address(mutant);
		} catch (Exception x) {
			ipe = GwtParameterExceptionAsserter.isIPE(x);
		}
		test.assertIsNotNull(ipe);
		test.assertIsEquals(Address.ADDRESS, ipe.getMethodName());
		test.assertIsEquals(
				prefix + ModelsCoreEnglishConstants.ADDRESS_THE_POSTAL_CODE_FIELD_MAY_NOT_BE_EMPTY, 
				ipe.getMessage());
		
		mutant.setPostal_code("12345A");
	}
}
