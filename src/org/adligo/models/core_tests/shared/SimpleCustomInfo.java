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
	public String toString() {
		return "SimpleCustomInfo [foo=" + foo + "]";
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foo == null) ? 0 : foo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleCustomInfo other = (SimpleCustomInfo) obj;
		if (foo == null) {
			if (other.foo != null)
				return false;
		} else if (!foo.equals(other.foo))
			return false;
		return true;
	}

	@Override
	public boolean isValidatable() {
		return true;
	}

}
