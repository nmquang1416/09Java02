package Aptech.day_2;

import java.sql.*;

public class resultSet {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_msql_02", "root", ""
            );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, name, price from products");
//            System.out.printf("%-10s || %-30s || %-30\n", "id", "name", "price");
            System.out.println("=====================================================");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                System.out.printf("%-10d || %-30s || %-30f\n", id, name,price);
            }
            connection.close();
            System.out.println("done!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
