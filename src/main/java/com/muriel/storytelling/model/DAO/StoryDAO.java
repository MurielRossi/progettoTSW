package com.muriel.storytelling.model.DAO;


import com.muriel.storytelling.DB.ConnPool;
import com.muriel.storytelling.model.StoryModel;

import java.sql.*;
import java.util.ArrayList;

public class StoryDAO
{
    public ArrayList<StoryModel> getAllStories() throws SQLException {
        ArrayList<StoryModel> stories = new ArrayList<StoryModel>();

        Connection conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Storia";
        PreparedStatement ps = conn.prepareStatement(sql);

        try{
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                StoryModel story = new StoryModel();
                story.setId(rs.getInt("id"));
                story.setUsername(rs.getString("username"));
                story.setContenuto(rs.getString("contenuto"));
                story.setNReazioni(rs.getInt("nReazioni"));
                story.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());
                stories.add(story);
            }
        }
        catch (SQLException e) {
        // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
            // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;
    }

    public ArrayList<StoryModel> getStoriesByUsername(String username)
    {
        ArrayList<StoryModel> stories = new ArrayList<StoryModel>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Storia WHERE username =?";
            ps.setString(1,username);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                StoryModel story = new StoryModel();
                story.setId(rs.getInt("id"));
                story.setUsername(rs.getString("username"));
                story.setContenuto(rs.getString("contenuto"));
                story.setNReazioni(rs.getInt("nReazioni"));
                story.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());
                stories.add(story);
            }
        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;

    }

    public int getReactionByID(int idStoria) throws SQLException {

        Connection conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Story WHERE id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int nReazioni = -1;

        try{
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            ps.setInt(1,idStoria);

            nReazioni = rs.getInt("nReazioni");
        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return nReazioni;
    }
/*
    public ArrayList<Story> getStoriesByDate(LocalDate dataCreazione)
    {
        ArrayList<Story> stories = new ArrayList<Story>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Story WHERE dataCreazione =?";
            ps.setDate(1, dataCreazione);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Story story = new Story();
                story.setEmail(rs.getInt("id"));
                story.setUsername(rs.getString("username"));
                story.setContenuto(rs.getString("contenuto"));
                story.setNReazioni(rs.getInt("nReazioni"));
                story.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());

                stories.add(story);
            }
        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;

    }
*/
    public StoryModel getStoryByID(int id) throws SQLException {
        StoryModel story = new StoryModel();
        Connection conn = null;
        PreparedStatement ps;
        conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Story WHERE id =?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,id);

        try{

            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            story.setUsername(rs.getString("username"));
            story.setContenuto(rs.getString("contenuto"));
            story.setNReazioni(rs.getInt("nReazioni"));
            story.setDataCreazione(rs.getDate("dataCreazione").toLocalDate());

        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return story;
    }

    public boolean saveStory(StoryModel story)
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            ps = conn.prepareStatement("INSERT into storia (username,contenuto,nReazioni,nCommenti,dataCreazione) values (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, story.getUsername());
            ps.setString(2, story.getContenuto());
            ps.setInt(3,story.getNReazioni());
            ps.setInt(4,0);
            ps.setDate(5, Date.valueOf(story.getDataCreazione()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            story.setId(rs.getInt(1));

        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }
        return true;
    }

   // public void deleteStory(Story story)
    //{

    //}
}