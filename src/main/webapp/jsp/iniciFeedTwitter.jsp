<%@ page import="objectes.UsuariTW, objectes.Tweet, 
com.vdurmont.emoji.*" 
%>
<%
	
%>
<head>
<title>Feed Twitter</title>
<link rel="stylesheet" type="text/css" href="css/estils-feed-twitter.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Feed Twitter" />
<meta charset="utf-8"/>
<!-- CAL ACABAR DE POSAR METADADES  -->
<style type="text/css">
	html {
		height: fit-content;
		max-width: 900px;
		margin: 0 auto;
		background-color: #1B4965;
		color: #CAE9FF;
		margin-top: 0px;
		/*border: 1px solid green;*/
	}
	body {
		margin: 0;
		width: 100%;
		/*border: 1px solid red;*/
		display: flex;
		margin-top: 50px;
		text-align: justify;
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
	div.inf-principal {
		padding: 5px;
	}
	.justificar{text-align: justify;}
	.negreta{font-weight: bold;}
	.inf-principal > a:hover img{
		opacity: 0.6;
	}
	div.tweets{
		width: 100%;
		display: flex;
		border: 1px solid #62B6CB;
		flex-direction: column;
		height: fit-content;
	}
	div.caixa {
		margin: 0;
		padding: 0;
		width: 100%;
		border-bottom: 1px solid #62B6CB;
	}
	div.caixa2 {
		margin: 10px 16px;
	}
	div.cos-tweet {
		width: 100%;
	}
	div.cos-tweet > div {
		margin-left: 45px;
		white-space: pre-line;
	}
	div.capçalera-tweet {
		display: flex;
	}
	div.capçalera-tweet img {
		margin-right: 5px;
	}
	div.capçalera-tweet a {
		text-decoration: none;
		color: snow;
	}
	div.capçalera-tweet a:hover {
		text-decoration: underline;
		color: grey;
	}
	
</style>
</head>
<body>
	<form action="<%=response.encodeURL("/Barraqueta/frontController?action=FeedTwitter")%>" method="post">
		<input type="text" name="usuari" placeholder="usuari tw"/>
		<input type="submit" value="Proves XML"/>
	</form>
</body>
</html>