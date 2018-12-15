<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>

</head>
<body>
	<h1>user</h1>


	<button type="button" onclick="getData()">getData</button>

	<script>
		function getData() {
			$.ajax({
				url : '/mybatisspring/user/selectUserJson',
				dataType : 'json',
				success : function(data) {
					console.log(data);
				}
			})
		}
	</script>

</body>
</html>