<%@ page language="java" %>
<html>
	<head>���������ͷ���</head>
	<body>
		<%--����һ������--%>
		<%! String string = "��������������";%>
		
		<%--����һ������--%>
		<%! 
			String sv(){
				return string;
			}
		%>
		
		<%--���÷���--%>
		<%= sv()%>
	</body>
</html>