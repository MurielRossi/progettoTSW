package DB;

public class connPool
{
    private static List<Connection> connections; //static perchè è un singleton, quindi una volta instanziato si occuperà di gestire tutte le connessioni

    static //costruttore
    {
        connections = new LinkedList<Connection>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver") //questo è un driver binario che permette la comunicaszione fra l'applicazione java ed il datab ase
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver not found" + e.getMessage());
        }
    }

    private static synchronized Connection createDBConnection() throws SQLExceptions
    {
        Connection newConnection = null;
        newConnection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storytelling?verifyServerCertificate=false&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","Storytelling","Ciao.123");
        System.out.println("Create new DB connection...");
        newConnection.setAutoCommit(false); //altrimenti quando si chiude la funzione si chiuderebbe anche la connessione
        return newConnection;
    }

    public static synchronized Connection getConnection() throws SQLExceptions
    {
        Connection conn = null;
        if(!(connections.isEmpty())
        {
            conn = (Connection) connections.get(0);
            connections.remove(0);
            try {
                if (connection.isClosed())
                    conn = getConnection();
            } catch (SQLException e) {
                conn.close();
                conn = getConnection();
            }
        } else {
        conn = createDBConnection();
        }

        return conn;
        }
    }

    public static synchronized void releaseConnection(Connection connection) throws SQLExceptions
    {
        if (connection != null)
            connections.add(connection);
    }

}




