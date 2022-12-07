<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
  <title>Edition client</title>
<%--  <link href="<c:url value="/asset/css/style.css" />" rel="stylesheet" type="text/css">--%>
</head>
<body>

<h1>Client à éditer</h1>

<form method="post" action="${pageContext.request.contextPath}/clients/update?idClient=${client.id}">
  <table class="table table-bill table-bill_client ">
    <thread>
      <tr>
        <th>Nom</th>
        <th>Adresse</th>
        <th>Ville</th>
        <th>Code Postal</th>
        <th>N° de téléphone</th>
        <th>Email</th>
      </tr>
    </thread>
    <tbody>
      <tr>
        <td>
          <input name="name" type="text" value="${client.name}">
        </td>
        <td>
          <input name="address" type="text" value="${client.address}">
        </td>
        <td>
          <input name="town" type="text" value="${client.town}">
        </td>
        <td>
          <input name="zip_code" type="text" value="${client.zip_code}">
        </td>
        <td>
          <input name="phone_number" type="text" value="${client.phone_number}">
        </td>
        <td>
          <input name="email" type="text" value="${client.email}">
        </td>

      </tr>
    </tbody>
</table>

<button class="btn btn-edit">Éditer</button>

</form>
</body>
</html>
