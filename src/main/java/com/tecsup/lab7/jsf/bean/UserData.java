package com.tecsup.lab7.jsf.bean.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Employee> getEmployees() {
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = getConnection();
		String stm = "Select first_name, last_name from employees";
		List<Employee> records = new ArrayList<Employee>();
		try {
			pst = con.prepareStatement(stm);
			pst.execute();
			rs = pst.getResultSet();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setFirstName(rs.getString(1));
				emp.setLastName(rs.getString(2));
				//author.setName(rs.getString(2));
				records.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return records;
	}

	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "HR";
		String password = "HR";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection completed.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			//System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			// TODO Auto-generated catch block
			//System.out.println(ex.getMessage());
		} finally {
		}
		return con;
	}

}
