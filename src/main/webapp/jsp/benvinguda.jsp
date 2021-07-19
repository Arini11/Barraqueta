<%@ page import="java.util.List, java.util.Iterator"%>
<%

%>
<head>
<title>Barraqueta</title>
<link rel="icon" href="img/logo.png" type="image/icon">
<link rel="stylesheet" type="text/css" href="css/estils.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Plana web de 'La Barraqueta'" />
<!-- CAL ACABAR DE POSAR METADADES  -->

</head>
<body>
	<div class="wrap">
		<div class="nav">
			<ul class="nav-menu">
				<li><a href="#">Inici</a></li>
				<li><a href="#">Galeria</a></li>
				<li><a href="#">Productes</a></li>
				<li><a href="#">Contacte</a></li>
			</ul>
		</div>
		<form action="<%=response.encodeURL("/Barraqueta/frontController?action=FeedTwitter")%>" method="post">
			<input type="text" name="usuari" placeholder="usuari tw"/>
			<input type="submit" value="Proves XML"/>
		</form>
		<div class="centrat mTop10">
			<img class="img-logo" alt="logo" src="img/logoBlanc.png"/>
		</div>
	</div>
	<div class="parallax">
		<div class="fonsFosc"></div>
	</div>
	<div class="embolcall-divs-diagonals">
		<div class="diagonal diag-esquerra"></div>
		<div class="diagonal diag-dreta"></div>
		<div class="recte"></div>
	</div>
	<!--<div class="div-diagonal"> 
		<div class="wrapper">-->
	
	<!--</div>
	</div>-->
	
</body>
</html>