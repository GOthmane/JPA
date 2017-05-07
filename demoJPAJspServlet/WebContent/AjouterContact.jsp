<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification d'un client</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="content">
		<div class="block">
		<form method="post" action="AjouterContact">
			<fieldset id="section-1">
				<label for="nom">Saisir le nom :</label>
				<input type="text" name="nom" id="nom"/><br/>
				<label for="prenom">Saisir le prénom :</label>
				<input type="text" name="prenom" id="prenom"/><br/>
				<label for="email">Saisir l'email :</label>
				<input type="text" name="email" id="email"/><br/>
				<label for="numRue">Saisir le numéro et la rue :</label>
				<input type="text" name="numRue" id="numRue"/><br/>
				<label for="ville">Saisir la ville :</label>
				<input type="text" name="ville" id="ville"/><br/>
				<label for="codePostal">Saisir le code postal :</label>
				<input type="text" name="codePostal" id="code postal"/><br/>
			</fieldset>
			<input type="submit" value="valider"/>
		</form>
		</div>
</div>
</body>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>