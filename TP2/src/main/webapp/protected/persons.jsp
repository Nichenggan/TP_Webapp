<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Liste des Personnes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>

<div class="header">
    <h2>Liste des personnes du système</h2>
    <p>Utilisateur connecté : <strong><c:out value="${sessionScope.login}" /></strong></p>
</div>

<!-- Vérification si la liste est vide ou nulle -->
<c:choose>
    <c:when test="${empty persons}">
        <!-- Si les données n'ont pas été chargées via la Servlet, on les charge depuis le Datamodel -->
        <c:set var="datamodel" value="<%= com.esiee.tp2.model.Datamodel.getInstance() %>" scope="page" />
        <c:set var="persons" value="${datamodel.getPersons()}" scope="page" />
    </c:when>
</c:choose>

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Civilité</th>
            <th>Fonction</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td><c:out value="${person.id}" /></td>
                <td><c:out value="${person.login}" /></td>
                <td><c:out value="${person.civility.label}" default="Non renseignée" /></td>
                <td><c:out value="${person.function.label}" default="Non renseignée" /></td>
                <td>
                    <a href="${pageContext.request.contextPath}/protected/person.jsp?id=${person.id}">
                        Voir détails
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/protected/success_authentication.jsp">Retour à l'accueil</a>

</body>
</html>