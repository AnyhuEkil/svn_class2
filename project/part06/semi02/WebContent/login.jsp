<%@page import="vo.PlayerInfo"%>
<%@page import="dao.DAO_PlayerInfo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String pid = (request.getParameter("inputId") != null) ? request.getParameter("inputId") : "";
	String pass = (request.getParameter("inputPass") != null) ? request.getParameter("inputPass") : "";
	boolean isIdValid = false;
	DAO_PlayerInfo daoP = new DAO_PlayerInfo();
	PlayerInfo sch = new PlayerInfo();
	sch.setPid(pid);
	sch.setPass(pass);
	PlayerInfo res = daoP.loginPlayer(sch);
	if (res != null)
		request.setAttribute("res", res);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		if(<%=res%>==null){
			alert("로그인 실패");
			$(location).attr("href","index_guset.jsp");
		}else{
			alert(<%=res.getPid()%>+"님 로그인하셨습니다.");
			$(location).attr("href","index_guest.jsp");
		}
	})
</script>
</html>