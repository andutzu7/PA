package com.company;

public class Book implements Item {
    private String name;
    private int pageNumber; //→ getWeight
    private double value;
    private double profitFactor;
    public Book(){}

    public Book(String name) {
        this.name = name;
    }

    public Book(String name,double weight,double value) {
        this.name=name;
        this.pageNumber= (int)weight*100;
        this.value=value;
        this.profitFactor=profitFactor();
    }

    public void setName(String otherName){
        name=otherName;
    }
    public void setWeight(int otherNumber) {
        pageNumber=otherNumber;
        profitFactor=profitFactor();
    }
    public void setValue(double otherValue){
        value=otherValue;
        profitFactor=profitFactor();
    }

    @Override
    public double getWeight()
    {
        return pageNumber/100;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getValue(){
        return value;
    }
}

