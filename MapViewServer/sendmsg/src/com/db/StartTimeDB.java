package com.db;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class StartTimeDB {
	
	private static StartTimeDB instance = new StartTimeDB(); 
	
	public static StartTimeDB getInstance() {
        return instance;
    }
	
    public StartTimeDB() {  }
    
	Connection conn = null;
	
	public static Connection getConnection() {
	        
	        // oracle 계정
	        String jdbcUrl = "jdbc:oracle:thin:@70.12.115.78:1521:xe";
	        String userId = "SAFE";
	        String userPw = "BUS";
	        Connection conn = null;
	        
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
	            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
	            System.out.println("연결성공, 호출성공");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return conn;
	    }


	
	public String setStartTime (String startTime) throws SQLException {
 
		 PreparedStatement pstmt = null;
		 PreparedStatement pstmt2 = null;
		 ResultSet rs = null;
		 JSONArray jArray = new JSONArray();
		 
		 Double starttime = Double.valueOf(startTime);

		 String returns = "";


         try {
            String sql = "UPDATE CAR SET START_TIME = ?";
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setDouble(1, starttime);

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                returns = "차량 출발 시간이 등록되었습니다";
            }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (getConnection() != null)try {getConnection().close();    } catch (SQLException ex) {    }
         }
         
         return returns;
      }
	
}

