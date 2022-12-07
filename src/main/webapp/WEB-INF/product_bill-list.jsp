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

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/exercicejavase01"
                   user="root"  password=""/>

<sql:query var="products" dataSource="${db}">
  SELECT * FROM products p
  INNER JOIN vat v
    ON v.id = p.vat_id
  INNER JOIN billproduct bp
    ON p.id = bp.id_product
  INNER JOIN bill b
    ON bp.id_bill = b.id
    WHERE b.id = ${idBill}
</sql:query>

<table class="table table-product ">
  <thread>
    <tr>
      <th>Numéro de référence</th>
      <th>Nom</th>
      <th>Coût hors taxe</th>
      <th>Taxation</th>
      <th>Liste des factures</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach var="product" items="${products.rows}">
    <tr>
      <td>${product.ref_nbr}</td>
      <td>${product.name}</td>
      <td>${product.price_wto_taxes}</td>
      <td>${product.quantityProduct}</td>
      <td>${product.amount}</td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/products/bills">
          <input type="hidden" value="${product.id}" name="idProduct">
          <button class="btn btn-details">Liste des Factures</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p>
  <a href="${pageContext.request.contextPath}/products">Retourner à la liste des produits</a>
  <a href="${pageContext.request.contextPath}/clients">Aller vers la liste des client</a>
  <a href="${pageContext.request.contextPath}/bills">Aller vers la liste des factures</a>
</p>

<form method="get" action="${pageContext.request.contextPath}/products/add">
  <button class="btn btn-details">Ajouter un produit</button>
</form>


</body>
</html>
