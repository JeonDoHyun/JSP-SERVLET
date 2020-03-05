<%@page import="user.UserDAO"%>
<%@page import="bbs.Board"%>
<%@page import="bbs.BoardDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="board" class="bbs.Board" scope="page" />
<jsp:setProperty name="board" property="boardTitle" />
<jsp:setProperty name="board" property="boardContent" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹사이트</title>
</head>
<body>
	<%
		//로그인된 회원들은 페이지에 접속 할 수 없도록
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID");
		}

		if (userID == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요');");
			script.println("location.href='login.jsp';");
			script.println("</script>");
		} else {
			if (board.getBoardTitle() == null || board.getBoardContent() == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안 된 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
				script.close();
			} else {
				BoardDAO boardDAO = new BoardDAO();
				int result = boardDAO.write(board.getBoardTitle(), userID, board.getBoardContent());
				if (result == -1) { // 아이디가 기본키기. 중복되면 오류.
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('글쓰기에 실패했습니다.')");
					script.println("history.back()");
					script.println("</script>");
					script.close();
				} else {
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("location.href='board.jsp'");
					script.println("</script>");
					script.close();
				}

			}
		}
	%>
</body>
</html>
