package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB2 {
	
	private static ConnectDB2 instance = new ConnectDB2(); 
	
	public static ConnectDB2 getInstance() {
        return instance;
    }
	
    public ConnectDB2() {  }
    
	Connection conn = null;
	
	public static Connection getConnection() {
	        
	        // oracle ����
	        String jdbcUrl = "jdbc:oracle:thin:@70.12.115.53:1521:xe";
	        String userId = "SCOTT";
	        String userPw = "TIGER";
	        Connection conn = null;
	        
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        try {
	            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
	            //System.out.println("���Ἲ��, ȣ�⼺��");
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        return conn;
	    }

	public String register (String id, String pwd) throws SQLException {
 
		 PreparedStatement pstmt = null;
		 PreparedStatement pstmt2 = null;
		 ResultSet rs = null;

		 String returns = "aaaaa";
		
         try {
            String sql = "SELECT USER_ID FROM APPUSERINFO WHERE USER_ID = ?";
            pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, id);
            
            rs = pstmt.executeQuery();
            
            System.out.println("id�� ? : @"+id);
            
            if(id == null || id.isEmpty() == true) {
            	//System.out.println("dddddd");
            	returns = "ȸ�� ���� ����! ���̵� ���� �Է��� �ּ���.";
            }
            else if(pwd == null || pwd.isEmpty() == true) {
            	//System.out.println("dddddd");
            	returns = "ȸ�� ���� ����! ��й�ȣ�� ���� �Է��� �ּ���.";
            }
            else {	
            	if (rs.next()) {
            		returns = "�̹� �����ϴ� ���̵� �Դϴ�.";
            	} else {
            		String sql2 = "INSERT INTO APPUSERINFO VALUES(?,?,1)";
            		pstmt2 = getConnection().prepareStatement(sql2);
            		pstmt2.setString(1, id);
            		pstmt2.setString(2, pwd);
            		pstmt2.executeUpdate();
            		returns = "ȸ�� ���� ���� !";
            	}
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