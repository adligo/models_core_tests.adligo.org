package org.adligo.models.core;

import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.StorageIdentifier;

public class StorageIdentifierSubclass extends StorageIdentifier {
	public static final String ID_ERROR = "IdError";
	public static final String KEY_ERROR = "KeyError";
	
	@SuppressWarnings("unused")
	private StorageIdentifierSubclass() {}
	
	public StorageIdentifierSubclass(I_StorageIdentifier other) throws InvalidParameterException {
		super(other);
	}
	
	@Override
	protected void setIdP(Long pId) throws InvalidParameterException {
		throw new InvalidParameterException(ID_ERROR, StorageIdentifier.SET_ID);
	}

	@Override
	protected void setKeyP(String pKey) throws InvalidParameterException {
		throw new InvalidParameterException(KEY_ERROR, StorageIdentifier.SET_KEY);
	}

}
