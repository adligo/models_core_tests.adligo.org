package org.adligo.models.core_tests.shared;

import org.adligo.i.util.shared.StringUtils;
import org.adligo.models.core.shared.I_CustomInfo;
import org.adligo.models.core.shared.ValidationException;

public class SimpleCustomInfo implements I_CustomInfo {
	public static final String FOO_MAY_NOT_BE_EMPTY = "Foo may not be empty.";
	private String foo;
	
	public SimpleCustomInfo(String p) {
		foo = p;
	}
	
	@Override
	public void isValid() throws ValidationException {
		if (StringUtils.isEmpty(foo)) {
			throw new ValidationException(FOO_MAY_NOT_BE_EMPTY,I_CustomInfo.IS_VALID);
		}
	}

	@Override
	public Class getDetailClass() {
		return String.class;
	}

	@Override
	public I_CustomInfo toImmutable() throws ValidationException {
		return new SimpleCustomInfo(foo);
	}

	@Override
	public I_CustomInfo toMutant() throws ValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValidatable() {
		return true;
	}

}
