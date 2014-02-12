package org.adligo.models.core_tests.shared.util;

import java.util.Date;

import org.adligo.models.core.shared.util.DateRangeMutant;

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
