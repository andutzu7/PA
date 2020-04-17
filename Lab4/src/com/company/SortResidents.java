package com.company;

import java.util.Comparator;

public class SortResidents implements Comparator<Resident> {
    public int compare(Resident i1,Resident i2){
        if(i1.getName().compareTo(i2.getName())==0) {
            return 0;
        }
        if(i1.getName().compareTo(i2.getName())>0) {
            return 1;
        }
        return -1;
    }
}
