<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
  <title>Factures</title>
<%--  <link href="<c:url value="/asset/css/style.css" />" rel="stylesheet" type="text/css">--%>
</head>
<body>

<h1>Liste des produits</h1>

<table class="table table-product ">
  <thread>
    <tr>
<%--      <th>Numéro de référence</th>--%>
      <th>Nom</th>
      <th>Coût hors taxe</th>
      <th>Taxation</th>
      <th colspan="3">Action</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach var="product" items="${products}">
    <tr>
<%--      <td>${product.ref_num}</td>--%>
      <td>${product.name}</td>
      <td>${product.price_wto_taxes}</td>
      <td>${product.vat.amount}</td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/products/bills">
          <input type="hidden" value="${product.id}" name="idProduct">
          <button class="btn btn-details">Liste des Factures</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/products/update">
          <input type="hidden" value="${product.id}" name="idProduct">
          <button class="btn btn-details">Éditer le produit</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/products/delete">
          <input type="hidden" value="${product.id}" name="idProduct">
          <button class="btn btn-details">Supprimer le produit</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p>
  <a href="${pageContext.request.contextPath}/clients">Aller vers la liste des client</a>
  <a href="${pageContext.request.contextPath}/bills">Aller vers la liste des factures</a>
</p>

<form method="get" action="${pageContext.request.contextPath}/products/add">
  <button class="btn btn-details">Ajouter un produit</button>
</form>

</body>
</html>
