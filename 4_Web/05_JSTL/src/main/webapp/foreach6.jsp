<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 기본 for문: for(int i = 0; i < 5; i++) {} -->
   
    <jsp:include page="header.jsp"/>
    <c:forEach var="i" begin="1" end="6"> <!-- -> 1부터 6까지 -->
         <h${i}>JSTL..!!</h1${i}>
    </c:forEach>
</body>
</html>