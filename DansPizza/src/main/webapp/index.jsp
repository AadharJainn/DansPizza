<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Dans Pizza!</title>
</head>
<body>
<center>
	<h2>Dan Pizza's</h2>
	<a href="${pageContext.request.contextPath}/LoadPizzaOrder">Save Order</a><br><br>
	<a href="${pageContext.request.contextPath}/UpdatePizzaOrder">Update Order</a><br><br>
	<a href="${pageContext.request.contextPath}/LoadBillRangeReport">Order Report</a><br/><br/><br/>	
	
</center>
</body>
</html>