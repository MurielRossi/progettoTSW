package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.ReactionDAO;
import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.ReactionModel;
import com.muriel.storytelling.model.Story;
import com.muriel.storytelling.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reaction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        ReactionDAO reactionDAO = new ReactionDAO();
        ReactionModel reaction = new ReactionModel();
        User user = (User) request.getSession().getAttribute("user");
        int storyID = (int) request.getAttribute("storyId");
        reaction.setEmailUtente(user.getEmail());
        reaction.setIdStoria(storyID);

        boolean result = reactionDAO.saveReaction(reaction);

        if(result)
        {
            response.setStatus(201);
            response.getWriter().write("La reazione è stata inserita. ");
        }
        else
        {
            response.setStatus(404);
            response.getWriter().write("Errore nell'inserimento della reazione. ");
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }
}
