package com.muriel.storytelling.model.DAO;


import com.muriel.storytelling.DB.ConnPool;
import com.muriel.storytelling.model.StoryModel;
import com.muriel.storytelling.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO
{
    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement ps;
        conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Utente";
        ps = conn.prepareStatement(sql);

        try{

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

    public User getUserByEmail(String email) throws SQLException {
        User user = new User();
        Connection conn = null;
        PreparedStatement ps;
        conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Utente WHERE email =?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,email);

        try{
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next())
            {
                user.setEmail(email);
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setIsAdmin(rs.getBoolean("isAdmin"));
            }
            else {
                user = null;
            }

        }
        catch (SQLException e) {
            // Auto-generated catch block
            user = null;
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

        return user;
    }

    public User getUserByUsername(String username) throws SQLException {
        User user = new User();
        Connection conn = null;
        PreparedStatement ps;
        conn = ConnPool.getConnection();
        String sql = "SELECT * FROM Utente WHERE username =?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,username);

        try{
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            if(rs.next()) {
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setIsAdmin(rs.getBoolean("isAdmin"));
            }
            else {
                user = null;

            }

        }
        catch (SQLException e) {
            // Auto-generated catch block
            user = null;
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

        return user;
    }

    public boolean deleteUser(String email) throws SQLException
    {
        Connection conn = ConnPool.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM utente WHERE email=?;");
        ps.setString(1, email.toLowerCase());
        return ps.executeUpdate() > 0;
    }


}