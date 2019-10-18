<%@page import="org.json.simple.JSONArray"%>
<%@ page import="com.db.ConnectDB3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   ConnectDB3 connectDB = ConnectDB3.getInstance();
	
   String state = request.getParameter("state");
   String station = request.getParameter("station"); // 안드로이드에서 station을 받는다 . 
   String returns = "";
   
   if(state == null || state.isEmpty() == true){
	   returns = connectDB.getRouteInfo_gokinder(state,station,station);   
   }else{
	   if(state.equals("gohome")){
		   returns = connectDB.getRouteInfo_gohome(state,station,station);   
	   }else if(state.equals("gokinder")){
		   returns = connectDB.getRouteInfo_gokinder(state,station,station);   
	   }
   }
   
   //connectDB.startGPS();
     
   
   System.out.println(returns);

   // 안드로이드로 전송
   out.println(returns);
%>