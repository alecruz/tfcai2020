package com.tfcai2020.services;

import java.util.List;

import com.tfcai2020.dto.AccidentDTO;
import com.tfcai2020.dto.DistanceDTO;
import com.tfcai2020.model.Common;
import com.tfcai2020.model.Point;

public interface IAccidentService {

	public List<AccidentDTO> getAccidentsByDate(String desde, String hasta);
	
	public List<Common> getAccidentsByCommonFeatures();
	
	public List<AccidentDTO> getAccidentsByLocation(double lat, double lon, double ratio);
	
	public List<DistanceDTO> getAccidentsByAverageDistance();
	
	public List<Point> getAccidentsByDangerousPoints(double ratio);
	
}
