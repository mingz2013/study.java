<html>
	<head><title>forward����</title></head>
	<body>
		<%
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			if(name.equals("mingzz") && password.equals("123")){
		%>
		<%--�����ͬ����ִ��������ת--%>
		<jsp:forward page="06.html"/>
		<%
			}else{
		%>
		<%--�������ͬ����ִ��������ת--%>
		<jsp:forward page="07.html"/>
		<%
			}
		%>
	</body>
</html>