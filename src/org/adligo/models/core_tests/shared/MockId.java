package org.adligo.models.core_tests.shared;

import org.adligo.models.core.shared.I_StorageIdentifier;

public class MockId implements I_StorageIdentifier {
	

	private String id;
			
	public MockId(String p) {
		id = p;
	}
	@Override
	public int getMemsize() {
		if (id == null) {
			return 0;
		}
		return id.getBytes().length;
	}

	@Override
	public boolean hasValue() {
		if (id == null) {
			return false;
		}
		return true;
	}

	@Override
	public I_StorageIdentifier toImmutable() {
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MockId [id=" + id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MockId other = (MockId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
