package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="verificaEmail",value = "/verificaEmail")

public class VerificaEmail extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        UserDAO userDao = new UserDAO();
        String email = request.getParameter("email");
        if(email == null)
            return;
        User user = null;
        try {
            user = userDao.getUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user != null)
        {
            response.setStatus(400);
            response.getWriter().write("Email già presente!");
            return;
        }

        else
        {
            response.setStatus(200);

        }

        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }
}
