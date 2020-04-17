package com.company;
import java.util.*;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();
    Knapsack(){}
    Knapsack(double capacity) {
        this.capacity=capacity;
    }
    Knapsack(double capacity,List<Item> items){
        this.capacity=capacity;
        this.items=items;
    }
    public List<Item> getItems(){
        return items;
    }
    public double getCapacity(){
        return capacity;
    }
    public void setCapacity(double otherCapacity) {
        capacity=otherCapacity;
    }
    public void setItems(List<Item> otherItems){
        items=otherItems;
    }
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "capacity=" + capacity +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knapsack knapsack = (Knapsack) o;
        return Double.compare(knapsack.capacity, capacity) == 0 &&
                Objects.equals(items, knapsack.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, items);
    }
    }

