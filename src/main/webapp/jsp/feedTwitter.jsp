<%@ page import="objectes.UsuariTW, objectes.Tweet, 
com.vdurmont.emoji.*" 
%>
<%
	UsuariTW usr = (UsuariTW)request.getAttribute("usr");
%>
<head>
<title>Feed Twitter</title>
<link rel="stylesheet" type="text/css" href="css/estils-feed-twitter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Feed Twitter" />
<meta charset="UTF-16"/>
<!-- CAL ACABAR DE POSAR METADADES  -->
<style type="text/css">
	html {
		height: 120%;
		max-width: 900px;
		margin: 0 auto;
		background-color: #1B4965;
		color: #CAE9FF;
		margin-top: 0px;
	}
	body {
		margin: 0;
		width: 100%;
		position: relative;
		border: 1px solid red;
		display: flex;
		margin-top: 50px;
	}
	body > div:first-child {
		margin-right: 25px;
	}
	div.perfil-usuari {
		height: fit-content;
	}
	div.perfil-usuari p {
		margin: 3px;
	}
	div.perfil-usuari {
		display:flex;
		flex-direction: column;
		align-items: flex-start;
		border: 1px solid #62B6CB;
		width: 300px;
	}
	div.perfil-usuari > div{
		width: 100%;
	}
	div.inf-extra{
		display:flex;
		width:100%;
		justify-content: space-around;
	}
	div.inf-secundaria{
		color:grey;
		border-top: 1px solid #5FA8D3;
		border-bottom: 1px solid #5FA8D3;
	}
	.justificar{text-align: justify;}
	.negreta{font-weight: bold;}
	.inf-principal > a:hover img{
		opacity: 0.6;
	}
	div.caixa {
		margin: 0;
		padding: 0;
		width:100%;
		border-bottom: 1px solid #62B6CB;
	}
	div.tweets{
		width: 100%;
		display: flex;
		border: 1px solid #62B6CB;
		flex-direction: column;
	}
	div.tweets div {
		width: 100%;
		white-space: pre-line;
		height: 100%;
		
	}
	
</style>
</head>
<body>
	<div class="perfil-usuari">
		<div class="inf-principal">
			<!-- La mida correcte original és de 400x400. Adaptar a partir d'aquí -->
			<a href="<%= usr.getImatge() %>" target="_blank">
				<img width="50" height="50" alt="imatge perfil" src="<%= usr.getImatge() %>"/>
			</a>
			<p>@<%= usr.getUsername() %></p>
			<p class="negreta" style="font-size: 22;"><%= EmojiParser.parseToHtmlHexadecimal(usr.getNom()) %></p>
			<p class="justificar"><%= EmojiParser.parseToHtmlHexadecimal(usr.getDescripcio()) %></p>
		</div>
		<div class="inf-secundaria">
			<div style="display: flex;align-items: center;">
				<img width="20" height="20" alt="icona ubicació" src="img/location.svg"/>
				<p><%= usr.getUbicacio() %></p>
			</div>
			<div style="display: flex;align-items: center;">
				<img width="20" height="20" alt="icona calendari" src="img/calendari.svg"/>
				<p>Va unir-se al <%= usr.getData()%></p>
			</div>
		</div>
		<div class="inf-extra">
			<div>
				<div class="negreta">Tweets</div>
				<div><%= usr.getNTweets()%></div>
			</div>
			<div>
				<div class="negreta">Seguidors</div>
				<div><%= usr.getNSeguidors()%></div>
			</div>
			<div>
				<div class="negreta">Seguint</div>
				<div><%= usr.getNSeguint()%></div>
			</div>
			<div>
				<div class="negreta">Likes</div>
				<div><%= usr.getNLikes()%></div>
			</div>
		</div>
		<p><%=EmojiParser.parseToHtmlHexadecimal("") %></p>
	</div>
	<div class="tweets">
		<%for(Tweet tw : usr.getTweets()){ %>
		<div class="caixa">
			<div>
				<div><%= EmojiParser.parseToHtmlHexadecimal(tw.getTweet()) %></div>
			</div>
			</div>
		<%} %>
	</div>
	<!-- 
	Enllaços !Se'n pot posar més d'un? Si és així, s'haurà d'obtenir una llista i recórrer-la
	Nº Tweets
	Following
	Followers
	Likes
	 -->
</body>
</html>