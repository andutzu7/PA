package com.company;

import javax.swing.*;

public class Main {
    static final int clientsNumber = 5;
    static final int depotsNumber = 2;
    static final int vehiclesNumber = 3;
    private static Client[] clients;
    private static Vehicle[] vehicles;
    private static Depot[] depots;

    /**
     * Constructorul clasei
     */
    public Main() {
        clients = new Client[clientsNumber + 1];
        vehicles = new Vehicle[vehiclesNumber + 1];
        depots = new Depot[depotsNumber + 1];
    }

    static void addClients(Client c, Client[] clients) {
        boolean faulty = false;
        if (clients.length > 0) {
            for (Client i : clients) {
                if (c.equals(i)) {
                    faulty = true;
                    break;
                }
            }

        }

        if (clients.length == 0) {
            clients[0] = c;
        }
        if (!faulty) {
            for (int i = 0; i < clients.length; i++) {
                if (clients[i] == null) {
                    clients[i] = c;
                    break;
                }
            }
        }
    }

    static void addDepot(Depot d, Depot[] depots) {
        boolean faulty = false;
        if (depots.length > 0) {
            for (Depot i : depots) {
                if (d.equals(i)) {
                    faulty = true;
                    break;
                }
            }

        }

        if (depots.length == 0) {
            depots[0] = d;
        }
        if (!faulty) {
            for (int i = 0; i < depots.length; i++) {
                if (depots[i] == null) {
                    depots[i] = d;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Client c1 = new Client();
        c1.setName("Client 1");
        c1.setOrder(1);
        Client c2 = new Client("Client 2", 1);
        Client c3 = new Client("Client 3", 2);
        Client c4 = new Client("Client 4", 2);
        Client c5 = new Client("Client 5", 3);
        Car v1 = new Car("Dacia");
        Car v2 = new Car("Renault");
        Drone v3 = new Drone("Chinese");
        Depot d1 = new Depot("Depot 1");
        d1.setVehicles(v1, v2);
        Depot d2 = new Depot("Depot 2");
        d2.setVehicles(v3);
        System.out.println(c1.equals(c2));
    }

}
