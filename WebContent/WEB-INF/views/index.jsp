<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accounts Manager</title>
</head>
<body>
	<div align="center">
		<h1>Accounts List</h1>
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
			<c:forEach var="contactList" items="${listContact}">
				<tr>
					<td>${contactList.id}</td>
					<td>${contactList.name}</td>
					<td>${contactList.email}</td>
					<td>${contactList.address}</td>
					<td>${contactList.phone}</td>
					<td>${contactList.balance}</td>
					<td><a href="/ContactManager/edit?id=${contactList.id}">Edit</a> <a
						href="/ContactManager/delete?id=${contactList.id}">Delete</a></td>

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