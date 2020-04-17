package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{


    public static void main(String[] args) {
        double capacity=8;
        List<Item> list = new ArrayList<>();
        list.add(new Book("Dragon Rising",3,5));
        list.add(new Book("A Blade in the Dark",3,5));
        list.add(new Food("Cabbage",2,4));
        list.add(new Food("Rabbit",2,4));
        list.add(new Weapon(WeaponType.Sword,5,10));
        Knapsack knapsack=new Knapsack(capacity);
        KnapsackDP kd=new KnapsackDP(knapsack,list);
        Knapsack result = kd.computeResult();
        List<Item> l=new ArrayList<>(result.getItems());

        for(Item i:l){
            System.out.println( i.profitFactor());
        }
    }
}
