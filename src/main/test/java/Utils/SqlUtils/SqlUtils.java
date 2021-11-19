package Utils.SqlUtils;

import Utils.Config;
import Utils.StringUtils;
import org.apache.log4j.Logger;
import java.sql.*;

public class SqlUtils {
    private static Logger logger = Logger.getLogger(SqlUtils.class);
    private final static String url = Config.getProperty("url");
    private final static String user = Config.getProperty("user");
    private final static String password = Config.getProperty("password");
    private static void setUp() {
        try {
            Class.forName(Config.getProperty("sqldriver")).getDeclaredConstructor().newInstance();
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void execQuery(String query, String field) throws SQLException {
        logger.info(StringUtils.getSeparator());
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String log = "   |   " + rs.getObject(field) + "   |   " + "\n-----------------";
                logger.info(log);
            }
        }
    }
    public static void execQuery(String query, String field1, String field2) throws SQLException {
        logger.info(StringUtils.getSeparator());
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String log = rs.getObject(field1) + "   |   " + rs.getObject(field2);
                logger.info(log);
            }
        }
    }

    public static void execQuery(String query, String field1, String field2, String field3) throws SQLException {
        logger.info(StringUtils.getSeparator());
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String log = rs.getObject(field1) + "   |   " + rs.getObject(field2) + "   |   " + rs.getObject(field3)
                        + "\n-----------------------------------------------------------";
                logger.info(log);
            }
        }
    }
}
