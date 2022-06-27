package com.gustavoparro.ecommerce_jsp.servlets;

import com.gustavoparro.ecommerce_jsp.models.AppUser;
import com.gustavoparro.ecommerce_jsp.repositories.AppUserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private final AppUserRepository appUserRepository = new AppUserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/auth/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String urlPath = request.getParameter("url");
        Optional<AppUser> optionalAppUser = appUserRepository.authenticateUser(
                new AppUser(null, null, request.getParameter("email"), request.getParameter("password")));

        if (optionalAppUser.isPresent()) {
            request.getSession().setAttribute("app_user", optionalAppUser.get().getEmail());

            if (urlPath == null || urlPath.equals("null")) {
                request.getRequestDispatcher("pages/index.jsp").forward(request, response);
            }

            request.getRequestDispatcher(urlPath).forward(request, response);
        }

        request.setAttribute("auth_error","Incorrect email or password");
        request.getRequestDispatcher("pages/auth/index.jsp").forward(request, response);
    }

}