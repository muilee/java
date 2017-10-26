package com.iii.bb104.matt;

import java.io.*;
import java.sql.*;

public class Homework2 {

	public static void main(String[] args) {
		File f = new File("./res/hw2.txt");
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connUrl, "root", "jack5221934");
			String qryStmt = "SELECT * FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String text = "";
			for(int i = 0; i < count; i++) {
				text += rsmd.getColumnName(i + 1) + ",";
			}
			text += "\r\n";
			
			while(rs.next()) {
				for(int i = 0; i < count; i++) {
					text += rs.getString(i + 1) + ",";
				}
				text += "\r\n";
			}
			
			FileWriter fw = new FileWriter(f);
			fw.write(text);
			fw.close();
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
