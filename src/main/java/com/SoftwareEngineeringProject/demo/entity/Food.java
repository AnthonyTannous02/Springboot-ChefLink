package com.SoftwareEngineeringProject.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.SoftwareEngineeringProject.demo.subEntity.FoodCategory;
import com.SoftwareEngineeringProject.demo.subEntity.FoodOption;
import com.SoftwareEngineeringProject.demo.subEntity.FoodReview;

@Document(collection = "Food")
public class Food {

    private String id_food;
    private String name;
    private double price;
    private String picture;
    private String timing;
    private List<String> ingredients;
    private String description;
    private FoodOption option;
    private FoodReview food_review;
    private FoodCategory category;

    public Food(String id_food, String name, double price, String picture, String timing, List<String> ingredients,
            String description,
            FoodOption option, FoodReview food_review, FoodCategory category) {
        this.id_food = id_food;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.ingredients = ingredients;
        this.description = description;
        this.option = option;
        this.food_review = food_review;
        this.category = category;
        this.timing = timing;
    }

    public String getId_food() {
        return id_food;
    }

    public void setId_food(String id_food) {
        this.id_food = id_food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<String> getIngredints() {
        return ingredients;
    }

    public void setIngredints(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodOption getOption() {
        return option;
    }

    public void setOption(FoodOption option) {
        this.option = option;
    }

    public FoodReview getFood_review() {
        return food_review;
    }

    public void setFood_review(FoodReview food_review) {
        this.food_review = food_review;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

}
