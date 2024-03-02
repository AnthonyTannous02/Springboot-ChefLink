package com.SoftwareEngineeringProject.demo.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SoftwareEngineeringProject.demo.dao.FoodService;
import com.SoftwareEngineeringProject.demo.entity.Food;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
//import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.DBObject;

@RestController
@RequestMapping("/api/food")
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
            rootNode.set("data", foodNode);

        }
        return rootNode;
    }

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food savedFood = foodService.addFood(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    @GetMapping("/get_explore_food")
    public ObjectNode getExploreFood(@RequestBody JsonNode req) {
        int amount = Integer.parseInt(req.get("amount").asText());
        String groupBy = req.get("group_by").asText();
        List<DBObject> foodList = foodService.findGroupByCategory(amount, groupBy);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;
        ObjectNode responseNode = nodeFactory.objectNode();
        JsonNode arrayNode = objectMapper.valueToTree(foodList);
        responseNode.set("data", arrayNode);
        
        return responseNode;
    }

}
