<%@ page language="java" contentType="text/html;charset=GB2312" %>
<%@ page import="pa.TestBean"%>   
<html>
	<head><title>��JSP������ʹ��</title></head>
	<body>
		<jsp:useBean id="test" class="pa.TestBean" scope="page"/>
		<%
			test.setText1("���ǵ�һ���ַ���");
			test.setText2("���ǵڶ����ַ���");
		%>
		JavaBean�еĵ�һ������ֵΪ��<%=test.getText1() %><br>
		JavaBean�еĵڶ�������ֵΪ��<%=test.getText2() %><br>
	</body>
</html>                                              