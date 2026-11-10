<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 50px;
        }
        .login-container {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .btn-submit {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            border-radius: 3px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Connexion</h2>

    <form action="${pageContext.request.contextPath}/api/authenticate" method="POST">
        <div class="form-group">
            <label for="login">Login :</label>
            <input type="text" id="login" name="login" required placeholder="Entrez votre login">
        </div>

        <div class="form-group">
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required placeholder="Entrez votre mot de passe">
        </div>

        <button type="submit" class="btn-submit">Se connecter</button>
    </form>
</div>

</body>
</html>