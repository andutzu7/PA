package com.company;

import java.util.Comparator;

public class SortHospitals implements Comparator<Hospital> {
    public int compare(Hospital i1, Hospital i2) {
        if (i1.getName().compareTo(i2.getName()) == 0) {
            return 0;
        }
        if (i1.getName().compareTo(i2.getName()) > 0) {
            return 1;
        }
        return -1;
    }
};