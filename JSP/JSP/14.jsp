<%@ page language="java"%>
<html>
	<head><title>reauest���ö���</title></head>
	<body>
		����������ʹ�õ�ģʽ��Э�飩���֣�<%=request.getScheme()%><br>
		���ؽ�������ķ�����������<%=request.getServerName()%><br>
		���ط������Ķ˿ںţ�<%=request.getServerPort()%><br>
		����������Ϣ�е���Servlet��URL���֣�<%=request.getServletPath()%><br>
		����URL֮��Ĳ�ѯ�ַ�����<%=request.getQueryString()%><br>
	</body>
</html>