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

<%--<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"--%>
<%--                   url="jdbc:mysql://localhost:3306/coursjavase"--%>
<%--                   user="root"  password=""/>--%>

<%--<sql:query var="bills" dataSource="${db}">--%>
<%--  SELECT * FROM bill--%>
<%--</sql:query>--%>



<%--<table class="table table-bill ">--%>
<%--  <thread>--%>
<%--    <tr>--%>
<%--      <th>Numéro de référence</th>--%>
<%--      <th>Coût hors taxe</th>--%>
<%--      <th>Coût toutes taxe</th>--%>
<%--      <th>Date de création</th>--%>
<%--      <th>Client</th>--%>
<%--      <th>Produit</th>--%>
<%--    </tr>--%>
<%--  </thread>--%>
<%--  <tbody>--%>
<%--  <c:forEach var="bill" items="${bills.rows}">--%>
<%--    <tr>--%>
<%--      <td>${bill.ref_nbr}</td>--%>
<%--      <td>${bill.cost_wto_taxe}</td>--%>
<%--      <td>${bill.cost_wt_taxe}</td>--%>
<%--      <td>${bill.date_of_creation}</td>--%>
<%--      <td>--%>
<%--        <form method="post">--%>
<%--          <a href=""></a>--%>
<%--        </form>--%>
<%--      </td>--%>
<%--      <td>--%>
<%--        <form method="post">--%>
<%--          <a href=""></a>--%>
<%--        </form>--%>
<%--      </td>--%>
<%--    </tr>--%>
<%--  </c:forEach>--%>
<%--  </tbody>--%>
<%--</table>--%>

<%--<a class="btn btn-add" href="${pageContext.request.contextPath}/bills/add">Add Bill</a>--%>

</body>
</html>
