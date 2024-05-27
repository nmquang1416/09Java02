package Aptech.day_3;

import Aptech.day_3.user.User;
import Aptech.day_3.user.UserReponsitory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("hello world");

        UserReponsitory userReponsitory = new UserReponsitory();
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your user name:");
        user.setUserName(scanner.nextLine());

        System.out.println("enter your password:");
        user.setUserPassword(scanner.nextLine());

        System.out.println("enter your full name:");
        user.setFullName(scanner.nextLine());

        System.out.println("enter your identity:");
        user.setIdentityCard(scanner.nextLine());

        System.out.println("enter your phone:");
        user.setPhone(scanner.nextLine());

        System.out.println("enter your Date of Birth:");
        user.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.println("enter your status");
        user.setStatus(scanner.nextInt());
        scanner.nextLine();

        userReponsitory.save(user);
    }
}
