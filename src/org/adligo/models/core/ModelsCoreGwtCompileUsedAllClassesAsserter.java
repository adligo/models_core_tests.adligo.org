package org.adligo.models.core;

import java.util.HashSet;
import java.util.Set;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.GwtCompileUsedAllClassesAsserter;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.DomainNameAssertions;
import org.adligo.models.core.client.EmailAssertions;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.OrganizationAssertions;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.models.core.client.UserAssertions;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtAddressValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtDomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtEmailValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtOrganizationsValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtPersonValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtPhoneNumberValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtUserValidationConstants;
import org.adligo.models.core.client.i18n.I_OrganizationValidationConstants;
import org.adligo.models.core.client.i18n.ModelsCoreConstantsSetup;
import org.adligo.models.core.gwt.client.MockModelsEntryPoint;
import org.adligo.tests.ATest;

public class ModelsCoreGwtCompileUsedAllClassesAsserter  extends ATest {
	private static final Log log = LogFactory.getLog(ModelsCoreGwtCompileUsedAllClassesAsserter.class);
	private GwtCompileUsedAllClassesAsserter usageHolder =  new GwtCompileUsedAllClassesAsserter();
	
	public void testUsedAllI_UtilClasses() throws Exception {
		//ignore classes in this (i_util_tests) project 
		Set<String> ignore = new HashSet<String>();
		//ignore from this project 
		ignore.add(ClassUtils.getClassName(AddressAssertions.class));
		ignore.add(ClassUtils.getClassName(DomainNameAssertions.class));
		ignore.add(ClassUtils.getClassName(EmailAssertions.class));
		ignore.add(ClassUtils.getClassName(PersonAssertions.class));
		ignore.add(ClassUtils.getClassName(OrganizationAssertions.class));
		ignore.add(ClassUtils.getClassName(PhoneNumberAssertions.class));
		ignore.add(ClassUtils.getClassName(UserAssertions.class));
		ignore.add(ClassUtils.getClassName(GwtParameterExceptionAsserter.class));
		ignore.add(ClassUtils.getClassName(ModelsCoreMockGwtSetup.class));
		//ignore from the models_core_relations project
		ignore.add(ClassUtils.getClassName(I_GwtAddressValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtDomainNameValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtEmailValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtUserValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtPhoneNumberValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtPersonValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtOrganizationsValidationConstants.class));
		String modelsCoreSetupClassName = ClassUtils.getClassName(ModelsCoreConstantsSetup.class);
		ignore.add(modelsCoreSetupClassName);
		for (int i = 0; i <= 7; i++) {
			ignore.add(modelsCoreSetupClassName + "$" + i);
		}
		if (log.isDebugEnabled()) {
			log.debug("ignoring classes " + ignore);
		}
		
		Set<Class<?>> classes = 
			GwtCompileUsedAllClassesAsserter.getClasses("org.adligo.models.core.client", ignore);
		classes.addAll(
				GwtCompileUsedAllClassesAsserter.getClasses("org.adligo.models.core.client.i18n", 
						ignore));
		classes.addAll(
				GwtCompileUsedAllClassesAsserter.getClasses("org.adligo.models.core.client.english", 
						ignore));
		
		ModelsCoreRegistry.init();
		new EnglishConstantsFactory();
		MockModelsEntryPoint entryPoint = new MockModelsEntryPoint(usageHolder);
		entryPoint.onModuleLoad();
		
		assertEquals(43, usageHolder.getUsedClasses().size());
		
		assertCollectionEquals(classes, usageHolder.getUsedClasses());
		
	}
}
