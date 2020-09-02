package com.tfcai2020.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tfcai2020.model.Accident;

public interface AccidentRepositoryMongo extends MongoRepository<Accident, String> {

}
