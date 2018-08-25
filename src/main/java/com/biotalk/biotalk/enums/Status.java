package com.biotalk.biotalk.enums;

public enum Status {
	
	PENDING(0), APPROVED(1), DESAPPROVED(2);
	
	public Integer valueStatus;
	
	private Status(Integer value) {
		valueStatus = value;
	}

}
