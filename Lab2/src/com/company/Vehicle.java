package com.company;

abstract class Vehicle {

    private String name;
    private Depot depot;
    private String type;

    /**
     * Constructorul clasei
     */
    public Vehicle() {
    }

    /**
     * Constructorul clasei
     */
    public Vehicle(String name) {
        this.name = name;
    }

    /**
     * Constructorul clasei
     */
    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    /**
     * Constructorul clasei
     */
    public Vehicle(String name, Depot depot, String type) {
        this.name = name;
        this.depot = depot;
        this.type = type;
    }

    /**
     * Metoda care seteaza tipul vehiculului
     */
    public void setType(String otherType) {
        type = otherType;
    }

    /**
     * Metoda care returneaza tipul vehiculului
     */
    public String getType() {
        return type;
    }
    /** Metoda care returneaza numele*/
    /**
     * Metoda care returneaza numele vehiculului
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda care seteaza numele vehiculului
     */
    public void setName(String otherName) {
        name = otherName;
    }

    /**
     * Metoda care returneaza depoul vehiculului
     */
    public Depot getDepot() {
        return depot;
    }

    /**
     * Metoda care seteaza depoul vehiculului
     */
    public void setDepot(Depot otherDepot) {
        depot = otherDepot;
    }

    /**
     * Metoda care converteste obiectul intr un string
     */
    public String toString() {
        return name;
    }

    /**
     * Metoda care verifica daca 2 obiecte de tipul vehicle sunt egale
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return name.equals(other.name);
    }
}
