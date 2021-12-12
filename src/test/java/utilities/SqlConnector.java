package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnector {
    private static final String Url = "jdbc:postgresql://localhost:5432/MyMortgageCalculate";
    private static final String User = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String Password = ReadConfigFiles.getPropertyValues("DbPassword");

    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);

    /**
     * Connect to the SQL database
     * @return a connection object
     */

    private static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Url,User,Password);
        } catch (SQLException e) {
            LOGGER.error("SQL Connection Exception" + e.getMessage());
        }
        return connection;
    }

    public static ResultSet readData(String SQL) throws SQLException {
        ResultSet result = null;
        Connection connection = null;
        try {
         connection = connect();
            LOGGER.debug("Connection obeject value" + connection);
            Statement statement = connection.createStatement();
            result = statement.executeQuery(SQL);

        }catch (SQLException e) {
            LOGGER.error("SQL ResultSet Exception" + e.getMessage());
        } finally {
            connection.close();
        }
        return result;

    }
}
