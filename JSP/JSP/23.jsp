<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="java.util.*" %>
<html>
	<head><title>response ���ö���</title></head>
	<body>
		<%
			response.setHeader("refresh", "1");
			Date myDate = new Date();
		%>
		<h3>��ǰʱ��Ϊ��</h3>
		<%
			out.println(myDate.toLocaleString());
		%>
	</body>
</html>