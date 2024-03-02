package com.SoftwareEngineeringProject.demo.subEntity;

public class FoodOption {
    private String addon_name;
    private double addon_price;
    public String getAddon_name() {
        return addon_name;
    }
    public void setAddon_name(String addon_name) {
        this.addon_name = addon_name;
    }
    public double getAddon_price() {
        return addon_price;
    }
    public void setAddon_price(double addon_price) {
        this.addon_price = addon_price;
    }
    public FoodOption(String addon_name, double addon_price) {
        this.addon_name = addon_name;
        this.addon_price = addon_price;
    }
}
