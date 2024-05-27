package Aptech.day_2.bai_tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductReponsitory implements ProductResponsitoryInterface {
    @Override
    public ArrayList<Product> findAll() {

        return null;
    }

    @Override
    public Product findById(long id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_msql_02", "root", "");
        } catch (Exception e){
            System.out.println("Error to connect to DB");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_msql_02", "root", "");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into products (name, price) values ('%s', '%s')");
                    connection.close();
            System.out.println("inserted successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
        return product;
    }

    @Override
    public void deleteById(long id) {

    }
}
