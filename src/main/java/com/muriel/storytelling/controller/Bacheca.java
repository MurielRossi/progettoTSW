package com.muriel.storytelling.controller;

import com.muriel.storytelling.model.DAO.StoryDAO;
import com.muriel.storytelling.model.DAO.UserDAO;
import com.muriel.storytelling.model.Story;
import com.muriel.storytelling.model.User;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

        User u = new User("gigino","ciao","email");
        User ciao = new User("muriella","srtfhd","adrth");
        User hello = new User("simoncino","sxthyyfd","sxdruuh");
        User jh = new User("peppino","jyuhtgf","tyud");
        User tfd = new User("carola","hbtgd","htgf");


        Story s = new Story("gigino","a fess e sort",43, LocalDate.now());
        Story t = new Story("muriella","a fess e mammt",43, LocalDate.now());
        Story g = new Story("simoncino","a fess e nonnt",43, LocalDate.now());
        Story f = new Story("peppino","a fess e zitt",43, LocalDate.now());
        Story h = new Story("carola","a fess e bast",43, LocalDate.now());
        uD.saveUser(u);
        uD.saveUser(ciao);
        uD.saveUser(hello);
        uD.saveUser(jh);
        uD.saveUser(tfd);


        dao.saveStory(s);
        dao.saveStory(t);
        dao.saveStory(g);
        dao.saveStory(f);
        dao.saveStory(h);

        ArrayList<Story> stories = null;
        try {
            stories = dao.getAllStories();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(stories.size() < 1)
            request.setAttribute("noStories", true);

        System.out.println(stories);
        request.setAttribute("stories", stories);

        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/bacheca.jsp");
        disp.forward(request, response);

    }
}