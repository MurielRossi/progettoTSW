package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SalvaPost extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {
        HttpSession sessione = request.getSession(true); //perchè puoi salvare le storie anche se non sei registrato
        int storyID =  Integer.parseInt(request.getParameter("storyId"));
        ArrayList<Integer> salvati = (ArrayList<Integer>) sessione.getAttribute("salvati");
        if(salvati == null) {
            salvati = new ArrayList<Integer>();
            //sessione.setAttribute("salvati", salvati);
        }
        //ArrayList<Integer> salvatiDef = (ArrayList<Integer>) sessione.getAttribute("salvati");

        if(salvati.contains(storyID))
            return;
        salvati.add(storyID);
        sessione.setAttribute("salvati", salvati);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server, il server mi sta mandando qualcosa
    {

    }
}
