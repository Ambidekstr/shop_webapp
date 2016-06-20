<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>
<h1>All products</h1>

<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>Product</th>
        <th>Price</th>
        <th></th>
    </tr>
    </thead>

    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td align="center" width="150">${product.product}</td>
            <td align="center" width="150">${product.price}</td>
            <td><spring:url value="/${product.productId}/buy" var="buy" />
                <button onclick="location.href='${buy}'">Buy</button>
            </td>
        </tr>
    </c:forEach>
</table>
<spring:url value="/purchases" var="p" />
<button onclick="location.href='${p}'">All Purchases</button>
<spring:url value="/purchases/1" var="pu" />
<button onclick="location.href='${pu}'">Purchases for last month</button>
<spring:url value="/purchases/3" var="pur" />
<button onclick="location.href='${pur}'">Purchases for last 3 month</button>
<spring:url value="/purchases/6" var="purch" />
<button onclick="location.href='${purch}'">Purchases for last 6 months</button>
</body>
</html>
