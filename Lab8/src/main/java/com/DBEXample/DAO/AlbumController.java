package com.DBEXample.DAO;

import com.DBEXample.Entities.Album;
import com.github.javafaker.Faker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlbumController extends Controller {

    public AlbumController() {
    }

    public void create(String name, int artistId, int releaseYear) {
        try {

            connection = getConnection();

            String query = "INSERT INTO ALBUMS values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getIdFromDB("Albums") + 1);//ultimul id +1
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, artistId);
            preparedStatement.setInt(4, releaseYear);
            System.out.println();
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Album> findByArtist(int artistId) {
        List<Album> albumsList = new ArrayList<Album>();
        try {
            connection = getConnection();
            String query = "SELECT * FROM Albums WHERE artist_id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, artistId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int releaseYear = rs.getInt(3);
                albumsList.add(new Album(id, name, artistId, releaseYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albumsList;
    }


    //insertam la un id de artist deja existent ca sa nu dam peste cap charts
    public void insertDummyValues(int howMany) throws SQLException {
        Random r = new Random();
        Faker faker = new Faker();
        for (int i = 0; i < howMany; i++) {
            String fakeAlbumName = faker.artist().name() + "'s Best hits "+r.nextInt(20);
            int releaseYear = r.nextInt(2020-1920)+1920;
            create(fakeAlbumName, getRandomId("Artists"), releaseYear);
        }
    }
}