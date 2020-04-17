package com.company;

public class Truck extends Vehicle {

    /**
     * Constructorul clasei
     */
    Truck() {
    }

    /**
     * Constructorul clasei
     */
    Truck(String name) {
        super(name);
    }

    /**
     * Constructorul clasei
     */
    Truck(String name, Depot d) {
        super(name, d);
    }

    /**
     * Constructorul clasei
     */
    Truck(String name, Depot d, String type) {
        super(name, d, type);
    }
}
