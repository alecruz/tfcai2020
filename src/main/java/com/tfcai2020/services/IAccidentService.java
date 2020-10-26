package com.tfcai2020.services;

import java.util.List;

import com.tfcai2020.dto.AccidentDTO;
import com.tfcai2020.dto.DistanceDTO;

public interface IAccidentService {

	public List<AccidentDTO> getAccidentsByDate(String desde, String hasta);
	
	public List<AccidentDTO> getAccidentsByLocation(double lat, double lon, double ratio);
	
	public List<DistanceDTO> getAccidentsByAverageDistance();
	
}
