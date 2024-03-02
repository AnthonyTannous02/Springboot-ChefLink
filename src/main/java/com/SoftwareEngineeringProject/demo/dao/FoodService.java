package com.SoftwareEngineeringProject.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoftwareEngineeringProject.demo.entity.Food;

@Service
public class FoodService {
    
    private FoodDAO foodRepository;

    @Autowired
    public FoodService(FoodDAO foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    public Food addFood(Food food){
        return foodRepository.save(food);
    }


}
