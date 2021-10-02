package com.lumen;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {

	static int id;
	static String firstName;
	static String lastName;
	static String address;
	static String email;
	static long phoneNo;
	static String birthday;
	static String anniversary;
	static boolean app = true;

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/lumen";
		String user = "root";
		String password = "password";
		Connection conn;
		PreparedStatement stmt;
		ResultSet rs;

		try {
			conn = DriverManager.getConnection(url, user, password);
			while (app) {
				Scanner sc = new Scanner(System.in);
				System.out.println(
						"select a option: \n 1. ADD EMPLOYEE \n 2. UPDATE DETAILS \n 3. DELETE EMPLOYEE \n 4. VIEW NAME AND MOBILE \n 5. SORT BY BIRTHDAY \n 6. SORT BY ANNIVERSARY \n 7. SEARCH BY NAME \n 8. EXIT ");

				int action = sc.nextInt();

				switch (action) {
				case 1:

					input();
					stmt = conn.prepareStatement(
							"insert into employee(id,firstName,lastName,address,email,phoneNo,birthday,anniversary) "
									+ "values(?,?,?,?,?,?,?,?)");
					stmt.setInt(1, id);
					stmt.setString(2, firstName);
					stmt.setString(3, lastName);
					stmt.setString(4, address);
					stmt.setString(5, email);
					stmt.setLong(6, phoneNo);
					stmt.setDate(7, Date.valueOf(birthday));
					stmt.setDate(8, Date.valueOf(anniversary));
					int rows = stmt.executeUpdate();
					System.out.println("Rows inserted = " + rows);
					break;

				case 2:

					input();
					stmt = conn.prepareStatement(
							"update employee set firstName = ?, lastName = ?, address = ?, email = ?,phoneNo = ?, birthday = ?, anniversary = ? where id = ?");

					stmt.setString(1, firstName);
					stmt.setString(2, lastName);
					stmt.setString(3, address);
					stmt.setString(4, email);
					stmt.setLong(5, phoneNo);
					stmt.setDate(6, Date.valueOf(birthday));
					stmt.setDate(7, Date.valueOf(anniversary));
					stmt.setInt(8, id);
					int row_updated = stmt.executeUpdate();
					System.out.println("Rows inserted/UPDATED = " + row_updated);
					break;

				case 3:
					System.out.println("Enter id to delete: ");
					id = sc.nextInt();
					stmt = conn.prepareStatement("DELETE FROM employee WHERE id = ?");
					stmt.setInt(1, id);
					int row_deleted = stmt.executeUpdate();
					System.out.println("Rows DELETED = " + row_deleted);

					break;

				case 4:
					Statement stm = conn.createStatement();
					rs = stm.executeQuery("Select firstName, phoneNo from employee");
					while (rs.next()) {
						System.out.println(rs.getString(1) + rs.getString(2));
					}
					break;

				case 5:
					System.out.println("Enter birthday yyyy-mm-dd: ");
					birthday = sc.next();
					stmt = conn.prepareStatement("select firstName, email FROM employee WHERE birthday = ?");
					stmt.setDate(1, Date.valueOf(birthday));
					rs = stmt.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2));
					}
					break;

				case 6:
					System.out.println("Enter anniversary yyyy-mm-dd: ");
					birthday = sc.next();
					stmt = conn.prepareStatement("select firstName, phoneNo FROM employee WHERE anniversary = ?");
					stmt.setDate(1, Date.valueOf(birthday));
					rs = stmt.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2));
					}
					break;

				case 7:
					System.out.println("Enter firstName: ");
					firstName = sc.next();
					stmt = conn.prepareStatement("select * FROM employee WHERE firstName = ?");
					stmt.setString(1, firstName);
					rs = stmt.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
								+ rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t"
								+ rs.getString(7) + "\t" + rs.getString(8));
					}
					break;

				case 8:
					app = false;
					break;

				default:
					System.out.println("INVALID SELECTION");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id: ");
		id = sc.nextInt();
		System.out.println("Enter your first name: ");
		firstName = sc.next();
		System.out.println("Enter your last name: ");
		lastName = sc.next();
		System.out.println("Enter your address: ");
		address = sc.next();
		System.out.println("Enter your email: ");
		email = sc.next();
		System.out.println("Enter your phoneNo: ");
		phoneNo = sc.nextLong();
		System.out.println("Enter your birtday yyyy-mm-dd: ");
		birthday = sc.next();
		System.out.println("Enter your anniversary yyyy-mm-dd: ");
		anniversary = sc.next();

	}

}
