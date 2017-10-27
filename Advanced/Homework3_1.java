package com.iii.bb104.matt;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Homework3_1 {

	public static void main(String[] args) {
		File f = new File("./res/hw3_1.txt");
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connUrl, "account", "password");
			String qryStmt = "SELECT empno, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			String updateStmt = "UPDATE employee SET salary=? WHERE empno=?";
			pstmt = conn.prepareStatement(updateStmt);
			int batchSize = 4;
			boolean b = true;
			while(b) {
				for(int i = 0; i < batchSize; i++) {
					if(!rs.next()) {
						b = false;
						break;
					}
					pstmt.setDouble(1, rs.getDouble(2) * 2);
					pstmt.setInt(2, rs.getInt(1));
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}
			
			
			
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
