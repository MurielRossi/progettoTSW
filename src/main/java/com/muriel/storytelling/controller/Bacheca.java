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

        User admin = new User("admin", "Admin.123", "admin@admin.com", true);
        User u = new User("gigino","Ciaftgo.123","email@email.com", false);
        User ciao = new User("muriella","Hello.34dfs","ciao@kio.it", false);
        User hello = new User("simoncino","IHiu123.","Heyyyy@hey.it", false);
        User jh = new User("peppino","OIUJHOjnh2.","Woooooow@wow.com", false);
        User tfd = new User("carola","YUIbgh.244.","Ciaociao@ciaooo.it", false);



        StoryModel s = new StoryModel("gigino","Oggi è stata proprio una bella giornata!",43, LocalDate.now());
        StoryModel t = new StoryModel("muriella","Oggi ho perso il pullman...purtoppo sono arrivato in ritardo",5, LocalDate.now());
        StoryModel g = new StoryModel("simoncino","Nuovo acquisto: macchina nuova!",7, LocalDate.now());
        StoryModel f = new StoryModel("peppino","L'Iphone 14 non mi convince....a voi piace?",2, LocalDate.now());
        StoryModel h = new StoryModel("carola","Sono stufa di tutta questa pioggia",87, LocalDate.now());
        /*
        uD.saveUser(u);
        uD.saveUser(ciao);
        uD.saveUser(hello);
        uD.saveUser(jh);
        uD.saveUser(tfd);
        uD.saveUser(admin);


        dao.saveStory(t);
        dao.saveStory(g);

        dao.saveStory(f);
        dao.saveStory(h);
        */

        ArrayList<StoryModel> stories = null;
        try {
            stories = dao.getAllStories();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(stories.size() < 1)
            request.setAttribute("noStories", true);

        request.setAttribute("stories", stories);

        //request.getSession().setAttribute("user", u);
        RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/bacheca.jsp");
        disp.forward(request, response);

    }
}