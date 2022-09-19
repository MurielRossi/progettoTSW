package com.muriel.storytelling.model.DAO;

import com.muriel.storytelling.DB.ConnPool;
import com.muriel.storytelling.model.SavedPostModel;
import com.muriel.storytelling.model.StoryModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SavedPostDAO
{
    //inserimento carrello
    //cancellazione carrello
    //getCarrelloByEmail

    public ArrayList<Integer> getAllSavedPosts(String email) throws SQLException
    {
        ArrayList<Integer> savedPosts = new ArrayList<Integer>();

        Connection conn = ConnPool.getConnection();
        String sql = "SELECT * FROM savedpost WHERE email=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, email.toLowerCase());

        try{
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {

                savedPosts.add(rs.getInt("idStoria"));
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

        return savedPosts;
    }

    public boolean savePost(SavedPostModel post)
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            ps = conn.prepareStatement("INSERT into savedpost (idStoria, email) values (?,?)");
            ps.setInt(1, post.getIdStoria());
            ps.setString(2, post.getEmail());
            ps.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                ps.close();
                ConnPool.releaseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean deletePost(String email, int storyId) throws SQLException
    {
        Connection conn = ConnPool.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM savedpost WHERE email=(?,?)");
        ps.setString(1, email.toLowerCase());
        return ps.executeUpdate() > 0;
    }





}
