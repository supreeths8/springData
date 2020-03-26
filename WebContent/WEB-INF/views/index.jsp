<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Manager</title>
</head>
<body>
	<div align="center">
		<h1>Contacts List</h1>
		<a href="/ContactManager/new">New Contact</a> <br> <br>
		<table border="1" cellpadding="3">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Balance</th>
				<th>Action</th>
			</tr>
			<c:forEach var="contact" items="${listContact}">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.name}</td>
					<td>${contact.email}</td>
					<td>${contact.address}</td>
					<td>${contact.phone}</td>
					<td>${contact.balance}</td>
					<td><a href="/ContactManager/edit?id=${contact.id}">Edit</a> <a
						href="/ContactManager/delete?id=${contact.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<form>
		<div align="center">
			<button type="submit" formaction="/ContactManager/logout">Logout</button>

		</div>
	</form>
</body>
</html>