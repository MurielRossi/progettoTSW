package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class CancellaStoria extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        StoryDAO storyDao = new StoryDAO();
        StoryModel story = new StoryModel();

        HttpSession sessione = request.getSession(false); //posso cancellare una storia solo se sono loggato

        if(sessione == null)
        {
            response.setStatus(403); //gli errori 400 in generale sono errori di errata richiesta, in particolare il 403 è il "divieto di accesso", ovvero forbidden
            return;
        }
        //Prendo l'utente dalla attuale sessione per avere le informazioni necessarie come l'username

        User user = (User) sessione.getAttribute("user");

        Integer id = Integer.parseInt(request.getParameter("storyId"));
        try {
            story = storyDao.getStoryByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if((user.getIsAdmin()) || story.getUsername().equals((String)user.getUsername()) ) //i controlli vanno fatti ambo i lati
        {

            boolean result = storyDao.deleteStoryById(id);

            if (result) {
                response.setStatus(201); // Story eliminata con successo
                response.getWriter().write("La storia è stata cancellata. ");
            } else {
                response.setStatus(503); //errore del server
                response.getWriter().write("Errore nella cancellazione della storia. ");
            }
        }
        else
        {
            response.setStatus(403); //gli errori 400 in generale sono errori di errata richiesta, in particolare il 403 è il "divieto di accesso", ovvero forbidden
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }


}
