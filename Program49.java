/* Program to insert values into a table.
@Shyam James
Roll no: 54
Date: 31-01-2026
*/

import java.sql.*;
import java.util.Scanner;

class Program49 {
    public static void main(String[] args) throws Exception {
        //postgresql connection
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "admin";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, user, password);
        //taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        //inserting values into table
        String sql = "INSERT INTO sample1 (id, name, age) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.setInt(3, age);
        int rowsInserted = pstmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new record was inserted successfully!");
        }
        pstmt.close();
        conn.close();
        sc.close();
    }
}