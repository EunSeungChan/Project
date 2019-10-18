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

public class ConnectDB4 {
	
	private static ConnectDB4 instance = new ConnectDB4(); 
	
	public static ConnectDB4 getInstance() {
        return instance;
    }
	
    public ConnectDB4() {  }
    
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


	
	public String getLocInfo (String carnum) throws SQLException {
 
		 PreparedStatement pstmt = null;
		 PreparedStatement pstmt2 = null;
		 ResultSet rs = null;
		 JSONObject jsonObj = new JSONObject();

		 String returns = "";

         try {
            String sql = "SELECT LATITUDE, LONGITUDE \r\n" + 
            		"FROM CAR \r\n" + 
            		"WHERE CAR_NUMBER = ?";
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, carnum);

            rs = pstmt.executeQuery();
            
            System.out.println("차 번호는 ? : @"+carnum);
            
            if(carnum == null || carnum.isEmpty() == true) {
            	//System.out.println("dddddd");
            	returns = "차 번호를 입력해주세요";
            }
            else {	
            	while (rs.next()) {
            		returns = "차 위치 정보 있음";
            		jsonObj = new JSONObject();
            		jsonObj.put("latitude",rs.getString("LATITUDE"));
            		jsonObj.put("longitude",rs.getString("LONGITUDE"));
            	}
            	returns = jsonObj.toJSONString();
            	
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

