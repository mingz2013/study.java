<%@ page language="java"%>
<html>
	<head>
		<title>request ���ö���</title>
		<body>
			<h3>��ѡ��İ������£�</h3>
			<%
				String ah[] = request.getParameterValues("checkbox1");
				for(int i = 0; i < ah.length; i++){
					out.println(i + ". " + ah[i] + "<br>");
				}
			%>
		</body>
	</head>

</html>