package org.adligo.models.core.gwt.client;

import org.adligo.gwt.util.client.GwtLogFactory;
import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.i.adi.client.I18nConstantsFactory;
import org.adligo.i.util.client.ClassUsageView;
import org.adligo.i.util.client.I_UsageHolder;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.CoreRoles;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.I_ModelsCoreValidationConstants;
import org.adligo.models.core.client.I_Mutable;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_StorageIdGenerator;
import org.adligo.models.core.client.I_StorageMutant;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_Validateable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreEnglishValidationConstants;
import org.adligo.models.core.client.ModelsCoreValidationConstantsObtainer;
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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MockModelsEntryPoint implements EntryPoint {
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
			try {
				GwtPlatform.init();
				GwtLogFactory.init();
				new ModelsCoreEnglishConstantsFactory();
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		try {
			
			
			
			holder.addUsed(new Address());
			holder.addUsed(new AddressMutant());
			holder.addUsed(CoreRoles.class);
			holder.addUsed(new DomainName());
			holder.addUsed(new EMail("support@adligo.com"));
			holder.addUsed(I_Mutable.class);
			holder.addUsed(I_NamedId.class);
			holder.addUsed(I_Storable.class);
			holder.addUsed(I_StorageMutant.class);
			holder.addUsed(I_StorageIdGenerator.class);
			holder.addUsed(I_User.class);
			holder.addUsed(I_Validateable.class);
			holder.addUsed(new InvalidParameterException("", ""));
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
			
			holder.addUsed(new ModelsCoreEnglishValidationConstants());
			holder.addUsed(new ModelsCoreValidationConstantsObtainer());
			holder.addUsed(ModelsCoreEnglishConstantsFactory.class);
			
			holder.addUsed(I_ModelsCoreValidationConstants.class);
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

}
