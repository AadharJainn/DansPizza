<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Pizza Details</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Update Pizza Details</h2>
		<form:form modelAttribute="updatePizzaOrder" method="POST"
			action="updateOrder">

			<br>

			<table border="2">
			<tr>

					<th>Order Id</th>
					<td><form:select path="orderId">
							
							<form:options items="${orderId}" />
						</form:select></td>
				</tr>
			
				<tr>
					<th>Customer Name</th>
					<td><form:input path="customerName" /></td>
				</tr>
				<tr>
					<th>Customer Contact</th>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>

					<th>Pizza Name</th>
					<td><form:select path="pizzaId">
							
							<form:options items="${pizzaNamesAndId}" />
						</form:select></td>
				</tr>

				<tr>
					<th>Quantity</th>
					<td><form:input path="numberOfPiecesOrdered" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Order" />
			<br />
			<br />
			<a href="${pageContext.request.contextPath}/index.jsp"> Home</a>
	   	
		</form:form>
	</center>
</body>
</html>