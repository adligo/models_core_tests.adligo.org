package org.adligo.models.core;

import java.util.HashSet;
import java.util.Set;

import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.util.GwtCompileUsedAllClassesAsserter;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.DomainNameAssertions;
import org.adligo.models.core.client.EmailAssertions;
import org.adligo.models.core.client.GwtParameterExceptionAsserter;
import org.adligo.models.core.client.ModelsCoreMockGwtSetup;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtDomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtEmailValidationConstants;
import org.adligo.models.core.client.i18n.I_GwtUserValidationConstants;
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
		ignore.add(ClassUtils.getClassName(DomainNameAssertions.class));
		ignore.add(ClassUtils.getClassName(EmailAssertions.class));
		ignore.add(ClassUtils.getClassName(GwtParameterExceptionAsserter.class));
		ignore.add(ClassUtils.getClassName(ModelsCoreMockGwtSetup.class));
		ignore.add(ClassUtils.getClassName(I_GwtDomainNameValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtUserValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtEmailValidationConstants.class));
		//ignore from the models_core_relations project
		ignore.add(ClassUtils.getClassName(I_GwtDomainNameValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtEmailValidationConstants.class));
		ignore.add(ClassUtils.getClassName(I_GwtUserValidationConstants.class));
		String modelsCoreSetupClassName = ClassUtils.getClassName(ModelsCoreConstantsSetup.class);
		ignore.add(modelsCoreSetupClassName);
		for (int i = 0; i <= 3; i++) {
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
		
		GwtCompileUsedAllClassesAsserter.assertEquals(classes, usageHolder.getUsedClasses());
		
	}
}
