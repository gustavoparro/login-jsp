package com.gustavoparro.ecommerce_jsp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/auth/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("admin@email.com") && password.equals("1234")) {
            request.getSession().setAttribute("app_user", email);
            request.getRequestDispatcher("pages/index.jsp").forward(request, response);
        }

        request.setAttribute("auth_error","Incorrect email or password");
        request.getRequestDispatcher("pages/auth/index.jsp").forward(request, response);
    }

}