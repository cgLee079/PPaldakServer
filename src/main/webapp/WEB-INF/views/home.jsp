<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8"%> 

<html>
<head>
	<title>Home</title>
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
 function login(){
	var form = $("<form>", {
		action : "login",
		method : "POST"
	});
	
	$("<input>", {
		type : "hidden",
		name : "id",
		value: "jihe"
	}).appendTo(form);
	
	$("<input>", {
		type : "hidden",
		name : "pwd",
		value: "1"
	}).appendTo(form);
	
	form.appendTo($("body"));
	form.submit();
 }

</script>
<body>
	<table>
		<tr>
		<td>TEST1</td>
		<td>/login</td>
		<td><a href="javascript:void(0)" onclick="login()">GO</a></td>
		</tr>
	</table>
</body>
</html>
