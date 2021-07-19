<%@ page import="java.util.List, java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<%
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	LocalDate avui = LocalDate.now();
	String dataAvui = avui.format(dtf);
%>
<head>
<title>Comandes Clients</title>
<link rel="icon" href="" type="image/icon">
<link rel="stylesheet" type="text/css" href="css/estils.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="Prova comandes clients" />
</head>
<body>
	<div class="">
		<form
			action="<%=response.encodeURL("/UHC/servletController?action=GenerarPDF")%>"
			method="post" target="_blank">
			
			<!-- Nom -->
			<div class="">
				<input type="text" class="" placeholder="Nom" name="nom" id="nom"
					value="" autofocus autocomplete="off" required>
			</div>
			
			<!-- Cognoms -->
			<div class="">
				<input type="text" class="" placeholder="Cognoms" name="cognoms" id="cognoms"
					value="" autocomplete="off" required>
			</div>
			
			<!-- Lloc -->
			<div class="">
				<select name="lloc" id="lloc" required>
					<option value="Dimc mati mercat Selva">Dimc mati mercat Selva</option>
					<option value="Dmc 18:45 Barraqueta">Dmc 18:45 Barraqueta</option>
					<option value="Dmc 19:00 Vilallonga">Dmc 19:00 Vilallonga</option>
					<option value="Dmc 20:00 Selva">Dmc 20:00 Selva</option>
					<option value="Dmc 21:00 Valls">Dmc 21:00 Valls</option>
				</select>
			</div>
			
			<!-- Data -->
			<div class="">
				<input type="date" class="" name="data" id="data"
					autocomplete="off" value="<%= dataAvui %>" required>
			</div>
			
<!-- 			<!-- Productes --> -->
<!-- 			<div class=""> -->
<!-- 				<select name="producte" id="producte" required> -->
<%-- 					<% for(int i=0;i<productes.size();i++) %> --%>
<!-- 					<option value="Dimc mati mercat Selva">Dimc mati mercat Selva</option> -->
<!-- 				</select> -->
<!-- 			</div> -->
			
			<!-- Submit -->
			<div class="">
				<input type="submit" class="" value="Enviar">
			</div>
		</form>
	</div>
</body>
</html>