package Aptech.day_3.user;

import java.sql.*;
import java.util.ArrayList;

public class UserReponsitory {
    public void save(User user) throws SQLException {
        try{
            //1. mở kêết nôối ến database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_02", "root", "");
            //2. tao cau hinh
            Statement statement= connection.createStatement();
            //3. thuc thi cau lenh

            String strSql = String.format( "insert into users(userName, userPassword, fullName, identityCard, phone, dob, status ) values ('%s', '%s', '%s', '%s', '%s', '%s', %d)", user.getUserName(), user.getUserPassword(), user.getFullName(), user.getIdentityCard(), user.getPhone(), user.getDob() , user.getStatus());

            statement.execute(strSql);

            System.out.println("Added Successfully");
            //4. dong ket noi
            connection.close();
        } catch (SQLException e){
            System.out.println("co loi xay ra, vui long thu lai sau");
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void save2(User user) throws SQLException {
        try{
            //1. mở kêết nôối ến database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_02", "root", "");
            //2. tao cau hinh
            Statement statement= connection.createStatement();
            //3. thuc thi cau lenh

            String prepareSql =  "insert into users(userName, userPassword, fullName, identityCard, phone, dob, status ) values (?, ?, ?, ?, ?, ?, ?)" ;

            PreparedStatement preparedStatement= connection.prepareStatement(prepareSql);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getIdentityCard());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getDob().toString());
            preparedStatement.setInt(7, user.getStatus());

            statement.execute(prepareSql);

            System.out.println("Added Successfully");
            //4. dong ket noi
            connection.close();
        } catch (SQLException e){
            System.out.println("co loi xay ra, vui long thu lai sau");
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<User> findAll() throws SQLException {
        try{
            //1. mở kêết nôối ến database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_02", "root", "");
            //2. tao cau hinh
            Statement statement= connection.createStatement();
            //3. thuc thi cau lenh

            String prepareSql =  "insert into users(userName, userPassword, fullName, identityCard, phone, dob, status ) values (?, ?, ?, ?, ?, ?, ?)" ;

            PreparedStatement preparedStatement= connection.prepareStatement(prepareSql);

            statement.execute(prepareSql);

            System.out.println("Added Successfully");
            //4. dong ket noi
            connection.close();
        } catch (SQLException e){
            System.out.println("co loi xay ra, vui long thu lai sau");
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
