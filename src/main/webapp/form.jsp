<%--
  Created by IntelliJ IDEA.
  User: Ambidekstr
  Date: 18-Jun-16
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>

<h2>Purchase Information</h2>
<form:form method="POST" action="/booking/${product.productId}" modelAttribute="purcha">
        <h1></h1>
        <label>Quantity</label>
        <form:input path="quantity"/>

        <h1></h1>
        <div>
            <input type="submit" value="Buy"/>
        </div>

</form:form>
</body>
</html>
