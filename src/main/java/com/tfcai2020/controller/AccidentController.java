package com.tfcai2020.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfcai2020.dto.AccidentDTO;
import com.tfcai2020.services.IAccidentService;

@RestController
public class AccidentController {

	@Inject
	private IAccidentService accidentsService;

	@GetMapping(value = "/api/accident")
	public ResponseEntity<?> getAccidents() {

		ResponseEntity<?> response = null;
		Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

		result.addAll(this.getAccidentsService().getAccidents());

		response = ResponseEntity.ok(result);

		return response;
	}

	/*@PostMapping(value = "/api/accident")
	public ResponseEntity<?> saveAccidents(@RequestBody AccidentRequestDTO request) {

		ResponseEntity<?> response = null;

		this.getAccidentsService().saveAccident(request.getReason());

		response = ResponseEntity.ok().build();

		return response;
	}*/

	public IAccidentService getAccidentsService() {
		return this.accidentsService;
	}
	
}
