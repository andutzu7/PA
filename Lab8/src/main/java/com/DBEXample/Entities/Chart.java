package com.DBEXample.Entities;

public class Chart {
    private int id;
    private int albumId;
    private long sales;

    public Chart(int id, int albumId, long sales) {
        this.id = id;
        this.albumId = albumId;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", sales=" + sales +
                '}';
    }
}