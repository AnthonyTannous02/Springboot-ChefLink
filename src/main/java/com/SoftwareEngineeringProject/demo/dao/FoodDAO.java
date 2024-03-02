package com.SoftwareEngineeringProject.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SoftwareEngineeringProject.demo.entity.Food;

public interface FoodDAO extends MongoRepository<Food,String> {
    
}
