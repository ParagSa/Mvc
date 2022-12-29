<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload form</title>
</head>
<body>
<form action="uploadServlet" method="post" enctype="multipart/form-data">
<div>
<lable>Select Image</lable>
<input type="file" name="image">
</div>
<button type="submit">Submit</button>


</form>

</body>
</html>