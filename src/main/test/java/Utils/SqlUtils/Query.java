package Utils.SqlUtils;

public class Query {
    public static String getMinWorkingTime() {
        return "SELECT project.name AS project, test.name AS test, (test.end_time - test.start_time)\n" +
                "AS min_working_time FROM project\n" +
                "JOIN test ON project.id = test.project_id;";
    }
    public static String getUniqueTestsCount() {
        return "SELECT project.name AS project, COUNT(test.project_id) AS tests_count \n" +
                "FROM project\n" +
                "LEFT OUTER JOIN test\n" +
                "ON project.id = test.project_id\n" +
                "GROUP BY project.name;";
    }
    public static String getTestsLaterThan(String datetime) {
        String query = "SELECT project.name AS project, test.name AS test, test.start_time AS date\n" +
                "FROM project\n" +
                "JOIN test ON project.id = test.project_id\n" +
                "WHERE test.start_time >= '%s';";
        return String.format(query, datetime);
    }
    public static String getBrowsersUsed() {
        return "SELECT COUNT(*) AS browsers FROM test WHERE browser = 'chrome'\n" +
                "UNION\n" +
                "SELECT COUNT(*) FROM test WHERE browser = 'firefox';";
    }
}
