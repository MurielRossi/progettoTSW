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
import java.sql.SQLException;

@WebServlet(name="login",value = "/login")


public class Login extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        UserDAO userDAO = new UserDAO();
        User user = new User();

        String email = request.getParameter("email");
        try {
            user = userDAO.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user == null) {
            response.setStatus(400);
            request.setAttribute("accessDenied", "Utente non trovato!");
            RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
            disp.forward(request, response);
        }
        else
        {
            if(user.getPassword().equals(request.getParameter("password")))
            {
                response.setStatus(200);
                request.getSession().setAttribute("user", user);


                response.sendRedirect(request.getContextPath()+"/Bacheca");
            }
            else {
                request.setAttribute("accessDenied", "Utente non trovato!");
                RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
                disp.forward(request, response);
                //response.getWriter().write("La password non è corretta!");
            }

        }

        return;


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {
        RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
        disp.forward(request, response);
    }
}
