package com.tfcai2020.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tfcai2020.dto.AccidentDTO;
import com.tfcai2020.repository.AccidentRepositoryMongo;
import com.tfcai2020.services.IAccidentService;

@Service
@Transactional
public class AccidentService implements IAccidentService {

	@Inject
	public AccidentRepositoryMongo accidentRepository;

	@Override
	public Collection<AccidentDTO> getAccidents() {
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();
		this.getAccidentRepository().findAll().stream().map(a -> new AccidentDTO(a))
				.collect(Collectors.toCollection(() -> result));
		return result;
	}

	/*@Override
	public void saveAccident(String aReason) {
		Accident newAccident = new Accident(new Date(), aReason);
		this.getAccidentRepository().save(newAccident);

	}*/

	public AccidentRepositoryMongo getAccidentRepository() {
		return this.accidentRepository;
	}

	/*public void setAccidentRepository(AccidentRepository aRepository) {
		this.accidentRepository = aRepository;
	}*/
	
}
