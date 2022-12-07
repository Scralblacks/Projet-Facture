<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
  <title>Édition produit</title>
<%--  <link href="<c:url value="/asset/css/style.css" />" rel="stylesheet" type="text/css">--%>
</head>
<body>

<h1>Produit à éditer</h1>

<form method="post" action="${pageContext.request.contextPath}/products/update?idProduct=${product.id}">

<table class="table table-product ">
  <thread>
    <tr>
<%--      <th>Numéro de référence</th>--%>
      <th>Nom</th>
      <th>Coût hors taxe</th>
    </tr>
  </thread>
  <tbody>
    <tr>
<%--      <td>${product.ref_num}</td>--%>
      <td>
        <input name="name" type="text" value="${product.name}">
      </td>
      <td>
        <input name="price_wto_taxes" type="number" step="0.01" value="${product.price_wto_taxes}">
      </td>
    </tr>
  </tbody>
</table>

<button class="btn btn-edit">Éditer</button>

</form>

</body>
</html>
