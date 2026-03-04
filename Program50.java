/* Assume that login is a table which has Uname, Upass and some records. Check
whether the record is present or not.
@Shyam James
Roll no: 54
Date: 31-01-2026
*/

import java.sql.*;
import java.util.Scanner;

class Program50 {
	public static void main(String[] args) throws Exception {
		//postgresql connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "admin";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, user, password);

		//taking input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String uname = sc.next();
		System.out.print("Enter password: ");
		String upass = sc.next();

		//checking whether record exists
		String sql = "SELECT * FROM login WHERE uname = ? AND upass = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uname);
		pstmt.setString(2, upass);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			System.out.println("Record is present");
		} else {
			System.out.println("Record is not present");
		}

		rs.close();
		pstmt.close();
		conn.close();
		sc.close();
	}
}