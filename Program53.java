/* Program to implement
a. Transaction.
b. Batch processing
@Shyam James
Roll no: 54
Date: 02-02-2026
*/

import java.sql.*;
import java.util.Scanner;

class Program53 {
	public static void main(String[] args) throws Exception {
		//postgresql connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "admin";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, user, password);

		//setup table
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DROP TABLE IF EXISTS accounts");
		stmt.executeUpdate("CREATE TABLE accounts (accno INT PRIMARY KEY, name VARCHAR(50), balance INT)");
		stmt.close();

		Scanner sc = new Scanner(System.in);

		//batch processing
		System.out.println("--- Batch Processing ---");
		System.out.print("Enter number of accounts to insert: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String insertSql = "INSERT INTO accounts (accno, name, balance) VALUES (?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(insertSql);
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter account no: ");
			int accno = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter name: ");
			String name = sc.nextLine();
			System.out.print("Enter balance: ");
			int balance = sc.nextInt();
			sc.nextLine();
			
			pstmt.setInt(1, accno);
			pstmt.setString(2, name);
			pstmt.setInt(3, balance);
			pstmt.addBatch();
		}
		
		int[] result = pstmt.executeBatch();
		System.out.println("Batch insert completed: " + result.length + " records inserted");

		//transaction processing
		System.out.println("\n--- Transaction Processing ---");
		System.out.print("Enter source account no: ");
		int srcAcc = sc.nextInt();
		System.out.print("Enter destination account no: ");
		int destAcc = sc.nextInt();
		System.out.print("Enter transfer amount: ");
		int amount = sc.nextInt();
		
		conn.setAutoCommit(false);
		
		try {
			String debitSql = "UPDATE accounts SET balance = balance - ? WHERE accno = ?";
			PreparedStatement debitStmt = conn.prepareStatement(debitSql);
			debitStmt.setInt(1, amount);
			debitStmt.setInt(2, srcAcc);
			debitStmt.executeUpdate();
			
			String creditSql = "UPDATE accounts SET balance = balance + ? WHERE accno = ?";
			PreparedStatement creditStmt = conn.prepareStatement(creditSql);
			creditStmt.setInt(1, amount);
			creditStmt.setInt(2, destAcc);
			creditStmt.executeUpdate();
			
			conn.commit();
			System.out.println("Transaction successful: Amount transferred");
			
			debitStmt.close();
			creditStmt.close();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Transaction failed: Rolled back - " + e.getMessage());
		}
		
		conn.setAutoCommit(true);
		
		//display final balances
		System.out.println("\nFinal Account Balances:");
		Statement stmtDisplay = conn.createStatement();
		ResultSet rs = stmtDisplay.executeQuery("SELECT * FROM accounts ORDER BY accno");
		System.out.println("accno\tname\tbalance");
		while (rs.next()) {
			System.out.println(rs.getInt("accno") + "\t" + rs.getString("name") + "\t" + rs.getInt("balance"));
		}
		
		rs.close();
		stmtDisplay.close();
		pstmt.close();
		conn.close();
		sc.close();
	}
}