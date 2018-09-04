package com.biotalk.biotalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.Parks;
import com.biotalk.biotalk.repository.ParksRepository;

@Service("parksService")
public class ParksServiceImpl implements ParksService {
	
	@Autowired
	private ParksRepository parksRepository;

	@Override
	public List<Parks> findParksByStatus(Status status) {
		return parksRepository.findByStatus(status);
	}

}
