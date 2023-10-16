<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
	String name = (String)request.getAttribute("Sname");
	String id = (String)request.getAttribute("Sid");
	int kscore = (int)request.getAttribute("kscore");
	int mscore = (int)request.getAttribute("mscore");
	int escore = (int)request.getAttribute("escore");
	int sscore = (int)request.getAttribute("sscore");
	
	int avg = (kscore+mscore+escore+sscore)/4;
	%>
		<span id='id'><%=id%></span>,
	<span id='name'><%=name%></span>님은

	국어 : <span id='kscore'><%=kscore%></span>
	수학 : <span id='mscore'><%=mscore%></span>
	영어 : <span id='escore'><%=escore%></span>
	과학 : <span id='sscore'><%=sscore%></span>
	
	<%if (avg >= 90){ %>
	a학점
	<%}else if(avg >= 80){ %>
	b학점
	<%}else if(avg >= 70){ %>
	c학점
	<%} %>
	
</body>
</html>