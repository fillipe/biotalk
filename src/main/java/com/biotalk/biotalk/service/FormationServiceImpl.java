package com.biotalk.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.model.Formation;
import com.biotalk.biotalk.repository.FormationRepository;

@Service("formationService")
public class FormationServiceImpl implements FormationService {

	@Autowired
	private FormationRepository formationRepository;

	@Override
	public void saveFormation(Formation formation) {
		formationRepository.save(formation);
	}

}
