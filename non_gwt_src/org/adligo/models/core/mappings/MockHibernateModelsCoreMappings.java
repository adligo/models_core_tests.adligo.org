package org.adligo.models.core.mappings;

import java.io.InputStream;

import org.adligo.hibernate.storage.I_HibernateMappingProvider;

public class MockHibernateModelsCoreMappings implements I_HibernateMappingProvider {

	@Override
	public int size() {
		return 1;
	}

	@Override
	public InputStream get(int i) {
		if (i == 0) {
			return this.getClass().getResourceAsStream(
					"/org/adligo/models/core/mappings/PersonMutant.hbm.xml");
		}
		return null;
	}

}
