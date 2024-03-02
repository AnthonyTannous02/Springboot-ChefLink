package com.SoftwareEngineeringProject.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoftwareEngineeringProject.demo.dao.FoodService;
import com.SoftwareEngineeringProject.demo.entity.Food;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/foods")
public class FoodRestController {

    @Autowired
    private FoodService foodService;

    // @GetMapping
    // public List<Food> getAllFood(){
    // return foodService.getAllFood();
    // }

    @GetMapping
    public ObjectNode getAllFoodAsJson() {
        List<Food> foods = foodService.getAllFood();
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        //ArrayNode foodArrayNode= rootNode.putArray("foods");

        for (Food food : foods) {
            ObjectNode foodNode = objectMapper.valueToTree(food);
            //foodArrayNode.add(foodNode);
            rootNode.set(food.getId_food(), foodNode);

        }
        return rootNode;
    }

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food savedFood = foodService.addFood(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

}
