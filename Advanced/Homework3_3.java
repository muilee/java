package com.iii.bb104.matt;

import java.io.*;
import java.sql.*;

public class Homework3_3 {

	public static void main(String[] args) {
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		String qryStmt = "SELECT * FROM employee WHERE empno >= 1001 AND empno <= 1005";
		String insertStmt = "INSERT INTO emp VALUES(?,?,?,?,?,?,?)";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connUrl, "account", "password");
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			pstmt = conn.prepareStatement(insertStmt);
			File f = null;
			FileInputStream fis = null;
			while(rs.next()) {
				f = new File("res/" + rs.getInt(1) + ".png");
				fis = new FileInputStream(f);
				pstmt.setInt(1, rs.getInt(1));
				pstmt.setString(2, rs.getString(2));
				pstmt.setDate(3, rs.getDate(3));
				pstmt.setDouble(4, rs.getDouble(4));
				pstmt.setInt(5, rs.getInt(5));
				pstmt.setString(6, rs.getString(6));
				pstmt.setBinaryStream(7, fis, f.length());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			fis.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
