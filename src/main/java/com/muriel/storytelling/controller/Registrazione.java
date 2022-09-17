package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="registrazione",value = "/registrazione")

public class Registrazione extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {

        UserDAO userDAO = new UserDAO();
        User user = new User();

        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setIsAdmin(false);

        if(user.getEmail() != null && user.getUsername() != null && user.getPassword() != null)
        {
            userDAO.saveUser(user);
            response.setStatus(200);
            request.getSession().setAttribute("user", user);

            response.sendRedirect(request.getContextPath()+"/Bacheca");

        }
        else
            response.setStatus(400);

        return;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {
        RequestDispatcher disp = request.getRequestDispatcher("registrazione.jsp");
        disp.forward(request, response);
    }
}
