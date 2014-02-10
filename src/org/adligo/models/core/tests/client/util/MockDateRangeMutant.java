package org.adligo.models.core.tests.client.util;

import java.util.Date;

import org.adligo.models.core.client.util.DateRangeMutant;

public class MockDateRangeMutant extends DateRangeMutant {

	public Date getStartDate() {
		return super.getStartDate();
	}
	
	public Date getEndDate() {
		return super.getEndDate();
	}
	
	public void setStartDate(Date p) {
		super.setStartDate(p);
	}
	
	public void setEndDate(Date p) {
		super.setEndDate(p);
	}
}
