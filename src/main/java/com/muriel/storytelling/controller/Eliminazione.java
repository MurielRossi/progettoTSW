package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="eliminazione",value ="/eliminazione")

public class Eliminazione extends HttpServlet
{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session = req.getSession(false);
        Object obj = null;
        UserDAO userDao = new UserDAO();
        User user = null;
        if(session == null || (obj = session.getAttribute("utente")) == null) //se l'utente non è loggato non può essere eliminato
        {
            resp.setStatus(403);
            throw new RuntimeException("L'utente non è in sessione!");
        }
        User utente = (User) obj;
        String email = req.getParameter("email");

        if(!utente.getEmail().equals(email))
        {
            resp.setStatus(400);
            resp.getWriter().write("Email non corretta.");
        }

        try {
            user = userDao.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String password = req.getParameter("password");

        if(!(user.getPassword().equals(password)))
        {
            resp.setStatus(400);
            resp.getWriter().write("Password non corretta.");

            return;
        }
        else
        {
            try {
                userDao.deleteUser(email);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            session.setAttribute("utente",null);
            session.setAttribute("eliminato",true);
            resp.sendRedirect("/Muriel/");

        }

    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {
        RequestDispatcher disp = req.getRequestDispatcher("WEB-INF/eliminazione.jsp");
        disp.forward(req, resp);
    }

}
