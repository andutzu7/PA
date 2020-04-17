package com.DBEXample.DAO;

public class ChartRow {
    String artistName;
    String albumName;
    int sales;

    public ChartRow(String artistName, String albumName, int sales) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "ChartRow{" +
                "artistName='" + artistName + '\'' +
                ", albumName='" + albumName + '\'' +
                ", sales=" + sales +
                '}';
    }
}
