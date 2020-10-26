package com.tfcai2020.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tfcai2020.model.Accident;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

	@Query("{ 'Start_Time' : { $gte: ?0, $lte: ?1 }}")
	public List<Accident> findByDate(String desde, String hasta);
		
	
	@Query("{'start_location': {$nearSphere: {$geometry: {type : 'Point', coordinates : [ ?1, ?0 ]}, "
			+ "$minDistance: 0, $maxDistance: ?2 }}}")
	public List<Accident> findByLocation(double lat, double lon, double ratio);	
			
	
	/*
	Devuelve la distancia promedio en metros desde el inicio hasta el final del accidente.
	Se utilizó el campo $Distance(mi) de la base de datos
	*/
	@Aggregation(pipeline = {"{$project: { distance: {$divide: [{$multiply: [ '$Distance(mi)', 1609.34] }, 2] }, ID: 1}}"})
	public List<Accident> findByAverageDistance();
	
}
