<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style><%@include file="css/style.css"%></style>
</head>
<body>
	<h2>Bestellungsliste:<br></h2>
	<table border="1">
		<tr>
			<th>Bestellungs Nummer</th>
			<th>Vorname</th>
			<th>Nachname</th>
			<th>Artikel</th>
			<th>Anzahl</th>
			<th>Preis</th>
		<tr>
		<c:forEach var="tempBestellung" items="${bestell_Liste}">
			<tr>
				<td>${tempBestellung.bestellungsId} </td>
				<td>${tempBestellung.vorname} </td>
				<td>${tempBestellung.nachname} </td>
				<td>${tempBestellung.artikel} </td>
				<td>${tempBestellung.anzahl} </td>
				<td>${tempBestellung.preis} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>