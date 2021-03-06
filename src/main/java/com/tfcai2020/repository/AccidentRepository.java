package com.tfcai2020.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tfcai2020.model.Accident;
import com.tfcai2020.model.Common;
import com.tfcai2020.model.Point;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

	@Query("{ 'Start_Time' : { $gte: ?0, $lte: ?1 }}")
	public List<Accident> findByDate(String desde, String hasta);
	
			
	@Aggregation(pipeline = {"{$facet: {"
							+ "'weather_condition': [{'$group': {'_id': '$Weather_Condition','count': { '$sum': 1 }}},{ '$sort': { 'count': -1 } },{ '$limit': 1 },{ '$project' : {'count' : 1}}],"
							+ "'city': [{'$group': {'_id': '$City','count': { '$sum': 1 }}},{ '$sort': { 'count': -1 } },{ '$limit': 1 },{ '$project' : {'count' : 1}}],"
							+ "'state': [{'$group': {'_id': '$State','count': { '$sum': 1 }}},{ '$sort': { 'count': -1 } },{ '$limit': 1 },{ '$project' : {'count' : 1}}]"
							+ "}}"})
	public List<Common> findByCommonFeatures();
	
	@Query("{'start_location': {$nearSphere: {$geometry: {type : 'Point', coordinates : [ ?1, ?0 ]}, "
			+ "$minDistance: 0, $maxDistance: ?2 }}}")
	public List<Accident> findByLocation(double lat, double lon, double ratio);				
	
	/*
	Devuelve la distancia promedio en metros desde el inicio hasta el final del accidente.
	Se utilizó el campo $Distance(mi) de la base de datos
	*/
	//@Aggregation(pipeline = {"{$project: { distance: {$divide: [{$multiply: [ '$Distance(mi)', 1609.34] }, 2] }, ID: 1}},{ '$limit': 100 }  "})
	@Aggregation(pipeline = {"{$project: { distance: {$divide: [{$multiply: [ '$Distance(mi)', 1609.34] }, 2] }, ID: 1}}"})
	public List<Accident> findByAverageDistance();
	
		
	@Aggregation(pipeline = {"{$geoNear: {near: { type: 'Point', coordinates: [?1, ?0]} , "
			+ "distanceField: 'dist.calculated', maxDistance: ?2}},{$project: {'ID' : 1}}"})								
	public List<Point> findByLocationDangerousPoint(double lat, double lon, double ratio);	
	
}
