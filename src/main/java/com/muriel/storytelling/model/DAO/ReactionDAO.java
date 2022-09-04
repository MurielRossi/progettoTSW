package com.muriel.storytelling.model.DAO;

import com.muriel.storytelling.DB.ConnPool;
import com.muriel.storytelling.model.ReactionModel;

import java.sql.*;

public class ReactionDAO
{
   /* public ReactionModel getReactionByIdStoryAndEmail(String Email, int idStoria)
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            ps = conn.prepareStatement("SELECT * FROM reazione WHERE emailUtente =? AND idStoria =?");
            ReactionModel reaction = new ReactionModel();
            ps.setString(1, email);
            ps.setInt(1,reaction.getIdStoria());

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
    }*/


    public boolean saveReaction(ReactionModel reaction)
    {
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            ps = conn.prepareStatement("INSERT into reazione (idStoria, emailUtente) values (?,?)");
            ps.setInt(1,reaction.getIdStoria());
            ps.setString(2, reaction.getEmailUtente());
            ps.executeUpdate();

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
}
