package com.company;

public class TimeKeeper extends Thread {
    private int maxTimeM; //the maximum time allowed untill the game stops in minutes

    public TimeKeeper(int maxTimeM) {
        this.maxTimeM = maxTimeM;
    }

    @Override
    public void run() {

        for (int i = 0; i < maxTimeM; i++) {
            System.out.println("Time elapsed: " + i );
            try {
                Thread.sleep(60 * 1000); //Inghetam thread ul pt 1 minut (1 minut * 60 sec * 1000 ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The time has expired.");
        System.exit(-1);//cand timpul expira se inchide fortat programul
    }
}
