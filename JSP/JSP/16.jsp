<%@ page language="java"%>
<html>
	<head>
		<title>request ���ö���</title>
		<body>
			<%
				String radio = request.getParameter("radio1");
				out.println("ѡ�������:" + radio);
			%>
		</body>
	</head>

</html>