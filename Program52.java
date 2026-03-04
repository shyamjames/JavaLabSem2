/* Write a database program including
a. callable statement
b. prepared statement
@Shyam James
Roll no: 54
Date: 02-02-2026
*/

import java.sql.*;
import java.util.Scanner;

class Program52 {
	public static void main(String[] args) throws Exception {
		//postgresql connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "admin";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, user, password);

		//table and function setup
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS emp52 (eno INT PRIMARY KEY, ename VARCHAR(50), esal INT)");
		stmt.executeUpdate("CREATE OR REPLACE FUNCTION add_bonus(p_eno INT, p_bonus INT) RETURNS INT AS $$ " +
				"BEGIN UPDATE emp52 SET esal = esal + p_bonus WHERE eno = p_eno; " +
				"RETURN (SELECT esal FROM emp52 WHERE eno = p_eno); END; $$ LANGUAGE plpgsql");

		Scanner sc = new Scanner(System.in);

		//prepared statement
		System.out.print("Enter emp no: ");
		int eno = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter emp name: ");
		String ename = sc.nextLine();
		System.out.print("Enter emp salary: ");
		int esal = sc.nextInt();

		String insertSql = "INSERT INTO emp52 (eno, ename, esal) VALUES (?, ?, ?) ON CONFLICT (eno) DO UPDATE SET ename = EXCLUDED.ename, esal = EXCLUDED.esal";
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		pstmt.setInt(1, eno);
		pstmt.setString(2, ename);
		pstmt.setInt(3, esal);
		pstmt.executeUpdate();
		System.out.println("Record inserted/updated using PreparedStatement");

		//callable statement
		System.out.print("Enter bonus amount: ");
		int bonus = sc.nextInt();
		CallableStatement cstmt = conn.prepareCall("{ ? = call add_bonus(?, ?) }");
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.setInt(2, eno);
		cstmt.setInt(3, bonus);
		cstmt.execute();
		int newSalary = cstmt.getInt(1);
		System.out.println("New salary after bonus: " + newSalary);

		cstmt.close();
		pstmt.close();
		stmt.close();
		conn.close();
		sc.close();
	}
}