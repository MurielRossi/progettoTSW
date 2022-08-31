package DAO;


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
                user.setId(rs.getInt("id"));
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return users;
    }


    public ArrayList<User> getUserByUsername&Password(String username, String password)
    {
        ArrayList<User> users = new ArrayList<User>();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = ConnPool.getConnection();
            String sql = "SELECT * FROM User WHERE username =? AND password =??";
            ps.setDate(1,username);
            ps.setDate(2,password);

            ps = conn.prepareStatement(sql);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
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
                ConnectionPool.releaseConnection(conn);
            } catch (SQLException e) {
                // Auto-generated catch block
                e.printStackTrace();
            }
        }

        return user;

    }

    public void saveUser(User user)
    {
        User user = new User();
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            Connection conn = ConnPool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT into user (id, username, password) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3,user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));

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

        return user;
    }

    // public void deleteStory(Story story)
    //{

    //}
}