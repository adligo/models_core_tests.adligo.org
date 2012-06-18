package org.adligo.models.core.gwt.client;

import org.adligo.gwt.util.client.GwtLogFactory;
import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.i.util.client.ClassUsageView;
import org.adligo.i.util.client.I_UsageHolder;
import org.adligo.models.core.client.Address;
import org.adligo.models.core.client.AddressMutant;
import org.adligo.models.core.client.ChainedFieldException;
import org.adligo.models.core.client.CommandToken;
import org.adligo.models.core.client.CommandTokenMutant;
import org.adligo.models.core.client.CoreRoles;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_Address;
import org.adligo.models.core.client.I_AddressMutant;
import org.adligo.models.core.client.I_Changeable;
import org.adligo.models.core.client.I_ChangeableMutant;
import org.adligo.models.core.client.I_CommandToken;
import org.adligo.models.core.client.I_CustomInfo;
import org.adligo.models.core.client.I_Customizable;
import org.adligo.models.core.client.I_CustomizableMutant;
import org.adligo.models.core.client.I_Identifiable;
import org.adligo.models.core.client.I_IdentifiableMutant;
import org.adligo.models.core.client.I_ModelsCoreConstants;
import org.adligo.models.core.client.I_ModifyEMailList;
import org.adligo.models.core.client.I_ModifyEMailListMutant;
import org.adligo.models.core.client.I_Mutable;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_NamedIdMutant;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_OrganizationMutant;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_PersonMutant;
import org.adligo.models.core.client.I_PhoneNumber;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_StorageInfo;
import org.adligo.models.core.client.I_StorageMutant;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_UserMutant;
import org.adligo.models.core.client.I_Validateable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.ModelsCoreEnglishConstants;
import org.adligo.models.core.client.ModelsCoreRegistry;
import org.adligo.models.core.client.ModifyEMailListMutant;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.PhoneNumber;
import org.adligo.models.core.client.SimpleStorageInfo;
import org.adligo.models.core.client.StorableValidator;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.ValidationException;
import org.adligo.models.core.client.ids.I_LongIdentifier;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.I_StringIdentifier;
import org.adligo.models.core.client.ids.I_VersionedLongIdentifier;
import org.adligo.models.core.client.ids.LongIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;
import org.adligo.models.core.client.ids.StringIdentifier;
import org.adligo.models.core.client.ids.VersionedLongIdentifierMutant;

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
			} catch (Exception x) {
				x.printStackTrace();
			}
		}
		try {
			
			
			
			holder.addUsed(new AddressMutant());
			holder.addUsed(new Address());
			
			holder.addUsed(CommandToken.class);
			holder.addUsed(CommandTokenMutant.class);
			
			holder.addUsed(CoreRoles.class);
			holder.addUsed(new ChainedFieldException("ye","foo"));
			holder.addUsed(new DomainName());
			holder.addUsed(new EMailAddress("support@adligo.com"));

			holder.addUsed(I_Address.class);
			holder.addUsed(I_AddressMutant.class);
			holder.addUsed(I_CommandToken.class);
			
			holder.addUsed(I_Changeable.class);
			holder.addUsed(I_ChangeableMutant.class);
			holder.addUsed(I_CustomInfo.class);
			holder.addUsed(I_Customizable.class);
			holder.addUsed(I_CustomizableMutant.class);
			
			holder.addUsed(I_Identifiable.class);
			holder.addUsed(I_IdentifiableMutant.class);
			
			holder.addUsed(I_LongIdentifier.class);
			
			holder.addUsed(I_ModifyEMailList.class);
			holder.addUsed(I_ModifyEMailListMutant.class);
			
			holder.addUsed(I_Mutable.class);
			
			holder.addUsed(I_NamedId.class);
			holder.addUsed(I_NamedIdMutant.class);
			holder.addUsed(I_Organization.class);
			holder.addUsed(I_OrganizationMutant.class);
			holder.addUsed(I_Person.class);
			holder.addUsed(I_PersonMutant.class);
			holder.addUsed(I_PhoneNumber.class);
			
			holder.addUsed(I_Storable.class);
			holder.addUsed(I_StorageMutant.class);
			holder.addUsed(I_StorageInfo.class);
			
			holder.addUsed(I_Subject.class);
			holder.addUsed(I_User.class);
			holder.addUsed(I_UserMutant.class);
			holder.addUsed(I_Validateable.class);

			holder.addUsed(I_VersionedLongIdentifier.class);
			
			holder.addUsed(new InvalidParameterException("", ""));
			holder.addUsed(ModelsCoreRegistry.class);
			holder.addUsed(new NamedId());
			holder.addUsed(new NamedIdMutant());
			holder.addUsed(new Organization());
			holder.addUsed(new OrganizationMutant());
			holder.addUsed(new Person());
			holder.addUsed(new PersonMutant());
			holder.addUsed(new PhoneNumber());
			
			holder.addUsed(new UserMutant());
			holder.addUsed(new User());
			
			
			holder.addUsed(new ModifyEMailListMutant());
			
			holder.addUsed(new ModelsCoreEnglishConstants());
			holder.addUsed(new ModelsCoreConstantsObtainer());
			holder.addUsed(ValidationException.class);
			holder.addUsed(new VersionedLongIdentifierMutant());
			holder.addUsed(new SimpleStorageInfo());
			
			holder.addUsed(StorageIdentifierValidator.class);
			holder.addUsed(StorableValidator.class);
			
			holder.addUsed(I_ModelsCoreConstants.class);
			
			addIdClasses();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	private void addIdClasses() {

		
		holder.addUsed(new LongIdentifier());
		holder.addUsed(new LongIdentifier());
		
		holder.addUsed(I_StorageIdentifier.class);
		holder.addUsed(I_StringIdentifier.class);
		
		holder.addUsed(new StringIdentifier());
		holder.addUsed(new StringIdentifier());
	}
}
