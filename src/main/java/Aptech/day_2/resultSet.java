package Aptech.day_2;

import Aptech.day_2.bai_tap.Product;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;

public class resultSet {
    static ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
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
                Product product = new Product();
                products.add(product);

            }
            connection.close();
            System.out.println("done!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

}
