<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>eCommerce-JSP | Auth</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">
</head>
<body class="container min-vh-100 d-flex flex-column justify-content-center align-items-center bg-dark">
<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="exclamation-triangle-fill" fill="currentColor" viewBox="0 0 16 16">
        <path d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path>
    </symbol>
</svg>

<div class="w-25 py-5 px-3 bg-light rounded">
    <h1 class="text-center mb-2">Login</h1>

    <% if (request.getAttribute("auth_error") != null) { %>
        <div class="alert alert-danger alert-dismissible fade show d-flex align-items-center mt-3" role="alert">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"></use></svg>
            ${auth_error}
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    <% } %>

    <form action="auth" method="post" class="w-100 pt-3 pb-5 needs-validation" novalidate>
        <input type="hidden" name="url" value="<%= request.getParameter("url") %>">

        <div class="mb-3">
            <label for="email" class="form-label">E-mail:</label>
            <input type="email" name="email" id="email" class="form-control" required>

            <div class="invalid-feedback">
                Please enter your email.
            </div>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" name="password" id="password" class="form-control" required>

            <div class="invalid-feedback">
                Please enter your password.
            </div>
        </div>

        <input type="submit" value="Sign in" class="w-100 btn btn-primary">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

<script>
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>
</body>
</html>