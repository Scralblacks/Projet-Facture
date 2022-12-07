<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
  <title>Factures</title>
<%--  <link href="<c:url value="/asset/css/style.css" />" rel="stylesheet" type="text/css">--%>
</head>
<body>

<h1>Liste des factures</h1>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/exercicejavase01"
                   user="root"  password=""/>

<sql:query var="bills" dataSource="${db}">
  SELECT * FROM products p
  INNER JOIN vat v
  ON v.id = p.vat_id
  INNER JOIN billproduct bp
  ON p.id = bp.id_product
  INNER JOIN bill b
  ON bp.id_bill = b.id
  WHERE P.id = ${idProduct}
</sql:query>

<table class="table table-bill table-bill_client ">
  <thread>
    <tr>
      <th>Numéro de référence</th>
      <th>Coût hors taxe</th>
      <th>Coût toutes taxe</th>
      <th>Date de création</th>
      <th>Client</th>
      <th colspan="4">Action</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach var="bill" items="${bills.rows}">
    <tr>
      <td>${bill.ref_nbr}</td>
      <td>${bill.cost_wto_taxes}</td>
      <td>${bill.cost_wt_taxes}</td>
      <td>${bill.date_of_creation}</td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/bills/client">
          <input type="hidden" value="${bill.client_id}" name="idClient">
          <button class="btn btn-details">Detail du client</button>
        </form>
      </td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/bills/products">
          <input type="hidden" value="${bill.id}" name="idBill">
          <button class="btn btn-details">Liste des produits</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/bills/update">
          <input type="hidden" value="${bill.id}" name="idBill">
          <button class="btn btn-details">Éditer la facture</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/bills/delete">
          <input type="hidden" value="${bill.id}" name="idBill">
          <button class="btn btn-details">Supprimer la facture</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<p>
  <a href="${pageContext.request.contextPath}/bills">Returner sur la liste des factures</a>
  <a href="${pageContext.request.contextPath}/clients">Aller vers la liste des client</a>
</p>

<form method="get" action="${pageContext.request.contextPath}/bills/add">
  <button class="btn btn-details">Ajouter une facture</button>
</form>

</body>
</html>
