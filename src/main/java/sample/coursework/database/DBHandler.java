package sample.coursework.database;

import sample.coursework.toy.Size;
import sample.coursework.toy.Toy;
import sample.coursework.toy.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends Configs {
    static Connection dbConnection;

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public static void addToy(String type, String size, int price) {
        String insert = "INSERT INTO " + Const.room_table + "(" + Const.toy_type + "," + Const.toy_size + "," + Const.toy_price + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, type);
            prSt.setString(2, size);
            prSt.setInt(3, price);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Toy> template(String query) {
        List<Toy> Toys = new ArrayList<>();
        try {
            Statement prSt = getDbConnection().createStatement();
            ResultSet resultSet = prSt.executeQuery(query);
            while (resultSet.next()) {
                Toys.add(new Toy(Type.valueOf(resultSet.getString(2)), Size.valueOf(resultSet.getString(3)), resultSet.getInt(4)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Toys;
    }

    public static List<Toy> getToys() {
        String gettoys = "SELECT * FROM gameroom";
        return template(gettoys);
    }

    public static List<Toy> findToysByPrice(int price) {
        String gettoys = "SELECT * FROM gameroom where price = " + price + "";
        return template(gettoys);
    }

    public static List<Toy> findToysBySize(String size) {
        String gettoys = "SELECT * FROM gameroom where size = '" + size + "'";
        return template(gettoys);
    }

    public static List<Toy> findToysByType(String type) {
        String gettoys = "SELECT * FROM gameroom where type = '" + type + "'";
        return template(gettoys);
    }

    public static List<Toy> sortToys() {
        String gettoys = "SELECT * FROM gameroom order by price";
        return template(gettoys);

    }
}
