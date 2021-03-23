<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadFile</title>
</head>
<body>
	<form action="upload.controller" method="post"
		enctype="multipart/form-data">
		<div>
			<h3>Please select your file</h3>
			<input type="file" name="myfiles2"> <br/>
			<input type="submit"value="submit">
		</div>
	</form>
</body>
</html>