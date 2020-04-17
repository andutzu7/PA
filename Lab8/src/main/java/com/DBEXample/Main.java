package com.DBEXample;

import com.DBEXample.DAO.ArtistController;
import com.DBEXample.DAO.ChartController;
import com.DBEXample.DAO.ChartRow;
import com.DBEXample.Database.Database;
import com.DBEXample.DAO.AlbumController;
import com.DBEXample.Entities.Album;
import com.DBEXample.Entities.Artist;
import com.DBEXample.Entities.Chart;
import com.github.javafaker.Faker;

import java.sql.*;
import java.util.List;
import java.util.Random;

//de avut grja cu indexu ca am oracle versiune f veche
class Main {
    private static Connection connection = null;

    Main() {
        try {
            connection = Database.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createArtistsTable() {

        try {
            Statement stmt = connection.createStatement();
            String query = "create table artists(" +
                    "    id integer not null," +
                    "    name varchar(100) not null," +
                    "    country varchar(100)," +
                    "    primary key (id)" +
                    ")";
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createAlbumsTable() {
        try {
            Statement stmt = connection.createStatement();
            String query = "create table albums(" +
                    "    id integer not null," +
                    "    name varchar(100) not null," +
                    "    artist_id integer not null," +
                    "    release_year integer," +
                    "    primary key (id)" +
                    ")";
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createChartsTable() {
        try {
            Statement stmt = connection.createStatement();
            String query = "CREATE TABLE charts (id INTEGER, " +
                    "album_id INTEGER not null, " +
                    "sales INTEGER, " +
                    "primary key(id))";
            stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //de creat functionaily test
    public static void main(String args[]) {
        try {
            Database db = Database.getInstance();
            Main m = new Main();//initializam obiectul dupa baza de date ca sa nu mai am e eroare
            ArtistController arc = new ArtistController();
            AlbumController abc = new AlbumController();
            ChartController c=new ChartController();
            //createAlbumsTable();
            // createArtistsTable();--created the table once, no need to drop it every time i run the code
            //createChartsTable();
            // arc.insertDummyValues(10);
            List<Album> albumList= abc.findByArtist(3);
            List<ChartRow> l=c.getSortedCharts();
            System.out.println("Albumele artistului cu id-ul 3 sunt: ");
            for (Album i:albumList) {
                System.out.println(i);
            }
            System.out.println("Chartul ordonat in functie de vanzari este:");
         for(ChartRow i : l){
             System.out.println(i);
         }
        connection.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }


}