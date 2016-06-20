<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>
<h1>All purchases</h1>

<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>Product</th>
        <th>Quantity</th>
        <th>Date</th>
    </tr>
    </thead>

    <c:forEach var="purch" items="${allPurchases}">
        <tr>
            <td>${purch.purchaseId}</td>
            <td align="center" width="150">${purch.product}</td>
            <td align="center" width="150">${purch.quantity}</td>
            <td align="center" width="150">${purch.dayOfPurchase}</td>

        </tr>
    </c:forEach>
</table>
<spring:url value="/products" var="prod" />
<button onclick="location.href='${prod}'">All products</button>
</body>
</html>
