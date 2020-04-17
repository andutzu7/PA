package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hospital implements Comparable<Hospital> {
    private String name;
    Hospital(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public static List<Resident> generatePreferences(List<Resident> residentsList) {
        //generam random lista de ordine
        Random r=new Random();
        boolean array[]=new boolean[residentsList.size()];
        List<Resident> result=new ArrayList<Resident>();
        for(int i=0;i<residentsList.size();i++){
            var aux=r.nextInt(residentsList.size());
            if(array[aux]){
                while(array[aux]){
                    aux=r.nextInt(residentsList.size());

                }
            }
            if(!array[aux]){
                array[aux]=true;
                result.add(residentsList.get(aux));
            }
        }
        return result;
    }
    @Override
    public int compareTo(Hospital otherHospital) {
        return this.getName().compareTo(otherHospital.getName());
    }

}
