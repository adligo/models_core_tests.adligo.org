package org.adligo.models.core.gwt.client;

import org.adligo.gwt.util.client.GwtLogFactory;
import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.i.util.client.ClassUsageView;
import org.adligo.i.util.client.I_UsageHolder;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.CommonTime;
import org.adligo.models.core.client.ConstantsFactory;
import org.adligo.models.core.client.CoreRoles;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_StorageIdGenerator;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelInvokerNames;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.PhoneNumberMutant;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.StorageIdentifierMutant;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.english.DomainValidationConstants;
import org.adligo.models.core.client.english.EnglishConstantsFactory;
import org.adligo.models.core.client.english.UserValidationConstants;
import org.adligo.models.core.client.i18n.I_DomainNameValidationConstants;
import org.adligo.models.core.client.i18n.I_EmailValidationConstants;
import org.adligo.models.core.client.i18n.I_UserValidationConstants;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MockModelsEntryPoint implements EntryPoint{
	I_UsageHolder holder;
	ClassUsageView view;
	
	
	public MockModelsEntryPoint() {
		view = new ClassUsageView();
		holder = view;
	}
	public MockModelsEntryPoint(I_UsageHolder p_holder) {
		holder = p_holder;
	}
	
	@Override
	public void onModuleLoad() {
		if (view != null) {
			// TODO Auto-generated method stub
			RootPanel.get().add(view);
		}
		try {
			
			GwtPlatform.init();
			GwtLogFactory.init();
			ModelsCoreRegistry.init();
			new EnglishConstantsFactory();
			
			holder.addUsed(new Address());
			holder.addUsed(new AddressMutant());
			holder.addUsed(CommonTime.class);
			holder.addUsed(ConstantsFactory.INSTANCE);
			holder.addUsed(CoreRoles.class);
			holder.addUsed(new DomainName());
			holder.addUsed(new EMail("support@adligo.com"));
			holder.addUsed(I_NamedId.class);
			holder.addUsed(I_StorageIdGenerator.class);
			holder.addUsed(I_User.class);
			holder.addUsed(new InvalidParameterException("", ""));
			holder.addUsed(ModelInvokerNames.class);
			holder.addUsed(ModelsCoreRegistry.class);
			holder.addUsed(new NamedId());
			holder.addUsed(new NamedIdMutant());
			holder.addUsed(new Organization());
			holder.addUsed(new OrganizationMutant());
			holder.addUsed(new Person());
			holder.addUsed(new PersonMutant());
			holder.addUsed(new PhoneNumber());
			holder.addUsed(new PhoneNumberMutant());
			holder.addUsed(new StorageIdentifier());
			holder.addUsed(new StorageIdentifierMutant());
			holder.addUsed(new User());
			holder.addUsed(new UserMutant());
			
			holder.addUsed(new DomainValidationConstants());
			holder.addUsed(EnglishConstantsFactory.class);
			holder.addUsed(new UserValidationConstants());
			
			holder.addUsed(I_DomainNameValidationConstants.class);
			holder.addUsed(I_EmailValidationConstants.class);
			holder.addUsed(I_UserValidationConstants.class);
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

}
