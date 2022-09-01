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
            String sql = "SELECT * FROM User";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
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
            String sql = "SELECT * FROM User WHERE username =? AND password =??";
            ps.setString(1,username);
            ps.setString(2,password);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
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
            ps = conn.prepareStatement("INSERT into user (id, username, password) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3,user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setId(rs.getString(1));

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