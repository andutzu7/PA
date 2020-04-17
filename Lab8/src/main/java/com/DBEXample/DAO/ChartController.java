package com.DBEXample.DAO;
import com.DBEXample.Entities.Chart;
import com.github.javafaker.Faker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartController extends Controller {
    public ChartController() {
    }

    public void create(int albumId, int sales) {
        try {
            connection = getConnection();
            String query = "insert into Charts values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, getIdFromDB("Charts") + 1);
            preparedStatement.setInt(2, albumId);
            preparedStatement.setInt(3, sales);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //we sort the albums by sales and that covers the 2 bulletpoints
    public List<ChartRow> getSortedCharts() throws SQLException {
        List<ChartRow> result = new ArrayList<ChartRow>();
        connection = getConnection();
        Statement stmt = connection.createStatement();
        String query = "select nume_artist,nume_album,sales from (SELECT ar.name as nume_artist,al.name as nume_album,c.sales FROM ARTISTS ar join ALBUMS al on ar.ID = al.ARTIST_ID join CHARTS c on c.ALBUM_ID=al.id ) ORDER BY sales desc";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            ChartRow c = new ChartRow(rs.getString(1), rs.getString(2), rs.getInt(3));
            result.add(c);
        }
        return result;
    }

    public void insertDummyValues(int howMany) throws SQLException {
        Random r = new Random();
        for (int i = 0; i < howMany; i++) {

            create(getRandomId("Albums"), r.nextInt(Integer.MAX_VALUE));
        }

    }
}