package com.iii.bb104.matt;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Homework3_2 {

	public static void main(String[] args) {
		File f = new File("./res/emp.txt");
		String connUrl = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		String insertStmt = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			FileReader fr = new FileReader(f);
			conn = DriverManager.getConnection(connUrl, "account", "password");
			int i = 0;
			String content = "";
			while((i = fr.read()) != -1) {
				content += (char) i;
			}
			
			fr.close();
			String[] contentList = content.split("\r\n");
			PreparedStatement pstmt = conn.prepareStatement(insertStmt);
			for(int j = 1; j < contentList.length; j++) {
				String[] datas = contentList[j].split("\\s*,\\s*");
				java.util.Date d = sdf.parse(datas[2]);
				pstmt.setInt(1, Integer.valueOf(datas[0]));
				pstmt.setString(2, datas[1]);
				pstmt.setDate(3, new Date(d.getTime()));
				pstmt.setDouble(4, Double.valueOf(datas[3]));
				pstmt.setInt(5, Integer.parseInt(datas[4]));
				pstmt.setString(6, datas[5]);
				pstmt.addBatch();
				
			}
			pstmt.executeBatch();
			
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
