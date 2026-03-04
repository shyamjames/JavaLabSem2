/* Department is table having dno, dname, dloc. Emp is table having eno, ename, esal
and dno. Write a program for displaying the information in the following order:
eno ename esal    dname dloc
1   abc   10,000  MCA   MB
2   bcd   20,000  MSW   OB
@Shyam James
Roll no: 54
Date: 02-02-2026
*/

import java.sql.*;

class Program51 {
	public static void main(String[] args) throws Exception {
		//postgresql connection
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "admin";
		String password = "password";
		Connection conn = DriverManager.getConnection(url, user, password);

		//join query to display required columns
		String sql = "SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
					 "FROM emp e INNER JOIN department d ON e.dno = d.dno ORDER BY e.eno";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		System.out.println("eno\tename\tesal\tdname\tdloc");
		while (rs.next()) {
			int eno = rs.getInt("eno");
			String ename = rs.getString("ename");
			int esal = rs.getInt("esal");
			String dname = rs.getString("dname");
			String dloc = rs.getString("dloc");
			System.out.println(eno + "\t" + ename + "\t" + esal + "\t" + dname + "\t" + dloc);
		}

		rs.close();
		stmt.close();
		conn.close();
	}
}

