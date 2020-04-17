package com.company;

import java.util.Objects;

public class Client {
    private String name;
    private int order;

    /**
     * Constructorul clasei
     */
    public Client() {
    }

    /**
     * Constructorul clasei
     */
    public Client(String name, int order) {
        this.name = name;
        this.order = order;
    }

    /**
     * Metoda care returneaza numele
     */

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setName(String otherName) {
        name = otherName;
    }

    public void setOrder(int otherOrder) {
        order = otherOrder;
    }

    /**
     * Metoda care verifica daca 2 obiecte de tipul vehicle sunt egale
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return order == client.order &&
                Objects.equals(name, client.name);
    }

    /**
     * Metoda care mapeaza obiectul la o valoare hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, order);
    }

    /**
     * Metoda care converteste obiectul intr un string
     */
    public String toString() {
        return name + " , " + order;
    }
}