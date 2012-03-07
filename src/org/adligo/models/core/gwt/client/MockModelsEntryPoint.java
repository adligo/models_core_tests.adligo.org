package org.adligo.models.core.gwt.client;

import org.adligo.gwt.util.client.GwtLogFactory;
import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.i.util.client.ClassUsageView;
import org.adligo.i.util.client.I_UsageHolder;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.CommonModel;
import org.adligo.models.core.client.CoreRoles;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.DomainNameMutant;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.EMailAddressMutant;
import org.adligo.models.core.client.I_Address;
import org.adligo.models.core.client.I_AddressMutant;
import org.adligo.models.core.client.I_DomainName;
import org.adligo.models.core.client.I_DomainNameMutant;
import org.adligo.models.core.client.I_EMailAddress;
import org.adligo.models.core.client.I_EMailAddressMutant;
import org.adligo.models.core.client.I_ModelsCoreConstants;
import org.adligo.models.core.client.I_Mutable;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_NamedIdMutant;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_OrganizationMutant;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_PersonMutant;
import org.adligo.models.core.client.I_PhoneNumber;
import org.adligo.models.core.client.I_PhoneNumberMutant;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_StorageMutant;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_UserMutant;
import org.adligo.models.core.client.I_Validateable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreCheckedInvokerNames;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ModelsCoreEnglishConstantsFactory;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.PhoneNumberMutant;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.ValidationException;
import org.adligo.models.core.client.ids.DefaultStorageIdentifierFactory;
import org.adligo.models.core.client.ids.I_LongIdentifier;
import org.adligo.models.core.client.ids.I_LongIdentifierMutant;
import org.adligo.models.core.client.ids.I_StorageIdGenerator;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.I_StringIdentifier;
import org.adligo.models.core.client.ids.I_StringIdentifierMutant;
import org.adligo.models.core.client.ids.I_VersionedIdentifier;
import org.adligo.models.core.client.ids.I_VersionedIdentifierMutant;
import org.adligo.models.core.client.ids.LongIdentifier;
import org.adligo.models.core.client.ids.LongIdentifierFactory;
import org.adligo.models.core.client.ids.LongIdentifierMutant;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.client.ids.StringIdentifierFactory;
import org.adligo.models.core.client.ids.StringIdentifierMutant;
import org.adligo.models.core.client.ids.VersionedIdentifier;
import org.adligo.models.core.client.ids.VersionedIdentifierFactory;
import org.adligo.models.core.client.ids.VersionedIdentifierMutant;

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
			
			
			
			holder.addUsed(new AddressMutant());
			holder.addUsed(new Address());
			holder.addUsed(CoreRoles.class);
			holder.addUsed(CommonModel.class);
			holder.addUsed(new DomainName());
			holder.addUsed(new DomainNameMutant());
			holder.addUsed(new DefaultStorageIdentifierFactory());
			holder.addUsed(new EMailAddress("support@adligo.com"));
			holder.addUsed(new EMailAddressMutant());

			holder.addUsed(I_Address.class);
			holder.addUsed(I_AddressMutant.class);
			holder.addUsed(I_DomainName.class);
			
			holder.addUsed(I_DomainNameMutant.class);
			holder.addUsed(I_EMailAddress.class);
			holder.addUsed(I_EMailAddressMutant.class);
			
			holder.addUsed(I_LongIdentifier.class);
			holder.addUsed(I_LongIdentifierMutant.class);
			
			holder.addUsed(I_Mutable.class);
			holder.addUsed(I_NamedId.class);
			holder.addUsed(I_NamedIdMutant.class);
			holder.addUsed(I_Organization.class);
			holder.addUsed(I_OrganizationMutant.class);
			holder.addUsed(I_Person.class);
			holder.addUsed(I_PersonMutant.class);
			holder.addUsed(I_PhoneNumber.class);
			holder.addUsed(I_PhoneNumberMutant.class);
			
			holder.addUsed(I_Storable.class);
			holder.addUsed(I_StorageMutant.class);
			
			holder.addUsed(I_Subject.class);
			holder.addUsed(I_User.class);
			holder.addUsed(I_UserMutant.class);
			holder.addUsed(I_Validateable.class);

			
			holder.addUsed(new InvalidParameterException("", ""));
			holder.addUsed(ModelsCoreRegistry.class);
			holder.addUsed(new NamedId());
			holder.addUsed(new NamedIdMutant());
			holder.addUsed(new Organization());
			holder.addUsed(new OrganizationMutant());
			holder.addUsed(new Person());
			holder.addUsed(new PersonMutant());
			holder.addUsed(new PhoneNumberMutant());
			holder.addUsed(new PhoneNumber());
			
			holder.addUsed(new UserMutant());
			holder.addUsed(new User());
			
			holder.addUsed(new ModelsCoreCheckedInvokerNames());
			holder.addUsed(new ModelsCoreEnglishConstants());
			holder.addUsed(new ModelsCoreConstantsObtainer());
			holder.addUsed(ModelsCoreEnglishConstantsFactory.class);
			holder.addUsed(ValidationException.class);
		
			holder.addUsed(I_ModelsCoreConstants.class);
			
			addIdClasses();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	private void addIdClasses() {
		
		holder.addUsed(LongIdentifier.class);
		holder.addUsed(LongIdentifierFactory.class);
		holder.addUsed(LongIdentifierMutant.class);
		
		holder.addUsed(I_StorageIdentifier.class);
		holder.addUsed(I_StorageIdGenerator.class);
		holder.addUsed(I_StringIdentifier.class);
		holder.addUsed(I_StringIdentifierMutant.class);
		holder.addUsed(I_VersionedIdentifier.class);
		holder.addUsed(I_VersionedIdentifierMutant.class);
		
		holder.addUsed(VersionedIdentifier.class);
		holder.addUsed(VersionedIdentifierFactory.class);
		holder.addUsed(VersionedIdentifierMutant.class);
		
		holder.addUsed(new StringIdentifier());
		holder.addUsed(new StringIdentifierFactory());
		holder.addUsed(new StringIdentifierMutant());
	}
}
