<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import ="jspexp.z01_database.*,jspexp.z02_vo.*, java.util.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="${encoding}"/>
<c:set var="path" value="$${pageContext.request.contextPath}"/>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>♪JSP</title>
		<style type="text/css">
			html,body{height:100%;}
			body{box-sizing:border-box;}
			*, *:after, *:before{box-sizing:inherit;}
			
			*{margin:0; padding:0;}
			
			.whyContain{padding:0;}
			.whyContain:after,
			.whyContain:before{content:"";display:table;clear:both;}
			
			
			/*
			*{border: 1px dotted red;}
			*/
		</style>
		<script src="http://code.jquery.com/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			$$(document).ready(function(){
				
			});
			${cursor}
			
		</script>
	</head>
	<body>

	</body>
</html>

