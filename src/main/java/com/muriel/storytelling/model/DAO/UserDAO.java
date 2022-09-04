package com.muriel.storytelling.model.DAO;


import com.muriel.storytelling.DB.ConnPool;
import com.muriel.storytelling.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO
{
    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Utente";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getBoolean("isAdmin"));

                users.add(user);
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

        return users;
    }


    public ArrayList<User> getUserByUsernamePassword(String username, String password)
    {
        ArrayList<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Utente WHERE username =? AND password =?";
            ps.setString(1,username);
            ps.setString(2,password);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getBoolean("isAdmin"));

                users.add(user);
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

        return users;

    }

    public void saveUser(User user)
    {
        PreparedStatement ps = null;
        Connection conn = null;
        try{
            conn = ConnPool.getConnection();
            ps = conn.prepareStatement("INSERT into Utente (username,email, password, isAdmin) values (?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setBoolean(4,user.getIsAdmin());

            ps.executeUpdate();
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

    }

    // public void deleteStory(Story story)
    //{

    //}
}