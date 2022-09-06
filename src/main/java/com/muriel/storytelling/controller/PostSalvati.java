package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PostSalvati extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server
    {
        StoryDAO dao = new StoryDAO();
        UserDAO uD = new UserDAO();


        ArrayList<StoryModel> stories = new ArrayList<>();
        HttpSession sessione = request.getSession(true);
        ArrayList<Integer> salvati = (ArrayList<Integer>) sessione.getAttribute("salvati");
        if(salvati.size() < 1)
            request.setAttribute("noStories", true);

        for(Integer x: salvati) {
            try {
                stories.add(dao.getStoryByID(x));
                System.out.println("entra nel for"+ x + stories);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("stories", stories);

        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/postSalvati.jsp");
        disp.forward(request, response);

    }

}
