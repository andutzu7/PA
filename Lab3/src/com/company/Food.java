package com.company;
public class Food implements Item{
    private String name;
    private double weight; // → getWeight, getValue
    private double value;
    private double profitFactor;
    public Food(){}

    public Food(String name) {
        this.name = name;
    }

    public Food(String name,double weight,double value) {
        this.name=name;
        this.weight = weight;
        this.value=value;
        this.profitFactor=profitFactor();
    }

    public void setName(String otherName){
        name=otherName;
    }
    public void setWeight(double otherWeight) {
        weight=otherWeight;
        profitFactor=profitFactor();
    }
    public void setValue(double otherValue){
        value=otherValue;
        profitFactor=profitFactor();
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getValue() {
        return value*2;
    }
    @Override
    public double getWeight(){
        return weight;
    }
}
