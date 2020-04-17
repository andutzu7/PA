package com.company;

public interface Item extends Comparable<Item> {

    String getName();

    double getValue();

    double getWeight();

    @Override
    default int compareTo(Item o){
        return getName().compareTo(o.getName());
    }

    default double profitFactor() {

        return getValue() / getWeight();
    }

}