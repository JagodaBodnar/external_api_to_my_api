package com.example.transfer_of_fruit_api_to_my_own_api.model;

import java.util.Map;

public class Fruit {
    private String name;
    private Map<String, Integer> nutritious;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    private int id;
    private String family;
    private String order;
    private String genus;

        public Fruit(String name, Map<String,Integer> nutritious){
        this.name = name;
        this.nutritious = nutritious;
    }
    public Fruit(String name, int id, String family, String order, String genus, Map<String,Integer> nutritions) {
        this.name = name;
        this.id = id;
        this.family = family;
        this.order = order;
        this.genus = genus;
        this.nutritious = nutritions;
    }


    public Map<String, Integer> getNutritious() {
        return nutritious;
    }

    public void setNutritious(Map<String, Integer> nutritious) {
        this.nutritious = nutritious;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
