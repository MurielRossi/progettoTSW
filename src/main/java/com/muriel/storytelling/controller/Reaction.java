package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.ReactionDAO;
import com.muriel.storytelling.model.ReactionModel;
import com.muriel.storytelling.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Reaction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        ReactionDAO reactionDAO = new ReactionDAO();
        ReactionModel reaction = new ReactionModel();

//        Prendo l'utente dalla attuale sessione per avere le informazioni necessarie come l'email
        User user = (User) request.getSession().getAttribute("user");

//        Ottengo l'id della storia a cui l'utente ha reagito dalla request
        int storyID =  Integer.parseInt(request.getParameter("storyId"));

        reaction.setEmailUtente(user.getEmail());
        reaction.setIdStoria(storyID);

        boolean result = reactionDAO.saveReaction(reaction);

        if(result)
        {
            response.setStatus(201); // Reazione creata con successo
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
