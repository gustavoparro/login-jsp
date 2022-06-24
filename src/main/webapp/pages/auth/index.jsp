<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
<html>
<head>
    <title>eCommerce-JSP | Auth</title>
</head>
<body>
    <h1>Login</h1>

    <h4>${ auth_error }</h4>

    <form action="auth" method="post">
        <input type="hidden" name="url" value="<%= request.getParameter("url") %>">

        <div>
            <label for="email">E-mail:</label><br />
            <input type="email" name="email" id="email">
        </div>

        <div>
            <label for="password">Password:</label><br />
            <input type="password" name="password" id="password">
        </div>

        <input type="submit" value="Sign in">
    </form>
</body>
</html>