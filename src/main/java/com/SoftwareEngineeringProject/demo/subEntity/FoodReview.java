package com.SoftwareEngineeringProject.demo.subEntity;

public class FoodReview {
    private double rating;
    private String comments;
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public FoodReview(double rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }
}
