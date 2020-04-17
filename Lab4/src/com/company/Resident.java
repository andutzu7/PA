package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Resident implements Comparable<Resident>{
    private String name;

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<Hospital> generatePreferences(List<Hospital> hospitalList) {
        //generam random lista de ordine
        Random r=new Random();
        boolean array[]=new boolean[hospitalList.size()];
        List<Hospital> result=new ArrayList<Hospital>();
        for(int i=0;i<hospitalList.size();i++){
            var aux=r.nextInt(hospitalList.size());
            if(array[aux]){
                while(array[aux]){
                    aux=r.nextInt(hospitalList.size());

                }
            }
            if(!array[aux]){
                array[aux]=true;
                result.add(hospitalList.get(aux));
            }
        }
        return result;
    }
    @Override
    public int compareTo(Resident otherResident) {
        return this.getName().compareTo(otherResident.getName());
    }
}
