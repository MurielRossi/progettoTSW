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
import java.util.ArrayList;

public class RimuoviPostSalvati extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        HttpSession sessione = request.getSession(true); //perchè puoi rimuovere le storie salvate anche se non sei registrato
        int storyID =  Integer.parseInt(request.getParameter("storyId"));
        ArrayList<Integer> salvati = (ArrayList<Integer>) sessione.getAttribute("salvati");
        if(salvati == null) {
            salvati = new ArrayList<Integer>();
            //sessione.setAttribute("salvati", salvati);
        }

        if(!(salvati.contains(storyID)))
            response.setStatus(403);
        else {
            salvati.remove(salvati.indexOf(storyID));
            response.setStatus(200);
            sessione.setAttribute("salvati", salvati);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }

}
