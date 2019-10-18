<%@ page import="com.db.ConnectDB2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   ConnectDB2 connectDB = ConnectDB2.getInstance();
	
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
	
   String returns = connectDB.register(id, pw);

   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>