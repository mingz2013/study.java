<%@ page language="java" %>
<html>
	<head>���������ͷ���</head>
	<body>
		<%--����һ������--%>
		<%! String str = "��ӭ����JSP������  ";%>
		
		<%--����һ��������һ������--%>
		<%! 
			String str2 = "Tom";
			String sv(){
				return str + str2;
			}
		%>
		
		<%--���÷���--%>
		<%= sv() %>
	</body>
</html>