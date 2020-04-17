package com.DBEXample.DAO;

import com.DBEXample.Entities.Artist;
import com.github.javafaker.Faker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArtistController extends Controller {
    public ArtistController() {}

    public void create(String name, String country) {
        try {
            connection = getConnection();
            String query = "INSERT INTO Artists VALUES(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getIdFromDB("Artists") + 1);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, country);
            preparedStatement.executeQuery();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public List<Artist> findByName(String name) {
        List<Artist> artistsList = new ArrayList<Artist>();
        try {
            connection = getConnection();
            String query = "SELECT * FROM Artists WHERE name LIKE '"+name+"'";
            Statement stmt=connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String country = resultSet.getString(2);
                artistsList.add(new Artist(id, name, country));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return artistsList;
    }


    public void insertDummyValues(int howMany){
        Faker faker=new Faker();
        for(int i=0;i<howMany;i++){
            create(faker.artist().name(),faker.country().name());
        }
    }
}