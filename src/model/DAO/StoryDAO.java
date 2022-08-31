package DAO;


public class StoryDAO
{
    public ArrayList<Story> getAllStories()
    {
        ArrayList<Story> stories = new ArrayList<Story>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Story";
            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Story story = new Story();
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
            // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;
    }

    public ArrayList<Story> getStoriesByUsername(String username)
    {
        ArrayList<Story> stories = new ArrayList<Story>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Story WHERE username =?";
            ps.setString(1,username);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Story story = new Story();
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;

    }

    public ArrayList<Story> getStoriesByDate(LocalDate dataCreazione)
    {
        ArrayList<Story> stories = new ArrayList<Story>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Story WHERE dataCreazione =?";
            ps.setDate(1,dataCreazione);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Story story = new Story();
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return stories;

    }

    public Story getStoryByID(int id)
    {
        Story story = new Story();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM Story WHERE id =?";
            ps.setInt(1,id);

            ps = conn.prepareStatement(sql);
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return story;
    }

    public void saveStory(Story story)
    {
        Story story = new Story();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            Connection conn = ConnPool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT into storia (username,contenuto,nReazioni,dataCreazione) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, story.getUsername());
            ps.setString(2, story.getContenuto());
            ps.setInt(3,story.getNReazioni());
            ps.setDate(4, Date.valueOf(storia.getDataCreazione()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            story.setId(rs.getInt(1));

        }
        catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return story;
    }

   // public void deleteStory(Story story)
    //{

    //}
}