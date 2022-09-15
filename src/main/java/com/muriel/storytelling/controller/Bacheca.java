package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//@WebServlet(name = "Bacheca")

public class Bacheca extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto mandando qualcosa al server
    {

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException //sto chiedendo qualcosa al server
    {
        StoryDAO dao = new StoryDAO();
        UserDAO uD = new UserDAO();

        User u = new User("gigino","Ciao123","email", false);
        User ciao = new User("muriella","srtfhd","adrth", false);
        User hello = new User("simoncino","sxthyyfd","sxdruuh", false);
        User jh = new User("peppino","jyuhtgf","tyud", false);
        User tfd = new User("carola","hbtgd","htgf", false);



        StoryModel s = new StoryModel("gigino","a fess e sort",43, LocalDate.now());
        StoryModel t = new StoryModel("muriella","a fess e mammt",43, LocalDate.now());
        StoryModel g = new StoryModel("simoncino","a fess e nonnt",43, LocalDate.now());
        StoryModel f = new StoryModel("peppino","a fess e zitt",43, LocalDate.now());
        StoryModel h = new StoryModel("carola","a fess e bast",43, LocalDate.now());
        uD.saveUser(u);
        uD.saveUser(ciao);
        uD.saveUser(hello);
        uD.saveUser(jh);
        uD.saveUser(tfd);


        dao.saveStory(f);
        dao.saveStory(h);


        ArrayList<StoryModel> stories = null;
        try {
            stories = dao.getAllStories();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(stories.size() < 1)
            request.setAttribute("noStories", true);

        System.out.println(stories);
        request.setAttribute("stories", stories);

        request.getSession().setAttribute("user", u);
        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/bacheca.jsp");
        disp.forward(request, response);

    }
}