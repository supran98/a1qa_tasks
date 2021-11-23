package Utils.SqlUtils;

import Utils.Config;
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
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String row_pattern = "|  %-20s |";
                int table_width = 25;
                String separator = new String(new char[table_width]).replace("\0", "-");
                String row = String.format(row_pattern, rs.getObject(field));
                logger.info(row + '\n' + separator);
            }
        }
    }
    public static void execQuery(String query, String field1, String field2) throws SQLException {
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String row_pattern = "|  %-20s |  %-20s |";
                int table_width = 49;
                String separator = new String(new char[table_width]).replace("\0", "-");
                String row = String.format(row_pattern, rs.getObject(field1), rs.getObject(field2));
                logger.info(row + '\n' + separator);
            }
        }
    }

    public static void execQuery(String query, String field1, String field2, String field3) throws SQLException {
        setUp();

        try (Connection conn = DriverManager.getConnection(url, user, password)){
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()) {
                String row_pattern = "|  %-30s |  %-150s |  %-30s |";
                int table_width = 223;
                String separator = new String(new char[table_width]).replace("\0", "-");
                String row = String.format(row_pattern, rs.getObject(field1), rs.getObject(field2), rs.getObject(field3));
                logger.info(row + '\n' + separator);
            }
        }
    }
}
