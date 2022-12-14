package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.ReactionDAO;
import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.ReactionModel;
import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class Story extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        StoryDAO storyDao = new StoryDAO();
        StoryModel story = new StoryModel();

        HttpSession sessione = request.getSession(false); //posso scrivere una storia solo se sono loggato

        if(sessione == null)
        {
            response.setStatus(403); //gli errori 400 in generale sono errori di errata richiesta, in particolare il 403 è il "divieto di accesso", ovvero forbidden
            return;
        }
        //Prendo l'utente dalla attuale sessione per avere le informazioni necessarie come l'email
        User user = (User) sessione.getAttribute("user");

//        Ottengo il contenuto della storia che l'utente ha chiesto di pubblicare
        story.setContenuto(request.getParameter("contenuto"));
        story.setUsername(user.getUsername());
        story.setDataCreazione(LocalDate.now());
        story.setNReazioni(0);

        boolean result = storyDao.saveStory(story);

        if(result)
        {
            response.setStatus(201); // Reazione creata con successo
            response.getWriter().write("La storia è stata inserita. ");
        }
        else
        {
            response.setStatus(404);
            response.getWriter().write("Errore nell'inserimento della storia. ");
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }
}
