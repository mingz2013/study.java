<%@ page language="java" %>
<html>
	<head>
		<title>JSP����</title>
	</head>
	<body>
		<jsp:useBean id="zc" scope="page" class="textBean"/>
		<jsp:setProperty name="zc" property="*"/>
		<h3>ע��ɹ�</h3>
		<hr>
		�����û���Ϊ��<%= zc.getText1() %><br>
		����Ϊ��<%= zc.getText2() %>
	</body>
</html>