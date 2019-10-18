<%@page import="org.json.simple.JSONArray"%>
<%@ page import="com.db.ConnectDB4"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   ConnectDB4 connectDB = ConnectDB4.getInstance();
	
   String carNum = request.getParameter("carNum");
   // String carNum = "123가456";
   
   String returns = connectDB.getLocInfo(carNum);   

   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>