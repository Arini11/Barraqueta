<%@ page import="objectes.UsuariTW, objectes.Tweet, 
java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<%
	UsuariTW usr = (UsuariTW)request.getAttribute("usr");
%>
<head>
<title>Feed Twitter</title>
<link rel="stylesheet" type="text/css" href="css/estils-feed-twitter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Feed Twitter" />
<!-- CAL ACABAR DE POSAR METADADES  -->
</head>
<body>
	<h1 style="color: green;">OK!</h1>
	<p>Nom: <%= usr.getNom()%></p>
</body>
</html>