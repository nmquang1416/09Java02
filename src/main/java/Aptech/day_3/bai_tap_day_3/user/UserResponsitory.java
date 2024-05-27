package Aptech.day_3.bai_tap_day_3.user;

import java.sql.*;
import java.util.ArrayList;

public class UserResponsitory {
    public void save(User user) throws SQLException {
        try{
            //01. mo ket noi den database
            //02. tao cau hinh
            //03. thuc thi cau lenh
            //04. dong ket noi

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_02", "root", "");
            Statement statement = connection.createStatement();
            String strSql = String.format("insert into users (userName, userPassword, fullName, identityCard, phone, dob, status) values ('%s','%s','%s','%s','%s','%s','%s', '%d')", user.getUserName(), user.getUserPassword(), user.getFullName(), user.getUserPassword(), user.getPhone(), user.getDob(), user.getStatus());

            statement.execute(strSql);

            System.out.println("Added Successfully");
            connection.close();

        }catch (SQLException e){
            System.out.println("co loi xay ra, vui long thu lai sau");
            e.printStackTrace();
        }
    }

    public void save2(User user){

    }

    public ArrayList<User> findAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_02","root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id, userName, userPassword, fullName, identityCard, phone, dob, status from users");

            System.out.println("--------------");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("userName");
                System.out.println(id +"||" + username);
                User user = new User();
                users.add(user);
            }
        } catch (SQLException e){
            System.out.println("co loi xay ra");
            e.printStackTrace();
        }

        return users;
    }
}
