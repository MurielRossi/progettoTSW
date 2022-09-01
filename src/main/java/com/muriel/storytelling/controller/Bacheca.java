package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.Story;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Bacheca")

public class Bacheca extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server
    {
        StoryDAO dao = new StoryDAO();
        ArrayList<Story> stories = dao.getAllStories();
        if(stories.size() < 1)
            request.setAttribute("noStories", true);

        request.setAttribute("stories", stories);

        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/bacheca.jsp");
        disp.forward(request, response);

    }
}