package org.adligo.models.core;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.NamedIdMutant;
import org.adligo.models.core.client.StorageIdentifier;

public class NameIdSubclass extends NamedId {
	public static final String ID_ERROR = "IdError";
	public static final String NAME_ERROR = "NameError";
	private static boolean throw_id_error = true;
	
	@SuppressWarnings("unused")
	private NameIdSubclass() {}
	
	public NameIdSubclass(NamedId other)  {
		super(other);
	}
	
	public NameIdSubclass(NamedIdMutant other) throws InvalidParameterException {
		super(other);
	}
	
	@Override
	protected void setIdP(StorageIdentifier pId)
			throws InvalidParameterException {
		if (throw_id_error) {
			throw new InvalidParameterException(ID_ERROR, SET_ID);
		}
	}

	@Override
	protected void setNameP(String pName) throws InvalidParameterException {
		throw new InvalidParameterException(NAME_ERROR, SET_NAME);
	}


	public static void setThrow_id_error(boolean throwIdError) {
		throw_id_error = throwIdError;
	}

}
