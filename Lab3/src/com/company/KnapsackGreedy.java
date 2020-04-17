package com.company;
//modul de gandire. Primesti un obiect ghiozdan si o lista de iteme si algoritmul iti computeaza rezultatul prim adaugarea in rucsac a itemelor cu cel mai mare profit margin,indiferent de greutate
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackGreedy implements Algorithm {
    Knapsack knapsack;
    List<Item> availableOptions=new ArrayList<>();
    //this implements the greedy algorithm
    KnapsackGreedy(Knapsack knapsack,List<Item>availableOptions){
        this.knapsack=knapsack;
        this.availableOptions=availableOptions;
    }
    public Knapsack computeResult(){
        Collections.sort(availableOptions,new SortByProfitDesc());//sortam dupa profit-factor
        knapsack.setItems(availableOptions);
        List<Item>resultList=new ArrayList<>();
        double size=0.0;
        //rez alg greedy
        for(Item i:availableOptions)
                if(i.getWeight()+size<=knapsack.getCapacity()) {
                    resultList.add(i);
                    size+=i.getWeight();
                }
        knapsack.setItems(resultList);

        return knapsack;
    }

}
