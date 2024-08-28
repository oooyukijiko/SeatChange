<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
	
		<meta charset="UTF-8">
		<title>userInputForm</title>
		
	</head>
	
	<body>
	
		<form action="UserInputServlet" method="post">
			出席番号:<input type="text" name="studentNum"><br>
			名前:<input type="text" name="name"><br>
			<input type="submit" value="結果を見る">
		</form>
		
	</body>
</html>