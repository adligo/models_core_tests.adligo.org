package org.adligo.models.core;

import java.util.HashSet;
import java.util.Set;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.GwtCompileUsedAllClassesAsserter;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.AddressAssertions;
import org.adligo.models.core.client.DomainNameAssertions;
import org.adligo.models.core.client.EMailAssertions;
import org.adligo.models.core.client.EmailAddressAssertions;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.OrganizationAssertions;
import org.adligo.models.core.client.PersonAssertions;
import org.adligo.models.core.client.PhoneNumberAssertions;
import org.adligo.models.core.client.UserAssertions;
import org.adligo.models.core.client.UserGroupAssertions;
import org.adligo.models.core.client.UserRelationsAssertions;
import org.adligo.models.core.client.i18n.I_GwtModelsCoreConstants;
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
		ignore.add(ClassUtils.getClassName(EmailAddressAssertions.class));
		ignore.add(ClassUtils.getClassName(EMailAssertions.class));
		ignore.add(ClassUtils.getClassName(PersonAssertions.class));
		ignore.add(ClassUtils.getClassName(OrganizationAssertions.class));
		ignore.add(ClassUtils.getClassName(PhoneNumberAssertions.class));
		ignore.add(ClassUtils.getClassName(UserAssertions.class));
		ignore.add(ClassUtils.getClassName(GwtParameterExceptionAsserter.class));
		ignore.add(ClassUtils.getClassName(ModelsCoreMockGwtSetup.class));
		ignore.add(ClassUtils.getClassName(ModelsMockSetup.class));
		ignore.add(ClassUtils.getClassName(UserRelationsAssertions.class));
		ignore.add(ClassUtils.getClassName(UserGroupAssertions.class));
		//ignore from the models_core_relations project
		ignore.add(ClassUtils.getClassName(I_GwtModelsCoreConstants.class));
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
		
		new ModelsCoreEnglishConstantsFactory();
		MockModelsEntryPoint entryPoint = new MockModelsEntryPoint(usageHolder);
		entryPoint.onModuleLoad();
		
		assertEquals(70, usageHolder.getUsedClasses().size());
		
		assertCollectionEquals(classes, usageHolder.getUsedClasses());
		
	}
}
