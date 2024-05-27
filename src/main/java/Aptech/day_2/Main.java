package Aptech.day_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_msql_02", "root", ""
            );
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Product Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Product Price:");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Statement statement = connection.createStatement();
            //insert into products (name, price) values ('Product 01', 3000);
//            statement.execute("insert into products (name, price) values ('%s', %f);");

            statement.execute(String.format("insert into products (name, price) values ('%s', %f);", name, price));

            System.out.println("insert success");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
