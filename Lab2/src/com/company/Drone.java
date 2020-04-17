package com.company;

public class Drone extends Vehicle {

    /**
     * Constructorul clasei
     */
    Drone() {
    }

    /**
     * Constructorul clasei
     */
    Drone(String name) {
        super(name);
    }

    /**
     * Constructorul clasei
     */
    Drone(String name, Depot d) {
        super(name, d);
    }

    /**
     * Constructorul clasei
     */
    Drone(String name, Depot d, String type) {
        super(name, d, type);
    }
}
