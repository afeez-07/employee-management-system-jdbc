package com.afeez.ems;

import java.sql.*;

public class EmployeeDAO {

	public void createTable() {

		String sql = """
				CREATE TABLE IF NOT EXISTS employee(
				emp_id INT PRIMARY KEY,
				emp_name VARCHAR(50),
				emp_phone BIGINT,
				emp_salary DOUBLE PRECISION
				)
				""";

		try {

			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			// Table checked/created silently
			st.close();
			con.close();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee e) {

		String sql = "insert into employee values(?,?,?,?)";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, e.getEmpId());
			ps.setString(2, e.getEmpName());
			ps.setLong(3, e.getEmpPhone());
			ps.setDouble(4, e.getEmpSalary());

			int rows = ps.executeUpdate();

			System.out.println(rows + " row inserted");

			ps.close();
			con.close();

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void viewEmployees() {

		String sql = "select * from employee";

		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println("========================================================");
			System.out.printf("%-10s %-15s %-15s %-10s%n",
			        "ID","NAME","PHONE","SALARY");
			System.out.println("========================================================");

			while (rs.next()) {
				System.out.printf("%-10d %-15s %-15d %-10.2f%n",
				        rs.getInt("emp_id"),
				        rs.getString("emp_name"),
				        rs.getLong("emp_phone"),
				        rs.getDouble("emp_salary")
				        );
			}
			
			rs.close();
			st.close();
			con.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void searchEmployee(int id) {

		String sql = "select * from employee where emp_id=?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(
						          rs.getInt("emp_id") + " "
								+ rs.getString("emp_name") + " "
								+ rs.getLong("emp_phone") + " "
								+ rs.getDouble("emp_salary"));
			}

			else {
				System.out.println("Employee Not Found");
			}

			rs.close();
			ps.close();
			con.close();

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateSalary(int id, double salary) {
		String sql = "update employee set emp_salary=? where emp_id=?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, salary);
			ps.setInt(2, id);

			int rows = ps.executeUpdate();

			System.out.println(rows + " row updated");

			ps.close();
			con.close();

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void countEmployees() {

	    String sql = "select count(*) from employee";

	    try {
	        Connection con = DBConnection.getConnection();
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(sql);

	        if(rs.next()) {
	            System.out.println(
	                "Total Employees : "
	                + rs.getInt(1));
	        }

	        rs.close();
	        st.close();
	        con.close();

	    } 
	    catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	public void deleteEmployee(int id) {
		String sql = "delete from employee where emp_id=?";

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			System.out.println(rows + " row deleted");

			ps.close();
			con.close();

		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}