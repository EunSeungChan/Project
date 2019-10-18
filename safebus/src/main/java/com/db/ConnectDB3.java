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

public class ConnectDB3 {
	
	private static ConnectDB3 instance = new ConnectDB3(); 
	
	public static ConnectDB3 getInstance() {
        return instance;
    }
	
    public ConnectDB3() {  }
    
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


	//
	public String getRouteInfo_gohome (String state, String station1, String station2) throws SQLException {
 
		 PreparedStatement pstmt = null;
		 PreparedStatement pstmt2 = null;
		 ResultSet rs = null;
		 JSONArray jArray = new JSONArray();

		 String returns = "";

         try {
            String sql = "SELECT *\r\n" + 
            		"FROM ROUTE\r\n" + 
            		"WHERE ROUTE IN (SELECT ROUTE FROM ROUTE WHERE STATION = ?)\r\n" + 
            		"AND TO_NUMBER(STATION)<= TO_NUMBER(?)\r\n" + 
            		"ORDER BY STATION\r\n" + 
            		"";
            
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, station1);
            pstmt.setString(2, station2);
            
            rs = pstmt.executeQuery();
            
            System.out.println("station은 ? : @"+station1);
            
            if(station1 == null || station1.isEmpty() == true || station2 == null || station2.isEmpty() == true) {
            	//System.out.println("dddddd");
            	returns = "정류장을 입력해주세요";
            
            }
            else {	
            	while (rs.next()) {
            		
            		returns = "경로 정보 있음";
            		JSONObject jsonObj = new JSONObject();
            		jsonObj.put("route",rs.getString("ROUTE"));
            		jsonObj.put("station",rs.getString("STATION"));
            		jsonObj.put("latitude",String.valueOf(rs.getDouble("STATION_LATITUDE")));
            		jsonObj.put("longitude",String.valueOf(rs.getDouble("STATION_LONGITUDE")));
            		jsonObj.put("description",rs.getString("DESCRIPTION"));
            		jArray.add(jsonObj);
            		
            	}
            	//returns = "경로 코드를 입력해주세요";
            	returns = jArray.toJSONString();
            	
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
	
	
	public String getRouteInfo_gokinder (String state, String station1, String station2) throws SQLException {
		 
		 PreparedStatement pstmt = null;
		 PreparedStatement pstmt2 = null;
		 ResultSet rs = null;
		 JSONArray jArray = new JSONArray();

		 String returns = "";

	    try {
	       String sql = "SELECT *\r\n" + 
	       		"FROM ROUTE\r\n" + 
	       		"WHERE ROUTE IN (SELECT ROUTE FROM ROUTE WHERE STATION = ?) \r\n" + 
	       		"AND TO_NUMBER(STATION)>= TO_NUMBER(?) ORDER BY STATION";
	       
	       pstmt = getConnection().prepareStatement(sql);
	       
	       pstmt.setString(1, station1);
	       pstmt.setString(2, station2);
	       
	       rs = pstmt.executeQuery();
	       
	       System.out.println("station은 ? : @"+station1);
	       
	       if(station1 == null || station1.isEmpty() == true || station2 == null || station2.isEmpty() == true ) {
	       	//System.out.println("dddddd");
	       	returns = "정류장을 입력해주세요";
	       }
	       
	       else {	
	       	while (rs.next()) {
	       		returns = "경로 정보 있음";
	       		JSONObject jsonObj = new JSONObject();
	       		jsonObj.put("route",rs.getString("ROUTE"));
	       		jsonObj.put("station",rs.getString("STATION"));
	       		jsonObj.put("latitude",String.valueOf(rs.getDouble("STATION_LATITUDE")));
	       		jsonObj.put("longitude",String.valueOf(rs.getDouble("STATION_LONGITUDE")));
	       		jsonObj.put("description",rs.getString("DESCRIPTION"));
	       		jArray.add(jsonObj);
	       		
	       	}
	       	//returns = "경로 코드를 입력해주세요";
	       	returns = jArray.toJSONString();
	       	
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
	
	public void startGPS() {
		TextArea textarea;
		TextField tf;
		Button startBtn;
		Button stopBtn;
		Socket socket;
		BufferedReader br;
		PrintWriter out;
		
		//버튼에서 action이 발생(클릭)했을 때 호출
		//접속버튼
		
		try {
			// 클라이언트는 버튼을 누르면 서버쪽에 Socket접속을 시도
			// Socket(url(서버쪽 ip주소), 접속할 port번호)
			// localhost = "127.0.0.1"
			socket = new Socket("localhost", 5557);
			// 만약에 접속에 성공하면 socket객체를 하나 얻어옴
			InputStreamReader isr = 
					new InputStreamReader(socket.getInputStream());
			br = new BufferedReader(isr);
			out = new PrintWriter(socket.getOutputStream());
			System.out.println("GPS 서버 접속 성공!!");
			
//			String msg = br.readLine();
//			printMsg(msg);
//			br.close();
//			isr.close();
//			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

