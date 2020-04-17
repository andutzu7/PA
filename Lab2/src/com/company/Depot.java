package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] vehicles;

    /**
     * Constructorul clasei
     */
    public Depot(String name) {
        this.name = name;
    }

    /**
     * Metoda care returneaza numele
     */
    public String getName() {
        return name;

    }

    /**
     * Metoda care seteaeza numele depoului
     */
    public void setName(String otherName) {
        name = otherName;
    }

    /**
     * Metoda care adauga vehicule in depou
     */
    public void setVehicles(Vehicle... vehicles) {
        boolean ok = true;
        Vehicle[] verification = vehicles;
        for (int i = 0; i < verification.length - 1; i++)
            for (int j = i + 1; j < verification.length; j++)
                if (i != j && verification[j] == verification[i])
                    ok = false;
        if (ok) {
            this.vehicles = vehicles;
            for (Vehicle v : vehicles) {
                v.setDepot(this);
            }
        }
    }

    /**
     * Metoda care returneaza vehiculele din depou
     */
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    /**
     * Metoda care converteste obiectul intr un string
     */

    @Override
    public String toString() {
        return name + Arrays.toString(vehicles);
    }

    /**
     * Metoda care verifica daca 2 obiecte de tipul depot sunt egale
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name) &&
                Arrays.equals(vehicles, depot.vehicles);
    }

    /**
     * Metoda care mapeaza obiectul la o valoare hash
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(vehicles);
        return result;
    }

}
