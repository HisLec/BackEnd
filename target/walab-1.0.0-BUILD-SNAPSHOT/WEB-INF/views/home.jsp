<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form method="post" action="./visiting_log/user/5" enctype="multipart/form-data">
	<input type="file" name="file"/>
	<input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>
</html>
