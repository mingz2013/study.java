<html>
	<head><title>out ���ö���</title></head>
	<body>
		<table>
			<%! int i; %>
			<%
				i  = 0;
				while(i < 6){
					i++;
					if(i % 2 == 0){
						out.println("<tr bgcolor=red>");
					}else{
						out.println("<tr bgcolor=green>");
					}
			%>
			<td>��ǰ����Ϊ��<%= i %></td>
			<td>���ǵ�<%= i %>����Ϣ</td>
			</tr>
			<%
				}
			%>
		
		</table>
	
	</body>
</html>