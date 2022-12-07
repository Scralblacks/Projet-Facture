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

<table class="table table-client ">
  <thread>
    <tr>
<%--      <th>Numéro de référence</th>--%>
      <th>Nom</th>
      <th>Adresse</th>
      <th>Ville</th>
      <th>Code postal</th>
      <th>n° de téléphone</th>
      <th>email</th>
      <th colspan="3">Action</th>
    </tr>
  </thread>
  <tbody>
    <tr>
<%--      <td>${client.ref_nbr}</td>--%>
      <td>${client.name}</td>
      <td>${client.address}</td>
      <td>${client.town}</td>
      <td>${client.zip_code}</td>
      <td>${client.phone_number}</td>
      <td>${client.email}</td>
      <td>
        <form method="get" action="${pageContext.request.contextPath}/clients/bills">
          <input type="hidden" value="${client.id}" name="idClient">
          <button class="btn btn-details">Liste des factures</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/clients/update">
          <input type="hidden" value="${client.id}" name="idClient">
          <button class="btn btn-details">Éditer le(la) client(e)</button>
        </form>
      </td>
      <td>
        <form method="post" action="${pageContext.request.contextPath}/clients/delete">
          <input type="hidden" value="${client.id}" name="idClient">
          <button class="btn btn-details">Supprimer le(la) client(e)</button>
        </form>
      </td>
    </tr>
  </tbody>
</table>

<p>
  <a href="${pageContext.request.contextPath}/clients">Returner sur la liste des client</a>
  <a href="${pageContext.request.contextPath}/bills">Aller vers la liste des factures</a>
  <a href="${pageContext.request.contextPath}/products">Aller vers la liste des produit</a>
</p>

<form method="get" action="${pageContext.request.contextPath}/client/add">
  <button class="btn btn-details">Ajouter un client</button>
</form>
