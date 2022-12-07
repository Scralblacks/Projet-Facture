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

<form method="post" action="/bills/update?idBill=${bill.id}">
  <table class="table table-bill table-bill_client ">
    <thread>
      <tr>
        <th>Coût hors taxe</th>
        <th>Date de création</th>
      </tr>
    </thread>
    <tbody>
      <tr>
        <td>
          <input name="cost_wto_taxes" type="number" value="${bill.cost_wto_taxes}">
        </td>
        <td>
          <input name="date_of_creation" type="date" ${bill.date_of_creation}>
        </td>
      </tr>
    </tbody>
</table>

<button class="btn btn-edit">Éditer</button>

</form>
</body>
</html>
