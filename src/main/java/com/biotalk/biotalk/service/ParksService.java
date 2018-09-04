package com.biotalk.biotalk.service;

import java.util.List;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.Parks;

public interface ParksService {
	
	public List<Parks> findParksByStatus(Status status);

}
