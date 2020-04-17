package com.company;

public class Car extends Vehicle {

    /**
     * Constructorul clasei
     */
    Car() {
    }

    /**
     * Constructorul clasei
     */
    Car(String name) {
        super(name);
    }

    /**
     * Constructorul clasei
     */
    Car(String name, Depot d) {
        super(name, d);
    }

    /**
     * Constructorul clasei
     */
    Car(String name, Depot d, String type) {
        super(name, d, type);
    }
}

