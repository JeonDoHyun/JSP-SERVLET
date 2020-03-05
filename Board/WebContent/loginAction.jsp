<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO"%>
<%@ page import="user.UserDTO"%>

<!-- 한명의 회원정보를 담는 user클래스를 자바빈즈로 사용 / scope : 페이지 현재의 페이지에서만 사용 -->
<jsp:useBean id="user" class="user.UserDTO" scope="page"/>
<jsp:setProperty property="userID" name="user"/>
<jsp:setProperty name="user" property="userPassword" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 웹 사이트</title>
</head>
<body>
<%
UserDAO userDAO = new UserDAO();
int result = userDAO.login(user.getUserID(),user.getUserPassword());

if(result == 1) {
	session.setAttribute("userID", user.getUserID());
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("location.href='main.jsp'");
	script.println("</script>");
	script.close();
}else if(result == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('비밀번호가 틀립니다.');");
	script.println("history.back()");
	script.println("</script>");
	script.close();
}else if(result == -1) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('존재하지 않는 아이디 입니다.')");
	script.println("history.back()");
	script.println("</script>");
	script.close();
}else if(result==-2) {
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('데이터베이스 오류가 발생했습니다.')");
	script.println("history.back()");
	script.println("</script>");
	script.close();
}
%>


</body>
</html>