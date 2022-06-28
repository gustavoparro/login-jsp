<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
<html>
<head>
    <title>eCommerce-JSP | Auth</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
</head>
<body class="container min-vh-100 d-flex flex-column justify-content-center align-items-center bg-dark">
    <div class="w-25 py-5 px-3 bg-light rounded">
        <h1 class="text-center mb-2">Login</h1>

        <h4 class="text-center mb-1">${ auth_error }</h4>

        <form action="auth" method="post" class="w-100">
            <input type="hidden" name="url" value="<%= request.getParameter("url") %>">

            <div class="mb-3">
                <label for="email" class="form-label">E-mail:</label>
                <input type="email" name="email" id="email" class="form-control">
            </div>

            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" name="password" id="password" class="form-control">
            </div>

            <input type="submit" value="Sign in" class="w-100 btn btn-primary">
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>