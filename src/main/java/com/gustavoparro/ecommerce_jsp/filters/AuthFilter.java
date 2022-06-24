package com.gustavoparro.ecommerce_jsp.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*" })
public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();
        String user = (String) httpSession.getAttribute("app_user");
        String servletPath = httpServletRequest.getServletPath();

        if (user == null && !servletPath.contains("/auth")) {
            request.setAttribute("auth_error", "Please signin!");
            request.getRequestDispatcher("auth/index.jsp?url=" + servletPath).forward(request, response);
        }

        chain.doFilter(request, response);
    }

}
