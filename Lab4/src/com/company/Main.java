//asta e lab4 !!!!!!!!!!
package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public List<Resident> generateResidents(List<Resident> r) {
        var arr = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("R" + i))
                .toArray(Resident[]::new);
        r = Arrays.asList(arr);
        return r;
    }

    public static TreeSet<Hospital> generateHospitals(TreeSet<Hospital> h) {
        Random r = new Random();
        var arr = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);
        h.addAll(Arrays.asList(arr));
        return h;
    }

    public Map<Resident, List<Hospital>> populateResidentMap(TreeSet<Hospital> hospitals, List<Resident> residents) {

        Map<Resident, List<Hospital>> map = new TreeMap<Resident, List<Hospital>>();
        List<Hospital> hospitalList = new ArrayList<Hospital>(hospitals);//a trebuit sa fac conversia pt lista
        for (var i : residents) {
            map.put(i, Resident.generatePreferences(hospitalList));

        }
        return map;
    }

    public Map<Hospital,List<Resident>> populateHospitalMap(TreeSet<Hospital> hospitals, List<Resident> residents) {

        Map<Hospital,List<Resident>> map = new TreeMap<Hospital,List<Resident>>();
        for (var i : hospitals) {
            map.put(i, Hospital.generatePreferences(residents));

        }
        return map;
    }

    public void printRMapElements(Map<Resident, List<Hospital>> m) {
        for (var i : m.entrySet()) {
            System.out.print(i.getKey().getName() + " ");
            for (var j : i.getValue()) {
                System.out.print(j.getName() + " ");
            }
            System.out.println();//newline
        }
        System.out.println();//newline

    }

    public void printHMapElements(Map<Hospital, List<Resident>> m) {
        for (var i : m.entrySet()) {
            System.out.print(i.getKey().getName() + " ");
            for (var j : i.getValue()) {
                System.out.print(j.getName() + " ");
            }
            System.out.println();//newline
        }
        System.out.println();//newline

    }

    public static void main(String[] args) {
        Main m = new Main();
        List<Resident> residents = new ArrayList<Resident>(4);
        residents = m.generateResidents(residents);
        Collections.sort(residents, new SortResidents());
        TreeSet<Hospital> hospitals = new TreeSet<Hospital>();//nu e nevoie de sortare ptc treeSet ordoneaza elementele crescator by default(sau sorteaza in fct de metoda compareTo a clasei
        hospitals = generateHospitals(hospitals);
        /*Prima implementare a unui map*/
        SortedMap<Resident, List<Hospital>> residentPrefList1 = new TreeMap<Resident, List<Hospital>>(m.populateResidentMap(hospitals, residents));
        m.printRMapElements(residentPrefList1);
        /*A doua implementare a unui map*/
        HashMap<Hospital, List<Resident>>hospitalPrefList1 = new HashMap<Hospital, List<Resident>>(m.populateHospitalMap(hospitals, residents));
        m.printHMapElements(hospitalPrefList1);
        // collecting the residents who accept H0 and H2

        List<Hospital> target = Arrays.asList(hospitals.first(), hospitals.last());
        List<Resident> result = residents.stream()
                .filter(res -> residentPrefList1.get(res).containsAll(target))
                .collect(Collectors.toList());
        for (var i : result) {
            System.out.println(i.getName());
        }
        for (var i : hospitalPrefList1  .entrySet()) { //iteram si verificam pe rand daca conditia este satisfacuta

           if (i.getValue().toArray()[0] == residents.get(0))
                ; // to fnish
        }

    }

}
