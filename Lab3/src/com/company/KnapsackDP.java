package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackDP implements Algorithm{
    Knapsack knapsack;
    List<Item> availableOptions=new ArrayList<>();

    KnapsackDP(Knapsack knapsack,List<Item>availableOptions){
        this.knapsack=knapsack;
        this.availableOptions=availableOptions;
    }
    public Knapsack computeResult(){
        int[][] m=new int[availableOptions.size()][(int)knapsack.getCapacity()+1];//creem matricea cu dimensiunile nrObiecte si capacitate+1
        Collections.sort(availableOptions,new SortByProfitDesc());//sortam dupa profit-factor
        int w=(int)knapsack.getCapacity();//max weight
        return knapsack;
    }


}
