<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("user_idx") != null) {
		session.removeAttribute("user_idx");
	}
	session.setAttribute("user_idx", 2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript">
	location.href = "feed/list";
</script> -->
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>feed/feedInsertForm</td>
				<td>feed/insertAction</td>
				<td>feed/list</td>
				<td>feed/updateForm</td>
				<td>feed/insertActionReply</td>
				<td>Schedule/main</td>
				<td>Schedule/country</td>
				<td>Schedule/city</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><button onclick="location.href = 'feed/feedInsertForm'">feed/feedInsertForm</button></td>
				<td><button onclick="location.href = 'feed/insertAction'">feed/insertAction</button></td>
				<td><button onclick="location.href = 'feed/list'">feed/list</button></td>
				<td><button onclick="location.href = 'feed/updateForm'">feed/updateForm</button></td>
				<td><button onclick="location.href = 'feed/insertActionReply'">feed/insertActionReply</button></td>
				<td><button onclick="location.href = 'Schedule/main'">Schedule/main</button></td>
				<td><button onclick="location.href = 'Schedule/country'">Schedule/country</button></td>
				<td><button onclick="location.href = 'Schedule/city'">Schedule/city</button></td>
			</tr>
		</tbody>
	</table>
</body>
</html>