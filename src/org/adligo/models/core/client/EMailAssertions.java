package org.adligo.models.core.client;

import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.relations.client.EMail;
import org.adligo.models.core.relations.client.EMailMutant;
import org.adligo.tests.client.I_Test;
import org.apache.tools.ant.taskdefs.email.EmailAddress;

public class EMailAssertions {

	public static void assertConstructorInvalidParameterExceptions(String pre, I_Test test) throws Exception {
		EMailMutant mutant = new EMailMutant();
		
		InvalidParameterException x = null;
		
		try {
			new EMail(mutant);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.E_MAIL, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_REQUIRES_A_FROM_ADDRESS, x.getMessage());
		
		mutant.setFrom(new EMailAddress("support@adligo.com"));
		
		x = null;
		try {
			new EMail(mutant);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.E_MAIL, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_REQUIRES_A_DESTINATION_ADDRESS, x.getMessage());
		
	}
	
	public static void assertSetterInvalidParameterExceptions(String pre, I_Test test) throws Exception {
		EMailMutant mutant = new EMailMutant();
		
		InvalidParameterException x = null;
		
		try {
			mutant.setFrom(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.SET_FROM, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_REQUIRES_A_FROM_ADDRESS, x.getMessage());
		
		x = null;
		try {
			mutant.setFrom(new EMailAddress());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.SET_FROM, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_REQUIRES_A_VALID_FROM_ADDRESS, x.getMessage());
		
		x = null;
		try {
			mutant.addAttachment(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_ATTACHMENT, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ATTACHEMNT_MAY_NOT_BE_NULL, x.getMessage());
		
		x = null;
		try {
			mutant.addAttachment(new StringIdentifier());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_ATTACHMENT, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ATTACHMENT_MAY_NOT_BE_EMPTY, x.getMessage());
		
		Set<I_SerializableStorageIdentifier> set = new HashSet<I_SerializableStorageIdentifier>();
		set.add(null);
		
		try {
			mutant.addAllAttachments(set);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_ATTACHMENT, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ATTACHEMNT_MAY_NOT_BE_NULL, x.getMessage());
		
		set.clear();
		set.add(new StringIdentifier());
		
		try {
			mutant.addAllAttachments(set);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_ATTACHMENT, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ATTACHMENT_MAY_NOT_BE_EMPTY, x.getMessage());
		
		
		x = null;
		try {
			mutant.addTo(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_TO, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		x = null;
		try {
			mutant.addTo(new EMailAddress());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_TO, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		Set<EMailAddress> emailSet = new HashSet<EMailAddress>();
		emailSet.add(null);
		x = null;
		try {
			mutant.addAllTo(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_TO, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		emailSet.clear();
		emailSet.add(new EMailAddress());
		x = null;
		try {
			mutant.addAllTo(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_TO, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		//CC
		x = null;
		try {
			mutant.addCc(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_CC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		x = null;
		try {
			mutant.addCc(new EMailAddress());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_CC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		emailSet.clear();
		emailSet.add(null);
		x = null;
		try {
			mutant.addAllCc(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_CC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		emailSet.clear();
		emailSet.add(new EMailAddress());
		x = null;
		try {
			mutant.addAllCc(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_CC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		//BCC
		x = null;
		try {
			mutant.addBcc(null);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_BCC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		x = null;
		try {
			mutant.addBcc(new EMailAddress());
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_BCC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		emailSet.clear();
		emailSet.add(null);
		x = null;
		try {
			mutant.addAllBcc(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_BCC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
		
		emailSet.clear();
		emailSet.add(new EMailAddress());
		x = null;
		try {
			mutant.addAllBcc(emailSet);
		} catch (Exception g) {
			x = GwtParameterExceptionAsserter.isIPE(g);
		}
		test.assertIsNotNull(x);
		test.assertIsEquals(EMail.ADD_BCC, x.getMethodName());
		test.assertIsEquals(pre + ModelsCoreEnglishConstants.EMAIL_ADDRESS_IS_NOT_VALID, x.getMessage());
	}
	
	public static void assertMutators(I_Test test) throws Exception {
		EMailMutant mutant = new EMailMutant();
		
		mutant.setFrom(new EMailAddress("support@adligo.com"));
		test.assertIsEquals(new EMailAddress("support@adligo.com"), mutant.getFrom());
		
		mutant.setSubject("subject");
		test.assertIsEquals("subject", mutant.getSubject());
		
		mutant.setBody("body");
		test.assertIsEquals("body", mutant.getBody());
		
		//tos
		test.assertIsTrue(mutant.addTo(new EMailAddress("to@adligo.com")));
		Set<EMailAddress> tos = mutant.getTOs();
		test.assertIsEquals(1, tos.size());
		test.assertIsTrue(tos.contains(new EMailAddress("to@adligo.com")));
		test.assertIsTrue(mutant.removeTo(new EMailAddress("to@adligo.com")));
		tos = mutant.getTOs();
		test.assertIsEquals(0, tos.size());
		
		Set<EMailAddress> newTos = new HashSet<EMailAddress>();
		test.assertIsTrue(newTos.add(new EMailAddress("to1@adligo.com")));
		test.assertIsTrue(newTos.add(new EMailAddress("to2@adligo.com")));
		test.assertIsTrue(mutant.addAllTo(newTos));
		tos = mutant.getTOs();
		test.assertIsEquals(2, tos.size());
		test.assertIsTrue(tos.contains(new EMailAddress("to1@adligo.com")));
		test.assertIsTrue(tos.contains(new EMailAddress("to2@adligo.com")));
		test.assertIsTrue(mutant.removeAllTo(newTos));
		tos = mutant.getTOs();
		test.assertIsEquals(0, tos.size());
		
		//ccs
		test.assertIsTrue(mutant.addCc(new EMailAddress("cc@adligo.com")));
		Set<EMailAddress> ccs = mutant.getCCs();
		test.assertIsEquals(1, ccs.size());
		test.assertIsTrue(ccs.contains(new EMailAddress("cc@adligo.com")));
		test.assertIsTrue(mutant.removeCc(new EMailAddress("cc@adligo.com")));
		ccs = mutant.getCCs();
		test.assertIsEquals(0, ccs.size());
		
		Set<EMailAddress> newCcs = new HashSet<EMailAddress>();
		test.assertIsTrue(newCcs.add(new EMailAddress("cc1@adligo.com")));
		test.assertIsTrue(newCcs.add(new EMailAddress("cc2@adligo.com")));
		test.assertIsTrue(mutant.addAllCc(newCcs));
		ccs = mutant.getCCs();
		test.assertIsEquals(2, ccs.size());
		test.assertIsTrue(ccs.contains(new EMailAddress("cc1@adligo.com")));
		test.assertIsTrue(ccs.contains(new EMailAddress("cc2@adligo.com")));
		test.assertIsTrue(mutant.removeAllCc(newCcs));
		ccs = mutant.getCCs();
		test.assertIsEquals(0, ccs.size());
		
		//bccs
		test.assertIsTrue(mutant.addBcc(new EMailAddress("bcc@adligo.com")));
		Set<EMailAddress> bccs = mutant.getBCCs();
		test.assertIsEquals(1, bccs.size());
		test.assertIsTrue(bccs.contains(new EMailAddress("bcc@adligo.com")));
		test.assertIsTrue(mutant.removeBcc(new EMailAddress("bcc@adligo.com")));
		bccs = mutant.getBCCs();
		test.assertIsEquals(0, bccs.size());
		
		Set<EMailAddress> newBccs = new HashSet<EMailAddress>();
		test.assertIsTrue(newBccs.add(new EMailAddress("bcc1@adligo.com")));
		test.assertIsTrue(newBccs.add(new EMailAddress("bcc2@adligo.com")));
		test.assertIsTrue(mutant.addAllBcc(newBccs));
		bccs = mutant.getBCCs();
		test.assertIsEquals(2, bccs.size());
		test.assertIsTrue(bccs.contains(new EMailAddress("bcc1@adligo.com")));
		test.assertIsTrue(bccs.contains(new EMailAddress("bcc2@adligo.com")));
		test.assertIsTrue(mutant.removeAllBcc(newBccs));
		bccs = mutant.getBCCs();
		test.assertIsEquals(0, bccs.size());
		
		//attachments
		test.assertIsTrue(mutant.addAttachment(new StringIdentifier("some_file")));
		Set<I_SerializableStorageIdentifier> attachments = mutant.getAttachments();
		test.assertIsEquals(1, attachments.size());
		test.assertIsTrue(attachments.contains(new StringIdentifier("some_file")));
		test.assertIsTrue(mutant.removeAttachment(new StringIdentifier("some_file")));
		attachments = mutant.getAttachments();
		test.assertIsEquals(0, attachments.size());
		
		Set<I_SerializableStorageIdentifier> newAttachemnts = new HashSet<I_SerializableStorageIdentifier>();
		test.assertIsTrue(newAttachemnts.add(new StringIdentifier("file1")));
		test.assertIsTrue(newAttachemnts.add(new StringIdentifier("file2")));
		test.assertIsTrue(mutant.addAllAttachments(newAttachemnts));
		attachments = mutant.getAttachments();
		test.assertIsEquals(2, attachments.size());
		test.assertIsTrue(attachments.contains(new StringIdentifier("file1")));
		test.assertIsTrue(attachments.contains(new StringIdentifier("file2")));
		test.assertIsTrue(mutant.removeAllAttachments(newAttachemnts));
		attachments = mutant.getAttachments();
		test.assertIsEquals(0, attachments.size());
	}
	
	public static void assertCopy(I_Test test) throws Exception {
		EMailMutant mutant = new EMailMutant();
		
		mutant.setFrom(new EMailAddress("support@adligo.com"));
		mutant.setSubject("subject");
		mutant.setBody("body");
		test.assertIsTrue(mutant.addTo(new EMailAddress("to@adligo.com")));
		test.assertIsTrue(mutant.addCc(new EMailAddress("cc@adligo.com")));
		test.assertIsTrue(mutant.addBcc(new EMailAddress("bcc@adligo.com")));
		test.assertIsTrue(mutant.addAttachment(new StringIdentifier("some_file")));
		
		EMail email = new EMail(mutant);
		test.assertIsEquals(new EMailAddress("support@adligo.com"), email.getFrom());
		test.assertIsEquals("subject", email.getSubject());
		test.assertIsEquals("body", email.getBody());
		
		Set<EMailAddress> tos = mutant.getTOs();
		test.assertIsEquals(1, tos.size());
		test.assertIsTrue(tos.contains(new EMailAddress("to@adligo.com")));
		
		Set<EMailAddress> ccs = mutant.getCCs();
		test.assertIsEquals(1, ccs.size());
		test.assertIsTrue(ccs.contains(new EMailAddress("cc@adligo.com")));
		
		Set<EMailAddress> bccs = mutant.getBCCs();
		test.assertIsEquals(1, bccs.size());
		test.assertIsTrue(bccs.contains(new EMailAddress("bcc@adligo.com")));
		
		Set<I_SerializableStorageIdentifier> attachments = mutant.getAttachments();
		test.assertIsEquals(1, attachments.size());
		test.assertIsTrue(attachments.contains(new StringIdentifier("some_file")));
	}
}
