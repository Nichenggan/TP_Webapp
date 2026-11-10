<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Détails de la Personne</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        .card {
            width: 400px;
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
        }
        .field {
            margin-bottom: 12px;
        }
        .label {
            font-weight: bold;
            color: #555;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h2>Détails du profil</h2>

<%-- 1. 通过表达式获取 Datamodel 单例 --%>
<c:set var="datamodel" value="<%= com.esiee.tp2.model.Datamodel.getInstance() %>" scope="page" />

<%-- 2. 根据 URL 中的 param.id 获取 Person 对象 --%>
<c:set var="person" value="${datamodel.getPerson(param.id)}" />

<c:choose>
    <c:when test="${not empty person}">
        <div class="card">
            <div class="field">
                <span class="label">ID :</span>
                <c:out value="${person.id}" />
            </div>
            <div class="field">
                <span class="label">Login :</span>
                <c:out value="${person.login}" />
            </div>
            <div class="field">
                <span class="label">Civilité :</span>
                <c:out value="${person.civility.label}" default="Non renseignée" />
            </div>
            <div class="field">
                <span class="label">Fonction :</span>
                <c:out value="${person.function.label}" default="Non renseignée" />
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <p class="error">Aucune personne trouvée pour l'identifiant : <c:out value="${param.id}" /></p>
    </c:otherwise>
</c:choose>

<br>
<a href="${pageContext.request.contextPath}/protected/persons">← Retour à la liste des personnes</a>

</body>
</html>