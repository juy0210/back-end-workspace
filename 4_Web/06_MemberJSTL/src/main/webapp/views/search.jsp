<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 회원검색 : 검색할 아이디 입력받아서
                      호출 : /search, 방식 : get
                      성공하면 views/search_ok.jsp 해당 정보 출력
                      실패하면 views/search_fail.jsp "검색 실패했습니다" 출력
        -->
     <h1>회원검색</h1>
     <form action="/search">
         검색할 회원 아이디 : <input type="text" name="id"><br>
         <input type="submit" value="검색">
     </form>
</body>
</html>