<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
  <title>Factures</title>
<%--  <link href="<c:url value="/asset/css/style.css" />" rel="stylesheet" type="text/css">--%>
</head>
<body>

<h1>Liste des clients</h1>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/exercicejavase01"
                   user="root"  password=""/>

<sql:query var="clients" dataSource="${db}">
  SELECT * FROM client
    WHERE id = ${idClient}
</sql:query>

<table class="table table-bill ">
  <thread>
    <tr>
      <th>Numéro de référence</th>
      <th>Nom</th>
      <th>Adresse</th>
      <th>Ville</th>
      <th>Code postal</th>
      <th>n° de téléphone</th>
      <th>email</th>
      <th>Liste des factures</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach var="client" items="${clients.rows}">
    <tr>
      <td>${client.ref_nbr}</td>
      <td>${client.name}</td>
      <td>${client.address}</td>
      <td>${client.town}</td>
      <td>${client.zip_code}</td>
      <td>${client.phone_number}</td>
      <td>${client.email}</td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/clients/bills">
          <input type="hidden" value="${client.id}" name="idClient">
          <button class="btn btn-details">Detail des factures</button>
        </form>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<%--<a class="btn btn-add" href="${pageContext.request.contextPath}/bills/add">Add Bill</a>--%>

</body>
</html>
