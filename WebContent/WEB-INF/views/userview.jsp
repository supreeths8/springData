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
		<h1>Welcome ${userContact.name}</h1>
		<h2>Account Details</h2>
		<br> <br>
		<table border="1" cellpadding="3">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Balance</th>
			</tr>
			<tr>
				<td>${userContact.id}</td>
				<td>${userContact.name}</td>
				<td>${userContact.email}</td>
				<td>${userContact.address}</td>
				<td>${userContact.phone}</td>
				<td>${userContact.balance}</td>
			</tr>
		</table>
	</div>
	<br>
	<form>
		<div align="center">
			<table>
				<tr>
					<td colspan="2" align="center"><button type="submit"
							formaction="/withdraw">Withdraw</button></td>

					<td></td>
					<td colspan="2" align="center"><button type="submit"
							formaction="/deposit">Deposit</button></td>
				</tr>
			</table>
		</div>
	</form>

</body>
</html>