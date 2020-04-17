package com.company;

import java.util.Comparator;

public class SortByProfitDesc implements Comparator<Item> {
    public int compare(Item i1,Item i2){
        if(i1.profitFactor()==i2.profitFactor()) {
            return 0;
        }
        if(i1.profitFactor()>i2.profitFactor()) {
            return -1;
        }
        return 1;
    }
}
