<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>menu 클릭하세요</h2>
<ul>
<c:if test="${empty login}">
  <li> <a href="${pageContext.request.contextPath}/login.do">로그인</a>
  <li> <a href="${pageContext.request.contextPath}/user/add.do">User 등록</a> </li>
  
</c:if>
 <c:if test="${!empty login}">
  <li> <a href="${pageContext.request.contextPath}/hello.do">hello.do</a>
  <li> <a href="${pageContext.request.contextPath}/report.do">이미지등록</a>

  <li> <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
  
  <li> <a href="${pageContext.request.contextPath}/user/add.do">User 등록</a> </li>
  <li> <a href="${pageContext.request.contextPath}/user/list.do">User 목록</a> </li>
</c:if>
</ul>
</body>
</html>